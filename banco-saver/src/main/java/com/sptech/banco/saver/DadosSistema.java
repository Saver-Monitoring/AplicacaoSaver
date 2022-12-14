///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
// */
//package com.sptech.banco.saver;
//
//import com.github.britooo.looca.api.core.Looca;
//import com.github.britooo.looca.api.group.discos.Disco;
//import com.github.britooo.looca.api.group.discos.DiscoGrupo;
//import com.github.britooo.looca.api.group.memoria.Memoria;
//import com.github.britooo.looca.api.group.processador.Processador;
//import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
//import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
//import com.github.britooo.looca.api.group.sistema.Sistema;
//import com.github.britooo.looca.api.group.temperatura.Temperatura;
//import com.github.britooo.looca.api.util.Conversor;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.TimerTask;
//
///**
// *
// * @author gabri
// */
//public class DadosSistema extends javax.swing.JFrame {
//
//    Looca looca = new Looca();
//
//    Sistema sistema = looca.getSistema();
//    Memoria memoria = looca.getMemoria();
//    Processador processador = looca.getProcessador();
//    Temperatura temperatura = looca.getTemperatura();
//    //Criação do gerenciador
//    DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
//    //Obtendo lista de discos a partir do getter
//    List<Disco> discos = grupoDeDiscos.getDiscos();
//    ServicoGrupo grupoDeServicos = looca.getGrupoDeServicos();
//    ProcessoGrupo todosProcessos = looca.getGrupoDeProcessos();
//
//    /**
//     * Creates new form DadosSistema
//     */
//    public DadosSistema() {
//        initComponents();
//        this.setResizable(false);
//        this.Tela();
//    }
//    private Connection connection = new Connection();
//    private JdbcTemplate con = connection.getConnection();
//
//    private Usuario user;
//
//    public DadosSistema(Usuario user) {
//        this.user = user;
//        initComponents();
//        this.setResizable(false);
//        this.Tela();
//    }
//
//    public void Tela() {
////        ColetaDeDados coleta = new ColetaDeDados();
//        coleta.isPcValido();
//
//        List idComputador = coleta.getIdComputador();
//        List idRack = coleta.getIdRack();
//
//        new java.util.Timer().schedule(new TimerTask(){
//            @Override
//            public void run() {
//                lblSistema.setText(String.format("▶ Sistema Operacional: %s", sistema.getSistemaOperacional()));
//                lblProcessador.setText(String.format("▶ Processador: %s", processador.getNome()));
//                lblMemoria.setText(String.format("▶ Memória Total: %s", Conversor.formatarBytes(memoria.getTotal())));
//                lblMemoria1.setText(String.format("▶ Memória Em uso: %s", Conversor.formatarBytes(memoria.getEmUso())));
//                lblMemoria2.setText(String.format("▶ Memória Disponível: %s", Conversor.formatarBytes(memoria.getDisponivel())));
//                try {
//                    coleta.gerarLog();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                coleta.insercaoDados(idComputador.get(0).toString().replaceAll("[^0-9]+", " "), idRack.get(0).toString().replaceAll("[^0-9]+", " "));
//            }
//        },0,1000*2);
//    }
//
////    lblFabricanteValue.setText(String.format("▶ %s", sistema.getFabricante()));
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        lblSistema = new javax.swing.JLabel();
//        lblProcessador = new javax.swing.JLabel();
//        lblMemoria1 = new javax.swing.JLabel();
//        lblMemoria = new javax.swing.JLabel();
//        lblMemoria2 = new javax.swing.JLabel();
//        lblTemperatura = new javax.swing.JLabel();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        lblSistema.setText("--");
//
//        lblProcessador.setText("--");
//
//        lblMemoria1.setText("--");
//
//        lblMemoria.setText("--");
//
//        lblMemoria2.setText("--");
//
//        lblTemperatura.setText("--");
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addComponent(lblMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
//                                        .addComponent(lblMemoria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(lblMemoria2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(lblTemperatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(lblProcessador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(lblSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                .addContainerGap())
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(36, 36, 36)
//                                .addComponent(lblSistema)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(lblProcessador)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(lblMemoria)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(lblMemoria1)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(lblMemoria2)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(lblTemperatura)
//                                .addContainerGap(111, Short.MAX_VALUE))
//        );
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DadosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DadosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DadosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DadosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DadosSistema().setVisible(true);
//            }
//        });
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JLabel lblMemoria;
//    private javax.swing.JLabel lblMemoria1;
//    private javax.swing.JLabel lblMemoria2;
//    private javax.swing.JLabel lblProcessador;
//    private javax.swing.JLabel lblSistema;
//    private javax.swing.JLabel lblTemperatura;
//    // End of variables declaration//GEN-END:variables
//}