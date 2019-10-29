CREATE TABLE expense_by_year_month_quota_doc (
     congressman_id int
   , year int
   , month int
   , quota int
   , document_id bigint
   , date date
   , allotment int
   , description varchar
   , document_value varchar
   , gloss_value varchar
   , net_value varchar
   , PRIMARY KEY ((congressman_id, year, month), quota, document_id)
)
