INSERT INTO company_user (id, login) VALUES
('a092517d-b869-441d-96b6-6b6a1bf1c45e', 'user1'),
('7cb9e72e-435c-49dd-8e4e-fcaf8c409a14', 'user2'),
('1e1f56b7-f96d-4aa6-bae0-c6dc2af90a6f', 'user3'),
('c2a2b504-d39e-4bfa-9b4d-62f9156b8e0d', 'user4'),
('e1f3f619-82a0-4d38-bb07-bd2191c181d2', 'user5'),
('7dff340e-19e5-4a38-8b1f-17be6b9a5d94', 'user6');

INSERT INTO patient_profile (id, first_name, last_name, old_client_guid, status_id) VALUES
('91e653cf-e7dc-470a-871d-320ff6963aae', 'John', 'Doe', 'd09ce99e-f161-4fc7-9434-e5bf44893d0c', 1),
('3cb62991-057e-4363-a1cb-d97ffe83636b', 'Jane', 'Smith', '79a6e09c-f548-4534-93dc-3ad22079e8b1', 1),
('be1a3b9e-4748-4678-8d04-08d192022689', 'Alice', 'Johnson', '99eb99be-f80f-42d8-8349-c2c04a919c4f', 2),
('d3e3c6a3-4edb-4cba-b3e5-fd6a01aef6c1', 'Emily', 'Davis', 'c1fbe8e0-45de-4f47-a44f-86f9d5e8651a', 1),
('ec5c1a60-e2d4-4704-832b-1a913d1238f5', 'Michael', 'Brown', 'cfe0e7ff-0a91-44be-94e3-8c8a0b1ecaf1', 2),
('5dbd8ae7-8c1f-4a1c-b8b4-6c98710c6f7c', 'Sophia', 'Miller', 'c6d9b462-3c7f-4c7b-b5e0-ace18ebae5cd', 1);

INSERT INTO patient_note (id, created_date_time, last_modified_date_time, created_by_user_id, last_modified_by_user_id, note, patient_id) VALUES
('9e4435bc-4004-44b0-80e9-b8d2f7ce86d1', '2023-10-01 10:00:00', '2023-10-01 10:00:00', 'a092517d-b869-441d-96b6-6b6a1bf1c45e', 'a092517d-b869-441d-96b6-6b6a1bf1c45e', 'This is the first note for John Doe.', '91e653cf-e7dc-470a-871d-320ff6963aae'),
('21602905-3ef0-48ec-8d8a-4ef2aadb3aba', '2023-10-02 11:00:00', '2023-10-02 11:00:00', '7cb9e72e-435c-49dd-8e4e-fcaf8c409a14', '7cb9e72e-435c-49dd-8e4e-fcaf8c409a14', 'This is a note for Jane Smith.', '3cb62991-057e-4363-a1cb-d97ffe83636b'),
('0509026a-3863-4313-98cb-aeb136099848', '2023-10-03 12:00:00', '2023-10-03 12:00:00', '1e1f56b7-f96d-4aa6-bae0-c6dc2af90a6f', '1e1f56b7-f96d-4aa6-bae0-c6dc2af90a6f', 'This is a note for Alice Johnson.', 'be1a3b9e-4748-4678-8d04-08d192022689'),
('b85c6a03-e8f2-4ae4-8a5e-57cbdaabc47e', '2023-10-04 09:00:00', '2023-10-04 09:00:00', 'c2a2b504-d39e-4bfa-9b4d-62f9156b8e0d', 'c2a2b504-d39e-4bfa-9b4d-62f9156b8e0d', 'Note for Emily Davis.', 'd3e3c6a3-4edb-4cba-b3e5-fd6a01aef6c1'),
('a50f5144-bd24-41f3-97c0-2252c781b1a8', '2023-10-05 10:30:00', '2023-10-05 10:30:00', 'e1f3f619-82a0-4d38-bb07-bd2191c181d2', 'e1f3f619-82a0-4d38-bb07-bd2191c181d2', 'Note for Michael Brown.', 'ec5c1a60-e2d4-4704-832b-1a913d1238f5'),
('3dbd6a38-2c99-44b6-91c2-8e27d2f1e8cb', '2023-10-06 11:45:00', '2023-10-06 11:45:00', '7dff340e-19e5-4a38-8b1f-17be6b9a5d94', '7dff340e-19e5-4a38-8b1f-17be6b9a5d94', 'Note for Sophia Miller.', '5dbd8ae7-8c1f-4a1c-b8b4-6c98710c6f7c');