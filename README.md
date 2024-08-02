# Java Quiz Game 🎮

Welcome to the Java Quiz Game project! This project is a simple quiz game application with a graphical user interface. It allows users to register, log in, and participate in quizzes. The project uses MySQL for storing user registration data.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Running the Project](#running-the-project)
- [Directory Structure](#directory-structure)
- [License](#license)
- [Contact](#contact)

## Features

- **User Registration**: Allows new users to register with a username, email, and password ✍️
- **User Login**: Users can log in with their credentials 🔐
- **Quiz Functionality**: Participate in quizzes and view your score 🎉

## Technologies Used

- **Java**: Core language for the application
- **Swing**: GUI components for the user interface
- **MySQL**: Database for storing user data
- **JDBC**: Java Database Connectivity for MySQL

## Setup

Follow these steps to set up the project on your local machine:

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Parthchauh/java-Quiz-Game.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd java-Quiz-Game
    ```

3. **Configure MySQL Database:**

   Ensure you have a MySQL database running and create a database for the quiz game. Also, create a `registerinfo` table as shown below:

   ```sql
   CREATE DATABASE quiz_game;
   USE quiz_game;
   CREATE TABLE registerinfo (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(255) NOT NULL,
       email VARCHAR(255) NOT NULL,
       password VARCHAR(255) NOT NULL
   );```

## Running the Project

1. **Compile the Java Files:**

   Open a terminal and run the following command:

   ```bash
   javac -cp .;"D:\java folder\test\mysql-connector-j-9.0.0\mysql-connector-j-9.0.0.jar" QuizGame.java
   java -cp .;"D:\java folder\test\mysql-connector-j-9.0.0\mysql-connector-j-9.0.0.jar" QuizGame
