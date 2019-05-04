## Introduction
Our project is a grading system designed for university professors.

For existing tool like Excel, there are many disadvantages and functions which are not fulfilled. 

In other words, our motivation for creating this project is to:  

*Create a excellent grading system tool which goes beyond Excel and other grading tools.*

## Features
We consider the grading system in four features. We thinks these four parts play an important tole in our project. 

And each part we have several detailed aspect explained well about the keyword. 

- Flexible
  * Increase or decrease, update the number of columns, rows
- Reusable
  * Imported from already existed tables
- Customizable
  * Create or adjust any grade criteria 
  * Save the customized grading model 
- Statistics
  * Get the average grade and other statistics of assignments.
  
## Steps to run the code
#### Step 1(important):
For this project, we use IDEA as editor and we install and manage our third part module by Maven.

If want to run our code in IDEA, you can open it and import all the changes or reimport``pom.xml``

#### Step 2(important):  
Make sure you've installed MySQL in your computer. If you haven't, you can use the [link](https://dev.mysql.com/doc/refman/8.0/en/installing.html) to download mysql 
#### Step 3(important):
Check the ``AppConf.java`` file for the four strings.  
For the database we used, our database name is ``gradingsystem``, our username is ``root``and our password is ``""``, so you must change this part if you want our project to run on your laptop.
```java
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/gradingsystem?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
    private static final String username = "root";
    private static final String password = "";
```
#### Step 4:
Run the ``GradingSystemApplication.java`` to initialize our database tables.
#### Step 5(Optional):
You can run our unit test function under ``test`` file to check your SQL and databases work well.
#### Final Step:
After finishing all of these steps, you can now run the ``GUI.java`` in the package called ``GUI`` and doing whatever functions you like.

## Problems may met and solutions
- When we input some data to our assignment table, we must click ``save sheet`` button anywhere in the table after inputting some data, in order to make sure that our data is saved into database.

- Please enter valid input otherwise the system will show some errors.

- When you want to delete certain column, you can choose the column in any unit and click ``delete colume`` button.

- If you want to import some data from local file, you must first define the form of these data. The number of data column must be the same as the table.

- If you can't see the background picture, you can check whether is path is right or just connect us by email directly.

- We use Maven to install and manage our module. 
Please check the modules under all installed correctly.
    - mysql
    - lombok
    - junit
    - opencsv  

  In detail, we should add dependencies below:
    ```java
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.13</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/junit/junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.opencsv</groupId>
            <artifactId>opencsv</artifactId>
            <version>4.1</version>
        </dependency>
    </dependencies>
    ```


  



