
INSERT INTO unit_13.courses (course_id, course_name) VALUES (1, 'Java For Beginners');
INSERT INTO unit_13.courses (course_id, course_name) VALUES (2, 'C++ For Beginners');

INSERT INTO unit_13.groups (group_id, group_name) VALUES (1, 'SP-11');
INSERT INTO unit_13.groups (group_id, group_name) VALUES (2, 'JV-11');

INSERT INTO unit_13.lessons (lesson_id,start,end,course_id,professor_id) VALUES (1, '2021-11-01 19:00:00', '2021-11-01 22:00:00', 1, 1);
INSERT INTO unit_13.lessons (lesson_id,start,end,course_id,professor_id) VALUES (2, '2021-11-11 18:00:00', '2021-11-11 21:00:00', 1, 1);
INSERT INTO unit_13.lessons (lesson_id,start,end,course_id,professor_id) VALUES (3, '2021-12-01 19:00:00', '2021-12-01 22:00:00', 1, 1);

INSERT INTO unit_13.students (student_id, student_name, student_phone, student_email, group_id) VALUES (1, 'Vintoniv S.O.', '1111111', 'ev@gmail.com', 1);
INSERT INTO unit_13.students (student_id, student_name, student_phone, student_email, group_id) VALUES (2, 'Kolodiy O.O.', '222222', 'ek@gmail.com', 1);
INSERT INTO unit_13.students (student_id, student_name, student_phone, student_email, group_id) VALUES (3, 'Ratyshin M.O.', '333333', 'er@gmail.com', 2);
INSERT INTO unit_13.students (student_id, student_name, student_phone, student_email, group_id) VALUES (3, 'Demidiyuk I.Y.', '444444', 'ed@gmail.com', 2);

INSERT INTO unit_13.professors (professor_id,professor_name,professor_email) VALUES (1, 'Nikolay Lutsenko', 'nl@gmail.com');
INSERT INTO unit_13.professors (professor_id,professor_name,professor_email) VALUES (2, 'Sergey Prosutov', 'sp@gmail.com');

INSERT INTO unit_13.themes (theme_id, theme_title) VALUES (1, 'Getting Started');
INSERT INTO unit_13.themes (theme_id, theme_title) VALUES (2, 'Why you should sell your soul. What it`s price');
INSERT INTO unit_13.themes (theme_id, theme_title) VALUES (3, 'Let`s the ritual begin');

INSERT INTO unit_13.course_lessons (course_id, lesson_id) VALUES (1, 1);

INSERT INTO unit_13.courses_topics (course_id, topic_id) VALUES (2, 3);
INSERT INTO unit_13.courses_topics (course_id, topic_id) VALUES (3, 2);