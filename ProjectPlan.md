# Upcoming Project Tasks

## Week 4 — Project Setup & Database Design

### Tasks

* Finalize the database design.
* Identify the entities needed for the application.
* Create the database and tables.
* Set up Hibernate and JPA.
* Create the initial Java entity classes.
* Create all getter and setters
* Create my first JSP


---

## Week 5 — Setup and DataBase 

### Tasks

* Create the first User with SQL query.
* Create the first set of vocabulary for the first User
* Create my first DAOs but don't add any code yet
* Test that the databases work and were connected with the foreign key 
* Crete my SessionFactory
* Add dependencies 
* Create Hibernate.xml



---

## Week 6 — Database Relationships and DAO Testing

## Goal
Finish and verify the DAO functionality and unit tests for the `User` and `Vocabulary` entities, including their relationship.

## User Story US-04 — Manage User Accounts

As a German learner, I want my account information to be saved in the database so that the application can identify my account.

### Tasks
- [ ] Create `addUserSuccess()` in `UserDaoTest.java`.
- [ ] Run the test and verify that a new user is saved in the database.
- [ ] Verify that the new user can be retrieved using its generated ID.
- [ ] Create a test for retrieving a user by ID.
- [ ] Create a test for retrieving all users.
- [ ] Create a test for deleting a user.
- [ ] Run all `UserDaoTest` tests and fix any failures.


## User Story US-05 — Manage Vocabulary Entries

As a German learner, I want to save, view, update, and delete vocabulary entries so that I can maintain my personal German vocabulary list.

### Tasks
- [ ] Finish the test for retrieving vocabulary by ID.
- [ ] Run the vocabulary insertion test and verify the new entry is saved.
- [ ] Run the vocabulary update test and verify the changes persist.
- [ ] Run the vocabulary deletion test and verify the entry no longer exists.
- [ ] Finish the test for retrieving vocabulary by property.
- [ ] Run all `VocabularyDaoTest` tests and fix any failures.

## User Story US-06 — Associate Vocabulary with a User

As a German learner, I want each vocabulary entry to be associated with its owner so that the application can manage vocabulary belonging to individual users.

### Tasks
- [ ] Create a test verifying that deleting a user also deletes their vocabulary entries.
- [ ] Create a test verifying that deleting a vocabulary entry does not delete its owner.
- [ ] Run both relationship tests and verify the expected results.
- [ ] Verify that `User` and `Vocabulary` have the correct Hibernate relationship mappings.
- [ ] Fix any database or Hibernate errors found during testing.

## User Story US-07 — Log Application Activity

As a developer, I want database operations to use Log4J logging so that I can troubleshoot problems without using `System.out.println()`.

### Tasks
- [ ] Check that `UserDao` uses Log4J for relevant database operations.
- [ ] Check that `VocabularyDao` uses Log4J for relevant database operations.
- [ ] Remove any remaining `System.out.println()` statements from the relevant DAO code.
- [ ] Run the DAO tests and confirm that logging works.

## Week 7 — AWS Elastic Beanstalk Deployment and Amazon Cognito Authentication

## Goal

Deploy the German Learning Tracker to AWS Elastic Beanstalk and integrate Amazon Cognito to manage user registration, login, and logout.

---

## User Story US-01 — User Registration

As a user, I want to create an account so that I can securely access my personal vocabulary and learning progress.

### Tasks

- [ ] Create an Amazon Cognito User Pool.
- [ ] Configure the required sign-up fields, such as email and password.
- [ ] Configure email verification if required.
- [ ] Configure the Cognito app client for the application.
- [ ] Review the Cognito settings and identify the information the Java application needs.
- [ ] Implement the registration flow using Cognito.
- [ ] Display a confirmation message after successful registration.
- [ ] Handle registration errors, such as an existing email or an invalid password.
- [ ] Test creating a new account.

## User Story US-02 — User Login and Logout

As a registered user, I want to log in and log out so that I can access my account securely.

### Tasks

- [ ] Create a login page for the application.
- [ ] Connect the login flow to Amazon Cognito.
- [ ] Handle successful login and invalid credentials.
- [ ] Establish an authenticated session for the signed-in user.
- [ ] Implement logout functionality.
- [ ] Verify that logging out ends the user's application session.
- [ ] Test login, invalid login, and logout.

---

## Deployment Tasks — AWS Elastic Beanstalk

### Tasks

- [ ] Confirm that the application runs locally on Tomcat 9.
- [ ] Create or configure an AWS Elastic Beanstalk environment.
- [ ] Select the Tomcat 9 platform with Amazon Corretto 11.
- [ ] Deploy the WAR file to Elastic Beanstalk.
- [ ] Configure the environment variables and settings required by the application.
- [ ] Configure database connectivity for the deployed application.
- [ ] Open the deployed application URL and verify that the application starts.
- [ ] Review application logs and fix deployment errors.

---

## User Story US-07 — View Saved Vocabulary

As a user, I want to view my saved vocabulary so that I can review the words I have learned.

### Tasks

- [ ] Verify that the deployed vocabulary page displays database records.
- [ ] Confirm that the Servlet retrieves vocabulary from the database and forwards it to the JSP.
- [ ] Test the vocabulary page in the AWS environment.
- [ ] Fix any database connection or display errors.

---

## Week 8 — Application Testing and Requirements Audit

## Goal

Test the German Learning Tracker using SoapUI, verify the current application functionality, and identify missing requirements before adding more features.

---

## User Story US-01 — User Registration

As a user, I want to create an account so that I can securely access my personal vocabulary and learning progress.

### Tasks

- [ ] Test registration with a new account in Amazon Cognito.
- [ ] Test registration with an account that already exists.
- [ ] Test invalid or incomplete registration information.
- [ ] Verify email confirmation if enabled.
- [ ] Check whether understandable error messages are displayed.
- [ ] Record any registration issues that need fixing.

## User Story US-02 — User Login and Logout

As a registered user, I want to log in and log out so that I can access my account securely.

### Tasks

- [ ] Test login with valid credentials.
- [ ] Test login with an incorrect password.
- [ ] Test access to protected pages while logged out.
- [ ] Test logout.
- [ ] Attempt to revisit a protected page after logout.
- [ ] Verify whether the application identifies the correct signed-in user.
- [ ] Record authentication problems.


## Week 9 — Application Testing and Requirements Audit


## User Story US-07 — View Saved Vocabulary

As a user, I want to view my saved vocabulary so that I can review the words I have learned.

### Tasks

- [ ] Open the vocabulary page locally and in AWS, if deployed.
- [ ] Verify that vocabulary entries are retrieved from the database.
- [ ] Check the display of German words, English meanings, articles, and plural forms.
- [ ] Test the page when no vocabulary entries exist.
- [ ] Verify that users cannot view another user's vocabulary.
- [ ] Record any database or display errors.

## SoapUI — HTTP Testing

### Tasks

- [ ] Create a collection named German Learning Tracker Tests.
- [ ] Test the existing vocabulary page route.
- [ ] Record response status codes and unexpected results.
- [ ] Test an invalid route and check the error response.
- [ ] Determine whether the application currently exposes REST endpoints or only JSP pages and Servlets.
- [ ] If REST endpoints already exist, test the available requests.
- [ ] Save screenshots or test notes as evidence.

**Note:** Do not create fake endpoints just for testing. If the application currently uses JSP pages and Servlets, test those routes first and decide whether a REST endpoint is necessary.

## Requirements Audit

### Tasks

- [ ] Review the original user stories and mark each as complete, incomplete, or not started.
- [ ] Verify that UserDao and VocabularyDao support the required CRUD operations.
- [ ] Review JUnit coverage for DAO operations and user-vocabulary relationships.
- [ ] Verify that Log4J is used instead of `System.out.println`.
- [ ] Check the AWS deployment and database connection.
- [ ] Verify that the deployed application URL is added to `IndividualProjects.md`.
- [ ] Review the grammar and flashcard requirements.
- [ ] Identify the most important unfinished requirements for Week 11.

---

# Week 10 — Dictionary API Integration and Application Improvements

## Goal

Select and test a German dictionary API, integrate it into the Java application, and improve any critical functionality identified during Week 10 testing.

---

## User Story US-15 — Search German Words Using a Dictionary API

As a user, I want to search for German words using a dictionary API so that I can find meanings and grammatical information without entering everything manually.

### Tasks

- [ ] Research dictionary APIs that support German vocabulary.
- [ ] Select an API that provides useful information for the project.
- [ ] Review its documentation, request format, response format, and usage limits.
- [ ] Test a valid German word using Postman.
- [ ] Test a word that is not found.
- [ ] Test missing parameters or invalid requests.
- [ ] Identify the response fields needed by the application.
- [ ] Implement a Java service class that sends requests to the selected API.
- [ ] Parse the API response and retrieve the relevant information.
- [ ] Display the returned information in the application.
- [ ] Handle API errors and missing results.
- [ ] Test the Java integration, not just the request in Postman.

## User Story US-16 — Retrieve Articles and Plural Forms

As a user, I want to retrieve German noun articles and plural forms from an external service when available so that I can save vocabulary more efficiently.

### Tasks

- [ ] Check whether the selected API returns noun articles and plural forms.
- [ ] Test several German nouns.
- [ ] Determine how to handle missing grammatical information.
- [ ] Display the article and plural form when the API provides them.
- [ ] Allow users to enter missing information manually.
- [ ] Document any limitations of the selected API.

---

# Week 11 — Dictionary API Integration and Application Improvements

## User Story US-03 — Add German Words and English Meanings

As a user, I want to add German words with their English meanings so that I can build my own vocabulary list.

### Tasks

- [ ] Review the existing vocabulary form.
- [ ] Allow users to search for a word before entering it manually.
- [ ] Populate available form fields with dictionary results.
- [ ] Allow users to review and correct the returned information.
- [ ] Save the vocabulary entry using VocabularyDao.
- [ ] Verify that the entry is associated with the correct user.
- [ ] Test saving a word returned by the API.

## Fixes from the Week 10 Audit

### Tasks

- [ ] Fix critical registration, login, or logout problems found during testing.
- [ ] Fix the most important database or vocabulary display errors.
- [ ] Correct any identified authorization issues before adding more features.
- [ ] Add or improve tests for the Java API integration.
- [ ] Retest affected functionality after making changes.
 is difficult to integrate, prioritize a working basic dictionary lookup before adding advanced grammar information.



  