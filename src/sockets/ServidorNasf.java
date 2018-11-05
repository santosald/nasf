package sockets;

import geral.ConverterObjetos;
import geral.Medico;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import geral.Paciente;
import geral.Rede;
import parteGrafica.MedGraf;
import parteGrafica.PacienteGraf;

/**
 *
 * @author jorge
 */
public class ServidorNasf implements Runnable{
    
    Socket s;
    int caso;
    public ServidorNasf(Socket s){
    this.s = s;
//    Paciente paciente;
    }


    @Override
    public void run() {
        try {
            Paciente paciente3 = null;
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
        if(in.readUTF().equals("Paciente")){
        Paciente teste = new Paciente("Paciente",19);
        PacienteGraf paciente = new PacienteGraf(teste,s);
        paciente.setVisible(true);
        }else{
        Medico medico = new Medico("Médico",19);
        MedGraf med = new MedGraf(medico,in,out);
        med.setVisible(true);
        }
        while(true){
        
//        caso = in.readInt();
//        switch(caso){
//            case 0: 
                int tamanho = in.readInt();
                System.out.println(tamanho);
//                if(tamanho > 0){
                byte[] bytes = new byte[tamanho];
                in.read(bytes);
                paciente3 = (Paciente) ConverterObjetos.converterByteParaObjeto(bytes);
                geral.Rede.banco.adicionarPaciente(paciente3);
                geral.Rede.banco.serializar();
                System.out.println(paciente3.getNome());
//                break;
//                }
//                PacienteGraf novo = new PacienteGraf(paciente3, s);
//                novo.setVisible(true);

//                break;
//        }
        }

        
        } catch (IOException e) {
            
        }

        

    }
    
}
