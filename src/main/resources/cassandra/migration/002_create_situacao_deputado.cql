CREATE TABLE SITUACAO_DEPUTADO (
     deputado_id int
   , id_legislatura varchar
   , data varchar
   , situacao varchar
   , partido varchar
   , PRIMARY KEY (deputado_id, id_legislatura)
);
