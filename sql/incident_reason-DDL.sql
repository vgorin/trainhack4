DROP TABLE IF EXISTS incident_reason;
CREATE TABLE incident_reason
(
    `Incident Category` INT(11),
    `Incident Reason` CHAR(2),
    `Incident Reason Name` VARCHAR(15),
    `Incident Category Description` VARCHAR(63),
    `Incident Reason Description` VARCHAR(128),
    `Incident JPIP Category` VARCHAR(31),
    `Incident Category Super Group Code` VARCHAR(4)
);
