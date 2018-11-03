/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import nasf.Paciente;
import nasf.Rede;
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
//            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            
        if(in.readUTF().equals("paciente")){
        Paciente teste = new Paciente("paciente",19);
        PacienteGraf paciente = new PacienteGraf(teste);
        paciente.setVisible(true);
        }else{
        Paciente teste = new Paciente("medico",19);
        PacienteGraf paciente = new PacienteGraf(teste);
        paciente.setVisible(true);
        }

        } catch (IOException e) {
            
        }
        

    }
    
}
