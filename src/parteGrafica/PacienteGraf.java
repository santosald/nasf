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
        txtNomePaciente.setText(this.paciente.getNome());
        txtIdadePaciente.setText(this.paciente.getIdade() + "");
    }
    
    public void NomePaciente(String string){
        txtNomePaciente.setText(string);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        txtNomePaciente = new javax.swing.JLabel();
        txtIdadePaciente = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNomePaciente.setText("jLabel1");

        txtIdadePaciente.setText("jLabel2");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdadePaciente)
                    .addComponent(txtNomePaciente))
                .addContainerGap(202, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtNomePaciente)
                .addGap(18, 18, 18)
                .addComponent(txtIdadePaciente)
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel txtIdadePaciente;
    private javax.swing.JLabel txtNomePaciente;
    // End of variables declaration//GEN-END:variables

}
