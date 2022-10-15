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

import java.util.List;

public class ColetaDeDados {

    public static void main(String[] args) {
        Looca looca = new Looca();


        Sistema sistema = looca.getSistema();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();
        Temperatura temperatura = looca.getTemperatura();
        //Criação do gerenciador
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        //Obtendo lista de discos a partir do getter
        List<Disco> discos = grupoDeDiscos.getDiscos();
        ServicoGrupo grupoDeServicos = looca.getGrupoDeServicos();
        ProcessoGrupo todosProcessos = looca.getGrupoDeProcessos();

        System.out.println(sistema);
        System.out.println(memoria);
        System.out.println(processador);
        System.out.println(temperatura);
        System.out.println(discos);
        System.out.println(grupoDeServicos);
        System.out.println(todosProcessos);
    }
}
