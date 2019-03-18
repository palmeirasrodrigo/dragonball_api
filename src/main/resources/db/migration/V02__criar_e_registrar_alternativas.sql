CREATE TABLE alternativas(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50) NOT NULL,
    link VARCHAR(700) NOT NULL,
    pergunta VARCHAR(200) NOT NULL,
	alternativa1 VARCHAR(70) NOT NULL,
	alternativa2 VARCHAR(70) NOT NULL,
	alternativa3 VARCHAR(70) NOT NULL,
	alternativa4 VARCHAR(70) NOT NULL,
    pontos int(5) NOT NULL,
	resposta VARCHAR(200) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    codigo_usuario BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO alternativas (titulo, link, pergunta, alternativa1, alternativa2, alternativa3, alternativa4, pontos, resposta, tipo, codigo_usuario) values ('Luta do seculo', 'http://www.globo.com', 'qual o mais forte?', 'goku','vegetta', 'freeza', 'piccolo', 10, 'goku','DRAGONBALL',1);