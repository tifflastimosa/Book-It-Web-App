DROP TABLE IF EXISTS db_design_final_project_database.frequencies;
CREATE TABLE db_design_final_project_database.frequencies (
	Frequency ENUM('ONE_TIME', 'WEEKLY', 'MONTHLY', 'QUARTERLY', 'ANNUALLY') NOT NULL DEFAULT 'ONE_TIME');
    
INSERT INTO db_design_final_project_database.frequencies(Frequency) VALUES ('ONE_TIME');
INSERT INTO db_design_final_project_database.frequencies(Frequency) VALUES ('WEEKLY');
INSERT INTO db_design_final_project_database.frequencies(Frequency) VALUES ('MONTHLY');
INSERT INTO db_design_final_project_database.frequencies(Frequency) VALUES ('QUARTERLY');
INSERT INTO db_design_final_project_database.frequencies(Frequency) VALUES ('ANNUALLY');

##SELECT * FROM db_design_final_project_database.frequencies