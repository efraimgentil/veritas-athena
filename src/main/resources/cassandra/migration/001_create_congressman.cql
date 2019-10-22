CREATE TYPE IF NOT EXISTS type_office (
 name varchar,
 building varchar,
 floor varchar,
 phone varchar,
 email varchar,
 room varchar
);

CREATE TYPE IF NOT EXISTS type_congressman_status (
     id INT,
     uri varchar,
     name varchar,
     political_party_acronym varchar,
     political_party_uri varchar,
     political_party_state varchar,
     legislature_id INT,
     photo_url varchar,
     date varchar,
     electoral_name varchar,
     office frozen<type_office>,
     status varchar,
     electoral_condition varchar,
     status_description varchar
);

CREATE TABLE congressman (
     id int primary key
   , uri varchar
   , civil_name varchar
   , identity_document varchar,
   , sex varchar,
   , website_url varchar,
   , date_of_birth varchar,
   , date_of_death varchar,
   , state_of_birth varchar,
   , municipality_of_birth varchar,
   , education varchar,
   , last_status frozen<type_congressman_status>,
   , last_statuses set<frozen<type_congressman_status>>
);
