CREATE SCHEMA timeControl;

USE timeControl;

CREATE TABLE usuario (
  id_usuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(50) NOT NULL,
  profissao VARCHAR(100) NOT NULL,
  PRIMARY KEY(id_usuario)
);

CREATE TABLE dia (
  id_dia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  data_dia DATETIME NOT NULL,
  total_horas_dia TIME NOT NULL DEFAULT 24,
  PRIMARY KEY(id_dia)
);

CREATE TABLE atividade (
  id_atividade INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  usuario_id_usuario INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(100) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  prioridade INTEGER UNSIGNED NOT NULL,
  categoria VARCHAR(50) NULL,
  PRIMARY KEY(id_atividade),
  INDEX atividade_FKIndex1(usuario_id_usuario),
  FOREIGN KEY(usuario_id_usuario)
    REFERENCES usuario(id_usuario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE tempo_investido (
  dia_id_dia INTEGER UNSIGNED NOT NULL,
  atividade_id_atividade INTEGER UNSIGNED NOT NULL,
  id_tempo_investido INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  horas_gastas TIME NOT NULL,
  data_inicio DATETIME NOT NULL,
  data_fim DATETIME NOT NULL,
  PRIMARY KEY(id_tempo_investido),
  INDEX dia_has_atividade_FKIndex1(dia_id_dia),
  INDEX dia_has_atividade_FKIndex2(atividade_id_atividade),
  FOREIGN KEY(dia_id_dia)
    REFERENCES dia(id_dia)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(atividade_id_atividade)
    REFERENCES atividade(id_atividade)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


