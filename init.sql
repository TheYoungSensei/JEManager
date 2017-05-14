DROP SCHEMA IF EXISTS jem CASCADE;


CREATE SCHEMA jem;

CREATE TABLE jem.users(
	id_user serial PRIMARY KEY NOT NULL,
	username varchar(255) NOT NULL,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	registration_date varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	manager boolean NOT NULL
);

CREATE TABLE jem.events(
	id_event serial PRIMARY KEY NOT NULL,
	date varchar(255) NOT NULL,
	closed boolean NOT NULL
);

CREATE TABLE jem.companies(
	id_company serial PRIMARY KEY NOT NULL,
	creator integer REFERENCES jem.users (id_user) NOT NULL,
	name varchar(255) NOT NULL,
	date_first_contact varchar(255) NOT NULL,
	street varchar(255) NOT NULL,
	number integer NOT NULL,
	box varchar(255),
	postal_code integer NOT NULL,
	municipality varchar(255) NOT NULL
);


CREATE TABLE jem.participations(
	id_participation serial PRIMARY KEY NOT NULL,
	id_company integer REFERENCES jem.companies (id_company) NOT NULL,
	id_event integer REFERENCES jem.events (id_event) NOT NULL,
	state varchar(255) NOT NULL,
	current_version integer DEFAULT 0
);

CREATE TABLE jem.contacts(
	id_contact serial PRIMARY KEY NOT NULL,
	id_company integer REFERENCES jem.companies (id_company) NOT NULL,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	email varchar(255),
	phone_number varchar(255),
	active boolean NOT NULL,
	current_version integer DEFAULT 0
);

CREATE TABLE jem.attendances(
	id_attendance serial PRIMARY KEY NOT NULL,
	id_contact integer REFERENCES jem.contacts (id_contact) NOT NULL,
	id_participation integer REFERENCES jem.participations (id_participation) NOT NULL,
	confirmed boolean NOT NULL,
	version integer DEFAULT 0
);




--ACCESS BD
REVOKE CONNECT	ON DATABASE dbdamien_meur	FROM PUBLIC;
GRANT  CONNECT	ON DATABASE dbdamien_meur	TO antoine_maniet, alexandre_maniet, sam_ndagano, damien_meur, christopher_sacre;

--ACCESS SCHEMA
REVOKE ALL		ON SCHEMA jem	FROM PUBLIC;
GRANT  USAGE	ON SCHEMA jem	TO antoine_maniet, alexandre_maniet, sam_ndagano, damien_meur, christopher_sacre;

--ACCESS TABLES
REVOKE ALL 						ON ALL TABLES IN SCHEMA jem FROM PUBLIC ;
GRANT ALL						ON ALL TABLES IN SCHEMA jem TO antoine_maniet, alexandre_maniet, sam_ndagano, damien_meur, christopher_sacre ;
grant all on all sequences in schema public to antoine_maniet, alexandre_maniet, sam_ndagano, damien_meur, christopher_sacre;
