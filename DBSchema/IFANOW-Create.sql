use  ifanow;


CREATE TABLE email_pool (
	id 					INT(11) 		NOT NULL 	AUTO_INCREMENT,
	ag_id 				VARCHAR(20) 	NOT NULL,
	email_from 			VARCHAR(100) 	NOT NULL,
	email_to 			VARCHAR(500) 	NOT NULL,
	email_cc 			VARCHAR(500),
	email_bcc 			VARCHAR(500),
	subject 			VARCHAR(100) 	NOT NULL,
	template_name 		VARCHAR(100) 	NOT NULL,
	attachment_location VARCHAR(200),
	contents 			VARCHAR(500) 	NOT NULL,
	send_flag 			VARCHAR(1) 		NOT NULL,
	processing_msg 		VARCHAR(2000),
	creation_date 		DATETIME 		NOT NULL 	DEFAULT CURRENT_TIMESTAMP,
	created_by 			VARCHAR(20) 	NOT NULL,
	modification_date 	DATETIME  ,
	modified_by 		VARCHAR(20)  ,
		CONSTRAINT pk_email_pool PRIMARY KEY (id)
);


CREATE TABLE email_configuration (
	id 					INT(11) 		NOT NULL 	AUTO_INCREMENT,
	ag_id 				VARCHAR(20) 	NOT NULL,
	host 				VARCHAR(50) 	NOT NULL,
	smtp 				VARCHAR(50) 	NOT NULL,
	port 				VARCHAR(10) 	NOT NULL,
	protocol 			VARCHAR(50) 	NOT NULL,
	auth 				VARCHAR(10),
	starttls 			VARCHAR(10) 	NOT NULL,
	debug 				VARCHAR(10) 	NOT NULL,
	username 			VARCHAR(100) 	NOT NULL,
	password 			VARCHAR(100) 	NOT NULL,
	creation_date 		DATETIME 		NOT NULL 	DEFAULT CURRENT_TIMESTAMP,
	created_by 			VARCHAR(20) 	NOT NULL,
	modification_date 	DATETIME,
	modified_by 		VARCHAR(20),
		CONSTRAINT pk_email_configuration PRIMARY KEY (id)
	
);


CREATE TABLE email_template 
(
	id 					INT(11) 		NOT NULL 	AUTO_INCREMENT,
	ag_id 				VARCHAR(20) 	NOT NULL,
	name 				VARCHAR(50) 	NOT NULL,
	template 			VARCHAR(2000) 	NOT NULL,
	creation_date 		DATETIME 		NOT NULL 	DEFAULT CURRENT_TIMESTAMP,
	created_by 			VARCHAR(20) 	NOT NULL,
	modification_date 	DATETIME ,
	modified_by 		VARCHAR(20),
		CONSTRAINT pk_email_template PRIMARY KEY (id)
);


CREATE TABLE user_event_info(
id 					INT(11) 		NOT NULL 	AUTO_INCREMENT,
userid 				INT(11) 		NOT NULL,
noun				VARCHAR(50) 	NOT NULL,
ts					INT(11) 		NOT NULL,
latlong				INT(11) 		NOT NULL,
verb				VARCHAR(50) 	NOT NULL,
timespent			INT(11) 		NOT NULL,
amount             	INT(11) 		NOT NULL,
CONSTRAINT pk_user_event_info PRIMARY KEY (id)

);
