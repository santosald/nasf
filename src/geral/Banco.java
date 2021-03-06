package geral;

import java.io.Serializable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class Banco implements Serializable {
    
//    public static Paciente[] pacientes = new Paciente[100];
    public List<Paciente> pacientes;
    public List<Medico> medicos;
    private static final String nomeBanco = "dados.ser";
    
    public int nPacientes = 0;
    
    public Banco() {
        pacientes = new ArrayList<Paciente>();
        medicos = new ArrayList<Medico>();
    }

    public List<Paciente> tdsPacientes(){
        return pacientes;
    }
    
    public List<Medico> tdsMedicos(){
        return medicos;
    }
    
    public void adicionarMedico(Medico medico){
        medicos.add(medico);
    }
    public void adicionarPaciente(Paciente paciente){
        pacientes.add(paciente);
        nPacientes++;
    }
    
    public void removerPaciente(Paciente paciente){
        this.pacientes.remove(paciente);
    }
    public Paciente buscarPaciente(String nome){
        for (Paciente paciente : pacientes) {
            if(paciente != null){
                        if(paciente.nome.equals(nome))
                return paciente;
            }
        }
        return null;
    }
    
    public Paciente buscarID(int id){
        for (Paciente paciente : pacientes) {
            if(paciente != null){
                        if(paciente.id == id)
                return paciente;
            }
        }
        return null;
    }
    public boolean buscarIDboolean(int id){
        for (Paciente paciente : pacientes) {
            if(paciente != null){
                        if(paciente.id == id)
                return true;
            }
        }
        return false;
    }
    public void serializar() {
      File arq = new File(nomeBanco);

      try {    
        ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
        objOutput.writeObject(this);
        objOutput.close();
    
      } catch(IOException erro) {
          System.out.printf("Erro: %s", erro.getMessage());
      }        
      }
    
//
//    public Banco deserializar() {
//        Banco rede = null;
//        try {
//            ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(nomeBanco));
//            rede = (Banco)objInput.readObject();
//            objInput.close();        
//        } catch(IOException erro1) {
//            System.out.printf("Erro: %s", erro1.getMessage());
//        } catch(ClassNotFoundException erro2) {
//            System.out.printf("Erro: %s", erro2.getMessage());
//        }
//    
//      return rede;
//    }
   
}
