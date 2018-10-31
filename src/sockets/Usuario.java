package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import parteGrafica.PacienteGraf;

/**
 *
 * @author jorge
 */
public class Usuario implements Runnable{
    Socket s;
    PacienteGraf frame;
    public Usuario(PacienteGraf frame){
        this.frame = frame;
    }

    @Override
    public void run() {
        
         try {
            //cria o buffer de entrada de mensagens
            DataInputStream input = new DataInputStream(s.getInputStream());
            
            //cria o buffer de saida de mensagens
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            
            while (true) {                
                //passa pro fromClient o que ta no buffer de mensagens recebidas
                String fromClient = input.readUTF();
                frame.NomePaciente(fromClient);
                //salva no buffer de mensagens enviadas o retorno do metodo processLine
                //junto com o comando que foi passado nas mensagens recebidas
                //Resposta do comando: + a string comando
                output.writeUTF(fromClient + "Porem passou pelo server");
                
                //se o que o cliente digitou foi Bye ele sai do loop while
                if (fromClient.equals("Bye")) {
                    break;
                }
   
            }

            //quando o cliente digita Bye fecha td
            input.close();
            output.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
       frame.setVisible(true);
    }
}
