CREATE TABLE alternativas(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    link VARCHAR(700) NOT NULL,
    pergunta VARCHAR(300) NOT NULL,
	alternativa1 VARCHAR(300) NOT NULL,
	alternativa2 VARCHAR(300) NOT NULL,
	alternativa3 VARCHAR(300) NOT NULL,
	alternativa4 VARCHAR(300) NOT NULL,
    pontos int(5) NOT NULL,
	resposta VARCHAR(300) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    episodio BIGINT(30) NOT NULL,
    esfera int(5) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO alternativas (titulo, link, pergunta, alternativa1, alternativa2, alternativa3, alternativa4, pontos, resposta, tipo, episodio, esfera) values ('Luta do seculo', 'https://www.eliciaduarte.adv.br/videos/verdao.mp4', 'Qual o mais forte?', 'goku','vegetta', 'freeza', 'piccolo', 10, 'goku','DRAGONBALL',1, 1);
INSERT INTO alternativas (titulo, link, pergunta, alternativa1, alternativa2, alternativa3, alternativa4, pontos, resposta, tipo,episodio, esfera) values ('Goku x Vegetta', 'https://www.eliciaduarte.adv.br/videos/abertura.mp4', 'O que Goku falou para Vegetta sobre quem vi vencer o torneio do poder?', 'Ele falou que vai perder feio, que kakaroto é o mais forte do universo','vegetta', 'freeza', 'piccolo', 10, 'goku','DRAGONBALL',2,2);