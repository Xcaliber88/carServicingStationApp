INSERT INTO cars (id, brand_name, model, year_built, colour, registration_no, first_name, last_name, owners_email, owners_phone_no)
                    VALUES (1001,'Mercedes', 'C180', 2020, 'Metalic_black', 'K-345-JL', 'Jan', 'Jansen', 'JanJansen@hotmail.com', 310612345678),
                           (1002, 'BMW', 'X6M', 2022, 'Metalic_white', 'R-543-KK', 'Kees', 'Koters', 'KeesKoters@gmail.com', 310652987321 ),
                           (1003, 'Audi', 'Etron_55', 2019, 'Metalic_blue', 'J-888-PK', 'Willem', 'de_Wit', 'Willemdewit@yahoo.com', 310658654321);

INSERT INTO car_parts (id, part_name, part_category, part_description, original_stock, sold, weight, price)
                    VALUES (2001, 'Motor oil 0W-30', 'Lubricators','0W-30', 10, 0, '1L', 9.95),
                           (2002, 'Motor oil 5W-30', 'Lubricators','5W-30', 8, 2, '1L', 11.95),
                           (2003, 'Motor oil 10W-30', 'Lubricators','10W-30', 18, 5, '1L', 14.95),
                           (2004, 'Motor oil 15W-30', 'Lubricators','15W-30', 9, 3, '1L', 16.95),
                           (2005, 'Oil filter', 'Lubricators', 'to filter motor oil', 100, 5,'1 piece',9.95),
                           (2006, 'Brake pads', 'Braking system','universal brake pad set', 50, 3, '4 pieces in set',49.5),
                           (2007, 'Battery 74Ah 12V','Power management', 'with start capacity of 680A', 30, 3, '5KG', 89.95),
                           (2008, 'Screen wipers', 'Screen', 'universal wipers', 50, 5, '2 pieces', 19.95),
                           (2009, 'Braking Fluid', 'Lubricators', 'dot 4', 50, 25, '250ml', 6.95),
                           (2010, 'Cooling Fluid', 'Cooling system','Anti-freeze', 20,5,'5L',10.95),
                           (2011, 'AC-Fluid', 'Cooling System', 'AC Fluid anti-freeze 10L', 30,7, '10L', 19.95),
                           (2012, 'LED head light', 'Lighting', 'LED light strip', 10,3, '2 pieces', 90),
                           (2013, 'Brake light bulb', 'lighting', 'LED brake light bulb', 50, 10, '2 pieces', 9.95);


INSERT INTO job_description (id, jobs_name, job_overview, labour_hours, hourly_labour_cost, part_id)
                    VALUES (3001, 'Motor oil change', 'Flush old oil and refill ',3, 39,2001),
                           (3002, 'Filter change', 'replacing old filter with new one',6, 39,2005),
                           (3003, 'Brake pad change', 'replacing with brake pads', 2, 39, 2006),
                           (3004, 'Battery replacement', 'replacing with new battery and recharge', 0.5, 39, 2007),
                           (3005, 'Wipers replacement','replacement with new wipers', 0.5, 39,2008),
                           (3006, 'Braking fluid change', 'flushing brake fluid tank and refill', 1, 39, 2009),
                           (3007, 'Cooling Fluid Change', 'Flushing Cooling fluid tank and refill', 1, 39, 2010),
                           (3008, 'AC Fluid change', 'Flushing AC radiator and refill', 1.5, 39, 2011),
                           (3009, 'Replacing headlight bulbs', 'replacing headlight bulb and calibration', 1,39, 2012),
                           (3010, 'Replacing brake light bulbs', 'replacing brake light bulb and calibration', 1,39, 2013);

INSERT INTO job_description (id, jobs_name, job_overview, labour_hours, hourly_labour_cost)
                    VALUES (3011, 'Calibration of wheels', 'balancing and calibration of wheels',3, 39),
                           (3012, 'APK testing','Inspection of fixed set of car parts and performances',3, 39),
                           (3013, 'Inspection of mall function', 'Diagnosis and Reporting', 8, 39);

INSERT INTO         repairs (id, repair_name, repair_description)
                    VALUES (4001, 'Major Service', 'Service at intervals of 40000KM'),
                           (4002, 'Minor Service', 'Service at intervals of 20000KM'),
                           (4003, 'Apk Keuring', 'Yearly vehicle testing'),
                           (4004, 'Part change', 'Defective part replacement');


INSERT INTO repair_job_description (job_id, repair_id)
                        VALUES (3001, 4001),
                               (3002,4001),
                               (3003, 4001),
                               (3001, 4002),
                               (3006,4002);

INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$10$0H9cheY9sNwnrFeghHWTweTSAq8ljWIwMM1AJ119J8fTpUjm4LBsu','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('john_parts', '$2a$10$0H9cheY9sNwnrFeghHWTweTSAq8ljWIwMM1AJ119J8fTpUjm4LBsu','j.parts@ev4u.com', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('evi_brown_front_office', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica','e.brown@ev4u.com', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('ev4u_admin', '$2a$10$idshQogvSCbwIoSbuOVNy.s6F4fu.OOev0xQDLJeBh1ZENiyQkFjy', 'admin@ev4u.com', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('evi_brown_front_office', 'ROLE_FRONTOFFICE');
INSERT INTO authorities (username, authority) VALUES ('john_parts', 'ROLE_MECHANIC');
INSERT INTO authorities (username, authority) VALUES ('ev4u_admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('ev4u_admin', 'ROLE_ADMIN');





