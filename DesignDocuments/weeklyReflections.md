## Week 4
- Date: 10/02/2026
- Hours: 2

Text: I created the properties file for the log4 and the database, I configured the
Tomcat and tested to make sure it was working. And I creates the database and the users table


## Week 5
- Date: 10/04/2026
- Hours: 1

Text: I added my getters, setters, constructors in my User and Vocabulary class. I added the dependency 5 of hibernate in my pom.xml
and I created the SessionFactoryProvider class inside my persistence folder to use hibernate. I also created the hibernate.xml


## Week 6
- Date: 10/07/2026
- Hours: 15

Text: Ok this week was a lot of work, I rewatched almost all the videos for hibernate, the DAOs, the UnitTest. So I can implement everything in the project
I created my database structure and the first two tables, my logs, hibernate, I built my userDao, vocabularyDao, my DaoTests, my first jsp to test my tomcat connection. 

## Week 7
- Date: 10/15/2026
- Hours 7

Text: I fixed some of the bugs I had on my log4j2 like the filepath and the file name. I added two of the tests that were missing, one that checks that when the vocabulary is deleted it doesn't delete the user and another one
that when the user is deleted it deletes all the vocabulary for that userId. I also deployed my app to AWS. And I will work on cognito


## Week 8
- Date: 10/22/2026
- Hours: 10

Text: I created my Beanstalk environment, I tested on my local machine and it worked. I also used Cognito to manage my log-in and sing-ups for my users 
The hard part was to put both together it took me a while to figure that out that the proxy was not saved when I made the change. I have my cognito working On beanstalk. 
Now I am ready to work in the next task.

## Week 9
- Date: 10/31/2023
- Hours: 7

Text: I fixed all the things that were mentioned on my peer review, like the typo in my screendesign.md, I removed the password field from my database and my code, I added my ERD to my screenDesigns. I also started testing the connection with my API, I'm using wiktapi this is a free German API.
I created my POJO classes, added the dependencies, and I am currently testing the information I get from the API.

## Week 10
- Date: 11/06/2026
- Hours: 9

Text: This week was a lot. I've been super busy with other classes and work, but I still had some time to make some changes.
I added functionalities to show only the vocabulary from the user the logged in, I created a GenericDao and I kept my UserDao and my VocabularyDao and those extend to my 
GenericDao and I added a specific method to get the vocabulary for the user. I also create the JSP with the forms where the user is gonna get the info from the API and I also 
he will have the option to enter the information manually. I finally fixed my project plan and added all the things I think I need to complete my project


## Week 11
- Date: 11/07/2026 - 
- Hours: 10

Text: I created the addVocabulary servlet, added a form from the data that was retrieved from my API in case I want to modify the data 
because for one word I can get multiple meanings, But I'm getting the information I need from the API but I can't save it to
my database yet, I'll keep working on it. I gitignore my hibernate file


## Week 12
- Date: 11/12/26
- Hours: 10

Text: I created a JSP that will be the home page before the user log in, I made all the CSS file for all my JSPs
The form is working, it's retrieving the words from the API and adding words to my DataBase. The form that adds the words manually
is not working yet. And my delete and update are still in progress. 



## Week 13
- Date: 11/17/26
- Hours: 

Text: I added the functionality to add the words manually to my DataBase. 


## Week 14
- Date:
- Hours

Text: 


## Week 15
- Date:
- Hours

Text: 


## Week 16
- Date:
- Hours

Text: 