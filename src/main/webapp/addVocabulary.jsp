<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Add Vocabulary</title>
</head>

<body>

<h1>German Learning Tracker</h1>

<h2>Add New Vocabulary</h2>

<!-- OPTION 1: DICTIONARY API -->

<h3>Option 1: Search German Dictionary</h3>

<p>Enter a German word to retrieve its meaning, article, and plural automatically.</p>

<form action="searchVocabulary" method="get">

  <label for="searchWord">German Word:</label>

  <input type="text"
         id="searchWord"
         name="germanWord"
         placeholder="Example: Hund"
         required>

  <button type="submit">Search Dictionary</button>

</form>


<!-- DISPLAY API RESULTS -->

<c:if test="${not empty suggestedVocabulary}">

  <hr>

  <h3>Dictionary Results</h3>

  <p>Review the information before adding it to your vocabulary.</p>

  <form action="addVocabulary" method="post">

    <label for="apiWord">German Word:</label>

    <input type="text"
           id="apiWord"
           name="germanWord"
           value="${suggestedVocabulary.germanWord}"
           readonly>

    <br><br>

    <label for="apiMeaning">English Meaning:</label>

    <input type="text"
           id="apiMeaning"
           name="englishMeaning"
           value="${suggestedVocabulary.englishMeaning}"
           required>

    <br><br>

    <label for="apiArticle">Article:</label>

    <select id="apiArticle" name="article" required>
      <option value="der" ${suggestedVocabulary.article == 'der' ? 'selected' : ''}>der</option>
      <option value="die" ${suggestedVocabulary.article == 'die' ? 'selected' : ''}>die</option>
      <option value="das" ${suggestedVocabulary.article == 'das' ? 'selected' : ''}>das</option>
    </select>

    <br><br>

    <label for="apiPlural">Plural:</label>

    <input type="text"
           id="apiPlural"
           name="plural"
           value="${suggestedVocabulary.plural}">

    <br><br>

    <button type="submit">Add to My Vocabulary</button>

  </form>

</c:if>


<hr>


<!-- OPTION 2: MANUAL ENTRY -->

<h3>Option 2: Add Vocabulary Manually</h3>

<p>Enter the vocabulary information yourself.</p>

<form action="addVocabulary" method="post">

  <label for="manualWord">German Word:</label>

  <input type="text"
         id="manualWord"
         name="germanWord"
         placeholder="Example: Haus"
         required>

  <br><br>

  <label for="manualMeaning">English Meaning:</label>

  <input type="text"
         id="manualMeaning"
         name="englishMeaning"
         placeholder="Example: House"
         required>

  <br><br>

  <label for="manualArticle">Article:</label>

  <select id="manualArticle" name="article" required>
    <option value="">Select an article</option>
    <option value="der">der</option>
    <option value="die">die</option>
    <option value="das">das</option>
  </select>

  <br><br>

  <label for="manualPlural">Plural:</label>

  <input type="text"
         id="manualPlural"
         name="plural"
         placeholder="Example: Häuser">

  <br><br>

  <button type="submit">Add to My Vocabulary</button>

</form>


<hr>

<a href="vocabulary">Back to My Vocabulary</a>

<br><br>

<a href="index.jsp">Back to Home</a>

</body>
</html>
