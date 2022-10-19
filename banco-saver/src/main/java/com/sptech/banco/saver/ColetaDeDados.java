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

    public void insercaoDados(Object idComputador, Object idRack) {
            con.update("insert into historicoDados(fkComputador, fkRack, usoRAM, usoCPU, dataHora) values (?,?,?,?, current_timestamp);",
                    idComputador, idRack, memoria.getEmUso(), processador.getUso());
    }
}
