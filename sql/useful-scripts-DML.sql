-- unique different routes affected by the incident
SELECT DISTINCT d.`Start Stanox`, s1.`NR ROUTE`, d.`End Stanox`, s2.`NR ROUTE` FROM delays d
LEFT JOIN stanox_codes s1 on d.`Start Stanox`=s1.`STANOX NO.`
LEFT JOIN stanox_codes s2 on d.`End Stanox` = s2.`STANOX NO.`
WHERE s1.`NR ROUTE` <> s2.`NR ROUTE`;

-- top 50 incidents:
SELECT `Incident Number`, `Incident Start Datetime`, `Incident End Datetime`, count(`Incident Number`)
FROM delays GROUP BY `Incident Number`, `Incident Start Datetime`, `Incident End Datetime`
ORDER BY count(`Incident Number`) DESC LIMIT 50;

-- generic script describing the column we're probably interested in
SELECT
  `Incident Number`,
  `TSC - Affected`,
  `English Day Type`,
  `Incident Start Datetime`,
  `Incident End Datetime`,
  `Event Datetime`,
  `Incident Category`,
  `Incident Category Super Group Code`,
  `Incident Category Description`,
  `Section Code`,
  `Start Stanox`,
  g1.Latitude AS 'Start Latitude',
  g1.Longitude AS 'Start Longitude',
  `End Stanox`,
  g2.Latitude AS 'End Latitude',
  g2.Longitude AS 'End Longitude',
  `PfPI Minutes`
FROM delays d
LEFT JOIN incident_reason i ON d.`Incident Reason` = i.`Incident Reason`
LEFT JOIN stanox_geocoding g1 ON g1.Stanox = d.`Start Stanox`
LEFT JOIN stanox_geocoding g2 ON g2.Stanox = d.`End Stanox`
WHERE `Incident Number` IN (
  SELECT
    `Incident Number`
  FROM delays d LEFT JOIN incident_reason i ON d.`Incident Reason` = i.`Incident Reason`
  WHERE
    `Performance Event Code` NOT IN('C', 'O', 'P', 'S')
    AND `Incident Category Super Group Code` IN ('NTAG', 'TAG', 'WSG', 'AG')
    AND (`Section Code` LIKE '19215%' OR `Section Code` LIKE '%19215')
    AND `Incident Start Datetime` = `Event Datetime`
) AND `Incident Start Datetime` < `Event Datetime`;

-- incidents caused by 12 incidents originated in section 19215
SELECT
  DISTINCT `Start Stanox` AS Affected_Stanox,
  Latitude,
  Longitude,
  count(`Start Stanox`) AS Number_of_Effects,
  avg(`PfPI Minutes`) AS Delay_Avg
FROM delays d LEFT JOIN incident_reason i ON d.`Incident Reason` = i.`Incident Reason`
LEFT JOIN stanox_geocoding g ON g.Stanox = d.`Start Stanox`
WHERE `Incident Number` IN (
  SELECT
    `Incident Number`
  FROM delays d LEFT JOIN incident_reason i ON d.`Incident Reason` = i.`Incident Reason`
  WHERE
    `Performance Event Code` NOT IN('C', 'O', 'P', 'S')
    AND `Incident Category Super Group Code` IN ('NTAG', 'TAG', 'WSG', 'AG')
    AND (`Section Code` LIKE '19215%' OR `Section Code` LIKE '%19215')
    AND `Incident Start Datetime` = `Event Datetime`
) AND `Incident Start Datetime` < `Event Datetime`
GROUP BY `Start Stanox`, Latitude, Longitude;
