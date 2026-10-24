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

## User Story US — Manage User Accounts

As a German learner, I want my account information to be saved in the database so that the application can identify my account.

### Tasks
- [X] Create `addUserSuccess()` in `UserDaoTest.java`.
- [X] Run the test and verify that a new user is saved in the database.
- [X] Verify that the new user can be retrieved using its generated ID.
- [X] Create a test for retrieving a user by ID.
- [X] Create a test for retrieving all users.
- [X] Create a test for deleting a user.
- [X] Run all `UserDaoTest` tests and fix any failures.


## User Story US — Manage Vocabulary Entries

As a German learner, I want to save, view, update, and delete vocabulary entries so that I can maintain my personal German vocabulary list.

### Tasks
- [X] Finish the test for retrieving vocabulary by ID.
- [X] Run the vocabulary insertion test and verify the new entry is saved.
- [X] Run the vocabulary update test and verify the changes persist.
- [X] Run the vocabulary deletion test and verify the entry no longer exists.
- [X] Finish the test for retrieving vocabulary by property.
- [X] Run all `VocabularyDaoTest` tests and fix any failures.

## User Story US — Associate Vocabulary with a User

As a German learner, I want each vocabulary entry to be associated with its owner so that the application can manage vocabulary belonging to individual users.

### Tasks
- [X] Create a test verifying that deleting a user also deletes their vocabulary entries.
- [X] Create a test verifying that deleting a vocabulary entry does not delete its owner.
- [X] Run both relationship tests and verify the expected results.
- [X] Verify that `User` and `Vocabulary` have the correct Hibernate relationship mappings.
- [X] Fix any database or Hibernate errors found during testing.

## User Story US — Log Application Activity

As a developer, I want database operations to use Log4J logging so that I can troubleshoot problems without using `System.out.println()`.

### Tasks
- [X] Check that `UserDao` uses Log4J for relevant database operations.
- [X] Check that `VocabularyDao` uses Log4J for relevant database operations.
- [X] Remove any remaining `System.out.println()` statements.
- [X] Run the DAO tests and confirm that logging works.

## Week 7 — AWS Elastic Beanstalk Deployment and Amazon Cognito Authentication

## User Story US — User Registration

As a user, I want to create an account so that I can securely access my personal vocabulary and learning progress.

### Tasks

- [X] Create an Amazon Cognito User Pool.
- [X] Configure the required sign-up fields, such as email and password.
- [X] Configure email verification if required when you are singing up.
- [X] Configure the Cognito app client for the application.
- [X] Review the Cognito settings and identify the information the Java application needs.
- [X] Implement the registration flow using Cognito.
- [X] Display a confirmation message after successful registration.
- [X] Handle registration errors, such as an existing email or an invalid password.
- [X] Test creating a new account.

## User Story US — User Login and Logout

As a registered user, I want to log in and log out so that I can access my account securely.

### Tasks

- [X] Connect the login flow to Amazon Cognito.
- [X] Handle successful login and invalid credentials.

---

## Deployment Tasks — AWS Elastic Beanstalk

### Tasks

- [X] Confirm that the application runs locally on Tomcat 9.
- [X] Create or configure an AWS Elastic Beanstalk environment.
- [X] Select the Tomcat 9 platform with Amazon Corretto 11.
- [X] Deploy the WAR file to Elastic Beanstalk.
- [X] Configure the environment variables and settings required by the application.
- [X] Configure database connectivity for the deployed application.
- [X] Open the deployed application URL and verify that the application starts.
- [X] Review application logs and fix deployment errors.

---

## User Story US — View Saved Vocabulary

As a user, I want to view my saved vocabulary so that I can review the words I have learned.

### Tasks

- [X] Create base JSP
- [X] Create VocabularyDao
- [X] Verify that the deployed vocabulary page displays database records.
- [X] Create Servlet
- [X] Confirm that the Servlet retrieves vocabulary from the database and forwards it to the JSP.
- [X] Test the vocabulary page in the AWS environment.
- [X] Fix any database connection or display errors.

---

## Week 8 — Cognito On BeanStalk

## User Story US — User Registration

As a user, I want to create an account so that I can securely access my personal vocabulary and learning progress.

### Tasks

- [X] Create certificates.
- [X] Set up file structure and download the config files.
- [X] Add the certificates to the https-instance.congif
- [X] Add the right link in cognito and also in my cognito.properties file
- [X] Change proxy to Apache
- [X] Test the cognito works on Beanstalk


## Week 9 - CheckPoint 3

Deployed to AWS, at least one JSP that displays data from the database is implemented, authentication implemented.

## Tasks

- [X] Set up beanStalk environment 
- [X] Test the environment locally with data from database
- [X] Set up Cognito and all the auth files
- [X] Create cognito.properties file (Git Ignore)
- [X] Create the auth controller
- [X] Create certificates.
- [X] Set up file structure and download the config files.
- [X] Add the certificates to the https-instance.congif
- [X] Add the right link in cognito and also in my cognito.properties file
- [X] Change proxy to Apache
- [X] Test the cognito works on Beanstalk
- [X] Create JSP that shows the data from database

## Week 10 — Application Testing and Requirements Audit

## User Story US — View Saved Vocabulary

As a user, I want to view my saved vocabulary so that I can review the words I have learned.

### Tasks

- [ ] Create tables for Grammar cases
- [ ] Create table for vocabulary cases
- [ ] Create table for flash cards
- [ ] Connect tables with foreign keys and make sure they are working
- [ ] Starting to integrate API an
- [ ] Open the vocabulary page locally and in AWS, if deployed.
- [ ] Verify that vocabulary entries are retrieved from the database.
- [ ] Check the display of German words, English meanings, articles, and plural forms.
- [ ] Test the page when no vocabulary entries exist.
- [ ] Verify that users cannot view another user's vocabulary.
- [ ] Record any database or display errors.
- [ ] Adding a generic DAO


## SoapUI — HTTP Testing

### Tasks

- [ ] Test the existing vocabulary page route.
- [ ] Record response status codes and unexpected results.
- [ ] Test an invalid route and check the error response.
- [ ] Determine whether the application currently exposes REST endpoints or only JSP pages and Servlets.
- [ ] If REST endpoints already exist, test the available requests.
- [ ] Save screenshots or test notes as evidence.

---

# Week 11 — Dictionary API Integration, Application Improvements and styling

## User Story US — Search German Words Using a Dictionary API

As a user, I want to search for German words using a dictionary API so that I can find meanings and grammatical information without entering everything manually.

### Tasks


- [ ] Research dictionary APIs that support German vocabulary.
- [ ] Select an API that provides useful information for the project.
- [ ] Create JSP with form to enter words so the API can give me the information
- [ ] Create a button to add the words to my list
- [ ] Create DAO and unit tests for the API
- [ ] Review its documentation, request format, response format, and usage limits.
- [ ] Test a valid German word.
- [ ] Test missing parameters or invalid requests.
- [ ] Identify the response fields needed by the application.
- [ ] Start adding some CSS to my app and Boostrap 


## User Story US — Retrieve Articles and Plural Forms

As a user, I want to retrieve German noun articles and plural forms .

### Tasks

- [ ] Add CSS and Boostrap 
- [ ] Check whether the selected API returns noun articles and plural forms.
- [ ] Test several German nouns.
- [ ] Determine how to handle missing grammatical information.
- [ ] Display the article and plural form when the API provides them.
- [ ] Create forms to get information form the user
- [ ] Create buttons to insert information into tables 
- [ ] Allow users to enter missing information manually.
- [ ] Document any limitations of the selected API.

---

# Week 12 — Dictionary API Integration, Application Improvements and styling

## User Story US — Add German Words and English Meanings (German cases and )

As a user, I want to add German words with their English meanings so that I can build my own vocabulary list.

### Tasks

- [ ] Review the existing vocabulary form.
- [ ] Allow users to search for a word before entering it manually.
- [ ] Populate available form fields with dictionary results.
- [ ] Allow users to review and correct the returned information.
- [ ] Save the vocabulary entry using VocabularyDao.
- [ ] Verify that the entry is associated with the correct user.
- [ ] Test saving a word returned by the API.

## Week 13 - Flash Cards and more styling

### Tasks

- [ ] Fix critical registration, login, or logout problems found during testing.
- [ ] Fix the most important database or vocabulary display errors.
- [ ] Correct any identified authorization issues before adding more features.
- [ ] Add or improve tests for the Java API integration.
- [ ] Retest affected functionality after making changes.
- [ ] Make sure all connections and integrations work, forms, button, call backs, app deplying information from database, etc.. 


## Week 13

### Tasks

-[ ] More styling and fixing last bugs
-[ ] Complete and add all tasks that couldn't be completed in previous weeks.
-[ ]
-[ ]
-[ ]
-[ ]


## Week 14

## Tasks

- [ ] Create project presentation 