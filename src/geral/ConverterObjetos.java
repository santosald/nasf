/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geral;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jorge
 */
public class ConverterObjetos {
     public static byte[] converterObjetoParaByte(Object object) {
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

    public static Object converterByteParaObjeto(byte[] bytes) {
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
//                Como converter objeto p byte
//                int tam = in.readInt();
//                byte[] bytes = new byte[tam];
//                in.read(bytes);
//                professor = (Professor) Serializador.converterByteArrayParaObjeto(bytes);


//
//                                Como converter byte p objeto
//                                byte[] bytes = Protocolo.converterObjetoParaArrayByte(professor);
//                                out.writeBoolean(true);
//                                out.writeInt(bytes.length);
//                                out.write(bytes, 0, bytes.length);