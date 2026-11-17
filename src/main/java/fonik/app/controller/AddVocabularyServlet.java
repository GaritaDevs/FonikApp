
package fonik.app.controller;

import fonik.app.entity.Vocabulary;
import fonik.app.entity.User;
import fonik.app.service.WiktapiService;
import fonik.app.persistence.UserDao;
import fonik.app.persistence.VocabularyDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addVocabulary")
public class AddVocabularyServlet extends HttpServlet {

    private UserDao userDao;
    private VocabularyDao vocabularyDao;
    private WiktapiService wiktapiService;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init() throws ServletException {
        wiktapiService = new WiktapiService();
        userDao = new UserDao();
        vocabularyDao = new VocabularyDao();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/addVocabulary.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // ACTION 1: Look up a German word using the dictionary API
        if ("lookup".equals(action)) {

            String germanWord = request.getParameter("germanWord");

            if (germanWord == null || germanWord.trim().isEmpty()) {
                request.setAttribute("errorMessage",
                        "Please enter a German word.");

                request.getRequestDispatcher("/addVocabulary.jsp")
                        .forward(request, response);
                return;
            }

            try {

                Vocabulary suggestedVocabulary =
                        wiktapiService.getVocabulary(germanWord.trim());

                if (suggestedVocabulary == null) {
                    request.setAttribute("errorMessage",
                            "No dictionary information was found for this word.");
                } else {
                    request.setAttribute("suggestedVocabulary",
                            suggestedVocabulary);
                }

            } catch (Exception e) {

                logger.error("Error looking up German word: {}", germanWord, e);

                request.setAttribute("errorMessage",
                        "Something went wrong while searching the dictionary.");
            }

            request.getRequestDispatcher("/addVocabulary.jsp")
                    .forward(request, response);

        }

        // ACTION 2: Save vocabulary for the logged-in user
        else if ("save".equals(action) || "saveManual".equals(action)) {

            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("userName") == null) {
                response.sendRedirect(request.getContextPath() + "/logIn");
                return;
            }

            String email = (String) session.getAttribute("userName");

            User loggedInUser = userDao.getByEmail(email);

            if (loggedInUser == null) {
                logger.error("No database user found for email: {}", email);

                request.setAttribute("errorMessage",
                        "Your user account could not be found.");

                request.getRequestDispatcher("/addVocabulary.jsp")
                        .forward(request, response);
                return;
            }

            String germanWord = request.getParameter("germanWord");
            String englishMeaning = request.getParameter("englishMeaning");
            String article = request.getParameter("article");
            String plural = request.getParameter("plural");

            if (germanWord == null || germanWord.trim().isEmpty()
                    || englishMeaning == null || englishMeaning.trim().isEmpty()) {

                request.setAttribute("errorMessage",
                        "German word and English meaning are required.");

                request.getRequestDispatcher("/addVocabulary.jsp")
                        .forward(request, response);
                return;
            }

            Vocabulary vocabulary = new Vocabulary();

            vocabulary.setGermanWord(germanWord.trim());
            vocabulary.setEnglishMeaning(englishMeaning.trim());
            vocabulary.setArticle(article);
            vocabulary.setPlural(plural);

            // Associate the vocabulary with the authenticated user
            vocabulary.setUser(loggedInUser);

            vocabularyDao.insert(vocabulary);

            logger.info("Vocabulary '{}' saved for user {}",
                    germanWord, email);

            response.sendRedirect(request.getContextPath() + "/vocabulary");
        }

        // Handle unknown actions
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid action.");
        }
    }
}
