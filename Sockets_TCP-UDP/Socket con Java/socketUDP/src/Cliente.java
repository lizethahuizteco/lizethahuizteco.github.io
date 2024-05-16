
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
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
        final int puerto_servidor = 5000;
        byte[] buffer = new byte[1024];
        
        try {            
            InetAddress direccionServidor = InetAddress.getByName("192.168.223.26");
            DatagramSocket socketUDP = new DatagramSocket();////
            
            String mensaje = "Hola desde el cliente (UDP)...";
            buffer = mensaje.getBytes();
            
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, puerto_servidor);
            System.out.println("Envio del Datagrama");
            socketUDP.send(pregunta);
            
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(peticion);
            System.out.println("Recibo la peticion");
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);
            
            socketUDP.close();
            
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
