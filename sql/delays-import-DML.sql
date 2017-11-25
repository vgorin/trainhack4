load data local infile 'Delay-Incident-v1_2-1718-P1.csv' into table delays
fields terminated by ','
enclosed by '"'
lines terminated by '\r\n';
/*
(
    `Financial Year & Period`,
    Date,
    `Train ID - Affected`,
    `Planned Origin Location Code - Affected`,
    `Planned Origin GBTT Datetime - Affected`,
    `Planned Origin WTT Datetime - Affected`,
    `Planned Dest Location Code - Affected`,
    `Planned Dest GBTT Datetime - Affected`,
    `Planned Dest WTT Datetime - Affected`,
    `TSC - Affected`,
    `Service Group Code - Affected`,
    `Operator - Affected`,
    `English Day Type`,
    `Applicable Timetable Flag - Affected`,
    `Train Schedule Type - Affected`,
    `Traction Type - Affected`,
    `Trailing Load - Affected`,
    `Timing Load - Affected`,
    `Unit Class - Affected`,
    `Incident Number`,
    `Incident Create Date`,
    `Incident Start Datetime`,
    `Incident End Datetime`,
    `Section Code`,
    `Network Rail Location Manager`,
    `Responsible Manager`,
    `Incident Reason`,
    `Attribution Status`,
    `Incident Equipment`,
    `Incident Description`,
    `Reactionary Reason Code`,
    `Incident Responsible Train`,
    `Performance Event Code`,
    `Start Stanox`,
    `End Stanox`,
    `Event Datetime`,
    `PfPI Minutes`,
    `Train ID - Resp`,
    `Train ID - React`
);
*/
