CREATE TABLE IF NOT EXISTS courses (
    id SERIAL,
    coursesname VARCHAR(100),
    department VARCHAR(50),
    credithours INT,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS instructors (
    id SERIAL,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    department VARCHAR(50),
    PRIMARY KEY (id)
    );
