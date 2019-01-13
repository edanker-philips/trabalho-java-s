DROP TABLE CITY;

CREATE TABLE CITY(
     id                INT AUTO_INCREMENT PRIMARY KEY
    ,uf                VARCHAR(2)
    ,name              VARCHAR(255)
    ,capital           VARCHAR(15)
    ,lon               NUMERIC(14,10)
    ,lat               NUMERIC(14,10)
    ,no_accents        VARCHAR(255)
    ,alternative_names VARCHAR(255)
    ,microregion       VARCHAR(255)
    ,mesoregion        VARCHAR(255)
  );

