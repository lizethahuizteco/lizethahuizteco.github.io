
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
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
        final int puerto = 5000;
        byte[] buffer = new byte[1024];
        
        try {
            System.out.println("Servidor UDP iniciado (UDP)...");
            DatagramSocket socketUDP = new DatagramSocket(puerto);///////
            
            while(true){
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                socketUDP.receive(peticion);
                System.out.println("Información del cliente recibida...");

                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);

                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                mensaje = "Hola desde el servidor";
                buffer = mensaje.getBytes();
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

                System.out.println("Envío de informacion al cliente...");
                socketUDP.send(respuesta);
            }
                                   
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
