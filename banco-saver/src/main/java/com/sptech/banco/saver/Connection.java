package com.sptech.banco.saver;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Connection {

    private JdbcTemplate connection;

    public Connection() {
        BasicDataSource datasource = new BasicDataSource();
        
        //datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //
        //datasource.setUrl("jdbc:sqlserver://saverm.database.windows.net/saver");
        //
        //datasource.setUsername("saver");
        //
        //datasource.setPassword("S4v3rM0n");

        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        datasource.setUrl("jdbc:mysql://127.0.0.1:3306/saver?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        datasource.setUsername("root");

        datasource.setPassword("80447341");
        
        connection = new JdbcTemplate(datasource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
    
}
