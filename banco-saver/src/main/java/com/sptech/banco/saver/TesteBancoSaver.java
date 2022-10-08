package com.sptech.banco.saver;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TesteBancoSaver {
    public static void main(String[] args) {

        Connection connection = new Connection();
        JdbcTemplate con = connection.getConnection();
        
        // A sintaxe utilizada no H2 é "praticamente" a mesma do MySQL.
        // Dropando a tabela caso já exista.
//        con.execute("DROP TABLE IF EXISTS pokemon");
//
//        // Um jeito de criar longos textos de maneira organizada.
//        StringBuilder createStatement = new StringBuilder();
//
//        // Criando o comando para criar tabela pokemon.
//        // o método append funciona como se fosse uma concatenação.
//        createStatement.append("CREATE TABLE pokemon (");
//        createStatement.append("id INT PRIMARY KEY AUTO_INCREMENT,");
//        createStatement.append("nome VARCHAR(255),");
//        createStatement.append("tipo VARCHAR(255)");
//        createStatement.append(")");
//
//        // Executando o comando de criação de fato.
//        con.execute(createStatement.toString());
//
//        // Texto padrão para insert
//        String insertStatement = "INSERT INTO pokemon VALUES (null, ?, ? )";
//
//        // Parametros para o primeiro insert
//        String pikachu = "pikachu";
//        String tipoPikachu = "eletricidade";
//
//        // Utilizamos o comando "update" para inserir e/ou atualizar registros.
//        // Podemos utilizar variavéis como o exemplo abaixo:
//        con.update(insertStatement, pikachu, tipoPikachu);
//
//        // Ou passar diretamente dentro do método
//        // exemplo:
//        con.update("INSERT INTO pokemon VALUES (?, ?, ?)",
//                null, "squirtle", "agua");

        // Para buscar informações devemos utilizar o comando queryForList ou query,
        // exemplo de uso do queryForList:
        List usuarioSimpleUse = con.queryForList("SELECT * FROM usuario");

        // Exibindo o resultado
        System.out.println("EXIBINDO DA MANEIRA MAIS SIMPLES:");
        System.out.println(usuarioSimpleUse);
}
}