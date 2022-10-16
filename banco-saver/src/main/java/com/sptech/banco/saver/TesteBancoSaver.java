package com.sptech.banco.saver;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class TesteBancoSaver {
    public static void main(String[] args) {

        Connection connection = new Connection();
        JdbcTemplate con = connection.getConnection();

        // Para buscar informações devemos utilizar o comando queryForList ou query,
        // exemplo de uso do queryForList:
        List usuarioSimpleUse = con.queryForList("SELECT * FROM usuario;");

        // Exibindo o resultado
        System.out.println("EXIBINDO DA MANEIRA MAIS SIMPLES:");
        System.out.println(usuarioSimpleUse);
}
}