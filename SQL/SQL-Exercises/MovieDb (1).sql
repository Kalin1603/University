create DATABASE MovieDatabase
Use MovieDatabase

Create Table Directors
(
	director_id INT Primary Key Identity,
	first_name Nvarchar(50) NOT NULL,
	last_name Nvarchar(50) NOT NULL,
	nationality Nvarchar(50) NOT NULL,
	birth DATETIME2 NOT NULL,
	movieId INT NOT NULL,
	Constraint fk_movieId_Directors
	Foreign Key (movieId)
	References Movies(movie_id)
);

Create Table Actors
(
	actor_id INT Primary Key Identity,
	first_name Nvarchar(50) NOT NULL,
	last_name Nvarchar(50) NOT NULL,
	nationality Nvarchar(50) NOT NULL,
	birth DATETIME2 NOT NULL DEFAULT '1990-01-01',
);

Create Table Genres
(
	genre_id INT Primary Key Identity,
	genre_name Nvarchar(50) NOT NULL
);

Create Table Movies
(
	movie_id INT Primary Key Identity,
	title Nvarchar(30) NOT NULL,
	release_year DATETIME2 NOT NULL,
	rating INT Unique NOT NULL,
	movie_length Nvarchar(10) NOT NULL
);


Create Table MovieActors
(
	movieId INT NOT NULL,
	actorId INT NOT NULL,
	Constraint fk_movieId_Movies
	Primary Key (movieId, actorId),
	Foreign Key (movieId)
	References Movies(movie_id),
	Constraint fk_actorId_Actors
	Foreign Key (actorId)
	References Actors(actor_id)
);

Create Table MovieGenres
(
	movieId INT NOT NULL,
	genreId INT NOT NULL,
	Constraint fk_movieId_MovieGenres
	Primary Key (movieId, genreId),
	Foreign Key (movieId)
	References Movies(movie_id),
	Constraint fk_genreId_MovieGenres
	Foreign Key (genreId)
	References Genres(genre_id)
);

Create Table Awards
(
	award_id INT Primary Key Identity,
	name Nvarchar(30) NOT NULL
);

Create Table MovieAwards
(
	movieId INT NOT NULL,
	awardId INT NOT NULL,
	Constraint fk_movieId_MovieAwards
	Primary Key (movieId, awardId),
	Foreign Key (movieId)
	References Movies(movie_id),
	Constraint fk_awardId_MovieAwards
	Foreign Key (awardId)
	References Awards(award_id)
);

Create Table Studio
(
	studio_id INT Primary Key Identity,
	name Nvarchar(30) NOT NULL,
	founded DATETIME2 NOT NULL,
	owner Nvarchar(20) NOT NULL,
	movieId INT NOT NULL
	Constraint fk_movieId_Studio
	Foreign Key (movieId)
	References Movies(movie_id)
);

Create Table Country
(
	country_id INT Primary Key Identity,
	country_iso_code Nvarchar(20) NOT NULL,
	country_name Nvarchar(30) NOT NULL,
);

Create Table ProductionCountry
(
	movieId INT NOT NULL,
	countryId INT NOT NULL,
	Constraint fk_movieId_ProductionCountry
	Primary Key (movieId, countryId),
	Foreign Key (movieId)
	References Movies(movie_id),
	Constraint fk_countryId_Country
	Foreign Key (countryId)
	References Country(country_id)
);

Create Table Person
(
	person_id INT Primary Key Identity,
	person_name Nvarchar(20) NOT NULL
);

Create Table Department
(
	department_id INT Primary Key Identity,
	department_name Nvarchar(30) NOT NULL
);

Create Table MovieCrew
(
	personId INT NOT NULL,
	movieId INT NOT NULL,
	departmentId INT NOT NULL,
	Constraint fk_personId_MovieCrew
	Primary Key (personId, movieId, departmentId),
	Foreign Key (personId)
	References Person(person_id),
	Constraint fk_movieId_MovieCrew
	Foreign Key (movieId)
	References Movies(movie_id),
	Constraint fk_departmentId_MovieCrew
	Foreign Key (departmentId)
	References Department(department_id),
	job Nvarchar(30) NOT NULL
);

--Added
Insert Into Actors(first_name, last_name, nationality)
Values
('Robert', 'Downey', 'USA'),
('Samuel', 'Jackson', 'USA'),
('Scarlett', 'Johansson', 'CAN'),
('Chris', 'Hemsworth', 'GER'),
('Chris', 'Evans', 'USA'),
('Zoe', 'Saldana', 'RUS'),
('Tom', 'Hanks', 'BEL'),
('Vin', 'Diesel', 'USA'),
('Bradley', 'Cooper', 'CAN'),
('Johnny', 'Depp', 'USA');

--Added
Insert Into Directors(first_name, last_name, nationality, birth, movieId)
Values
('David ', 'Lynch', 'FR', '1990-01-01', 1),
('Martin ', 'Scorsese', 'USA', '1990-01-01', 2),
('Steven ', 'Soderbergh', 'CAN', '1990-01-01', 3),
('Terrence ', 'Malick', 'GER', '1990-01-01', 4),
('Abbas ', 'Kiarostami', 'BG', '1990-01-01', 5),
('Errol ', 'Morris', 'RUS', '1990-01-01', 6),
('Hayao ', 'Miyazaki', 'BEL', '1990-01-01', 7),
('David ', 'Cronenberg', 'CHI', '1990-01-01', 8),
('Terence ', 'Davies', 'UK', '1990-01-01', 9),
('Lukas ', 'Moodysson', 'AF', '1990-01-01', 10);

--Added
Insert Into Awards(name)
Values
('AFCC: Best Actor'),
('AFCC: Best Director'),
('AFCC: Best Cinematography'),
('NYFCO: Best Picture'),
('WAFCA: Best Director'),
('WAFCA: Best Supporting Actor'),
('WAFCA: Best Adapted Screenplay'),
('NYFCC: Best Director'),
('NYFCC: Best Actor'),
('NYFCC: Best Supporting Actor');

--Added
Insert Into Genres(genre_name)
Values
('Action'),
('Comedy'),
('Drama'),
('Fantasy'),
('Horror'),
('Mystery'),
('Romance'),
('Thriller'),
('Western'),
('Crime Thriller');

--Added
Insert Into Movies(title, movie_length, release_year, rating)
Values
('Scream', '1:25:00', '2022-01-01', 7),
('Dont look up', '1:00:00', '2022-01-01', 6),
('Spider-man', '2:00:00', '2022-01-01', 8),
('Dune', '1:15:00', '2022-01-01', 9),
('Shang-Chi', '1:10:00', '2022-01-01', 10),
('Dexter: New Blood', '1:12:00', '2022-01-01', 4),
('The power of the dog', '1:30:00', '2022-01-01', 3),
('The Witcher', '2:10:00', '2022-01-01', 2),
('Hawkeye', '1:15:00', '2022-01-01', 1),
('The unforgivable', '1:02:00', '2022-01-01', 5);

--Added
Insert Into Country(country_name, country_iso_code)
Values
('Antigua and Barbuda', '3166'),
('Argentina', '3166'),
('Armenia', '3166'),
('Aruba', '3166'),
('Australia ', '3166'),
('Austria', '3166'),
('Azerbaijan', '3166'),
('Bahrain', '3166'),
('Bangladesh', '3166'),
('Barbados', '3166');

--Added
Insert Into Person(person_name)
Values
('Ada Lovelace'),
('Elon Musk'),
('Alice H Parker'),
('Ellen Ochoa'),
('George Stephenson'),
('Krasimir Sokolov'),
('Adam Varkam'),
('Leonardo da Vinci'),
('Kalin Todorov'),
('Krasimir Djorakov');

--Added
Insert Into Department(department_name)
Values
('General Management'),
('Marketing Department'),
('Operations Department'),
('Finance Department'),
('Sales Department'),
('Human Resource Department'),
('Purchase Department'),
('Administration Department'),
('IT Department'),
('Executive Department');


--Added
Insert Into Studio(name, owner, founded, movieId)
Values
('Pixxel Studio', 'Steven Spielberg', '2000-01-01', 1),
('GreenRoom Design', 'Russo brothers', '2001-01-01', 2),
('Vivid Media Images', 'Peter Jackson', '2002-01-01', 3),
('Lensly', 'Michael Bay', '2003-01-01', 4),
('Abstract Records', 'James Cameron', '2004-01-01', 5),
('Blurred Vision', 'David Yates', '2005-01-01', 6),
('Colorpix Studio', 'Christopher Nolan', '2006-01-01', 7),
('InMotion Videography', 'J. J. Abrams', '2007-01-01', 8),
('Lens Kings', 'Tim Burton', '2008-01-01', 9),
('B&W Studio', 'Robert Zemeckis', '2009-01-01', 10);

Insert INTO MovieGenres(movieId, genreId)
VALUES
(1,2),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);

Insert INTO ProductionCountry(movieId, countryId)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);

Insert INTO MovieAwards(movieId, awardId)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);

Insert INTO MovieActors(movieId, actorId)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);

Insert INTO MovieCrew(movieId, personId, departmentId, job)
VALUES
(1,1,1, 'Director'),
(2,2,2, 'Producer'),
(3,3,3, 'Set Designer'),
(4,4,4, 'Director of Photography'),
(5,5,5, 'Costume Designer'),
(6,6,6, 'Prop Master'),
(7,7,7, 'Makeup Artist'),
(8,8,8, 'Movie Editor'),
(9,9,9, 'Composer'),
(10,10,10, 'Developer');

--1
Select * From Movies AS m
JOIN Studio AS s ON s.movieId = m.movie_id
JOIN Directors AS d ON d.movieId = m.movie_id
Where m.rating > 5
Order By m.title, m.rating

--2
Select * From Movies AS m
JOIN ProductionCountry AS pc ON pc.movieId = m.movie_id
JOIN Country AS c ON c.country_id = pc.countryId
JOIN MovieAwards AS ma ON ma.movieId = m.movie_id
JOIN Awards AS a ON a.award_id = ma.awardId
Order By m.rating

--3
Select m.title, a.name, CONCAT_WS(' ', ac.first_name, ac.last_name) AS 'Full Name' From Movies AS m
JOIN MovieActors AS ma ON ma.movieId = m.movie_id
JOIN Actors AS ac ON ac.actor_id = ma.actorId
JOIN MovieAwards AS mw ON mw.movieId = m.movie_id
JOIN Awards AS a ON a.award_id = mw.awardId
Where a.name = 'NYFCC: Best Actor'
Order By m.movie_id

--4
Select m.title, p.person_name, d.department_name From Movies AS m
JOIN MovieCrew AS mc ON mc.movieId = m.movie_id
JOIN Person AS p ON p.person_id = mc.personId
JOIN Department AS d ON d.department_id = mc.departmentId
Where m.movie_length > '1:00:00'
Order By m.movie_id

--5
Select m.title, m.release_year, g.genre_name, s.name AS 'Studio name' From Movies AS m
JOIN MovieGenres AS mg ON mg.movieId = m.movie_id
JOIN Genres AS g ON g.genre_id = mg.genreId
JOIN Studio AS s ON s.movieId = m.movie_id
Where s.founded > '2000-01-01'
Order By m.movie_id

--6
Select m.title, m.release_year AS 'Release year', g.genre_name AS 'Genre name', a.name AS 'Award name' From Movies AS m
JOIN MovieGenres AS mg ON mg.movieId = m.movie_id
JOIN Genres AS g ON g.genre_id = mg.genreId
JOIN MovieAwards AS mw ON mw.movieId = m.movie_id
JOIN Awards AS a ON a.award_id = mw.awardId
Where g.genre_name = 'Horror'
Order By m.movie_id

--7
Select CONCAT_WS(' ', d.first_name, d.last_name) AS 'Full Name', c.country_name AS 'Country name',
m.title, g.genre_name, m.rating AS 'Total rating' From Movies AS m
JOIN MovieGenres AS mg ON mg.movieId = m.movie_id
JOIN Genres AS g ON g.genre_id = mg.genreId
JOIN Directors AS d ON d.movieId = m.movie_id
JOIN ProductionCountry AS pc ON pc.movieId = m.movie_id
JOIN Country AS c ON c.country_id = pc.countryId
Order By 'Total rating'

--8
Select p.person_name, mc.job, m.title, c.country_name From Movies AS m
JOIN ProductionCountry AS pc ON pc.movieId = m.movie_id
JOIN Country AS c ON c.country_id = pc.countryId
JOIN MovieCrew AS mc ON mc.movieId = m.movie_id
JOIN Person AS p ON p.person_id = mc.personId
Order By mc.job

--9
Select m.title, m.release_year, m.rating, m.movie_length, g.genre_name, mc.job, p.person_name, a.name From Movies AS m
JOIN MovieGenres AS mg ON mg.movieId = m.movie_id
JOIN Genres AS g ON g.genre_id = mg.genreId
JOIN MovieCrew AS mc ON mc.movieId = m.movie_id
JOIN Person AS p ON p.person_id = mc.personId
JOIN MovieAwards AS mw ON mw.movieId = m.movie_id
JOIN Awards AS a ON a.award_id = mw.awardId
Where mc.job = 'Set Designer' OR mc.job = 'Movie Editor'
Order By m.movie_id

--10
Select * From Movies AS m
JOIN Studio AS s ON s.movieId = m.movie_id
JOIN Directors AS di ON di.movieId = m.movie_id
JOIN ProductionCountry AS pc ON pc.movieId = m.movie_id
JOIN Country AS c ON c.country_id = pc.countryId
JOIN MovieAwards AS ma ON ma.movieId = m.movie_id
JOIN Awards AS a ON a.award_id = ma.awardId
JOIN MovieGenres AS mg ON mg.movieId = m.movie_id
JOIN Genres AS g ON g.genre_id = mg.genreId
JOIN MovieCrew AS mc ON mc.movieId = m.movie_id
JOIN Person AS p ON p.person_id = mc.personId
JOIN Department AS d ON d.department_id = mc.departmentId
JOIN MovieActors AS mac ON ma.movieId = m.movie_id
JOIN Actors AS ac ON ac.actor_id = mac.actorId
Order By m.movie_length DESC