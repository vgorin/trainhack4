load data local infile 'incident_reason.csv' into table delays
fields terminated by ','
enclosed by '"'
lines terminated by '\r';
