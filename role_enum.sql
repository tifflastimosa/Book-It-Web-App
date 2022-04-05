DROP TABLE IF EXISTS db_design_final_project_database.roles;
CREATE TABLE db_design_final_project_database.roles (
	role VARCHAR(10) NOT NULL,
    PRIMARY KEY(role),
	Role ENUM('MANAGER', 'ORGANIZER', 'ASSOCIATE') NOT NULL DEFAULT 'ASSOCIATE');
    
INSERT INTO db_design_final_project_database.roles(Role) VALUES ('MANAGER');
INSERT INTO db_design_final_project_database.roles(Role) VALUES ('ORGANIZER');
INSERT INTO db_design_final_project_database.roles(Role) VALUES ('ASSOCIATE');

SELECT * FROM db_design_final_project_database.roles