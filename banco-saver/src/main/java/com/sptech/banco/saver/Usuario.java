package com.sptech.banco.saver;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Usuario {
    private String email;
    private String senha;
    private String nome;

    public Usuario() {
        email = "";
        senha = "";
        nome = "";
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    private Connection connection = new Connection();
    private JdbcTemplate con = connection.getConnection();

    public String getIdEmpresa() {
        return String.valueOf(con.queryForList("select fkEmpresa from usuario where email = ?", email)).replaceAll("fkEmpresa","").replace("{","").replace("[","").replace("]","").replace("}","").replace("=","");
    }
    public String getIdUsuario() {
        return String.valueOf(con.queryForList("select idUsuario from usuario where email = ?", email)).replaceAll("idUsuario","").replace("{","").replace("[","").replace("]","").replace("}","").replace("=","");
    }

    
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
