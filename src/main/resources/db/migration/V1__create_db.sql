DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS planet;
DROP TABLE IF EXISTS ticket;

create table client(id SERIAL not null primary key
	, name varchar not null check(length(name)>2 and length(name)<201)
);

CREATE SEQUENCE client_seq START 1 INCREMENT 1 owned BY client.id;

alter table client alter column id set default nextval('client_seq');


create table planet(--id SERIAL not null primary key
	id varchar not null primary key
	, name varchar not null check(length(name)>0 and length(name)<501)
);

--CREATE SEQUENCE planet_seq START 1 INCREMENT 1 owned BY planet.id;

--alter table planet alter column id set default nextval('planet_seq');


create table ticket(id SERIAL not null primary key
	, created_at timestamp
	, client_id int
	, from_planet_id varchar --bigint
	, to_planet_id varchar --bigint
	, foreign key (client_id) references client(id)
	, foreign key (from_planet_id) references planet(id)
	, foreign key (to_planet_id) references planet(id)
);

CREATE SEQUENCE ticket_seq START 1 INCREMENT 1 owned BY ticket.id;

alter table ticket alter column id set default nextval('ticket_seq');
