package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import geral.Paciente;
//import static sockets.ServidorNasf.s;
//import parteGrafica.PacienteGraf;

/**
 *
 * @author jorge
 */
public class ServidorNasfMain  {
    public static void main(String[] args) throws IOException {
//        Executor exec = Executors.newCachedThreadPool();
        ServerSocket s = new ServerSocket(4444);
        
        while (true) {            
            Socket ns = s.accept();
            DataOutputStream out = new DataOutputStream(ns.getOutputStream());
//            DataOutputStream out = new DataOutputStream(ns.getOutputStream());
//            exec.execute(new ServidorNasf(ns));
            new Thread(new ServidorNasf(ns)).start();
            
        }
    }
     
}
