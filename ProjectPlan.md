# Upcoming Project Tasks

## Week 4 — Project Setup & Database Design

### Tasks

* Finalize the database design.
* Identify the entities needed for the application.
* Create the database and tables.
* Set up Hibernate and JPA.
* Create the initial Java entity classes.
* Set up the project structure for DAO development.

### Requirements to Complete

* [ ] Database design is finalized.
* [ ] Database is created.
* [ ] Tables and relationships are defined.
* [ ] Hibernate/JPA is configured.
* [ ] Entity classes are connected to the database.

---

## Week 5 — DAO Development

### Tasks

* Create the DAO for the vocabulary entity.
* Implement the **Create** operation.
* Implement the **Read** operation.
* Implement the **Update** operation.
* Implement the **Delete** operation.
* Connect the DAO to Hibernate.
* Test each CRUD operation manually.

### Requirements to Complete

* [ ] At least one DAO is implemented.
* [ ] DAO can create records.
* [ ] DAO can read records.
* [ ] DAO can update records.
* [ ] DAO can delete records.
* [ ] CRUD operations work correctly with Hibernate.
* [ ] Database changes are correctly reflected in the application.

---

## Week 6 — Unit Testing & Logging

### Tasks

* Create JUnit tests for the DAO.
* Test Create, Read, Update, and Delete operations.
* Fix any problems found during testing.
* Implement Log4J.
* Replace all `System.out.println()` statements with appropriate logging.
* Review the DAO and database code for errors.

### Requirements to Complete

* [ ] DAO has unit tests.
* [ ] Create operation is tested.
* [ ] Read operation is tested.
* [ ] Update operation is tested.
* [ ] Delete operation is tested.
* [ ] All DAO tests pass.
* [ ] Log4J is implemented.
* [ ] No `System.out.println()` statements are used.
* [ ] Errors and important application events are logged.

---

## Week 7 — Checkpoint 2

- **US-01:** As a user, I want to create an account so that I can securely access my personal vocabulary and learning progress.
- **US-02:** As a registered user, I want to log in and log out so that I can access my account securely.

### Checkpoint 2 Requirements

By the end of Week 7, the following must be completed:

* [ ] Database is designed and created.
* [ ] At least one DAO is implemented.
* [ ] DAO has full CRUD functionality.
* [ ] CRUD is implemented using Hibernate.
* [ ] DAO is fully unit tested.
* [ ] All unit tests pass.
* [ ] Log4J is implemented.
* [ ] No `System.out.println()` statements remain.


---

## Week 8 — JSP & Authentication

### Tasks

* Create the first JSP page for the application.
* Connect the JSP to the database.
* Display vocabulary data from the database.
* Begin implementing user authentication.
* Connect authentication to the application's user data.
* Test the login functionality.

### Requirements to Complete

* [ ] At least one JSP page is implemented.
* [ ] JSP successfully retrieves data from the database.
* [ ] Database information is displayed on the JSP.
* [ ] Authentication functionality is implemented.
* [ ] Users can successfully log in.
* [ ] Invalid login attempts are handled appropriately.
* [ ] Application is ready for AWS deployment.

---

## Week 9 — Checkpoint 3

### Checkpoint 3 Requirements

By the end of Week 9, the following must be completed:

* [ ] Application is deployed to AWS.
* [ ] At least one JSP displays data from the database.
* [ ] Authentication is implemented.
* [ ] Deployed application is accessible.
* [ ] Application link is added to `IndividualProjects.md` on GitHub.

### Final Tasks

* Test the deployed application.
* Fix any deployment issues.
* Verify authentication on AWS.
* Verify that the JSP displays database information.
* Add the deployed application link to GitHub.
* Commit and push all final Checkpoint 3 changes.
