load data local infile 'Delay-Incident-v1_2-1718-P1.csv' into table delays
fields terminated by ','
enclosed by '"'
lines terminated by '\r\n';
