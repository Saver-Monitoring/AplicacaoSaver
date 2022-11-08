package com.sptech.banco.saver;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Usuario {
    private String email;
    private String senha;
    private Connection connection = new Connection();
    private JdbcTemplate con = connection.getConnection();

    public List getIdEmpresa() {
        return con.queryForList("select fkEmpresa from usuario where email = ?", email);
    }
    public List getIdUsuario() {
        return con.queryForList("select idUsuario from usuario where email = ?", email);
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
