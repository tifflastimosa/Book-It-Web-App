DROP TABLE IF EXISTS db_design_final_project_database.stands;
CREATE TABLE db_design_final_project_database.stands (
standID INT NOT NULL,
marketSessionID INT NOT NULL AUTO_INCREMENT,
tableName VARCHAR(45) NOT NULL,
tableNotes VARCHAR(100) NULL,
booked BOOLEAN,
vendorID INT NOT NULL AUTO_INCREMENT,
price FLOAT NOT NULL,
lastUpdated DATETIME NULL
			DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(standID),
INDEX stands_to_marketSession_idx (marketSessionID ASC),
CONSTRAINT strands_to_marketSession
	FOREIGN KEY(marketSessionID)
    REFERENCES db_design_final_project_database.marketSessions(marketSessionID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
