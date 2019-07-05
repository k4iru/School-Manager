# School Management System

This was a final project for one of my Software Engineering classes.  

# The Problem 

In groups of 4, we were tasked with designing a management system where you could log in as either an Admin, Instructor, or Student, after which you would be presented with the available commands such as adding students to a class or updating grades.

# What I Learned 

This was the largest project I've donei yet. I learned a lot about how to work efficiently with others, as well as various design patterns. In the end we decided on using the Factory Method design pattern to easily add new classes and students. We also decided to implement a singleton so that only one instance of the database would exist at anytime. My next step would be to create a GUI for the application as well as fully implement a database. For the purposes of this project we were allowed to read from txt files. 

# How to Run on Linux

1. in terminal cd to the src folder
2. run `javac ./testHarness/TestHarness.java`
3. run `java ./testHarness/TestHarness`
4. log in as any user specified in the database.txt
