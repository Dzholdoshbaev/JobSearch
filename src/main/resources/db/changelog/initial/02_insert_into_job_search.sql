insert into authorities (AUTHORITY)
values ('APPLICANT'),
       ('EMPLOYER');

insert into roles (role)
values ('APPLICANT'),
       ('EMPLOYER');

insert into roles_authorities (role_id,authority_id)
values (SELECT id FROM roles WHERE role = 'APPLICANT',SELECT id FROM AUTHORITIES WHERE authority = 'APPLICANT'),
       (SELECT id FROM roles WHERE role = 'EMPLOYER',SELECT id FROM AUTHORITIES WHERE authority = 'EMPLOYER');

INSERT INTO categories (name, parent_id)
VALUES ('It', NULL),
       ('Medicine', NULL),
       ('Kitchen',NULL),
       ('Hospitality',NULL),
       ('Building',NULL),
       ('Military',NULL),
       ('Fashion',NULL),
       ('Beauty',NULL),
       ('Government',NULL),
       ('Judge',NULL),
       ('Driver',Null),
       ('Farmer',NULL),
       ('Education',NULL),
       ('Electronics',NULL),
       ('Business',NULL),
       ('Science',NULL),
       ('Trade',NULL),
       ('Geologist',NULL),
       ('Petroleum',NULL),
       ('Hydroelectric power plant',NULL),
       ('Diplomat',NULL),
       ('Taxi',select ID from CATEGORIES where NAME  = 'Driver'),
       ('Police',select ID from CATEGORIES where NAME = 'Military'),
       ('MakeUp Artist',select ID from CATEGORIES where NAME = 'Beauty'),
       ('Dentist',select ID from CATEGORIES where NAME = 'Medicine'),
       ('Teacher',select ID from CATEGORIES where NAME = 'Education'),
       ('Waiter', select ID from CATEGORIES where NAME = 'Hospitality'),
       ('Chef',select ID from CATEGORIES where NAME = 'Kitchen'),
       ('Deputy',select ID from CATEGORIES where NAME = 'Government'),
       ('Businessman',select ID from CATEGORIES where NAME = 'Business'),
       ('Scientist', select ID from CATEGORIES where NAME = 'Science'),
       ('Seller',select ID from CATEGORIES where NAME = 'Trade'),
       ('Doctor',select ID from CATEGORIES where NAME = 'Medicine'),
       ('FireMan',select ID from CATEGORIES where NAME = 'Government'),
       ('Electrician',select ID from CATEGORIES where NAME = 'Hydroelectric power plant'),
       ('Model',select ID from CATEGORIES where NAME = 'Fashion'),
       ('Assistant',select ID from CATEGORIES where NAME = 'Business');


//qwe password
INSERT INTO users (name, surname, age, email, password, phone_number, enabled)
VALUES
    ('adilet', 'urmat', 47, 'adilet.urmat@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433444', true),
    ('alibek', 'bek', 35, 'alibek.bek@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433443', true),
    ('mirbek', 'alishev', 45, 'mirbek.alishev@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433447', true),
    ('tarsyn', 'zhan', 29, 'tarsyn.zhan@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433451', true),
    ('katya', 'sidorova', 32, 'katya.sidorova@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433452', true),
    ('ruslan', 'kutubekov', 40, 'ruslan.kutubekov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433453', true),
    ('nurlan', 'bekov', 28, 'nurlan.bekov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433454', true),
    ('akmaral', 'baisalova', 34, 'akmaral.baisalova@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433455', true),
    ('dastan', 'daniyar', 38, 'dastan.daniyar@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433456', true),
    ('gulnara', 'muratova', 27, 'gulnara.muratova@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433457', true),
    ('bekzat', 'kyrgyzbaev', 31, 'bekzat.kyrgyzbaev@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433458', true),
    ('shamil', 'shamsiev', 29, 'shamil.shamsiev@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433459', true),
    ('saniya', 'kairatova', 36, 'saniya.kairatova@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433460', true),
    ('janyl', 'bekova', 33, 'janyl.bekova@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433461', true),
    ('serik', 'keldi', 37, 'serik.keldi@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433462', true),
    ('alina', 'dzhangirova', 26, 'alina.dzhangirova@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433463', true),
    ('valery', 'fedotov', 41, 'valery.fedotov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433464', true),
    ('yana', 'solovyeva', 30, 'yana.solovyeva@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433465', true),
    ('timur', 'samatov', 42, 'timur.samatov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433466', true),
    ('mariam', 'kurbatova', 29, 'mariam.kurbatova@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433467', true),
    ('aristotel', 'akmatov', 37, 'aristotel.akmatov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433468', true),
    ('eldar', 'serikov', 33, 'eldar.serikov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433469', true),
    ('beksultan', 'bekov', 26, 'beksultan.bekov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433471', true),
    ('zhanar', 'ramazanova', 32, 'zhanar.ramazanova@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433472', true),
    ('nursultan', 'zhanbayeva', 34, 'nursultan.zhanbayeva@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433473', true),
    ('lara', 'lutsenko', 27, 'lara.lutsenko@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433474', true),
    ('samat', 'sharipov', 39, 'samat.sharipov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433475', true),
    ('tatyana', 'mironova', 31, 'tatyana.mironova@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433476', true),
    ('mukhit', 'tursunov', 36, 'mukhit.tursunov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433477', true),
    ('anara', 'osmonalieva', 28, 'anara.osmonalieva@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433478', true),
    ('sultan', 'sharipov', 41, 'sultan.sharipov@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433479', true),
    ('elena', 'kudryavtseva', 29, 'elena.kudryavtseva@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433480', true);

insert into users_roles (users_id,role_id)
values (SELECT id FROM users WHERE email = 'adilet.urmat@gmail.com',2),
       (SELECT id FROM users WHERE email = 'alibek.bek@gmail.com',2),
       (SELECT id FROM users WHERE email = 'mirbek.alishev@gmail.com',2),
       (SELECT id FROM users WHERE email = 'tarsyn.zhan@gmail.com',2),
       (SELECT id FROM users WHERE email = 'katya.sidorova@gmail.com',2),
       (SELECT id FROM users WHERE email = 'ruslan.kutubekov@gmail.com',2),
       (SELECT id FROM users WHERE email = 'nurlan.bekov@gmail.com',2),
       (SELECT id FROM users WHERE email = 'akmaral.baisalova@gmail.com',2),
       (SELECT id FROM users WHERE email = 'dastan.daniyar@gmail.com',2),
       (SELECT id FROM users WHERE email = 'gulnara.muratova@gmail.com',2),
       (SELECT id FROM users WHERE email = 'bekzat.kyrgyzbaev@gmail.com',2),
       (SELECT id FROM users WHERE email = 'shamil.shamsiev@gmail.com',2),
       (SELECT id FROM users WHERE email = 'saniya.kairatova@gmail.com',2),
       (SELECT id FROM users WHERE email = 'janyl.bekova@gmail.com',2),
       (SELECT id FROM users WHERE email = 'serik.keldi@gmail.com',2),
       (SELECT id FROM users WHERE email = 'alina.dzhangirova@gmail.com',2),
       (SELECT id FROM users WHERE email = 'valery.fedotov@gmail.com',1),
       (SELECT id FROM users WHERE email = 'yana.solovyeva@gmail.com',1),
       (SELECT id FROM users WHERE email = 'timur.samatov@gmail.com',1),
       (SELECT id FROM users WHERE email = 'mariam.kurbatova@gmail.com',1),
       (SELECT id FROM users WHERE email = 'aristotel.akmatov@gmail.com',1),
       (SELECT id FROM users WHERE email = 'eldar.serikov@gmail.com',1),
       (SELECT id FROM users WHERE email = 'beksultan.bekov@gmail.com',1),
       (SELECT id FROM users WHERE email = 'zhanar.ramazanova@gmail.com',1),
       (SELECT id FROM users WHERE email = 'nursultan.zhanbayeva@gmail.com',1),
       (SELECT id FROM users WHERE email = 'lara.lutsenko@gmail.com',1),
       (SELECT id FROM users WHERE email = 'samat.sharipov@gmail.com',1),
       (SELECT id FROM users WHERE email = 'tatyana.mironova@gmail.com',1),
       (SELECT id FROM users WHERE email = 'mukhit.tursunov@gmail.com',1),
       (SELECT id FROM users WHERE email = 'anara.osmonalieva@gmail.com',1),
       (SELECT id FROM users WHERE email = 'sultan.sharipov@gmail.com',1),
       (SELECT id FROM users WHERE email = 'elena.kudryavtseva@gmail.com',1);


INSERT INTO resumes (applicant_id, name, category_id, salary, is_active, created_date)
VALUES
    ((SELECT id FROM USERS WHERE EMAIL = 'valery.fedotov@gmail.com'), 'Resume 1', 1, 2900.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'yana.solovyeva@gmail.com'), 'Resume 2', 2, 3100.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'timur.samatov@gmail.com'), 'Resume 3', 3, 3300.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'mariam.kurbatova@gmail.com'), 'Resume 4', 1, 3000.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'aristotel.akmatov@gmail.com'), 'Resume 5', 2, 3200.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'eldar.serikov@gmail.com'), 'Resume 6', 3, 3400.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'beksultan.bekov@gmail.com'), 'Resume 7', 1, 3100.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'zhanar.ramazanova@gmail.com'), 'Resume 8', 2, 3300.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'nursultan.zhanbayeva@gmail.com'), 'Resume 9', 3, 3500.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'lara.lutsenko@gmail.com'), 'Resume 10', 1, 3200.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'samat.sharipov@gmail.com'), 'Resume 11', 2, 3400.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'tatyana.mironova@gmail.com'), 'Resume 12', 3, 3600.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'mukhit.tursunov@gmail.com'), 'Resume 13', 1, 3300.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'anara.osmonalieva@gmail.com'), 'Resume 14', 2, 3500.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'sultan.sharipov@gmail.com'), 'Resume 15', 3, 3700.00, TRUE, current_timestamp()),
    ((SELECT id FROM USERS WHERE EMAIL = 'elena.kudryavtseva@gmail.com'), 'Resume 16', 1, 3400.00, TRUE, current_timestamp());


INSERT INTO vacancies (name, description, category_id, salary, exp_from, exp_to, is_active, author_id, created_date)
VALUES
    ('Software Developer', 'Develop and maintain software applications.', 1, 4000.00, 3, 5, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'adilet.urmat@gmail.com'), current_timestamp()),
    ('Data Analyst', 'Analyze and interpret complex data to help organizations make decisions.', 2, 3500.00, 2, 4, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'alibek.bek@gmail.com'), current_timestamp()),
    ('Project Manager', 'Oversee project development from inception to completion.', 3, 5000.00, 4, 7, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'mirbek.alishev@gmail.com'), current_timestamp()),
    ('UI/UX Designer', 'Design user interfaces and improve user experiences.', 4, 3800.00, 3, 5, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'tarsyn.zhan@gmail.com'), current_timestamp()),
    ('Marketing Specialist', 'Develop marketing strategies and campaigns.', 2, 3200.00, 2, 5, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'katya.sidorova@gmail.com'), current_timestamp()),
    ('Sales Manager', 'Manage sales team and develop sales strategies.',3, 4500.00,  6,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'ruslan.kutubekov@gmail.com'), current_timestamp()),
    ('HR Specialist', 'Recruit and manage employees.',2, 3000.00, 4,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'nurlan.bekov@gmail.com'), current_timestamp()),
    ('Web Developer', 'Build and maintain websites.',2, 4000.00, 5,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'akmaral.baisalova@gmail.com'), current_timestamp()),
    ('Graphic Designer', 'Create visual concepts to communicate ideas.',2, 3200.00, 4,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'dastan.daniyar@gmail.com'), current_timestamp()),
    ('Customer Support Representative', 'Assist customers with their inquiries and issues.',1, 2900.00,  3,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'gulnara.muratova@gmail.com'), current_timestamp()),
    ('Content Writer', 'Write and edit content for various platforms.',1, 3100.00, 4,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'bekzat.kyrgyzbaev@gmail.com'), current_timestamp()),
    ('Business Analyst', 'Evaluate business processes and provide solutions.',3, 3700.00, 5,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'shamil.shamsiev@gmail.com'), current_timestamp()),
    ('Network Engineer', 'Design and implement network solutions.',3, 4300.00, 6,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'saniya.kairatova@gmail.com'), current_timestamp()),
    ('Database Administrator', 'Manage and maintain database systems.',4, 4500.00, 7,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'janyl.bekova@gmail.com'), current_timestamp()),
    ('Operations Manager', 'Oversee daily operations and improve processes.',5, 4700.00, 8,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'serik.keldi@gmail.com'), current_timestamp()),
    ('Product Manager', 'Plan and execute product strategies.',4, 5000.00, 7,10, TRUE, (SELECT id FROM USERS WHERE EMAIL = 'alina.dzhangirova@gmail.com'), current_timestamp());


INSERT INTO responded_applicants (resume_id, vacancy_id, confirmation)
VALUES
    (1, 1, TRUE),
    (2, 1, FALSE),
    (3, 2, TRUE),
    (4, 2, TRUE),
    (5, 3, FALSE),
    (6, 4, TRUE);


INSERT INTO contact_types (type)
VALUES ('Email'),
       ('Phone'),
       ('Telegram'),
       ('FaceBook'),
       ('LinkedIn');

INSERT INTO contacts_info (type_id, resume_id, info)
VALUES
    (1, 1, 'valery.fedotov@gmail.com'),
    (2, 1, '0555433464'),
    (3, 1, 'valery_fedotov_telegram'),
    (4, 1, 'valery.fedotov.fb'),
    (5, 1, 'valery_fedotov_linkedin'),

    (1, 2, 'yana.solovyeva@gmail.com'),
    (2, 2, '0555433465'),
    (3, 2, 'yana_solovyeva_telegram'),
    (4, 2, 'yana.solovyeva.fb'),
    (5, 2, 'yana_solovyeva_linkedin'),

    (1, 3, 'timur.samatov@gmail.com'),
    (2, 3, '0555433466'),
    (3, 3, 'timur_samatov_telegram'),
    (4, 3, 'timur.samatov.fb'),
    (5, 3, 'timur_samatov_linkedin'),

    (1, 4, 'mariam.kurbatova@gmail.com'),
    (2, 4, '0555433467'),
    (3, 4, 'mariam_kurbatova_telegram'),
    (4, 4, 'mariam.kurbatova.fb'),
    (5, 4, 'mariam_kurbatova_linkedin'),

    (1, 5, 'aristotel.akmatov@gmail.com'),
    (2, 5, '0555433468'),
    (3, 5, 'aristotel_akmatov_telegram'),
    (4, 5, 'aristotel.akmatov.fb'),
    (5, 5, 'aristotel_akmatov_linkedin'),

    (1, 6, 'eldar.serikov@gmail.com'),
    (2, 6, '0555433469'),
    (3, 6, 'eldar_serikov_telegram'),
    (4, 6, 'eldar.serikov.fb'),
    (5, 6, 'eldar_serikov_linkedin'),

    (1, 7, 'beksultan.bekov@gmail.com'),
    (2, 7, '0555433471'),
    (3, 7, 'beksultan_bekov_telegram'),
    (4, 7, 'beksultan.bekov.fb'),
    (5, 7, 'beksultan_bekov_linkedin'),

    (1, 8, 'zhanar.ramazanova@gmail.com'),
    (2, 8, '0555433472'),
    (3, 8, 'zhanar_ramazanova_telegram'),
    (4, 8, 'zhanar.ramazanova.fb'),
    (5, 8, 'zhanar_ramazanova_linkedin'),

    (1, 9, 'nursultan.zhanbayeva@gmail.com'),
    (2, 9, '0555433473'),
    (3, 9, 'nursultan_zhanbayeva_telegram'),
    (4, 9, 'nursultan.zhanbayeva.fb'),
    (5, 9, 'nursultan_zhanbayeva_linkedin'),

    (1, 10, 'lara.lutsenko@gmail.com'),
    (2, 10, '0555433474'),
    (3, 10, 'lara_lutsenko_telegram'),
    (4, 10, 'lara.lutsenko.fb'),
    (5, 10, 'lara_lutsenko_linkedin'),

    (1, 11, 'samat.sharipov@gmail.com'),
    (2, 11, '0555433475'),
    (3, 11, 'samat_sharipov_telegram'),
    (4, 11, 'samat.sharipov.fb'),
    (5, 11, 'samat_sharipov_linkedin'),

    (1, 12, 'tatyana.mironova@gmail.com'),
    (2, 12, '0555433476'),
    (3, 12, 'tatyana_mironova_telegram'),
    (4, 12, 'tatyana.mironova.fb'),
    (5, 12, 'tatyana_mironova_linkedin'),

    (1, 13, 'mukhit.tursunov@gmail.com'),
    (2, 13, '0555433477'),
    (3, 13, 'mukhit_tursunov_telegram'),
    (4, 13, 'mukhit.tursunov.fb'),
    (5, 13, 'mukhit_tursunov_linkedin'),

    (1, 14, 'anara.osmonalieva@gmail.com'),
    (2, 14, '0555433478'),
    (3, 14, 'anara_osmonalieva_telegram'),
    (4, 14, 'anara.osmonalieva.fb'),
    (5, 14, 'anara_osmonalieva_linkedin'),

    (1, 15, 'sultan.sharipov@gmail.com'),
    (2, 15, '0555433479'),
    (3, 15, 'sultan_sharipov_telegram'),
    (4, 15, 'sultan.sharipov.fb'),
    (5, 15, 'sultan_sharipov_linkedin'),

    (1, 16, 'elena.kudryavtseva@gmail.com'),
    (2, 16, '0555433480'),
    (3, 16, 'elena_kudryavtseva_telegram'),
    (4, 16, 'elena.kudryavtseva.fb'),
    (5, 16, 'elena_kudryavtseva_linkedin');


INSERT INTO messages (responded_applicants_id, content, timestamp)
VALUES
    (1, 'Hello it is actually', current_timestamp()),
    (2, 'Hello i am looking new job', current_timestamp()),
    (3, 'I want work with you', current_timestamp()),
    (4, 'Hello i like this job', current_timestamp()),
    (6, 'I am looking new opportunity', current_timestamp());


INSERT INTO education_info (resume_id, institution, program, start_date, end_date, degree)
VALUES
    (1, 'University ASA', 'Computer Science', '2015-09-01', '2019-06-30', 'Bachelor'),
    (2, 'University BAS', 'Business Administration', '2014-08-01', '2018-05-30', 'Bachelor'),
    (3, 'University CDSA', 'Electrical Engineering', '2016-09-01', '2020-06-30', 'Bachelor'),
    (4, 'University DAS', 'Graphic Design', '2017-09-01', '2021-06-30', 'Bachelor'),
    (5, 'University EJD', 'Economics', '2014-09-01', '2018-06-30', 'Bachelor'),
    (6, 'University FJFC', 'Mechanical Engineering', '2015-09-01', '2019-06-30', 'Bachelor'),
    (7, 'University GRTY', 'Mathematics', '2016-09-01', '2020-06-30', 'Bachelor'),
    (8, 'University HDDC', 'Physics', '2015-09-01', '2019-06-30', 'Bachelor'),
    (9, 'University IVEW', 'Biology', '2017-09-01', '2021-06-30', 'Bachelor'),
    (10, 'University JGDG', 'Chemistry', '2016-09-01', '2020-06-30', 'Bachelor'),
    (11, 'University KGD', 'Engineering Management', '2018-09-01', '2022-06-30', 'Master'),
    (12, 'University LB', 'Psychology', '2017-09-01', '2021-06-30', 'Bachelor'),
    (13, 'University MHD', 'Civil Engineering', '2014-09-01', '2018-06-30', 'Bachelor'),
    (14, 'University NPD', 'Finance', '2018-09-01', '2022-06-30', 'Master'),
    (15, 'University OOI', 'International Relations', '2016-09-01', '2020-06-30', 'Bachelor'),
    (16, 'University PTY', 'Journalism', '2015-09-01', '2019-06-30', 'Bachelor');


INSERT INTO work_experience_info (resume_id, years, company_name, position, responsibilities)
VALUES
    (1, 3, 'BEELINE', 'Software Developer', 'Developed web applications'),
    (2, 5, 'O', 'Marketing Manager', 'Developed marketing strategies'),
    (3, 4, 'MEGA', 'Data Analyst', 'Analyzed and interpreted data'),
    (4, 2, 'O', 'Graphic Designer', 'Created visual content'),
    (5, 6, 'MBANK', 'Economist', 'Conducted economic research'),
    (6, 5, 'AUTOSERV', 'Mechanical Engineer', 'Designed mechanical systems'),
    (7, 3, 'SCHOOL', 'Mathematician', 'Applied mathematical models'),
    (8, 4, 'CUMTOR GOLD', 'Physicist', 'Conducted experiments in physics'),
    (9, 3, 'PHARMAMIR', 'Biologist', 'Performed biological research'),
    (10, 5, 'AIBOLIT', 'Chemist', 'Conducted chemical analyses'),
    (11, 2, 'ISITO', 'Engineering Manager', 'Oversaw engineering projects'),
    (12, 3, 'OSH BAZAR', 'Psychologist', 'Provided psychological counseling'),
    (13, 4, 'ANTA', 'Civil Engineer', 'Managed construction projects'),
    (14, 2, 'BAKAI BANK', 'Financial Analyst', 'Performed financial analysis'),
    (15, 3, 'AUCA', 'Diplomat', 'Negotiated international agreements'),
    (16, 4, 'KTRK', 'Journalist', 'Reported news stories');

