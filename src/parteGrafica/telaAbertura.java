package parteGrafica;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import geral.Banco;
import geral.Medico;
import geral.Paciente;
import geral.Protocolo;
import static geral.Rede.banco;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import jdialogs.dialogInfoPaciente;

/**
 *
 * @author Jorge Gomes
 */

public class telaAbertura extends javax.swing.JFrame {
    
    Socket s;
    DataInputStream in;
    DataOutputStream out;
    Medico medico;
    Paciente paciente;

    private static final String nomeBanco = "dados.ser";

    public telaAbertura() throws IOException {
        initComponents();
        boxUsuario.removeAllItems();
        boxUsuario.addItem("Médico");
        boxUsuario.addItem("Paciente");
        
        s = new Socket("localhost",4444);
        in = new DataInputStream(s.getInputStream());
        out = new DataOutputStream(s.getOutputStream());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnMedico = new javax.swing.JRadioButton();
        btnPaciente = new javax.swing.JRadioButton();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        boxUsuario = new javax.swing.JComboBox<>();
        menu = new javax.swing.JMenuBar();
        menuInfo = new javax.swing.JMenu();
        menuContato = new javax.swing.JMenu();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnMedico.setText("Medico");

        btnPaciente.setText("Paciente");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setLocationByPlatform(true);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jButton2.setText("entrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        boxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        menuInfo.setText("Info");
        menu.add(menuInfo);

        menuContato.setText("Contato");
        menu.add(menuContato);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(boxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 175, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
//se ainda não existir um arquivo banco.ser, aqui ele cria um
    if(banco == null)
        banco = new Banco();

//pega a string selecionada jcombobox    
    String teste = (String)boxUsuario.getSelectedItem();
    
//se a String selecionada for um Paciente, ele cria um objeto dele e pega a senha e usuario e adiciona no banco 
       if(teste.equals("Paciente")){
           
            Paciente paciente = new Paciente(txtUsuario.getText(),Integer.parseInt(txtSenha.getText()));
            banco.adicionarPaciente(paciente);
            dialogInfoPaciente info = new dialogInfoPaciente(paciente);
            info.setVisible(true);
            banco.serializar();
}

//se a String selecionada for um Médico, ele cria um objeto dele e pega a senha e usuario e adiciona no banco       
       if(teste.equals("Médico")){
           
           Medico medico = new Medico(txtUsuario.getText(), Integer.parseInt(txtSenha.getText()));
           banco.adicionarMedico(medico);
           banco.serializar();
       }
       
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
  String teste = (String)boxUsuario.getSelectedItem();

if(teste.equals("Médico")){       
         try {
            out.writeInt(102);
            out.writeUTF(txtUsuario.getText());
            out.writeUTF(txtSenha.getText());
       
            if(in.readBoolean()){
                int tam = in.readInt();
                byte[] bytes = new byte[tam];
                in.read(bytes);
                medico = (Medico) Protocolo.converterByteArrayParaObjeto(bytes);
             
                MedGraf med = new MedGraf(medico, in,out);
                med.setVisible(true);   
            } else {
                JOptionPane.showMessageDialog(this, "Senha/Usuario incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        }catch (Exception e){
             System.out.println(e.getMessage());
             JOptionPane.showMessageDialog(this, "Falha no servidor.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
}else{
         try {
            out.writeInt(101);
            out.writeUTF(txtUsuario.getText());
            out.writeUTF(txtSenha.getText());
       
            if(in.readBoolean()){
                int tam = in.readInt();
                byte[] bytes = new byte[tam];
                in.read(bytes);
                paciente = (Paciente) Protocolo.converterByteArrayParaObjeto(bytes);
             
                PacienteGraf pac = new PacienteGraf(paciente, in, out);
                pac.setVisible(true);   
            } else {
                JOptionPane.showMessageDialog(this, "Senha/Usuario incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        }catch (Exception e){
             System.out.println(e.getMessage());
             JOptionPane.showMessageDialog(this, "Falha no servidor.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

}       
            
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaAbertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAbertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAbertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAbertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new telaAbertura().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(telaAbertura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxUsuario;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JRadioButton btnMedico;
    private javax.swing.JRadioButton btnPaciente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuContato;
    private javax.swing.JMenu menuInfo;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
