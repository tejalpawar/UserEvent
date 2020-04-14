
INSERT INTO email_template (ag_id, name, template, creation_date, created_by) VALUES ('ifanow', 'REGISTRATION', '/emailtemplate/firstTranaction.vm', NOW(), 'admin');
INSERT INTO email_configuration (ag_id, host, smtp, port, protocol, auth, starttls, debug, username, password, creation_date, created_by, modification_date, modified_by) VALUES ('ifanow', 'smtp.gmail.com', '', '587', '', NULL, 'true', 'true', 'test@gmail.com', 'j>A&37K=', NOW(), 'admin', NULL, NULL);

