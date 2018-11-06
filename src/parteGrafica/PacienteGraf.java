package parteGrafica;

import java.net.Socket;
import geral.Paciente;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 *
 * @author aluno
 */
public class PacienteGraf extends javax.swing.JFrame{

    /**
     * Creates new form Paciente
     */
    
    Paciente paciente;

    DataInputStream in;
    DataOutputStream out;

    public PacienteGraf(Paciente paciente,DataInputStream in, DataOutputStream out ) {
        initComponents();
        this.paciente = paciente;
        
        this.in = in;
        this.out = out;
        atualizarTela();

    }
    
    
    
    public void atualizarTela(){
        lblNomePaciente.setText(this.paciente.getNome());
        lblIdadePaciente.setText(this.paciente.getSexo() + "");
        lblID.setText(paciente.getId() + "");
    }
    
    public void NomePaciente(String string){
        lblNomePaciente.setText(string);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        lblNomePaciente = new javax.swing.JLabel();
        lblIdadePaciente = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNomePaciente.setText("jLabel1");

        lblIdadePaciente.setText("jLabel2");

        lblID.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID)
                    .addComponent(lblIdadePaciente)
                    .addComponent(lblNomePaciente))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblNomePaciente)
                .addGap(18, 18, 18)
                .addComponent(lblIdadePaciente)
                .addGap(18, 18, 18)
                .addComponent(lblID)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIdadePaciente;
    private javax.swing.JLabel lblNomePaciente;
    // End of variables declaration//GEN-END:variables

}
