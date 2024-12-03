-- Insert sample data into Authors table
INSERT INTO Authors2 (Name) VALUES
('John Doe'),
('Jane Smith'),
('Michael Johnson');

-- Insert sample data into Genres table
INSERT INTO Genres1 (Name) VALUES
('Rock'),
('Pop'),
('Jazz');

-- Insert sample data into Books table
INSERT INTO Books1 (Name, PubDate) VALUES
('Book 1', '2023-01-01'),
('Book 2', '2024-03-15');

-- Insert sample data into Songs table
INSERT INTO Songs1 (Name, PubDate, GenreID, AuthorID, BookID)
VALUES
('Song 1', '2023-01-10', 1, 1, 1),
('Song 2', '2023-02-20', 2, 2, 1),
('Song 3', '2024-04-05', 1, 1, 2),
('Song 4', '2024-05-12', 3, 3, 2);
