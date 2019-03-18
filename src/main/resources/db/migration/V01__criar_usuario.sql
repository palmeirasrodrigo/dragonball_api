CREATE TABLE usuario(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
	senha VARCHAR(50) NOT NULL,
	pontos BIGINT(20) 
	
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO usuario (nome, email, senha, pontos) values ('Rodrigo Negrão', 'palmeirasrodrigo@hotmail.com', 'valdivea10', 10);