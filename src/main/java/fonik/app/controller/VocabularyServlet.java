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
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Vocabulary servlet was called");

        // Get the logged-in user's email from the session
        String email = (String) request.getSession().getAttribute("userName");

        // Find the user in the database
        User loggedInUser = userDao.getByEmail(email);

        // Get only this user's vocabulary
        List<Vocabulary> vocabularyList =
                vocabularyDao.getByUserId(loggedInUser.getId());

        logger.debug("Vocabulary entries found: {}", vocabularyList.size());

        request.setAttribute("vocabularyList", vocabularyList);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/vocabulary.jsp");

        dispatcher.forward(request, response);
    }

}