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

    public static void mandaMensagemSlack(Usuario user) throws IOException, InterruptedException {
        Looca looca = new Looca();

        Sistema sistema = looca.getSistema();
        Processador processador = looca.getProcessador();
        Memoria memoria = looca.getMemoria();

        JSONObject json = new JSONObject();
        json.put("text", String.format("Ola %s esses são alguns dados do seu pc"
                + "\nSeu Sistema Operacional: %s"
                + "\nSeu Processador: %s"
                + "\nMemória Total: %s"
                + "\nMemória Em uso: %s"
                + "\nMemória Disponível: %s",
                String.valueOf(user.getNome()).replaceAll("nomeUsuario","").replace("{","").replace("[","").replace("]","").replace("}","").replace("=",""),
                sistema.getSistemaOperacional(), processador.getNome(), Conversor.formatarBytes(memoria.getTotal()),
                Conversor.formatarBytes(memoria.getEmUso()), Conversor.formatarBytes(memoria.getDisponivel())));
        Slack.sendMessage(json);
    }
}
