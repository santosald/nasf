/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

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
        Paciente teste = new Paciente("teste",19);
        PacienteGraf paciente = new PacienteGraf(teste);
        paciente.setVisible(true);
    }
    
}
