-- This file allow to write SQL commands that will be emitted in test and dev.

-- The commands are commented as their support depends of the database

insert into area (id, name) values(uuid(), 'AREA001');

insert into area (id, name) values(uuid(), 'AREA002');

insert into area (id, name) values(uuid(), 'AREA003');

insert into area (id, name) values(uuid(), 'AREA004');

insert into area (id, name) values(uuid(), 'AREA005');

insert into area (id, name) values(uuid(), 'AREA006');

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');