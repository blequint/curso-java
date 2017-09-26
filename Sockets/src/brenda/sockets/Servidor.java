/*video 190*/
package brenda.sockets;



import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		Thread mihilo=new Thread(this);
		mihilo.start();
		
		}
	


	@Override
	public void run() {
		// TODO Auto-generated method stub
		//codigo que estara a la escucha
		
		//System.out.println("Estoy escuchando");
		try {
			//socket del servidor el cual abre el puerto donde recibira la informacion
			ServerSocket servidor=new ServerSocket(9999);
			
			String nick,ip,mensaje;
			ArrayList<String> ips=new ArrayList<String>();

			PaqueteEnvio paquete_recibido;
			
			while(true){
			//acepta las conexiones del exterior con ese socket
			Socket misocket=servidor.accept();
			

			
			ObjectInputStream paquete_datos=new ObjectInputStream(misocket.getInputStream());
			//debido a que el paquete almacenado es de clase paquete envio es necesario hacer un casting para paquete recibido
			paquete_recibido=(PaqueteEnvio) paquete_datos.readObject();
			nick=paquete_recibido.getNick();
			ip=paquete_recibido.getIp();
			mensaje=paquete_recibido.getMensaje();
			
			
			/*
			//la informacion que viene con el socket que va a leer
			DataInputStream flujo_entrada=new DataInputStream(misocket.getInputStream());
			String mensaje_texto=flujo_entrada.readUTF(); //mesaje convertido a un String
			
			areatexto.append("\n"+mensaje_texto); //agrega el texto 
			*/
			if(!mensaje.equals("online")){
			
			
			areatexto.append("\n"+nick+": "+mensaje+" para "+ip);
			//tiene que abrir otro tunel para la pc destinataria
			
			Socket enviaDestinatario=new Socket(ip,9090);
			
			ObjectOutputStream paqueteReenvio=new ObjectOutputStream(enviaDestinatario.getOutputStream());
			
			paqueteReenvio.writeObject(paquete_recibido);
			
			enviaDestinatario.close();
			paqueteReenvio.close();
			
			//solo permite un mensaje a la vez porque estoy cerrando la conexion por eso el bucle debe ser infinito
			misocket.close();
			}else {
	/**********DETECTA ONLINE--- se acaba de conectar un usuario*/
				
				//almacena la direccion del cliente con el se acaba de conectar
				InetAddress localizacion=misocket.getInetAddress();
				//lo covierte en string
				String ipRemota=localizacion.getHostAddress();
				System.out.println("Online "+ipRemota);
				//para mandarle el listado de los ips a cada cliente se debe iniciar en otra parte, debido a que si 
				//se inicia aqui se reiniciaria
			//	ArrayList<String> ips=new ArrayList<String>();

				ips.add(ipRemota);
				//paquete que se reenviara
				paquete_recibido.setIps(ips);
				
				//tiene que abrir un zocket por cada ip recibida
				for(String z: ips){
					Socket enviaDestinatario=new Socket(z,9090);
					
					ObjectOutputStream paqueteReenvio=new ObjectOutputStream(enviaDestinatario.getOutputStream());
					
					paqueteReenvio.writeObject(paquete_recibido);
					
					enviaDestinatario.close();
					paqueteReenvio.close();
					
					//solo permite un mensaje a la vez porque estoy cerrando la conexion por eso el bucle debe ser infinito
					misocket.close();
				}
				
			}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) { //exception de paqueterecibido
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private JTextArea areatexto;
	
}

