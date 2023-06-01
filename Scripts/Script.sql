--DDL data defination langauge
--create alter turncate DROP 

CREATE TABLE users (
	username text
	
);

--alter tabel to add new table--

ALTER TABLE users ADD USER_age int;

--use truncate to erase all data from table--

TRUNCATE TABLE users;

--use drop to delete table--

DROP TABLE users;

-- DATA TYPE ---


CREATE TABLE datatypes(
	smll_number int2,
	normal_number int,
	big_number int8,
	standard_decimal decimal(10,2),-- total number OF digit,total number OF decimal--
	
	"boolean" boolean, --double qote let you use keyword AS COLUMN use--
	
	fixed_length_text char(2),
	variable_length_text varchar(15),
	unlimited_lengt_text TEXT, 
	"date" date --INPUT date yyyy-mm-dd format
	
);




