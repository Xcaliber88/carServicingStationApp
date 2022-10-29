INSERT INTO cars (id, brand_name, model, year_built, colour, registration_no, owners_first_name, owners_last_name, owners_email, owners_phone_no)
                    VALUES (1001,'Mercedes', 'C180', 2020, 'Metalic_black', 'K-345-JL', 'Jan', 'Jansen', 'JanJansen@hotmail.com', 310612345678),
                           (1002, 'BMW', 'X6M', 2022, 'Metalic_white', 'R-543-KK', 'Kees', 'Koters', 'KeesKoters@gmail.com', 310652987321 ),
                           (1003, 'Audi', 'Etron_55', 2019, 'Metalic_blue', 'J-888-PK', 'Willem', 'de_Wit', 'Willemdewit@yahoo.com', 310658654321);

INSERT INTO job_description (id, jobs_name, job_overview, labour_hours, hourly_labour_cost )
                    VALUES (3001, 'Major servicing', 'replacing many parts',6, 39),
                           (3002, 'Minor servicing', 'replacing some parts',3, 39),
                           (3003, 'brake pad change', 'replacing the brake pads', 2, 39);

INSERT INTO car_parts (id, part_name, part_category, part_description, original_stock, sold, weight, price, job_id)
VALUES (2001, 'Motor oil 0W-30', 'Lubricators','0W-30', 10, 0, '1L', 9.95, 3001);

INSERT INTO car_parts (id, part_name, part_category, part_description, original_stock, sold, weight, price)
VALUES (2002, 'Motor oil 5W-30', 'Lubricators','5W-30', 8, 2, '1L', 11.95),
       (2003, 'Motor oil 10W-30', 'Lubricators','10W-30', 18, 5, '1L', 14.95),
       (2004, 'Motor oil 15W-30', 'Lubricators','15W-30', 9, 3, '1L', 16.95);

