INSERT INTO categories (name, parent_id)
VALUES ('It', NULL),
       ('Medicine', NULL),
       ('Building', 1),
       ('Web', 1),
       ('Dent', 2);

//$2a$12$VBdxN5LHWqk8IF4f6JJZ.OTOKHUE6GGPO2sQbs0ONi/FdBJMCSn/u = Qwerty777
INSERT INTO users (name, surname, age, email, password, phone_number, account_type, enabled, authority_id)
VALUES ('adilet', 'urmat', 47, 'urmat@gmail.com', '$2a$12$VBdxN5LHWqk8IF4f6JJZ.OTOKHUE6GGPO2sQbs0ONi/FdBJMCSn/u
', '0555433444', 'employer', true, select id from AUTHORITIES where AUTHORITY = 'EMPLOYER'),
       ('alibek', 'bek', 35, 'alibek@gmail.com', '$2a$12$VBdxN5LHWqk8IF4f6JJZ.OTOKHUE6GGPO2sQbs0ONi/FdBJMCSn/u
', '0555433443', 'applicant', true, select id from AUTHORITIES where AUTHORITY = 'APPLICANT'),
       ('mirbek', 'alishev', 45, 'mirbek@gmail.com', '$2a$12$VBdxN5LHWqk8IF4f6JJZ.OTOKHUE6GGPO2sQbs0ONi/FdBJMCSn/u
', '0555433447', 'applicant', true, select id from AUTHORITIES where AUTHORITY = 'APPLICANT'),
       ('Chyngyz', 'Dzholdoshbaev', 24, 'chyngyz@gmail.com', '$2a$12$VBdxN5LHWqk8IF4f6JJZ.OTOKHUE6GGPO2sQbs0ONi/FdBJMCSn/u
', '0504110800', 'admin', true, select id from AUTHORITIES where AUTHORITY = 'ADMIN');

INSERT INTO resumes (applicant_id, name, category_id, salary, is_active, created_date)
VALUES (select id from USERS where EMAIL = 'alibek@gmail.com', 'Resume 1', 1, 2800.00, TRUE, current_timestamp()),
       (select id from USERS where EMAIL = 'mirbek@gmail.com', 'Resume 2', 2, 3200.00, TRUE, current_timestamp());

INSERT INTO vacancies (name, description, category_id, salary, exp_from, exp_to, is_active, author_id, created_date)
VALUES ('Job 1', 'Description for Job 1', 1, 3000.00, 2, 5, TRUE, select id from USERS where EMAIL = 'urmat@gmail.com', current_timestamp());

INSERT INTO responded_applicants (resume_id, vacancy_id, confirmation)
VALUES (1, 1, TRUE),
       (2, 1, FALSE);

INSERT INTO contact_types (type)
VALUES ('Email'),
       ('Phone');

INSERT INTO contacts_info (type_id, resume_id, info)
VALUES (1, 1, 'alibek@example.com'),
       (1, 2, 'mirbek@example.com');

INSERT INTO messages (responded_applicants_id, content, timestamp)
VALUES (1, 'Message content for responded applicant 1', current_timestamp()),
       (2, 'Message content for responded applicant 2', current_timestamp());

INSERT INTO education_info (resume_id, institution, program, start_date, end_date, degree)
VALUES (1, 'University A', 'Computer Science', '2015-09-01', '2019-06-30', 'Bachelor'),
       (2, 'University B', 'Business Administration', '2014-08-01', '2018-05-30', 'Bachelor');

INSERT INTO work_experience_info (resume_id, years, company_name, position, responsibilities)
VALUES (1, 3, 'Company X', 'Software Developer', 'Developed web applications'),
       (2, 5, 'Company Y', 'Marketing Manager', 'Developed marketing strategies');
