/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import nasf.Paciente;
//import parteGrafica.PacienteGraf;

/**
 *
 * @author jorge
 * aqui eu já to criando o pool de threads, oq precisa modificar é a classe
 * que vou passar como parâmetro no execute pra inserir no pool.
 * 
 * nessa classe que vai ser passada como parâmetro, 
 */
public class ServidorNasfMain  {
    public static void main(String[] args) throws IOException {
        Executor exec = Executors.newCachedThreadPool();
        ServerSocket s = new ServerSocket(4444);
        
        while (true) {            
            Socket ns = s.accept();
            
//            DataOutputStream out = new DataOutputStream(ns.getOutputStream());
            exec.execute(new ServidorNasf(ns));
            
        }
    }
     
}
