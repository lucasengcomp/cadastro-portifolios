
--=====================================================================================================================
-- PESSOA
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario)
VALUES ('Brian May', '1947-07-19', '987.654.321-00', true);

INSERT INTO pessoa (nome, datanascimento, cpf, funcionario)
VALUES ('Freddie Mercury', '1946-09-05', '123.456.789-00', true);

INSERT INTO pessoa (nome, datanascimento, cpf, funcionario)
VALUES ('John Deacon', '1951-08-19', '111.222.333-00', false);

INSERT INTO pessoa (nome, datanascimento, cpf, funcionario)
VALUES ('Roger Taylor', '1949-07-26', '555.666.777-00', false);
--=====================================================================================================================

-- PROJETO
--=====================================================================================================================
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, data_fim, descricao, status, orcamento, risco, idgerente)
VALUES ('Projeto Google Chrome', '2022-01-15', '2023-12-31', NULL, 'Desenvolvimento do Navegador Google Chrome', 5, 5000000.00, 1, 1);

INSERT INTO projeto (nome, data_inicio, data_previsao_fim, data_fim, descricao, status, orcamento, risco, idgerente)
VALUES ('Projeto Facebook Messenger', '2021-09-01', '2023-08-31', '2060-08-31', 'Desenvolvimento do Messenger do Facebook', 1, 3000000.00, 2, 2);

INSERT INTO projeto (nome, data_inicio, data_previsao_fim, data_fim, descricao, status, orcamento, risco, idgerente)
VALUES ('Projeto Microsoft Windows 11', '2020-10-01', '2022-12-31', '2022-12-15', 'Desenvolvimento do Sistema Operacional Windows 11', 7, 10000000.00, 3, 1);

INSERT INTO projeto (nome, data_inicio, data_previsao_fim, data_fim, descricao, status, orcamento, risco, idgerente)
VALUES ('Projeto Linux Kernel 5.0', '2022-03-15', '2023-03-14', NULL, 'Desenvolvimento do Kernel Linux 5.0', 3, 2000000.00, 4, 2);
--=====================================================================================================================

-- MEMBROS
--=====================================================================================================================
INSERT INTO membros (idprojeto, idpessoa)
VALUES (1, 1);

INSERT INTO membros (idprojeto, idpessoa)
VALUES (2, 1);

INSERT INTO membros (idprojeto, idpessoa)
VALUES (3, 1);

INSERT INTO membros (idprojeto, idpessoa)
VALUES (4, 2);
--=====================================================================================================================