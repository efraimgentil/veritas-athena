CREATE TYPE IF NOT EXISTS type_gabinete (
 nome varchar,
 predio varchar,
 andar varchar,
 telefone varchar,
 email varchar,
 sala varchar
);

CREATE TYPE IF NOT EXISTS type_status_deputado (
     id INT,
     uri varchar,
     nome varchar,
     sigla_partido varchar,
     uri_partido varchar,
     sigla_uf varchar,
     id_legislatura INT,
     url_foto varchar,
     data varchar,
     nome_eleitoral varchar,
     gabinete frozen<type_gabinete>,
     situacao varchar,
     condicao_eleitoral varchar,
     descricao_status varchar
);

CREATE TABLE DEPUTADO (
     id int primary key
   , uri varchar
   , nome_civil varchar
   , cpf varchar,
   , sexo varchar,
   , url_website varchar,
   , data_nascimento varchar,
   , data_falecimento varchar,
   , uf_nascimento varchar,
   , municipio_nascimento varchar,
   , escolaridade varchar,
   , ultimo_status frozen<type_status_deputado>,
   , ultimos_status set<frozen<type_status_deputado>>
);
