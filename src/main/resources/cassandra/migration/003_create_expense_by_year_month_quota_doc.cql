CREATE TABLE expense_by_year_month_quota_doc (
     congressman_id int
   , year int
   , month int
   , quota int
   , document_id bigint
   , datetime timestamp
   , allotment int
   , description varchar
   , document_value decimal
   , gloss_value decimal
   , net_value decimal
   , PRIMARY KEY ((congressman_id, year, month), quota, document_id)
)
