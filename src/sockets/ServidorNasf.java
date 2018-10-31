/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import nasf.Paciente;
import parteGrafica.PacienteGraf;

/**
 *
 * @author jorge
 */
public class ServidorNasf implements Runnable {
    

ServerSocket s; 
    @Override
    public void run() {
           //cria um pool de threads, nesse caso um com cache onde
    //possui um numero variavel de threads
     Executor exec = Executors.newCachedThreadPool();
     
     //aloca a porta 4444 para o servidor 
     
        try {
            s = new ServerSocket(4444);
        } catch (IOException ex) {
            Logger.getLogger(ServidorNasf.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    while(true){            
         try {
             //cria um socket passivo para ficar escutando se algum cliente
             //tenta se conectar no servidor
             Socket ns = s.accept();
         } catch (IOException ex) {
             Logger.getLogger(ServidorNasf.class.getName()).log(Level.SEVERE, null, ex);
         }
        //cria um novo servidor para o cliente conectado
        //e coloco no pool de threads
        Paciente paciente = new Paciente("higor", 10);
        exec.execute(new Usuario(new PacienteGraf(paciente)));
}
    }
     
}
