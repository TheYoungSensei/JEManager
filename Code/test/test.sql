--Insert test

--Enoncé présentation
INSERT INTO jem.events VALUES(DEFAULT,'2010-10-27 12:15:30', true);
INSERT INTO jem.events VALUES(DEFAULT,'2011-11-16 10:15:30', true);
INSERT INTO jem.events VALUES(DEFAULT,'2012-11-07 10:15:30', true);
INSERT INTO jem.events VALUES(DEFAULT,'2013-11-13 10:15:30', true);
INSERT INTO jem.events VALUES(DEFAULT,'2014-11-12 10:15:30', true);
INSERT INTO jem.events VALUES(DEFAULT,'2015-10-28 10:15:30', true);
INSERT INTO jem.events VALUES(DEFAULT,'2016-10-26 10:15:30', false);
INSERT INTO jem.users VALUES(DEFAULT, 'test', 'firstNameTest', 'lastNameTest', 'emailTest@email.com', '2016-07-03 10:15:30', '$2a$10$Nk8NNuF34pyOo.9NbXUvpeLw6NxgH/Y4cu.BWokM98Ylcfl.Qd.o2', true);

--Ajout personnel
INSERT INTO jem.companies VALUES(DEFAULT, (SELECT u.id_user FROM jem.users u WHERE u.username='test'), 'company1', '2013-06-03 12:15:30', 'rueA', 1, '', 1520, 'Region du test');
INSERT INTO jem.companies VALUES(DEFAULT, (SELECT u.id_user FROM jem.users u WHERE u.username='test'), 'company2', '2013-05-03 13:15:30', 'rueB', 2, 'B25', 1520, 'Region du test');  
INSERT INTO jem.companies VALUES(DEFAULT, (SELECT u.id_user FROM jem.users u WHERE u.username='test'), 'company3', '2012-04-03 14:15:30', 'rueC', 3, '2', 1520, 'Region du test');  
INSERT INTO jem.companies VALUES(DEFAULT, (SELECT u.id_user FROM jem.users u WHERE u.username='test'), 'company4', '2013-03-03 15:15:30', 'rueD', 4, '', 1520, 'Region du test');  
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company1'),(SELECT e.id_event FROM jem.events e WHERE e.date='2016-10-26 10:15:30'), 'paid');
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company2'),(SELECT e.id_event FROM jem.events e WHERE e.date='2016-10-26 10:15:30'), 'paid');
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company3'),(SELECT e.id_event FROM jem.events e WHERE e.date='2016-10-26 10:15:30'), 'paid');
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company4'),(SELECT e.id_event FROM jem.events e WHERE e.date='2015-10-28 10:15:30'), 'paid');
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company1'),(SELECT e.id_event FROM jem.events e WHERE e.date='2015-10-28 10:15:30'), 'paid');
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company2'),(SELECT e.id_event FROM jem.events e WHERE e.date='2015-10-28 10:15:30'), 'paid');
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company1'),'Jean','Famille', 'jean.famille@gmail.com','067799793', true);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company1'),'Charles','Famille2', 'monsieur2@gmail.com','', true);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company2'),'Frédéric','Famille3', '','067749793', true);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company2'),'Alphonse','Famille4', 'monsieur4@gmail.com','', true);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company3'),'Paul','Famille5', 'monsieur5@gmail.com','047799793', false);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company3'),'Tom','Famille2', '','067779793', true);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company4'),'Pierre','Famille6', 'monsieur7@gmail.com','067729793', true);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company4'),'Luc','Famille7', 'monsieur8@gmail.com','', true);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company1'),'Marc','Famille8', '','', true);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='company1'),'Jean','Famille9', 'monsieur10@gmail.com','067499793', false);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.first_name='Jean' AND c.last_name='Famille'), 1, true);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.first_name='Jean' AND c.last_name='Famille'), 5, true);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.first_name='Jean' AND c.last_name='Famille9'), 1, true);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.first_name='Jean' AND c.last_name='Famille9'), 5, true);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.first_name='Frédéric' AND c.last_name='Famille3'), 6, true);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.first_name='Paul' AND c.last_name='Famille5'), 3, true);