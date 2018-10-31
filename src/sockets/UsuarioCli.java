/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author jorge
 */
public class UsuarioCli {
    public static void main(String[] args) throws IOException{
        String fromUser;
        
        //cria um socket para conectar o cliente na porta 4444
        //que é a do servidor criado
        Socket s = new Socket("localhost", 4444);
        
        //cria o buffer de receber as mensagens
        DataInputStream input = new DataInputStream(s.getInputStream());
        
        //cria o buffer de enviar as mensagens
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        
        //salva o que é digitado no teclado em stdIn
        //o InputStreamReader serve para consertar o problema com os caracteres do java
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); 
        
        while (true) {            
            //passa as mensagens que estao sendo digitadas no teclado
            //para a string fromUser
            fromUser = stdIn.readLine();
            
            //salva no buffer de output
            output.writeUTF(fromUser);
            
            //imprime no terminal o que foi recebido
            System.out.println(input.readUTF());
            
            //se o que o usuário digitar for Bye ele saia desse while
            if (fromUser.equals("Bye")) {
                break;
            }

        }
            //quando o usuario insere Bye td o fechado tanto os reads como o socket que escuta
            input.close();
            output.close();
            stdIn.close();
            s.close();
    }
}
