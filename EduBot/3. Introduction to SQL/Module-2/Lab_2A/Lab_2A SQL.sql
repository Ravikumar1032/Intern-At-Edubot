SELECT b.Name AS BookName, s.Name AS SongName
FROM Books1 b
JOIN Songs1 s ON b.BookID = s.BookID
WHERE b.Name = 'Book 1';

SELECT a.Name AS AuthorName, s.Name AS SongName
FROM Authors2 a
JOIN Songs1 s ON a.AuthorID = s.AuthorID
WHERE a.Name = 'John Doe';

SELECT *
FROM Songs
WHERE PubDate BETWEEN '2023-01-01' AND '2024-01-01';

SELECT *
FROM Songs
WHERE PubDate BETWEEN '2023-01-01' AND '2024-01-01'
AND LENGTH(Name) > 4;

SELECT g.Name AS Genre, COUNT(s.SongID) AS NumSongs
FROM Genres g
LEFT JOIN Songs s ON g.GenreID = s.GenreID
GROUP BY g.Name;


