CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO client (guid, agency, first_name, last_name, status, dob, created_date_time) VALUES
('d09ce99e-f161-4fc7-9434-e5bf44893d0c', 'vhh1', 'Alice', 'Smith', 'ACTIVE', '1990-01-15', '2021-01-15 11:51:59'),
('79a6e09c-f548-4534-93dc-3ad22079e8b1', 'vhh1', 'Bob', 'Johnson', 'INACTIVE', '1985-05-22', '2021-02-16 12:00:00'),
('c1fbe8e0-45de-4f47-a44f-86f9d5e8651a', 'vhh1', 'Emma', 'Williams', 'ACTIVE', '1992-02-10', '2021-03-01 10:00:00'),
('cfe0e7ff-0a91-44be-94e3-8c8a0b1ecaf1', 'vhh1', 'Oliver', 'Jones', 'INACTIVE', '1988-08-30', '2021-03-15 14:30:00'),
('c6d9b462-3c7f-4c7b-b5e0-ace18ebae5cd', 'vhh1', 'Ava', 'Garcia', 'ACTIVE', '1995-12-25', '2021-04-05 09:15:00');

INSERT INTO note (note_id, agency, client_guid, comments, created_date_time, modified_date_time, logged_user)VALUES
(uuid_generate_v4(), 'vhh1', (SELECT guid FROM client WHERE first_name = 'Alice' AND last_name = 'Smith'), 'Первый комментарий.', '2021-01-15 11:51:59', '2021-01-15 11:51:59', 'user1'),
(uuid_generate_v4(), 'vhh1', (SELECT guid FROM client WHERE first_name = 'Bob' AND last_name = 'Johnson'), 'Второй комментарий.', '2021-02-16 12:00:00', '2021-02-16 12:00:00', 'user2'),
('a77e3e70-4700-4be6-bc1f-4d8f177a43b7', 'vhh1', (SELECT guid FROM client WHERE first_name = 'Emma' AND last_name = 'Williams'), 'Первый комментарий для Эммы.', '2021-03-01 10:00:00', '2021-03-01 10:00:00', 'user4'),
('f9b1e1a4-dc6b-4b6b-b8d0-6c9b1cfec1e3', 'vhh1', (SELECT guid FROM client WHERE first_name = 'Oliver' AND last_name = 'Jones'), 'Второй комментарий для Оливера.', '2021-03-15 14:30:00', '2021-03-15 14:30:00', 'user5'),
('fb5c9b2a-958e-41f3-b888-b64e3a0ae8a0', 'vhh1', (SELECT guid FROM client WHERE first_name = 'Ava' AND last_name = 'Garcia'), 'Третий комментарий для Авой.', '2021-04-05 09:15:00', '2021-04-05 09:15:00', 'user6');