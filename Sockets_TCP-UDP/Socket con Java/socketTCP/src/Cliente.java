
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lizeth
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String host = "192.168.223.26";
        final int puerto = 5000;
        DataInputStream in;
        DataOutputStream out;
        
        try {
            Socket sc = new Socket(host, puerto);/////
            in = new DataInputStream(sc.getInputStream());//cleinte <- servidor
            out = new DataOutputStream(sc.getOutputStream());//servidor<-cliente
            out.writeUTF("Hola desde el cliente (TCP)...");
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            
            sc.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
