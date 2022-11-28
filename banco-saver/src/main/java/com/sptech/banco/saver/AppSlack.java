package com.sptech.banco.saver;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author gabri
 */
public class AppSlack {

    public static void mandaMensagemSlack(Usuario user) throws IOException, InterruptedException{
        Looca looca = new Looca();

        Sistema sistema = looca.getSistema();
        Processador processador = looca.getProcessador();
        Memoria memoria = looca.getMemoria();

        JSONObject json = new JSONObject();
        Long alertaCritico = 12884901888L;

        if(memoria.getEmUso() > alertaCritico){
            json.put("text", String.format("Usuario: %s."
                            + "\nNa entrada a maquina apresenta uso elevado de memoria:"
                            + "\nSistema Operacional: %s"
                            + "\nProcessadro: %s"
                            + "\nTotal de Memoria da maquina: %s"
                            + "\nMemoria em uso no momento: %s"
                            + "\nUma ação é nessessaria?",
                    String.valueOf(user.getNome()).replaceAll("nomeUsuario","").replace("{","").replace("[","").replace("]","").replace("}","").replace("=",""),
                    sistema.getSistemaOperacional(), processador.getNome(), Conversor.formatarBytes(memoria.getTotal()),
                    Conversor.formatarBytes(memoria.getEmUso())));
        }else{
            json.put("text", String.format("Usuario: %s."
                            + "\nEsses são os dados da maquina no momento da entrada:"
                            + "\nSistema Operacional: %s"
                            + "\nProcessadro: %s"
                            + "\nTotal de Memoria da maquina: %s"
                            + "\nMemoria em uso no momento: %s",
                    String.valueOf(user.getNome()).replaceAll("nomeUsuario","").replace("{","").replace("[","").replace("]","").replace("}","").replace("=",""),
                    sistema.getSistemaOperacional(), processador.getNome(), Conversor.formatarBytes(memoria.getTotal()),
                    Conversor.formatarBytes(memoria.getEmUso())));
        }

        Slack.sendMessage(json);
    }
}
