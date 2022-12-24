CREATE DATABASE IF NOT EXISTS TasksManagement;

USE TasksManagement;

CREATE TABLE IF NOT EXISTS Users(
    userid int AUTO_INCREMENT PRIMARY KEY,
    fname varchar(100),
    lname varchar(100),
    email varchar(100),
    profession varchar(100),
    pwd varchar(255)
);

INSERT INTO `Users` (`userid`, `fname`, `lname`, `email`, `profession`, `pwd`) VALUES (NULL, 'alpha', 'diallo', 'alpha@test.sn', 'fullstack developer', 'passer123');

INSERT INTO `Users` (`userid`, `fname`, `lname`, `email`, `profession`, `pwd`) VALUES 
    (NULL, 'alpha', 'diallo', 'alpha@test.sn', 'fullstack developer', 'passer123'),
	(NULL, 'adja', 'diouf', 'adja@test.sn', 'ingenieure agronome', 'passer123'),
    (NULL, 'mouhamed', 'fall', 'mouhamed@test.sn', 'technicien', 'passer123'),
    (NULL, 'alian', 'latouf', 'alain@test.sn', 'traiter', 'passer123');