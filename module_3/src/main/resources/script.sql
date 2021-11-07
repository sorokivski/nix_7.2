INSERT INTO users (user_id, user_name, user_phone_num, user_email)
VALUES (1, 'Elsa Hosk', '+795252252542', 'elsa@gmail.com');
INSERT INTO users (user_id, user_name, user_phone_num, user_email)
VALUES (2, 'Kendall Jenner', '+7945553354354', 'kenny@gmail.com');
INSERT INTO users (user_id, user_name, user_phone_num, user_email)
VALUES (3, 'Taylor Hill', '+7955551254774', 'taylorhill@gmail.com');
INSERT INTO users (user_id, user_name, user_phone_num, user_email)
VALUES (4, 'Iryna Shaik', '+7452228535532', 'shaiklislamova@gmail.com');

INSERT INTO bills (user_id, amount)
VALUES (1, 10826654);
INSERT INTO bills (user_id, amount)
VALUES (4, 26520605);
INSERT INTO bills (user_id, amount)
VALUES (3, 2656525);
INSERT INTO bills (user_id, amount)
VALUES (2, 26562605);


INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (22, 2, 4, '2020-12-10 10:00:00', -10020);
INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (23, 3, 3, '2021-02-10 10:00:00', -10983);
INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (232, 1, 0, '2021-11-11 10:00:00', 10545);
INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (221, 2, 7, '2021-07-11 17:00:00', 10040);
INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (212, 4, 6, '2021-08-10 13:40:00', 98920);
INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (99, 1, 1, '2021-12-12 12:22:21', -13430);
INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (78, 2, 4, '2021-06-21 18:06:57', -10200);
INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (44, 3, 4, '2021-05-10 16:50:31', -10140);
INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (77, 4, 4, '2020-10-20 10:30:24', -10320);
INSERT INTO transactions (transaction_id, bill_id, transaction_category, transaction_time, transaction_amount)
VALUES (12, 4, 8, '2021-09-12 12:30:30', -10010);
