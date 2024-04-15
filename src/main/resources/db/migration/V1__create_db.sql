DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS planet;
DROP TABLE IF EXISTS ticket;

CREATE TABLE client(id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
	, name VARCHAR(200) NOT NULL CHECK(LENGTH(name)>2 AND LENGTH(name)<201)
);


CREATE TABLE planet(--id SERIAL not null primary key
	id VARCHAR(7) NOT NULL PRIMARY KEY
	, name VARCHAR(500) NOT NULL CHECK(LENGTH(name)>0 AND LENGTH(name)<501)
);


CREATE TABLE ticket(id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
	, created_at TIMESTAMP
	, client_id BIGINT NOT NULL
	, from_planet_id VARCHAR(7) NOT NULL
	, to_planet_id VARCHAR(7) NOT NULL
	, CONSTRAINT ticket_client_fk FOREIGN KEY (client_id) REFERENCES client(id)
	, CONSTRAINT ticket_from_planet_fk FOREIGN KEY (from_planet_id) REFERENCES planet(id)
	, CONSTRAINT ticket_to_planet_fk FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);
