/* video 190
 * La serializacion es necesaria cuando se quiere mandar un objeto por la red o cuando queremos tener acceso a un objeto 
 * en nuestro fichero de archivos
 *  */
package brenda.sockets;
import javax.swing.*;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.awt.event.*;



public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		
		addWindowListener(new EnvioOnline());
		}	
	
}

class EnvioOnline extends WindowAdapter{
	public void windowOpened(WindowEvent e){
		//todo lo que hagamos aqui se ejecutara al momento de abrir la ventana, el plan es es mandarle al sevidor todos los ips activos
		try{
			Socket misocket=new Socket("192.168.15.233", 9999);
			PaqueteEnvio datos=new PaqueteEnvio();
			datos.setMensaje("online");
			ObjectOutputStream paquete_datos=new ObjectOutputStream(misocket.getOutputStream());
		
			paquete_datos.writeObject(datos);
			misocket.close();
		}catch(Exception ex){
			
		}
	}
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){
		
		nick_usuario=JOptionPane.showInputDialog("Nick: ");
		JLabel n_nick =new JLabel("Nick: ");
		//nick.setText(arg0); //otra forma de agregar texto al label
		add(n_nick);
		nick=new JLabel(nick_usuario);
		add(nick);
		JLabel texto=new JLabel("Online: ");
		ip=new JComboBox();
		/*
		ip.addItem("Usuario 1");
		ip.addItem("Usuario 2");
		ip.addItem("Usuario 3");
		 */
		
		add(texto);
		add(ip);
		
		campochat=new JTextArea(12,20);
		
		add(campochat);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		miboton.addActionListener(new EnviaTexto());
		
		add(miboton);
		//hay que poner en escucha la recepcion de mensajes
		Thread mihilo=new Thread(this);
		mihilo.start();
		
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(campo1.getText());
			
			campochat.append("\n"+nick_usuario+": "+campo1.getText());
			try {
				//ip del servidor o dominio, puerto por el que va a salir

				Socket misocket=new Socket("192.168.15.233",9999);
				//tunel por donde viajara la informacion
				PaqueteEnvio datos=new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				
				datos.setIp(ip.getSelectedItem().toString());
				
				datos.setMensaje(campo1.getText());
				//crea un objeto de salida para el socket
				ObjectOutputStream paquete_datos=new ObjectOutputStream(misocket.getOutputStream());
				
				paquete_datos.writeObject(datos);
				
				misocket.close();
				paquete_datos.close();
				
				/*
				DataOutputStream flujo_salida=new DataOutputStream(misocket.getOutputStream());
				//informacion que viajara, el cual sera el campo
				flujo_salida.writeUTF(campo1.getText());
				flujo_salida.close();
				*/
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				//lanza en consola el mensaje con cual es el error
				//System.out.println(e1.getMessage());
			}
		}
		
	}
	
	@Override
	public void run() {
		
		try{
			ServerSocket servidor_cliente=new ServerSocket(9090);
			Socket cliente;
			PaqueteEnvio paqueteRecibido;
			
			while(true){
				//acepta todas las conexiones del exterior
				cliente=servidor_cliente.accept();
				//entrada de datos del tunel del socket
				ObjectInputStream flujoentrada=new ObjectInputStream(cliente.getInputStream());
				//lectura del paquete- como este es un objeto de paquete envio debe haber un casting
				paqueteRecibido=(PaqueteEnvio) flujoentrada.readObject();
				if(!paqueteRecibido.getMensaje().equals("online")){
					campochat.append("\n"+paqueteRecibido.getNick()+": "+paqueteRecibido.getMensaje());

				}else{
				//se ha conectado un equipo hay que actualizar el combobox
			//prueba para obtener el arraylist de los ips
				//campochat.append("\n"+paqueteRecibido.getIps());
				//hay que cambiar el arraylist en string para que salgan por invidivual y no en conjunto
					ArrayList <String> ipsMenu=new ArrayList<String>();
					ipsMenu=paqueteRecibido.getIps();
					//debido a que va a estar agregando cada vez que se actualice primero se debe vaciar el contenido del combobox
					ip.removeAllItems();
					for(String z : ipsMenu){
						ip.addItem(z);
					}
					}
				}
		}catch(Exception e){
		System.out.println(e.getMessage());
		}
	}	
		
		
	private JTextField campo1;
	
	private JComboBox ip;
	
	private JLabel nick;
	
	private JTextArea campochat;
	
	private JButton miboton;
	private String nick_usuario;


	
}
//indica que todas las instancias creadas van a convertirse en bytes para poder ser enviadas
class PaqueteEnvio implements Serializable{
	private String nick, ip, mensaje;
	private ArrayList<String> Ips;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public ArrayList<String> getIps() {
		return Ips;
	}

	public void setIps(ArrayList<String> ips) {
		Ips = ips;
	}

}