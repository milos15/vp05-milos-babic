use dbad;

-- insert users
-- password is 12345 (bcrypt encoded) 
insert into security_user (id, username, password, first_name, last_name) values 
	(1, 'admin', '$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi', 'Admin', 'Admin');
-- password is abcdef (bcrypt encoded)
insert into security_user (id, username, password, first_name, last_name) values 
	(2, 'petar', '$2a$04$Yr3QD6lbcemnrRNLbUMLBez2oEK15pdacIgfkvymQ9oMhqsEE56EK', 'Petar', 'Petrovic');

-- insert authorities
insert into security_authority (id, name) values (1, 'ROLE_ADMIN'); -- super user
insert into security_authority (id, name) values (2, 'ROLE_USER'); -- normal user

-- insert mappings between users and authorities
insert into security_user_authority (id, user_id, authority_id) values (1, 1, 1); -- admin has ROLE_ADMIN
insert into security_user_authority (id, user_id, authority_id) values (2, 1, 2); -- admin has ROLE_USER too
insert into security_user_authority (id, user_id, authority_id) values (3, 2, 2); -- petar has ROLE_USER

INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('1', 'lorem ipsum', 'A plush toy that is sure', 'Novi Sad', 'Beanie Baby', '1000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('2', 'lorem ipsum', 'Just like the one used', 'Novi Sad', 'Garfild phone', '2000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('3', 'lorem ipsum', 'A bit mouldy', 'Novi Sad', 'Old bit colin', '15000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('4', 'lorem ipsum', 'A plush toy that is sure', 'Novi Sad', 'Beanie Baby', '1000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('5', 'lorem ipsum', 'Just like the one used', 'Novi Sad', 'Garfild phone', '2000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('6', 'lorem ipsum', 'A bit mouldy', 'Novi Sad', 'Old bit colin', '15000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('7', 'lorem ipsum', 'A plush toy that is sure', 'Novi Sad', 'Beanie Baby', '1000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('8', 'lorem ipsum', 'Just like the one used', 'Novi Sad', 'Garfild phone', '2000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('9', 'lorem ipsum', 'A bit mouldy', 'Novi Sad', 'Old bit colin', '15000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('10', 'lorem ipsum', 'A plush toy that is sure', 'Novi Sad', 'Beanie Baby', '1000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('11', 'lorem ipsum', 'Just like the one used', 'Novi Sad', 'Garfild phone', '2000');
INSERT INTO `dbad`.`ad` (`id`, `content`, `description`, `location`, `name`, `price`) VALUES ('12', 'lorem ipsum', 'A bit mouldy', 'Novi Sad', 'Old bit colin', '15000');

