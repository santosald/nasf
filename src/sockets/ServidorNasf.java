package sockets;


import geral.Medico;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import geral.Paciente;
import geral.Protocolo;
import geral.Rede;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import parteGrafica.MedGraf;
import parteGrafica.PacienteGraf;

/**
 *
 * @author jorge
 */
import java.net.*;
import java.io.*;

public class ServidorNasf implements Runnable {

    private Socket socket;

    public ServidorNasf(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        int caso;
        String usuario,senha;
        Paciente paciente;
        Medico medico;
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            

            boolean aberto = true;

            try {
                while (aberto) {
                    
                    caso = in.readInt();
                   

                    switch (caso) {
                        //login pro paciente
                        case 1:

                            usuario = in.readUTF();
                            senha = in.readUTF();
                            
                            paciente = Protocolo.temPaciente(usuario, senha);

                            if (paciente == null) {
                                out.writeBoolean(false);
                            } else {
                                byte[] bytes = Protocolo.converterObjetoParaArrayByte(paciente);
                                out.writeBoolean(true);
                                out.writeInt(bytes.length);
                                out.write(bytes, 0, bytes.length);
                            }
                            break;
                        //login pro medico    
                        case 2:

                            usuario = in.readUTF();
                            senha = in.readUTF();
                            
                            medico = Protocolo.temMedico(usuario, senha);

                            if (medico == null) {
                                out.writeBoolean(false);
                            } else {
                                byte[] bytes = Protocolo.converterObjetoParaArrayByte(medico);
                                out.writeBoolean(true);
                                out.writeInt(bytes.length);
                                out.write(bytes, 0, bytes.length);
                            }
                            break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Conexão fechada. Razão: " + ex.toString());
            }

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("Conexão fechada. Razão: " + e.toString());
        }
    }
}
