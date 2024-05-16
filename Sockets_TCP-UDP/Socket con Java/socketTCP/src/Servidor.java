
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
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
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        
        final int puerto = 5000;
        
        try {
            servidor = new ServerSocket(puerto);/////
            System.out.println("Servidor iniciado (TCP)");
            
            while(true){
                sc = servidor.accept();//espera del cliente
                System.out.println("Cliente conectado...");
                in = new DataInputStream(sc.getInputStream());//cliente -> servidor
                out = new DataOutputStream(sc.getOutputStream());//servidor->cliente
                
                String mensaje = in.readUTF();
                
                System.out.println(mensaje);
                
                out.writeUTF("Hola desde el servidor...");
                
                sc.close();
                System.out.println("Cliente desconectado");
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
