CREATE TABLE congressman_status (
     congressman_id int
   , legislature_id varchar
   , date varchar
   , status varchar
   , party varchar
   , PRIMARY KEY (congressman_id, legislature_id)
);
