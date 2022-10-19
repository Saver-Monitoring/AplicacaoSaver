package com.sptech.banco.saver;

import java.util.List;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import org.springframework.jdbc.core.JdbcTemplate;

public class TesteBancoSaver {

    public static void main(String[] args) {

        Connection connection = new Connection();
        JdbcTemplate con = connection.getConnection();
        Looca looca = new Looca();

        Processador processador = looca.getProcessador();
        Memoria memoria = looca.getMemoria();

        // Para buscar informações devemos utilizar o comando queryForList ou query,
        // exemplo de uso do queryForList:
        //List usuarioSimpleUse = con.queryForList("SELECT * FROM usuario;");
//
        // Exibindo o resultado
       //System.out.println("EXIBINDO DA MANEIRA MAIS SIMPLES:");
       //System.out.println(usuarioSimpleUse);

        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Disco> discos = grupoDeDiscos.getDiscos();

        System.out.println(memoria.getTotal());
        System.out.println(String.format("%s GB", discos.get(0).getTamanho()));


    }
}