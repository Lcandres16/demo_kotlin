CREATE TABLE IF NOT EXISTS courses (
    id SERIAL,
    coursename VARCHAR(100),
    department VARCHAR(50),
    credithours INT,
    PRIMARY KEY (course_id)
    );

CREATE TABLE IF NOT EXISTS instructors (
    id SERIAL,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    department VARCHAR(50),
    PRIMARY KEY (instructor_id)
    );
