--create two table with relationship
--i can accomplish this WITH primary and foreign key 
--foreign key of one table point to to primary keu of another table--

--schema will track employee and thier roles

CREATE TABLE roles(
	role_id serial PRIMARY KEY, -- PRIMARY KEY uniquely identified EACH record (row in table)
	--serial is an auto incrementing int data type -perfect primary key
	--whenever we insert new record the primary key will get populated.
	role_title TEXT UNIQUE, --EVERY ROLE must have a dfferent title FROM EACH other
	role_salary int CHECK(role_salary >20000)---salary can NOT be lessthan 20k
	

);


--employee table 
CREATE TABLE employees(
	employee_id serial PRIMARY KEY,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	role_id_fk int REFERENCES roles(role_id)
	
);

--DML--data manipulation lanauge
--select,inser,delete,update--

--inseert more data in to my table
 

INSERT INTO roles(role_title, role_salary)
VALUES ('Manager', 100000), 
		('Cashier', 40000),
		('fry cook', 50000),
		('Marketeing Director', 100000);

--select to view data in table
	
SELECT * FROM roles;

INSERT INTO employees(first_name, last_name, role_id_fk)
VALUES ('Eugene', 'krabs', 1),
		('Spongebob', 'Squarepants', 3),
		('Squidward', 'tentacles', 2),
		('sheldon', 'plankton', 1);

SELECT * FROM employees;


--where cluase in select ststment lets us further filter the data that comes back
/*
 = equal
 != not equal
 < less than
 > greater than
 'LIKE %s'  end with  s
 'like s%' start with s
 'LIKE %JOHN%' retrieve all rows where the name contains the substring "John"
 */


SELECT * FROM employees
WHERE last_name LIKE 'S%';


SELECT * FROM roles
WHERE role_salary = 100000;

--between 
SELECT *FROM roles 
WHERE role_salary BETWEEN 30000 AND 70000;

--or

SELECT * FROM employees
WHERE first_name = 'Eugene' OR first_name = 'Sheldon';


-- IN 
SELECT * FROM employees
WHERE first_name IN('Eugene', 'Sheldon'); --better IF there ARE many value



--order by

SELECT * FROM roles
ORDER BY role_salary;  --defualt increasing ORDER 

-- we can specify "desc" for descending order
SELECT * FROM employees
ORDER BY first_name DESC;

--functtion--

--scaller function  can take up to one value  and return one value
--now upper lower round 

SELECT now(); --RETURN currrent DATA/time
SELECT upper('this string will be returned uppercase');

--aggergate function take multiple vale and return single value
--avg sum count max min 

SELECT avg(role_salary) FROM roles;
SELECT sum(role_salary) FROM roles;
SELECT count(first_name) FROM employees;

--GROUP BY will merge rows on matching COLUMN VALUES--

SELECT count(*) FROM roles GROUP BY role_salary;

--having is like a where cluase, but it can only be used after group by .
--where can not work after group BY 
--becuase where cluase only works after selection from the table 
--where does not works on value returned from aggregate function

SELECT count(*) FROM employees GROUP BY last_name HAVING last_name = 'tentacles';




--update --

UPDATE employees SET last_name = 'plankton' WHERE first_name = 'sheldon';

--delete--

DELETE FROM roles WHERE role_title = 'Manager';

--can't delete it becuase there are employee records that are pointing to manager record
-- you can not delete record that other depend on it 

/* why can not we delete
 this is just a built in rule ,to avoid a what known as orphan records
 we can't have reocrd that refer to other record that dont exist
 this is one way of sql enforce Refernetial integerity
 --
 
 in order for this delete to work w would had to say on delete cascade in our foreign key
 */
--example

CREATE TABLE employee(
	role_id_fk int REFERENCES roles(role_id) ON DELETE CASCADE 
-- works FOR ON UPDATE CASCADE 

);
















