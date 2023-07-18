# Movie Ticket Reservation System (BackEnd)
This Repository contains the code for backend of the MTRS. It is hosted on Render [Link](https://mtrs.onrender.com). Running on a free tier might take some time to load initially. To access any endpoint first need to use /signup endpoint then /login endpoint to get the jwt. Working the Endpoints documentation.

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

The Movie Ticket Reservation System is a web application built with Spring Boot 3 and java 11 that allows users to reserve movie tickets online. It provides a user-friendly interface for browsing movies, selecting showtimes, and making reservations. This project aims to simplify the process of managing movie ticket bookings and enhance the overall movie-going experience.

## Features

- Browse movies: Users can view the list of available movies and their details, such as title, genre, release date, duration, director, and description.
- Select showtimes: Users can choose from various showtimes for a specific movie, including the start time, end time, and available seats.
- Make reservations: Users can select their desired seats and make reservations for a specific movie and showtime. The system tracks the number of tickets and calculates the total amount.
- User authentication: The system provides user authentication to ensure secure access to reservation functionality.
- Admin dashboard: An admin dashboard allows authorized personnel to manage movies, theaters, showtimes, and reservations.

## Technologies Used

Language - Java 17

Framework - Spring boot 3.0

Database - PostgreSQL

Message Broker - ActiveMQ

Cloud - Render

Unit Testing - Junit

Mock testing - Mockito

Logging = Log4j

Build tool - Maven

IDE - Intellij

## Getting Started

Follow these steps to get the Movie Ticket Reservation System up and running on your local machine:

1. Clone the repository:

   ```shell
   git clone https://github.com/saahilanande/Backend-MTRS.git
   
Configure the database:

Create a new MySQL database.
Update the application.properties file with your database connection details.
Do load dummy data Cvs files can be imported in the table. Files are located in resource/Data 

Build and run the application:

Set all the Environment variables in application.properties file

Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
Build the project and resolve any dependencies.
Run the application, and it should start on http://localhost:8080.
Access the application:

Open a web browser and visit http://localhost:8080 to access the movie ticket reservation system.
Contributing
Contributions are welcome! If you'd like to contribute to the Movie Ticket Reservation System, please follow these steps:

Fork the repository.
Create a new branch for your feature or bug fix.
Make the necessary changes and commit them.
Push your changes to your forked repository.
Submit a pull request to the original repository.
License
This project is licensed under the MIT License. Feel free to modify and use it according to your needs.

Acknowledgements
OpenAPI GPT-3.5 for providing assistance in generating responses to user queries.
Spring Boot for the powerful and easy-to-use Java framework.
MySQL for the reliable and efficient relational database management system.
Contact
If you have any questions or suggestions regarding the Movie Ticket Reservation System, feel free to contact us at saahilanande21@gmail.com.

