-- Create Authors Table
CREATE TABLE Authors2 (
    AuthorID SERIAL PRIMARY KEY,
    Name VARCHAR(100) NOT NULL
);

-- Create Genres Table
CREATE TABLE Genres1 (
    GenreID SERIAL PRIMARY KEY,
    Name VARCHAR(100) NOT NULL
);

-- Create Books Table
CREATE TABLE Books1 (
    BookID SERIAL PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    PubDate DATE NOT NULL
);

-- Create Songs Table
CREATE TABLE Songs1 (
    SongID SERIAL PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    PubDate DATE NOT NULL,
    GenreID INT NOT NULL,
    AuthorID INT NOT NULL,
    BookID INT NOT NULL,
    FOREIGN KEY (GenreID) REFERENCES Genres(GenreID),
    FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID),
    FOREIGN KEY (BookID) REFERENCES Books(BookID)
);
