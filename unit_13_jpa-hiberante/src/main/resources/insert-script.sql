INSERT INTO courses (id, name)
VALUES (1, 'Java For Beginners');
INSERT INTO courses (id, name)
VALUES (2, 'C++ For Beginners');

INSERT INTO groups (id, name, course_id)
VALUES (31, 'SP-11', 1);
INSERT INTO groups (id, name, course_id)
VALUES (11, 'JV-11', 2);

INSERT INTO lessons(id, start_time, end_time, course_id, professor_id)
VALUES (1, '2021-11-01 19:00:00', '2021-11-01 22:00:00', 1, 1);
INSERT INTO lessons (id, start_time, end_time, course_id, professor_id)
VALUES (2, '2021-11-11 18:00:00', '2021-11-11 21:00:00', 1, 1);
INSERT INTO lessons (id, start_time, end_time, course_id, professor_id)
VALUES (3, '2021-12-01 19:00:00', '2021-12-01 22:00:00', 2, 2);
INSERT INTO lessons (id, start_time, end_time, course_id, professor_id)
VALUES (4, '2021-12-06 19:00:00', '2021-12-06 22:00:00', 2, 2);

INSERT INTO students (student_id, student_name, student_phone, student_email, group_id)
VALUES (21, 'Mykhailo Dmytrash', '+380965542212', 'dmytrash@gmail.com', 31);
INSERT INTO students (student_id, student_name, student_phone, student_email, group_id)
VALUES (32, 'Sviatoslav Vintoniv', '+380689944342', 'vintoniv@gmail.com', 31);
INSERT INTO students (student_id, student_name, student_phone, student_email, group_id)
VALUES (33, 'Nikolai Ratishin', '+380676656656', 'keepcalm@gmail.com', 31);
INSERT INTO students (student_id, student_name, student_phone, student_email, group_id)
VALUES (43, 'Ada Symonenko', '+3809633644336', 'valyas@gmail.com', 31);
INSERT INTO students (student_id, student_name, student_phone, student_email, group_id)
VALUES (11, 'Andriy Yerzhikevich', '+380967675576', 'yierzhik@gmail.com', 11);
INSERT INTO students (student_id, student_name, student_phone, student_email, group_id)
VALUES (12, 'Oleg Golovkov', '+380977445675', 'golovkoov@gmail.com', 11);
INSERT INTO students (student_id, student_name, student_phone, student_email, group_id)
VALUES (13, 'Alina Dobrianska', '+380680942344', 'dobrianskaa@gmail.com', 11);

INSERT INTO professors (professor_id, professor_name, professor_email)
VALUES (1, 'Nikolay Lutsenko', 'nl@gmail.com');
INSERT INTO professors (professor_id, professor_name, professor_email)
VALUES (2, 'Sergey Lankarra', 'lankarra@gmail.com');

INSERT INTO themes (theme_id, theme_title, lesson_id)
VALUES (1, 'Getting Started', 1);
INSERT INTO themes (theme_id, theme_title, lesson_id)
VALUES (2, 'Why you should sell your soul. What it`s price', 2);
INSERT INTO themes (theme_id, theme_title, lesson_id)
VALUES (3, 'Let`s the ritual begin', 3);

INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (10, 13, 1, 1);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (7, 33, 1, 1);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (6, 12, 1, 1);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (6, 21, 1, 1);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (8, 43, 1, 1);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (10, 32, 1, 1);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (10, 11, 1, 2);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (9, 13, 2, 2);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (10, 11, 2, 2);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (7, 12, 2, 2);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (7, 21, 2, 3);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (10, 43, 2, 3);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (7, 32, 2, 3);
INSERT INTO marks (mark, student_id, professor_id, theme_id)
VALUES (6, 33, 2, 3);