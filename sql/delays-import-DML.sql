TRUNCATE TABLE delays;
LOAD DATA LOCAL INFILE 'Delay-Incident-v1_2-1718-P1.csv'
INTO TABLE delays
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;
