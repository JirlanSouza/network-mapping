insert into area (id, name) values (uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'), 'AREA001');
insert into area (id, name) values (uuid_to_bin('255fed83-2b8b-4b99-b62d-379e9e9cafdc'), 'AREA002');
insert into area (id, name) values (uuid_to_bin('561ea7c1-e635-4a3c-ab4a-74b601a46393'), 'AREA003');
insert into area (id, name) values (uuid_to_bin('5289c641-0173-48a3-8e24-d2564020c9d6'), 'AREA004');
insert into area (id, name) values (uuid_to_bin('4dd17de3-8dbc-4768-be1c-09c8535220dc'), 'AREA005');
insert into area (id, name) values (uuid_to_bin('281d9026-f555-41bd-bb0b-1d9157e71024'), 'AREA006');

insert into sub_area (id, name, parent_id) values (uuid_to_bin('CAC2D569-87F9-4B69-A5B5-DBC560CFFF35'), 'SUB_AREA001', uuid_to_bin('281d9026-f555-41bd-bb0b-1d9157e71024'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA002', uuid_to_bin('281d9026-f555-41bd-bb0b-1d9157e71024'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA003', uuid_to_bin('281d9026-f555-41bd-bb0b-1d9157e71024'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA004', uuid_to_bin('561ea7c1-e635-4a3c-ab4a-74b601a46393'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA005', uuid_to_bin('561ea7c1-e635-4a3c-ab4a-74b601a46393'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA006', uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA006', uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA006', uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'));
insert into sub_area (id, name, parent_id) values (uuid_to_bin(uuid()), 'SUB_AREA006', uuid_to_bin('6784f6d0-2d39-48f8-a357-7f9fae325cb9'));

insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin('4961AE40-1FB3-402D-B7BE-73F8987B176B'), 'ethernet', 1, 'GBPS');
insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin(uuid()), 'ethernet', 10, 'MBPS');
insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin(uuid()), 'ethernet', 100, 'MBPS');
insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin('B97CA5B3-E98F-4723-A9F5-C4D202F4AD0E'), 'ftp', 1, 'GBPS');
insert into network_port_type (id, name, speed, speed_unit) values (uuid_to_bin(uuid()), 'ftp', 10, 'GBPS');

insert into network_switch (id, brand, model, identification_tag, installation_local_id, layer) values (uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), 'Cisco', 'st3040', 'ST001', uuid_to_bin('CAC2D569-87F9-4B69-A5B5-DBC560CFFF35'), 'LAYER2');

insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 1, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('4961AE40-1FB3-402D-B7BE-73F8987B176B'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 2, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('4961AE40-1FB3-402D-B7BE-73F8987B176B'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 3, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('4961AE40-1FB3-402D-B7BE-73F8987B176B'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 4, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('4961AE40-1FB3-402D-B7BE-73F8987B176B'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 5, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('4961AE40-1FB3-402D-B7BE-73F8987B176B'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 6, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('4961AE40-1FB3-402D-B7BE-73F8987B176B'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 7, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('4961AE40-1FB3-402D-B7BE-73F8987B176B'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 8, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('4961AE40-1FB3-402D-B7BE-73F8987B176B'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 9, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('B97CA5B3-E98F-4723-A9F5-C4D202F4AD0E'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 10, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('B97CA5B3-E98F-4723-A9F5-C4D202F4AD0E'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 11, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('B97CA5B3-E98F-4723-A9F5-C4D202F4AD0E'), 'DISCONNECTED');
insert into network_port (id, number, parent_id, port_type, status) values (uuid_to_bin(uuid()), 12, uuid_to_bin('8C50A83F-5623-44C8-B640-6E4950CA173D'), uuid_to_bin('B97CA5B3-E98F-4723-A9F5-C4D202F4AD0E'), 'DISCONNECTED');


