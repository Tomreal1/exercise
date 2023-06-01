CREATE TABLE owners(
	owner_id serial PRIMARY KEY,
	owner_name TEXT
	
);

CREATE TABLE dogs(
	dog_id serial PRIMARY KEY,
	dog_name TEXT,
	dog_age int,
	owner_id_fk int REFERENCES owners(owner_id)

);

INSERT INTO owners(owner_name)
VALUES ('malik'),
	('jemal');

SELECT * FROM owners;

INSERT INTO dogs(dog_name, dog_age,owner_id_fk)
VALUES ('Papi', 2, 2),
		('Lucy',1, 1),
		('Leo', 2 ,1),
		('Roxy',3, 2),
		('Buddy',5, 1)
		
SELECT * FROM dogs;

SELECT * FROM dogs WHERE dog_age > 4;

SELECT *FROM dogs 
ORDER BY dog_name;

SELECT avg(dog_age) FROM dogs; 

SELECT owner_name FROM owners;



