CREATE TABLE atividade (
  id_atividade INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  usuario_id_usuario INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(100) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  prioridade INTEGER UNSIGNED NOT NULL,
  categoria VARCHAR(50) NULL,
  PRIMARY KEY(id_atividade),
  INDEX atividade_FKIndex1(usuario_id_usuario)
);

CREATE TABLE atividade_dia (
  dia_id_dia INTEGER UNSIGNED NOT NULL,
  atividade_id_atividade INTEGER UNSIGNED NOT NULL,
  id_atividade_dia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tempo_investido TIME NOT NULL,
  data_inicio DATETIME NOT NULL,
  data_fim DATETIME NOT NULL,
  PRIMARY KEY(dia_id_dia, atividade_id_atividade, id_atividade_dia),
  INDEX dia_has_atividade_FKIndex1(dia_id_dia),
  INDEX dia_has_atividade_FKIndex2(atividade_id_atividade)
);

CREATE TABLE dia (
  id_dia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  data_2 DATETIME NOT NULL,
  total_horas_dia TIME NOT NULL DEFAULT 24,
  PRIMARY KEY(id_dia)
);

CREATE TABLE usuario (
  id_usuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(4) NOT NULL,
  profissao VARCHAR(100) NOT NULL,
  PRIMARY KEY(id_usuario)
);


