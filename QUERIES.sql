CREATE DATABASE IF NOT EXISTS TasksManagement;

USE TasksManagement;

CREATE TABLE IF NOT EXISTS Users(
    userid int AUTO_INCREMENT PRIMARY KEY,
    fname varchar(100),
    lname varchar(100),
    email varchar(100),
    profession varchar(100),
    profil varchar(10) NOT NULL DEFAULT 'visiteur',
    pwd varchar(255)
);


INSERT INTO `Users` (`userid`, `fname`, `lname`, `email`, `profession`, `pwd`) VALUES 
    (NULL, 'alpha', 'diallo', 'alpha@test.sn', 'fullstack developer', 'passer123'),
	(NULL, 'adja', 'diouf', 'adja@test.sn', 'ingenieure agronome', 'passer123'),
    (NULL, 'mouhamed', 'fall', 'mouhamed@test.sn', 'technicien', 'passer123'),
    (NULL, 'alian', 'latouf', 'alain@test.sn', 'traiter', 'passer123');
    
    
    
CREATE TABLE IF NOT EXISTS Tasks(
    taskid int AUTO_INCREMENT PRIMARY KEY,
    title varchar(100),
    description varchar(250),
    labelid_task int,
    userid_task int,
    FOREIGN KEY (userid_task) REFERENCES Users(userid),
    FOREIGN KEY (labelid_task) REFERENCES Labels(labelid)
);



INSERT INTO `Tasks` (`taskid`, `title`, `description`, `label`, `user_id_task`) VALUES 
	(NULL, 'Page Etiquettes', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1'),
    (NULL, 'Portflio React', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1'),
    (NULL, 'Link Array list', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1'),
    (NULL, 'Memoire', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1'),
    (NULL, 'Continuer mon Article', 'Lorem ipusm bab sunu dio fhe miass nos ayga', '1', '1');
    
    
CREATE TABLE IF NOT EXISTS Labels(
    labelid int AUTO_INCREMENT PRIMARY KEY,
    title varchar(100),
    code varchar(20)
);


INSERT INTO `Labels` (`labelid`, `title`, `code`) VALUES 
(NULL, 'Lecture', '#12AEE3'),
(NULL, 'Musique', '#F05'),
(NULL, 'Developpement', '#1BABA6');