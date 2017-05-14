/* Users */
INSERT INTO jem.users VALUES(DEFAULT, 'grolaux', 'Donatien', 'Grolaux', 'donatien.grolaux@ipl.be', '2017-05-09 00:00:00', '$2a$06$oozVBSLCyV1N5EfPH0V.sebGcz3CckDIK87bV03l1bnkImXQ5lLg6', true);
INSERT INTO jem.users VALUES(DEFAULT, 'lehmann', 'Brigitte', 'Lehmann', 'brigitte.lehmann@ipl.be', '2017-05-09 00:00:00', '$2a$06$oozVBSLCyV1N5EfPH0V.sebGcz3CckDIK87bV03l1bnkImXQ5lLg6', true);

/* Bussiness Days */

INSERT INTO jem.events VALUES(DEFAULT, '2013-11-13 00:00:00', true);
INSERT INTO jem.events VALUES(DEFAULT, '2014-11-12 00:00:00', true);
INSERT INTO jem.events VALUES(DEFAULT, '2015-10-28 00:00:00', true);
INSERT INTO jem.events VALUES(DEFAULT, '2016-10-26 00:00:00', false);

/* Companies - Contacts */
INSERT INTO jem.companies VALUES(DEFAULT, 1, 'Accenture', '2013-05-09 00:00:00', 'Waterloolaan', 16, '', 1000,'Brussels');
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Accenture'), 'Stéphanie', 'De Troyer', 'stephanie.de.troyer@accenture.com', '', true, DEFAULT);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Accenture'), 'Marijke', 'Van Dyck', 'marijke.vandyck@accenture.com', '', true, DEFAULT);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Accenture'), 'Aimée', 'Marecaux', 'aimee.marecaux@accenture.com', '', true, DEFAULT);

INSERT INTO jem.companies VALUES(DEFAULT, 1, 'CodeItBlue', '2013-05-09 00:00:00', 'Avenue de l''espérance', 40, 'b', 1348,'LLN');
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='CodeItBlue'), 'Vincent', 'Lepape', 'Vincent.lepape@CodeItBlue.com', '0479/97.95.05', true, DEFAULT);

INSERT INTO jem.companies VALUES(DEFAULT, 1, 'STERIA', '2013-05-09 00:00:00', 'Boulevard du Souverain', 36, '', 1170,'Bruxelles');
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='STERIA'), 'Roberto', 'Alvarez', 'roberto.alvarez@steria.be', '', true, DEFAULT);

INSERT INTO jem.companies VALUES(DEFAULT, 1, 'Eezee-IT', '2013-05-09 00:00:00', 'rue André Dumont', 5, '', 1435, 'Mont-Saint-Guibert');
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Eezee-IT'), 'Nicolas', 'Rigo', 'nicolas.rigo@eezee-it.com', '+32 478 88 02 55', true, DEFAULT);

INSERT INTO jem.companies VALUES(DEFAULT, 1, 'Bewan', '2013-05-09 00:00:00', 'Drève Richelle', 161, 'b46', 1410, 'Waterloo');
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Bewan'), 'Virginie', 'BRASSINNE', 'Virginie.BRASSINNE@bewan.be', '', true, DEFAULT);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Bewan'), 'Isabelle', 'Croiset', 'isabelle.croiset@bewan.be', '', true, DEFAULT);
INSERT INTO jem.contacts VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Bewan'), 'Bénédicte', 'Dedecker', 'drh@bewan.be', '', true, DEFAULT);

/* Participations - Attendances */
/* Accenture */
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Accenture'), (SELECT e.id_event FROM jem.events e WHERE e.date='2014-11-12 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='stephanie.de.troyer@accenture.com'), 1, true, DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Accenture'), (SELECT e.id_event FROM jem.events e WHERE e.date='2015-10-28 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='marijke.vandyck@accenture.com'), 2, true, DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='aimee.marecaux@accenture.com'), 2, true, DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Accenture'), (SELECT e.id_event FROM jem.events e WHERE e.date='2016-10-26 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='aimee.marecaux@accenture.com'), 3, true, DEFAULT);

/* CodeItBlue */
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='CodeItBlue'), (SELECT e.id_event FROM jem.events e WHERE e.date='2013-11-13 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='Vincent.lepape@CodeItBlue.com'), 4, true, DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='CodeItBlue'), (SELECT e.id_event FROM jem.events e WHERE e.date='2014-11-12 00:00:00'), 'refused', DEFAULT);

/* STERIA */
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='STERIA'), (SELECT e.id_event FROM jem.events e WHERE e.date='2013-11-13 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='roberto.alvarez@steria.be'), 6, true, DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='STERIA'), (SELECT e.id_event FROM jem.events e WHERE e.date='2014-11-12 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='roberto.alvarez@steria.be'), 7, true, DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='STERIA'), (SELECT e.id_event FROM jem.events e WHERE e.date='2015-10-28 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='roberto.alvarez@steria.be'), 8, true, DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='STERIA'), (SELECT e.id_event FROM jem.events e WHERE e.date='2016-10-26 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='roberto.alvarez@steria.be'), 9, true, DEFAULT);

/* Eezee-IT */
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Eezee-IT'), (SELECT e.id_event FROM jem.events e WHERE e.date='2013-11-13 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='nicolas.rigo@eezee-it.com'), 10, true, DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Eezee-IT'), (SELECT e.id_event FROM jem.events e WHERE e.date='2014-11-12 00:00:00'), 'cancelled', DEFAULT);

/* Bewan */
INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Bewan'), (SELECT e.id_event FROM jem.events e WHERE e.date='2013-11-13 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='Virginie.BRASSINNE@bewan.be'), 12, true, DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='isabelle.croiset@bewan.be'), 12, true, DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Bewan'), (SELECT e.id_event FROM jem.events e WHERE e.date='2014-11-12 00:00:00'), 'refused', DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Bewan'), (SELECT e.id_event FROM jem.events e WHERE e.date='2015-10-28 00:00:00'), 'refused', DEFAULT);

INSERT INTO jem.participations VALUES(DEFAULT, (SELECT co.id_company FROM jem.companies co WHERE co.name='Bewan'), (SELECT e.id_event FROM jem.events e WHERE e.date='2016-10-26 00:00:00'), 'paid', DEFAULT);
INSERT INTO jem.attendances VALUES(DEFAULT, (SELECT c.id_contact FROM jem.contacts c WHERE c.email='drh@bewan.be'), 15, true, DEFAULT);