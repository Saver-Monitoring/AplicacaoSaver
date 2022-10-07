package com.sptech.banco.saver;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Connection {

    private JdbcTemplate connection; 
    
    // Exemplo de configuração utilizando H2
    // Obs. O código comentado é um exemplo de como se conectar ao mysql
    public Connection() {
        BasicDataSource datasource = new BasicDataSource();

//        datasource.setDriverClassName("org.h2.Driver");
//        
//        datasource.setUrl("jdbc:h2:file:./meu_banco");
//               
//        datasource.setUsername("sa");

        //datasource.setPassword("");
        
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        datasource.setUrl("jdbc:mysql://localhost:3306/saver");
        
        datasource.setUsername("aluno");
        
        datasource.setPassword("sptech");
        
        connection = new JdbcTemplate(datasource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
    
}