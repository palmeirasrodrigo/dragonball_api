CREATE TABLE  permissao (
	codigo BIGINT(20) PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
    ) ENGINE = InnoDB DEFAULT CHARSET= utf8;
    
CREATE TABLE usuario_permissao (
codigo_usuario BIGINT(20) NOT NULL,
codigo_permissao BIGINT(20) NOT NULL,
PRIMARY KEY (codigo_usuario, codigo_permissao),
FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)	    
) ENGINE = InnoDB DEFAULT CHARSET= utf8;

INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_ALTERNATIVAS');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_REMOVER_ALTERNATIVAS');

-- ADMIN

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1,1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1,2);
