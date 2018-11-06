/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geral;

import static geral.Rede.banco;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import parteGrafica.telaAbertura;

/**
 *
 * @author jorge
 */
public class Protocolo {
    public Protocolo(){}
    
    public static Paciente temPaciente(String usuario, String senha){
        for (Paciente x : banco.tdsPacientes() ) {
            if(x != null){
            if(x.getUsuario().equals(usuario) && Integer.parseInt(senha) == x.getSenha()){
                return x;
            }
        }
        }
    return null;
    }
    
    public static Medico temMedico(String usuario,String senha){
    for(Medico x : banco.tdsMedicos()){
        if(x != null){
       if(x.getNome().equals(usuario) && x.getSenha() == Integer.parseInt(senha)){
           return x;
        }
        }
        }
    return null;
    }
    public static byte[] converterObjetoParaArrayByte(Object object) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
       
        return bytes;
    }
    
    public static Object converterByteArrayParaObjeto(byte[] bytes) {
        Object object = null;
 
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return object;
    }
}
