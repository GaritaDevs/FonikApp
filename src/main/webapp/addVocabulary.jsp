
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Add Vocabulary - Fonik App</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addVocabulary.css">
</head>

<body>

<!-- NAVBAR -->

<nav class="navbar">

  <div class="logo">
    Fonik App
  </div>

  <div class="nav-links">
    <a href="${pageContext.request.contextPath}/login.jsp">Dashboard</a>

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



<main class="add-vocabulary-container">

  <section class="add-vocabulary-header">

    <h1>Add New Vocabulary</h1>

    <p>
      Expand your German vocabulary by searching the dictionary
      or adding words manually.
    </p>

  </section>


  <!-- OPTION 1: DICTIONARY API -->

  <section class="add-vocabulary-section">

    <div class="section-heading">
      <span class="section-icon">&#128269;</span>
      <h2>Search German Dictionary</h2>
    </div>

    <p>
      Enter a German word to retrieve its English meaning,
      article, and plural automatically.
    </p>

    <form action="${pageContext.request.contextPath}/addVocabulary" method="post">

      <input type="hidden" name="action" value="lookup">

      <label for="searchWord">German Word</label>

      <input type="text"
             id="searchWord"
             name="germanWord"
             placeholder="Example: Hund"
             required>

      <button type="submit" class="add-button">
        Search Dictionary
      </button>

    </form>

    <!-- ERROR MESSAGE -->

    <c:if test="${not empty errorMessage}">
      <p class="error-message">${errorMessage}</p>
    </c:if>


    <!-- DISPLAY API RESULTS -->

    <c:if test="${not empty suggestedVocabulary}">

      <div class="dictionary-results">

        <h3>Dictionary Results</h3>

        <p>
          Review the information below before adding it
          to your personal vocabulary.
        </p>

        <form action="${pageContext.request.contextPath}/addVocabulary" method="post">

          <input type="hidden" name="action" value="save">

          <label for="apiWord">German Word</label>

          <input type="text"
                 id="apiWord"
                 name="germanWord"
                 value="${suggestedVocabulary.germanWord}"
                 required>

          <label for="apiMeaning">English Meaning</label>

          <input type="text"
                 id="apiMeaning"
                 name="englishMeaning"
                 value="${suggestedVocabulary.englishMeaning}"
                 required>

          <label for="apiArticle">Article</label>

          <select id="apiArticle" name="article" required>
            <option value="der" ${suggestedVocabulary.article == 'der' ? 'selected' : ''}>der</option>
            <option value="die" ${suggestedVocabulary.article == 'die' ? 'selected' : ''}>die</option>
            <option value="das" ${suggestedVocabulary.article == 'das' ? 'selected' : ''}>das</option>
          </select>

          <label for="apiPlural">Plural</label>

          <input type="text"
                 id="apiPlural"
                 name="plural"
                 value="${suggestedVocabulary.plural}">

          <button type="submit" class="add-button">
            Add to My Vocabulary
          </button>

        </form>

      </div>

    </c:if>

  </section>


  <!-- OPTION 2: MANUAL ENTRY -->

  <section class="add-vocabulary-section">

    <div class="section-heading">
      <span class="section-icon">&#9998;</span>
      <h2>Add Vocabulary Manually</h2>
    </div>

    <p>
      Already know a German word? Enter its information
      yourself and save it to your collection.
    </p>

    <form action="${pageContext.request.contextPath}/addVocabulary" method="post">

      <input type="hidden" name="action" value="saveManual">

      <label for="manualWord">German Word</label>

      <input type="text"
             id="manualWord"
             name="germanWord"
             placeholder="Example: Haus"
             required>

      <label for="manualMeaning">English Meaning</label>

      <input type="text"
             id="manualMeaning"
             name="englishMeaning"
             placeholder="Example: House"
             required>

      <label for="manualArticle">Article</label>

      <select id="manualArticle" name="article" required>
        <option value="">Select an article</option>
        <option value="der">der</option>
        <option value="die">die</option>
        <option value="das">das</option>
      </select>

      <label for="manualPlural">Plural</label>

      <input type="text"
             id="manualPlural"
             name="plural"
             placeholder="Example: Häuser">

      <button type="submit" class="add-button">
        Add to My Vocabulary
      </button>

    </form>

  </section>



  <section class="add-vocabulary-footer">

    <a href="${pageContext.request.contextPath}/vocabulary">
      &#8592; Back to My Vocabulary
    </a>

  </section>

</main>

</body>
</html>
