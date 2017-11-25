DROP TABLE IF EXISTS incident_reason;
CREATE TABLE incident_reason
(
    `Incident Category` VARCHAR(4),
    `Incident Reason` CHAR(2),
    `Incident Reason Name` VARCHAR(15),
    `Incident Category Description` VARCHAR(63),
    `Incident Reason Description` VARCHAR(128),
    `Incident JPIP Category` VARCHAR(63),
    `Incident Category Super Group Code` VARCHAR(4)
);
