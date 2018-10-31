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

/**
 *
 * @author jorge
 */
public class ServidorNasf  {
    
public static void main(String[] args) throws IOException {
     Executor exec = Executors.newCachedThreadPool();
     ServerSocket s = new ServerSocket(4444); 
     
    while(true){            

        Socket ns = s.accept();

//        exec.execute();
}
    }
     
 
        
}
