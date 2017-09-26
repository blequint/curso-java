package graficos;

import java.awt.Frame;

import javax.swing.*;
public class CreandoMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiMarco marco1=new MiMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}
class MiMarco extends JFrame{
	public MiMarco(){
		//setSize(500,300);
	//	setLocation(500,300);
		setBounds(500,300,550,250);
		setTitle("Mi ventana");
		//setResizable(false);
	//	setExtendedState(Frame.MAXIMIZED_BOTH);
	}
}

