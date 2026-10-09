<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>German Vocabulary</title>
</head>

<body>


<h1>German Learning Tracker</h1>

<h2>Users</h2>

<h2>My Vocabulary</h2>

<p>Vocabulary list: ${vocabularyList}</p>

<p>
    Number of words:
    <strong>${not empty vocabularyList ? vocabularyList.size() : 0}</strong>
</p>

<table border="1">

    <thead>
    <tr>
        <th>German Word</th>
        <th>English Meaning</th>
        <th>Article</th>
        <th>Plural</th>
    </tr>
    </thead>

    <tbody>


    <c:forEach var="vocabulary" items="${vocabularyList}">

        <tr>
            <td>${vocabulary.germanWord}</td>
            <td>${vocabulary.englishMeaning}</td>
            <td>${vocabulary.article}</td>
            <td>${vocabulary.plural}</td>
        </tr>

    </c:forEach>

    </tbody>

</table>

<br>

<a href="index.jsp">Back to Home</a>

</body>

</html>