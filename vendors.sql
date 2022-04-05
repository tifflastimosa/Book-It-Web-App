DROP TABLE IF EXISTS db_design_final_project_database.vendors;
CREATE TABLE db_design_final_project_database.vendors (
vendorID INT NOT NULL AUTO_INCREMENT,
vendorName VARCHAR(45) NOT NULL,
vendorDescription VARCHAR(100) NULL,
contactNumber INT NOT NULL,
contactEmail VARCHAR(45) NOT NULL,
website VARCHAR(45) NOT NULL,
socialMediaLink VARCHAR(45) NOT NULL,
PRIMARY KEY(vendorID)
);
