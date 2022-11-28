package com.sptech.banco.saver;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ColetaDeDados {
        private Connection connection = new Connection();
        private JdbcTemplate con = connection.getConnection();
        private Looca looca = new Looca();
        private Memoria memoria = looca.getMemoria();
        private Sistema sistema = looca.getSistema();
        private Processador processador = looca.getProcessador();

        private Usuario user;

        public ColetaDeDados(Usuario usuario) {
                this.user = usuario;
        }

        public List getIdComputador() {
                return con.queryForList(
                        "SELECT idComputador FROM computador " +
                                "inner join rack on rack.idRack = computador.fkRack " +
                                "inner join empresa on empresa.idEmpresa = rack.fkEmpresa " +
                                "inner join usuario on empresa.idEmpresa = usuario.fkEmpresa " +
                                "where usuario.email = ? and computador.processador = ?", user.getEmail(), processador.getNome());
        }

        public List getIdRack() {
                return con.queryForList(
                        "SELECT idRack from rack " +
                                "inner join empresa on empresa.idEmpresa = rack.fkEmpresa " +
                                "inner join usuario on usuario.fkEmpresa = usuario.idUsuario " +
                                "where usuario.email = ?", user.getEmail());
        }

        public void gerarLog() throws IOException, InterruptedException {
                System.out.println("Gerando Log");
                FileWriter arq = new FileWriter("C:\\Saver\\log.txt");
                PrintWriter gravarArq = new PrintWriter(arq);
                System.out.println("Gravando Log");
                gravarArq.print(String.format("\nteste\n"));

                System.out.println("Log gravado com sucesso");
        }

        public void isPcValido(){

                List idComputador =  con.queryForList(
                        "SELECT idComputador FROM computador " +
                                "inner join rack on rack.idRack = computador.fkRack " +
                                "inner join empresa on empresa.idEmpresa = rack.fkEmpresa " +
                                "inner join usuario on empresa.idEmpresa = usuario.fkEmpresa " +
                                "where usuario.email = ? and computador.processador = ?", user.getEmail(), processador.getNome());

                List idRack = con.queryForList(
                        "SELECT idRack from rack " +
                                "inner join acesso on acesso.fkRack = rack.idRack " +
                                "inner join empresa on empresa.idEmpresa = rack.fkEmpresa " +
                                "inner join usuario on usuario.fkEmpresa = usuario.idUsuario " +
                                "where usuario.email = ?", user.getEmail());

                if(idRack.isEmpty()){
                        con.update("insert into rack(nome, fkEmpresa) values ('rack1', ?)",  user.getIdEmpresa());

                } else {
                        if(idComputador.isEmpty()){
                                con.update("insert into computador(fkRack, sistOperacional, processador, qtdRAM) values (?, ?, ?, ?)",
                                        idRack, sistema.getSistemaOperacional(), processador.getNome(),
                                        Conversor.formatarBytes(memoria.getTotal()).replaceAll("[^0-9-,]+", "").replace(",","."));

                        } else {
                                System.out.println("Computador já cadastrado em nosso sistema.");
                        }
                }
        }
    public void insercaoDados(Object idComputador, Object idRack) {
            con.update("insert into historicoDados(fkComputador, fkRack, usoRAM, usoCPU, dataHora) values (?,?,?,?, current_timestamp);",
                    idComputador, idRack, Conversor.formatarBytes(memoria.getEmUso()).replaceAll("[^0-9-,]+", "").replace(",","."), String.format("%.2f",processador.getUso()).replace(",","."));
    }
}
