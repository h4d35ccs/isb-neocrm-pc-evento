create Schema DERBY;
CREATE TABLE PC_EVENTOS (
  tipopers varchar(255) NOT NULL,
  codpers integer NOT NULL,
  COD_EVENTO varchar(255) NOT NULL,
  DETALLE varchar(255) DEFAULT NULL,
  FECHA_FIN timestamp DEFAULT NULL,
  FECHA_INI timestamp DEFAULT NULL,
  idempr varchar(255) DEFAULT NULL,
  IMAGEN varchar(255) DEFAULT NULL,
  IND_MOSTRADO integer DEFAULT NULL,
  TITULO varchar(255) DEFAULT NULL,
  PRIMARY KEY (tipopers,codpers,COD_EVENTO)
);
