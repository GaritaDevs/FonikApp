
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Fonik App</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vocabulary.css">
</head>

<body>


<nav class="navbar">

    <div class="logo">
        Fonik App
    </div>

    <div class="nav-links">
        <a href="${pageContext.request.contextPath}/login.jsp">Dashboard</a>
        <a href="${pageContext.request.contextPath}/vocabulary">My Vocabulary</a>
        <a href="${pageContext.request.contextPath}/addVocabulary">Add Vocabulary</a>
    </div>

    <div class="user-profile">
        <span>&#128100;</span>
        <span>${sessionScope.userName}</span>
    </div>

</nav>


<main class="vocabulary-container">

    <section class="vocabulary-header">

        <div>
            <h1>My Vocabulary</h1>
            <p>Manage and review the German words you have learned.</p>
        </div>

        <a href="${pageContext.request.contextPath}/addVocabulary"
           class="main-button">
            + Add New Word
        </a>

    </section>


    <section class="vocabulary-stats">

        <div class="stat-card">
            <span class="stat-icon">&#128218;</span>

            <div>
                <p>Total Words</p>
                <h2>${not empty vocabularyList ? vocabularyList.size() : 0}</h2>
            </div>
        </div>

    </section>


    <section class="vocabulary-table-section">
        <h2>Your Saved Words</h2>

        <c:choose>

            <c:when test="${not empty vocabularyList}">

                <div class="table-wrapper">

                    <table class="vocabulary-table">

                        <thead>
                        <tr>
                            <th>German Word</th>
                            <th>English Meaning</th>
                            <th>Article</th>
                            <th>Plural</th>
                            <th>Actions</th>
                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach var="vocabulary" items="${vocabularyList}">

                            <tr>
                                <td class="german-word">
                                        ${vocabulary.germanWord}
                                </td>

                                <td>${vocabulary.englishMeaning}</td>

                                <td>
                                            <span class="article-tag">
                                                    ${vocabulary.article}
                                            </span>
                                </td>

                                <td>${vocabulary.plural}</td>

                                <td>
                                    <div class="action-buttons">

                                        <form action="${pageContext.request.contextPath}/vocabulary" method="get">
                                            <input type="hidden" name="action" value="edit">
                                            <input type="hidden" name="id" value="${vocabulary.id}">

                                            <button type="submit" class="edit-button" title="Edit word">
                                                &#9998;
                                            </button>
                                        </form>

                                        <form action="${pageContext.request.contextPath}/vocabulary" method="post"
                                              onsubmit="return confirm('Are you sure you want to delete this word?');">

                                            <input type="hidden" name="action" value="delete">
                                            <input type="hidden" name="id" value="${vocabulary.id}">

                                            <button type="submit" class="delete-button" title="Delete word">
                                                &#128465;
                                            </button>
                                        </form>

                                    </div>
                                </td>
                            </tr>

                        </c:forEach>

                        </tbody>

                    </table>

                </div>

            </c:when>

            <c:otherwise>

                <div class="empty-vocabulary">
                    <div class="empty-icon">&#128218;</div>

                    <h3>Your vocabulary is empty</h3>

                    <p>
                        Start building your German vocabulary
                        by adding your first word.
                    </p>

                    <a href="${pageContext.request.contextPath}/addVocabulary"
                       class="main-button">
                        Add Your First Word
                    </a>
                </div>

            </c:otherwise>

        </c:choose>

    </section>

</main>

</body>
</html>
