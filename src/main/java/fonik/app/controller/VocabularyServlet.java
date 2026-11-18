
package fonik.app.controller;

import fonik.app.entity.User;
import fonik.app.entity.Vocabulary;
import fonik.app.persistence.VocabularyDao;
import fonik.app.persistence.UserDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/vocabulary")
public class VocabularyServlet extends HttpServlet {

    private VocabularyDao vocabularyDao;
    private UserDao userDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init() throws ServletException {
        vocabularyDao = new VocabularyDao();
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Vocabulary servlet was called");

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userName") == null) {
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        String email = (String) session.getAttribute("userName");
        User loggedInUser = userDao.getByEmail(email);

        if (loggedInUser == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String action = request.getParameter("action");

        if ("edit".equals(action)) {

            String idParameter = request.getParameter("id");

            try {
                int id = Integer.parseInt(idParameter);

                Vocabulary vocabulary = vocabularyDao.getById(id);

                if (vocabulary == null ||
                        vocabulary.getUser().getId() != loggedInUser.getId()) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
                }

                request.setAttribute("vocabulary", vocabulary);

                request.getRequestDispatcher("/editVocabulary.jsp")
                        .forward(request, response);

            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

            return;
        }

        List<Vocabulary> vocabularyList =
                vocabularyDao.getByUserId(loggedInUser.getId());

        logger.debug("Vocabulary entries found: {}", vocabularyList.size());

        request.setAttribute("vocabularyList", vocabularyList);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/vocabulary.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userName") == null) {
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        String email = (String) session.getAttribute("userName");
        User loggedInUser = userDao.getByEmail(email);

        if (loggedInUser == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String action = request.getParameter("action");

        if ("delete".equals(action)) {

            try {
                int id = Integer.parseInt(request.getParameter("id"));

                Vocabulary vocabulary = vocabularyDao.getById(id);

                if (vocabulary == null ||
                        vocabulary.getUser().getId() != loggedInUser.getId()) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
                }

                vocabularyDao.delete(vocabulary);

                logger.info("Vocabulary entry {} deleted for user {}", id, email);

                response.sendRedirect(request.getContextPath() + "/vocabulary");

            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid action.");
        }
    }
}
