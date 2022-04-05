DROP TABLE IF EXISTS db_design_final_project_database.vendorStaff;
CREATE TABLE db_design_final_project_database.vendorStaff (
vendorStaffID INT NOT NULL,
vendorID INT NOT NULL AUTO_INCREMENT,
role ENUM('MANAGER', 'ORGANIZER', 'ASSOCIATE') NOT NULL DEFAULT 'ASSOCIATE',
PRIMARY KEY(vendorStaffID),
INDEX vendorStaff_to_vendors_idx (vendorID ASC),
CONSTRAINT vendorStaff_to_vendors
	FOREIGN KEY(vendorID)
    REFERENCES db_design_final_project_database.vendors(vendorStaffID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);