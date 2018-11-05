/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parteGrafica;

import geral.ConverterObjetos;
import geral.Medico;
import geral.Paciente;
import geral.Prontuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class MedGraf extends javax.swing.JFrame {

    /**
     * Creates new form MedGraf
     */
    Medico medico;
    Socket s;
    Paciente teste;
    DataInputStream in;
    DataOutputStream out;
//    ConverterObjetos converter = new ConverterObjetos();
    public MedGraf(Medico medico, DataInputStream in, DataOutputStream out) {
        initComponents();
        this.medico = medico;
        Prontuario prontuario = new Prontuario("ruim", 123);
        teste = new Paciente("teste", 19);
        teste.setProntuario(prontuario);
        teste.setNome("Jorge");
        ProntuarioPanel graf = new ProntuarioPanel(teste);
        Prontuario prontuario2 = new Prontuario("ruim", 123);
        Paciente teste2 = new Paciente("teste", 19);
        teste.setProntuario(prontuario2);
        ProntuarioPanel graf2 = new ProntuarioPanel(teste2);
        pnlProntuario.add(graf);
        pnlProntuario.add(graf2);
        pnlProntuario.repaint();
        pnlProntuario.revalidate();
        this.in = in;
        this.out = out;
        this.s = s;
    }
    
    public void atualizarTela(){
        for (Paciente x : medico.getPacientes()) {
            if(x != null){
                ProntuarioGraf graf = new ProntuarioGraf(x);
                pnlProntuario.add(graf);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlProntuario = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pnlProntuario.setLayout(new javax.swing.BoxLayout(pnlProntuario, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnlProntuario);

        jButton2.setText("Enviar mudanças");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton1))
                            .addComponent(jButton2))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(74, 74, 74))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(239, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for(Prontuario x : medico.getProntuarios()){
            if(Integer.parseInt(txtBusca.getText()) == x.getId()){
                
            }
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        System.out.println(teste.getNome());
        try {
//            in = new DataInputStream(s.getInputStream());
//            out  = new DataOutputStream(s.getOutputStream());
            byte[] bytes = ConverterObjetos.converterObjetoParaByte(teste);
//            out.write(0);
            out.writeInt(bytes.length);
            System.out.println(bytes.length+"");
            out.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            Logger.getLogger(MedGraf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Paciente paciente = geral.Rede.banco.buscarPaciente("Jorge");
        PacienteGraf pacientegraf = new PacienteGraf(paciente, s);
        pacientegraf.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlProntuario;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
