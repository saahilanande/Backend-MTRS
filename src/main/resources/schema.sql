CREATE TABLE IF NOT EXISTS users (
	user_id serial PRIMARY KEY,
    "role" VARCHAR ( 50 ) NOT NULL,
    username VARCHAR ( 50 ) NOT NULL,
    "password" VARCHAR ( 500 ) NOT NULL,
    email VARCHAR ( 255 ) UNIQUE NOT NULL,
    phone int
);

CREATE TABLE IF NOT EXISTS Movies (
    movie_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(255),
    release_date smallint,
    duration VARCHAR(255),
    rating FLOAT,
    movie_img VARCHAR(255),
    description VARCHAR(500),
    status VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Theaters (
    theater_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    capacity smallint
);

CREATE TABLE IF NOT EXISTS Showtimes (
    showtime_id SERIAL PRIMARY KEY,
    movie_id INTEGER REFERENCES Movies(movie_id),
    theater_id INTEGER REFERENCES Theaters(theater_id),
    movie_date DATE,
    start_time time
);

CREATE TABLE IF NOT EXISTS Seats (
    seat_id SERIAL PRIMARY KEY,
    theater_id INTEGER REFERENCES Theaters(theater_id),
    seat_number VARCHAR(10),
    status VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Reservations (
    reservation_id SERIAL PRIMARY KEY,
    showtime_id INTEGER REFERENCES Showtimes(showtime_id),
    seat_id INTEGER REFERENCES Seats(seat_id),
    user_id INTEGER REFERENCES users(user_id),
    reservation_date DATE
);