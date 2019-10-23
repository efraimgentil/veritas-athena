CREATE TABLE congressman_status (
     congressman_id int
   , legislature_id int
   , datetime timestamp
   , status varchar
   , political_party_acronym varchar
   , PRIMARY KEY (congressman_id, datetime)
) WITH CLUSTERING ORDER BY (datetime DESC);
