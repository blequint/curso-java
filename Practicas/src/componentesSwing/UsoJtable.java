package componentesSwing;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;



public class UsoJtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco marco=new Marco();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class Marco extends JFrame{
	public Marco(){
		setBounds(350,350,600,400);
		Lamina lam=new Lamina();
		add(lam);
		setVisible(true);
	}
}
class Lamina extends JPanel{
	public Lamina(){
		JTable tabla=new JTable();
		
		DefaultTableModel modelo= (DefaultTableModel) tabla.getModel();
		 String[] lista={"a","b", "c","d"};
		Vector <Hora> listaHoras=new Vector <Hora>();
		listaHoras.add(new Hora("14:30:00"));
		listaHoras.add(new Hora("17:30:00"));
		listaHoras.add(new Hora("15:30:00"));
		listaHoras.add(new Hora("10:30:00"));
		
		modelo.addColumn(modelo.getRowCount() - 1, listaHoras);
		
		add(tabla);	
	}
}
 class Hora{
	 public Hora(String hora){	 
		 DateFormat formato =new SimpleDateFormat("hh:mm:ss");
		 try {
			this.hora=formato.parse(hora);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public String toString(){
		 return ""+hora.toString();
	 }
	 private Date hora;
 }
