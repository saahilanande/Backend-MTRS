CREATE TABLE IF NOT EXISTS users (
	userId serial PRIMARY KEY,
	"role" VARCHAR ( 50 ) NOT NULL,
	username VARCHAR ( 50 ) NOT NULL,
	"password" VARCHAR ( 500 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	phone int
);

CREATE TABLE IF NOT EXISTS Movies (
  movieId SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  genre VARCHAR(255),
  releaseDate smallint,
  duration VARCHAR(255),
  rating INTEGER,
  movieImg VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Theaters (
  theaterId SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255),
  city VARCHAR(255),
  state VARCHAR(255),
  capacity smallint
);

CREATE TABLE IF NOT EXISTS Showtimes (
  showtimeId SERIAL PRIMARY KEY,
  movieId INTEGER REFERENCES Movies(movieId),
  theaterId INTEGER REFERENCES Theaters(theaterId),
  startTime TIMESTAMP,
  endTime TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Seats (
  seatId SERIAL PRIMARY KEY,
  theaterId INTEGER REFERENCES Theaters(theaterId),
  seatNumber VARCHAR(10),
  status VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Reservations (
  reservationId SERIAL PRIMARY KEY,
  showtimeId INTEGER REFERENCES Showtimes(showtimeId),
  seatId INTEGER REFERENCES Seats(seatId),
  userId INTEGER REFERENCES users(userId),
  reservation_date DATE
);