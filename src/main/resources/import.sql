insert into area (id, name) values (uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'), 'AREA001');
insert into area (id, name) values (uuid_to_bin('255fed83-2b8b-4b99-b62d-379e9e9cafdc'), 'AREA002');
insert into area (id, name) values (uuid_to_bin('561ea7c1-e635-4a3c-ab4a-74b601a46393'), 'AREA003');
insert into area (id, name) values (uuid_to_bin('5289c641-0173-48a3-8e24-d2564020c9d6'), 'AREA004');
insert into area (id, name) values (uuid_to_bin('4dd17de3-8dbc-4768-be1c-09c8535220dc'), 'AREA005');
insert into area (id, name) values (uuid_to_bin('281d9026-f555-41bd-bb0b-1d9157e71024'), 'AREA006');

insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA001', uuid_to_bin('281d9026-f555-41bd-bb0b-1d9157e71024'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA002', uuid_to_bin('281d9026-f555-41bd-bb0b-1d9157e71024'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA003', uuid_to_bin('281d9026-f555-41bd-bb0b-1d9157e71024'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA004', uuid_to_bin('561ea7c1-e635-4a3c-ab4a-74b601a46393'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA005', uuid_to_bin('561ea7c1-e635-4a3c-ab4a-74b601a46393'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA006', uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA006', uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA006', uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA006', uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'));

insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin(uuid()), 'ethernet', 1, 'GBPS');
insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin(uuid()), 'ethernet', 10, 'MBPS');
insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin(uuid()), 'ethernet', 100, 'MBPS');
insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin(uuid()), 'ftp', 1, 'GBPS');
insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin(uuid()), 'ftp', 10, 'GBPS');

