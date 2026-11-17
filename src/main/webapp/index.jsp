
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Fonik App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>

<body>

<nav class="navbar">
    <div class="logo">
        Fonik App
    </div>

    <div class="nav-links">
        <a href="${pageContext.request.contextPath}/index.jsp">Home</a>

        <c:choose>
            <c:when test="${empty userName}">
                <a href="${pageContext.request.contextPath}/logIn">Log In</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/vocabulary">My Vocabulary</a>
                <span>Welcome, ${userName}</span>
            </c:otherwise>
        </c:choose>
    </div>
</nav>

<main class="home-container">

    <section class="hero">
        <h1>Start Your German Learning Journey</h1>

        <p>
            Learn German one word at a time. Build your vocabulary,
            discover new words, and keep track of your progress.
        </p>

        <c:choose>
            <c:when test="${empty userName}">
                <a class="main-button"
                   href="${pageContext.request.contextPath}/logIn">
                    Get Started
                </a>
            </c:when>
            <c:otherwise>
                <a class="main-button"
                   href="${pageContext.request.contextPath}/logIn">
                    Dashboard
                </a>
            </c:otherwise>
        </c:choose>
    </section>

    <section class="features">
        <h2>What Can You Do?</h2>

        <div class="feature-container">

            <div class="feature">
                <h3>Build Your Vocabulary</h3>
                <p>
                    Save German words and organize your personal
                    vocabulary collection.
                </p>
            </div>

            <div class="feature">
                <h3>Dictionary Lookup</h3>
                <p>
                    Search for German words and discover their
                    English meanings, articles, and plural forms.
                </p>
            </div>

            <div class="feature">
                <h3>Track Your Learning</h3>
                <p>
                    Keep your vocabulary organized and make
                    learning German part of your daily routine.
                </p>
            </div>

        </div>
    </section>

</main>

</body>
</html>
