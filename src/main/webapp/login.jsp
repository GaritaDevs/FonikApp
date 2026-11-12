
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Fonik App </title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>

<body>

<nav class="navbar">

  <div class="logo">
    Fonik App
  </div>

  <div class="nav-links">
    <a href="${pageContext.request.contextPath}/index.jsp">Home</a>

    <a href="${pageContext.request.contextPath}/vocabulary">
      My Vocabulary
    </a>

    <a href="${pageContext.request.contextPath}/addVocabulary">
      Add Vocabulary
    </a>
  </div>

  <div class="user-profile">
    <span class="user-icon">&#128100;</span>
    <span>${sessionScope.userName}</span>
  </div>

</nav>


<main class="dashboard-container">

  <section class="dashboard-welcome">
    <h1>Welcome back!</h1>

    <p>
      Halloo! Ready to continue learning German?
    </p>
  </section>


  <section class="dashboard-section">

    <h2>What would you like to do today?</h2>

    <div class="dashboard-cards">

      <div class="dashboard-card">
        <div class="dashboard-icon">&#128218;</div>

        <h3>My Vocabulary</h3>

        <p>
          View and manage all the German words
          you have saved in your personal collection.
        </p>

        <a href="${pageContext.request.contextPath}/vocabulary"
           class="card-button">
          View Vocabulary
        </a>
      </div>


      <div class="dashboard-card">
        <div class="dashboard-icon">&#128269;</div>

        <h3>Add New Words</h3>

        <p>
          Search the German dictionary, discover
          translations, articles, and plural forms.
        </p>

        <a href="${pageContext.request.contextPath}/addVocabulary"
           class="card-button">
          Add Vocabulary
        </a>
      </div>

    </div>

  </section>

</main>

</body>
</html>
