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
                        case 101:

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
                        case 102:

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
                        //armazenar prontuario criado    
                        case 103:
                            
                            int tam = in.readInt();
                            byte[] bytes = new byte[tam];
                            in.read(bytes);
                            paciente = (Paciente) Protocolo.converterByteArrayParaObjeto(bytes);
                            
                            Paciente auxiliar = Rede.banco.buscarPaciente(paciente.getNome());
                            Rede.banco.removerPaciente(auxiliar);
                            Rede.banco.adicionarPaciente(paciente);
                            System.out.println(paciente.getProntuario().getSituacao());
                            break;
                        //buscar usuario no banco   
                        case 104:

                            int id = in.readInt();
                            Paciente pacienteid = Rede.banco.buscarID(id);
                            
                            if (pacienteid == null) {
//                                out.writeBoolean(false);
                            } else {
                                byte[] bytesid = Protocolo.converterObjetoParaArrayByte(pacienteid);
                                out.writeBoolean(true);
                                out.writeInt(bytesid.length);
                                out.write(bytesid, 0, bytesid.length);
                            }
                            break;
                            
                         //salvar um paciente no banco
                        case 105:
                            int tam2 = in.readInt();
                            byte[] bytes2 = new byte[tam2];
                            in.read(bytes2);
                            paciente = (Paciente) Protocolo.converterByteArrayParaObjeto(bytes2);
                            Rede.banco.adicionarPaciente(paciente);
                            Rede.banco.serializar();
                            break;
                         //salvar um medico no banco
                        case 106:
                            int tam3 = in.readInt();
                            byte[] bytes3 = new byte[tam3];
                            in.read(bytes3);
                            Medico medico2 = (Medico) Protocolo.converterByteArrayParaObjeto(bytes3);
                            Rede.banco.adicionarMedico(medico2);
                            Rede.banco.serializar();
                            break;
                         //vincular paciente   
                        case 107:
                            int id2 = in.readInt();
                            boolean verdade = Rede.banco.buscarIDboolean(id2);
                            Paciente pacienteid2 = Rede.banco.buscarID(id2);
                            out.writeBoolean(verdade);
                            if(verdade){
                                byte[] bytesid2 = Protocolo.converterObjetoParaArrayByte(pacienteid2);
                                out.writeInt(bytesid2.length);
                                out.write(bytesid2, 0, bytesid2.length);
                            }
                            
                            
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
