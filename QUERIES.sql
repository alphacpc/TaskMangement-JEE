CREATE DATABASE IF NOT EXISTS TasksManagement;

USE TasksManagement;

-- CREATE TABLE
CREATE TABLE IF NOT EXISTS Users(
    userid int AUTO_INCREMENT PRIMARY KEY,
    fname varchar(100) NOT NULL,
    lname varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    profession varchar(100),
    profil varchar(10) NOT NULL DEFAULT 'visiteur',
    pwd varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Labels(
    labelid int AUTO_INCREMENT PRIMARY KEY,
    title varchar(100) NOT NULL UNIQUE,
    code varchar(20) NOT NULL DEFAULT '#1ABCFF'
);

CREATE TABLE IF NOT EXISTS Tasks(
    taskid int AUTO_INCREMENT PRIMARY KEY,
    title varchar(100) NOT NULL UNIQUE,
    description varchar(250) NOT NULL,
    labelid_task int NOT NULL,
    userid_task int NOT NULL,
    FOREIGN KEY (userid_task) REFERENCES Users(userid),
    FOREIGN KEY (labelid_task) REFERENCES Labels(labelid)
);




-- INSERT DATA ON TABLE
INSERT INTO `Users` (`userid`, `fname`, `lname`, `email`, `profession`, `pwd`) VALUES 
    (NULL, 'alpha', 'diallo', 'alpha@test.sn', 'fullstack developer', 'passer123'),
	(NULL, 'adja', 'diouf', 'adja@test.sn', 'ingenieure agronome', 'passer123'),
    (NULL, 'mouhamed', 'fall', 'mouhamed@test.sn', 'technicien', 'passer123'),
    (NULL, 'alian', 'latouf', 'alain@test.sn', 'traiter', 'passer123');
    
    
INSERT INTO `Tasks` (`taskid`, `title`, `description`, `label`, `user_id_task`) VALUES 
	(NULL, 'Page Etiquettes', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1'),
    (NULL, 'Portflio React', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1'),
    (NULL, 'Link Array list', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1'),
    (NULL, 'Memoire', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1'),
    (NULL, 'Continuer mon Article', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1');
    
    
INSERT INTO `Labels` (`labelid`, `title`, `code`) VALUES 
(NULL, 'Lecture', '#12AEE3'),
(NULL, 'Musique', '#F05'),
(NULL, 'Developpement', '#1BABA6');