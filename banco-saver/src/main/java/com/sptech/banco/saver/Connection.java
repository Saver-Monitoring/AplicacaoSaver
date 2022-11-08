package com.sptech.banco.saver;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Connection {

    private JdbcTemplate connection;

    public Connection() {
        BasicDataSource datasource = new BasicDataSource();
<<<<<<< HEAD
        
       //datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

       //datasource.setUrl("jdbc:sqlserver://saverm.database.windows.net:1433;database=saver;user=saver@saverm;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");

       //datasource.setUsername("saver");

       //datasource.setPassword("S4v3rM0n");

        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        datasource.setUrl("jdbc:mysql://localhost:3306/saver?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        datasource.setUsername("root");

        datasource.setPassword("S4v3rM0n");
=======
//
        //datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
        //datasource.setUrl("jdbc:sqlserver://saverm.database.windows.net:1433;database=saver;user=saver@saverm;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
//
        //datasource.setUsername("saver");
//
        //datasource.setPassword("S4v3rM0n");

        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        datasource.setUrl("jdbc:mysql://localhost:3306/saver?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        datasource.setUsername("root");

        datasource.setPassword("saver");
>>>>>>> a2e9e0c6095f7094e139fd4e454dcf3ff637703f
        
        connection = new JdbcTemplate(datasource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
    
}
