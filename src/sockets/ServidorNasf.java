package sockets;

import geral.Medico;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import geral.Paciente;
import geral.Rede;
import parteGrafica.MedGraf;
import parteGrafica.PacienteGraf;

/**
 *
 * @author jorge
 */
public class ServidorNasf implements Runnable{
    
    Socket s;
    
    public ServidorNasf(Socket s){
    this.s = s;
    }


    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            
        if(in.readUTF().equals("Paciente")){
        Paciente teste = new Paciente("Paciente",19);
        PacienteGraf paciente = new PacienteGraf(teste,s);
        paciente.setVisible(true);
        }else{
        Medico medico = new Medico("Médico",19);
        MedGraf med = new MedGraf(medico);
        med.setVisible(true);
        }

        } catch (IOException e) {
            
        }
        

    }
    
}
