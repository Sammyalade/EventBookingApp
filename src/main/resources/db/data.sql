TRUNCATE TABLE events cascade;
TRUNCATE TABLE attendees cascade;
TRUNCATE TABLE organizers cascade;


INSERT INTO events (id, name, description, date, time)
VALUES (200, 'Wedding', 'no description', '2024-12-29', '09:00');


INSERT INTO attendees (id, name, email, phone, address, city, state, country, have_payed)
VALUES (100, 'John Doe', 'john.doe@example.com', '123-456-7890', '123 Main St', 'Anytown', 'CA', 'USA', true);



INSERT INTO organizers (id, name, address, phone, email, city, state)
VALUES (10, 'Organizer One', '123 Main St', '123-456-7890', 'organizer1@example.com', 'New York', 'NY'),
       (11, 'Organizer Two', '456 Elm St', '987-654-3210', 'organizer2@example.com', 'Los Angeles', 'CA'),
       (12, 'Organizer Three', '789 Oak St', '555-555-5555', 'organizer3@example.com', 'Chicago', 'IL');
