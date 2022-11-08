package com.sptech.banco.saver;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ColetaDeDados {
        private Connection connection = new Connection();
        private JdbcTemplate con = connection.getConnection();
        private Looca looca = new Looca();

        private Sistema sistema = looca.getSistema();
        private Memoria memoria = looca.getMemoria();
        private Processador processador = looca.getProcessador();
        private Temperatura temperatura = looca.getTemperatura();
        //Criação do gerenciador
        private DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        //Obtendo lista de discos a partir do getter
        private List<Disco> discos = grupoDeDiscos.getDiscos();
        private ServicoGrupo grupoDeServicos = looca.getGrupoDeServicos();
        private ProcessoGrupo todosProcessos = looca.getGrupoDeProcessos();

        private swingSaver saver = new swingSaver();

        private Usuario user = saver.getUser();
        private List idComputador= con.queryForList("SELECT idComputador FROM computador " +
                "inner join rack on rack.idRack = computador.fkRack " +
                "inner join empresa on empresa.idEmpresa = rack.fkEmpresa " +
                "inner join usuario on empresa.idEmpresa = usuario.fkEmpresa " +
                "where usuario.email = ? and computador.processador = ?", user.getEmail(), processador.getNome());

        private List idRack = con.queryForList("SELECT idRack from rack " +
                "inner join acesso on acesso.fkRack = rack.idRack " +
                "inner join usuario on acesso.fkUsuario = usuario.idUsuario " +
                "where usuario.email = ?", user.getEmail());

        public List getIdComputador() {
                return idComputador;
        }

        public List getIdRack() {
                return idRack;
        }

        public void validaPC(Usuario user){
                if(idRack.isEmpty()){
                        con.update("insert into rack(nome, fkEmpresa) values (?, ?)", "rack1", user.getIdEmpresa());
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
