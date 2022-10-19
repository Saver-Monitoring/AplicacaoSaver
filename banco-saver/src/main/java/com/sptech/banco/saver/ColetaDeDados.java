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
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ColetaDeDados {
        private Connection connection = new Connection();
        private JdbcTemplate con = connection.getConnection();
        private Looca looca = new Looca();

        swingSaver user = new swingSaver();

        private List idComputador = con.queryForList("SELECT idComputador FROM computador " +
                        "inner join rack on rack.idRack = computador.fkRack " +
                                "inner join acesso on acesso.fkRack = rack.idRack " +
                                        "inner join usuario on acesso.fkUsuario = usuario.idUsuario " +
                                                "where usuario.email = ?", user.getEmail());
        private List idRack = con.queryForList("SELECT idRack from rack " +
                                "inner join acesso on acesso.fkRack = rack.idRack " +
                                        "inner join usuario on acesso.fkUsuario = usuario.idUsuario " +
                                                "where usuario.email = ?", user.getEmail());
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

    public void insercaoDados() {
            con.update("insert into historicoDados(fkComputador, fkRack, usoRAM, usoCPU, dataHora) values (?,?,?,?, current_timestamp);",
                    idComputador.get(0), idRack.get(0), memoria.getEmUso(), processador.getUso());
    }
}
