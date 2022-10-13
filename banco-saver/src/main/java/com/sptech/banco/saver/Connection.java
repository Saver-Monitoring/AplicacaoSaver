package com.sptech.banco.saver;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Connection {

    private JdbcTemplate connection;

    public Connection() {
        BasicDataSource datasource = new BasicDataSource();
        
        datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        datasource.setUrl("jdbc:sqlserver://saverm.database.windows.net/saver");
        
        datasource.setUsername("saver");
        
        datasource.setPassword("S4v3rM0n");
        
        connection = new JdbcTemplate(datasource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
    
}
