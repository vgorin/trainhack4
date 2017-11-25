-- unique different routes affected by the incident
SELECT DISTINCT d.`Start Stanox`, s1.`NR ROUTE`, d.`End Stanox`, s2.`NR ROUTE` FROM delays d
LEFT JOIN stanox_codes s1 on d.`Start Stanox`=s1.`STANOX NO.`
LEFT JOIN stanox_codes s2 on d.`End Stanox` = s2.`STANOX NO.`
WHERE s1.`NR ROUTE` <> s2.`NR ROUTE`;

-- top 50 incidents:
SELECT `Incident Number`, `Incident Start Datetime`, `Incident End Datetime`, count(`Incident Number`)
FROM delays GROUP BY `Incident Number`, `Incident Start Datetime`, `Incident End Datetime`
ORDER BY count(`Incident Number`) DESC LIMIT 50;
