<html>
<body>
<h2>Testing Tomcat</h2>
<a href="vocabulary">Vocabulary</a>

<c:choose>
    <c:when test="${empty userName}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
    </c:otherwise>
</c:choose>

</body>
</html>
