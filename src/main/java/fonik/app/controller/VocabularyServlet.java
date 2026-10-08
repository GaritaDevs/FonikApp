package fonik.app.controller;

import fonik.app.entity.Vocabulary;
import fonik.app.persistence.VocabularyDao;

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

    @Override
    public void init() throws ServletException {
        vocabularyDao = new VocabularyDao();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Vocabulary> vocabularyList = vocabularyDao.getAll();

        request.setAttribute("vocabularyList", vocabularyList);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/vocabulary.jsp");

        dispatcher.forward(request, response);
    }
}