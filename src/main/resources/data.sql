CREATE TABLE if not exists categories
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    parent_id BIGINT
);

CREATE TABLE if not exists users
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255)        NOT NULL,
    surname      VARCHAR(255)        NOT NULL,
    age          INTEGER,
    email        VARCHAR(255) UNIQUE NOT NULL,
    password     VARCHAR(255)        NOT NULL,
    phone_number VARCHAR(55),
    avatar       VARCHAR(255),
    account_type VARCHAR(50)         NOT NULL
);

CREATE TABLE if not exists vacancies
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  TEXT,
    category_id  BIGINT,
    salary       REAL,
    exp_from     INTEGER,
    exp_to       INTEGER,
    is_active    BOOLEAN      NOT NULL DEFAULT TRUE,
    author_id    BIGINT       NOT NULL,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if not exists responded_applicants
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    resume_id    BIGINT NOT NULL,
    vacancy_id   BIGINT NOT NULL,
    confirmation BOOLEAN
);

CREATE TABLE if not exists messages
(
    id                      BIGINT AUTO_INCREMENT PRIMARY KEY,
    responded_applicants_id BIGINT    NOT NULL,
    content                 TEXT      NOT NULL,
    timestamp               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if not exists education_info
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    resume_id   BIGINT NOT NULL,
    institution TEXT,
    program     TEXT,
    start_date  DATE,
    end_date    DATE,
    degree      TEXT
);

CREATE TABLE if not exists contacts_info
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_id   BIGINT NOT NULL,
    resume_id BIGINT NOT NULL,
    value     TEXT   NOT NULL
);

CREATE TABLE if not exists resumes
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    applicant_id BIGINT    NOT NULL,
    name         TEXT,
    category_id  BIGINT,
    salary       REAL,
    is_active    BOOLEAN   NOT NULL DEFAULT TRUE,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if not exists work_experience_info
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    resume_id        BIGINT NOT NULL,
    years            INTEGER,
    company_name     TEXT,
    position         TEXT,
    responsibilities TEXT
);

CREATE TABLE if not exists contact_types
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    type TEXT NOT NULL
);

ALTER TABLE categories
    ADD CONSTRAINT fk_parent_id FOREIGN KEY (parent_id)
        REFERENCES categories (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE vacancies
    ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id)
        REFERENCES categories (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE vacancies
    ADD CONSTRAINT fk_author_id FOREIGN KEY (author_id)
        REFERENCES users (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE responded_applicants
    ADD CONSTRAINT fk_resume_id FOREIGN KEY (resume_id)
        REFERENCES resumes (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE responded_applicants
    ADD CONSTRAINT fk_vacancy_id FOREIGN KEY (vacancy_id)
        REFERENCES vacancies (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE messages
    ADD CONSTRAINT fk_responded_applicants_id FOREIGN KEY (responded_applicants_id)
        REFERENCES responded_applicants (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE education_info
    ADD CONSTRAINT fk_resume_id_education FOREIGN KEY (resume_id)
        REFERENCES resumes (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE contacts_info
    ADD CONSTRAINT fk_type_id FOREIGN KEY (type_id)
        REFERENCES contact_types (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE contacts_info
    ADD CONSTRAINT fk_resume_id_contacts FOREIGN KEY (resume_id)
        REFERENCES resumes (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE work_experience_info
    ADD CONSTRAINT fk_resume_id_experience FOREIGN KEY (resume_id)
        REFERENCES resumes (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

ALTER TABLE resumes
    ADD CONSTRAINT fk_applicant_id FOREIGN KEY (applicant_id)
        REFERENCES users (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;

INSERT INTO categories (name, parent_id)
VALUES ('Category 1', NULL),
       ('Category 2', NULL),
       ('Subcategory 1', 1),
       ('Subcategory 2', 1),
       ('Subcategory 3', 2);

INSERT INTO users (name, surname, email, password, account_type)
VALUES ('John', 'Doe', 'john.doe@example.com', 'password1', 'employer'),
       ('Jane', 'Smith', 'jane.smith@example.com', 'password2', 'applicant'),
       ('Alice', 'Johnson', 'alice.johnson@example.com', 'password3', 'employer'),
       ('Bob', 'Brown', 'bob.brown@example.com', 'password4', 'applicant'),
       ('Eve', 'Davis', 'eve.davis@example.com', 'password5', 'applicant');

INSERT INTO vacancies (name, description, category_id, salary, exp_from, exp_to, is_active, author_id)
VALUES ('Job 1', 'Description for Job 1', 1, 3000.00, 2, 5, TRUE, 1),
       ('Job 2', 'Description for Job 2', 2, 2500.00, 1, 3, TRUE, 3),
       ('Job 3', 'Description for Job 3', 3, 3500.00, 3, 7, TRUE, 1),
       ('Job 4', 'Description for Job 4', 1, 2800.00, 2, 4, TRUE, 3),
       ('Job 5', 'Description for Job 5', 2, 3200.00, 4, 6, TRUE, 2);

INSERT INTO responded_applicants (resume_id, vacancy_id, confirmation)
VALUES (1, 1, TRUE),
       (2, 3, FALSE),
       (3, 5, TRUE),
       (4, 2, TRUE),
       (5, 4, FALSE);

INSERT INTO messages (responded_applicants_id, content)
VALUES (1, 'Message content for responded applicant 1'),
       (2, 'Message content for responded applicant 2'),
       (3, 'Message content for responded applicant 3'),
       (4, 'Message content for responded applicant 4'),
       (5, 'Message content for responded applicant 5');

INSERT INTO education_info (resume_id, institution, program, start_date, end_date, degree)
VALUES (1, 'University A', 'Computer Science', '2015-09-01', '2019-06-30', 'Bachelor'),
       (2, 'University B', 'Business Administration', '2014-08-01', '2018-05-30', 'Bachelor'),
       (3, 'University C', 'Engineering', '2016-09-01', '2020-06-30', 'Master'),
       (4, 'University D', 'Art', '2017-09-01', '2021-06-30', 'Bachelor'),
       (5, 'University E', 'Medicine', '2018-09-01', '2022-06-30', 'Doctorate');

INSERT INTO contacts_info (type_id, resume_id, value)
VALUES (1, 1, 'john.doe@example.com'),
       (2, 2, 'jane.smith@example.com'),
       (3, 3, '+1234567890'),
       (1, 4, 'bob.brown@example.com'),
       (2, 5, '+9876543210');

INSERT INTO resumes (applicant_id, name, category_id, salary, is_active)
VALUES (2, 'Resume 1', 1, 2800.00, TRUE),
       (4, 'Resume 2', 2, 3200.00, TRUE),
       (5, 'Resume 3', 3, 3500.00, TRUE),
       (3, 'Resume 4', 1, 3000.00, TRUE),
       (1, 'Resume 5', 2, 2500.00, TRUE);

INSERT INTO work_experience_info (resume_id, years, company_name, position, responsibilities)
VALUES (1, 3, 'Company X', 'Software Developer', 'Developed web applications'),
       (2, 5, 'Company Y', 'Marketing Manager', 'Developed marketing strategies'),
       (3, 4, 'Company Z', 'Mechanical Engineer', 'Designed mechanical systems'),
       (4, 2, 'Company W', 'Graphic Designer', 'Created visual designs'),
       (5, 3, 'Company V', 'Doctor', 'Provided medical care');

INSERT INTO contact_types (type)
VALUES ('Email'),
       ('Phone');
