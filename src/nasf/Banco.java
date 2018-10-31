package nasf;

import java.io.Serializable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Jorge Gomes & Naiara Brito
 */
public class Banco implements Serializable {
    
    public Paciente[] pacientes = new Paciente[100];
    private static final String nomeBanco = "banco.ser";
    int nPacientes = 0;
    public Banco() {

    }

    public void adicionarPaciente(Paciente paciente){
        this.pacientes[nPacientes] = paciente;
        nPacientes++;
    }
    
    public Paciente[] tdsPacientes(){
        return pacientes;
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
    

    public Banco deserializar() {
        Banco rede = null;
        try {
            ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(nomeBanco));
            rede = (Banco)objInput.readObject();
            objInput.close();        
        } catch(IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }
    
      return rede;
    }
   
}
