INSERT INTO client (name) VALUES
 ('Theodore Roosevelt')
,('Franklin D. Roosevelt')
,('Harry S. Truman')
,('John F. Kennedy')
,('Richard M. Nixon')
,('Jimmy Carter')
,('Ronald Reagan')
,('George Bush')
,('Bill Clinton')
,('George W. Bush')
,('Barack Obama')
,('Donald J. Trump')
,('Joseph R. Biden');

INSERT INTO planet (id, name) VALUES
 ('MERC234', 'MERCURY')
,('JUP221', 'JUPITER')
,('MRS777', 'MARS')
,('SAT064', 'SATURN')
,('UR321', 'URANUS')
,('NEP704', 'NEPTUNE')
,('VEN66', 'VENUS')
,('ERZ99', 'EARTH');


INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
 ('2016-08-02 14:01:01', 1, 'MERC234', 'ERZ99')
,('2017-01-02 12:02:27', 2, 'JUP221',  'MRS777')
,('2018-02-02 13:09:26', 3, 'MRS777',  'SAT064')
,('2019-03-02 12:23:51', 4, 'UR321',   'ERZ99')
,('2020-04-02 11:43:43', 5, 'UR321',   'VEN66')
,('2020-05-02 19:21:23', 6, 'VEN66',   'MERC234')
,('2021-06-02 10:28:54', 7, 'SAT064',  'JUP221')
,('2021-07-02 21:56:57', 8, 'ERZ99',   'UR321')
,('2022-01-02 23:33:56', 9, 'VEN66',   'MRS777')
,('2022-05-02 12:44:34', 10,'MERC234', 'NEP704')
,('2022-10-02 09:24:14', 11,'JUP221',  'ERZ99')
,('2023-02-02 07:07:13', 12,'NEP704',  'SAT064')
,('2023-11-02 09:18:12', 13,'VEN66',   'UR321')
,('2024-01-03 11:16:11', 4, 'JUP221',  'SAT064')
,('2024-02-22 13:13:10', 7, 'NEP704',  'ERZ99');

