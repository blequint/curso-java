package excepciones_I;
import java.io.EOFException;

//video 22 y 146 https://www.youtube.com/watch?v=V1Wgi_FsehM&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=22
//creacion de excepciones manuales
import javax.swing.JOptionPane;


public class CompruebaMail2 {

	public static void main(String[] args) {
	
		
		String mail=JOptionPane.showInputDialog("Introduce mail");
		try{
		examina_mail(mail);
		}catch(Exception e){
			System.out.println("correo invalido");
			e.printStackTrace();
		}
	}	
	static void examina_mail(String mail) throws Longitud_mail_erronea{
		int arroba=0;
		boolean punto=false;
		
		if(mail.length()<=3){
			throw new Longitud_mail_erronea("El mail es muy corto");
			//throw new Longitud_mail_erronea();
		}else{
		for(int i=0; i<mail.length(); i++){
			if(mail.charAt(i)=='@'){
				arroba++;
			}
			if(mail.charAt(i)=='.'){
				punto=true;
			}
			
		}
		if(arroba==1 && punto==true){
			System.out.println("Es correcto");
		}else{
			System.out.println("No es correcto");
		}
		
	}
	}
}
//extends Exception, RunTimeException
//Exception obliga try catch
//RunTimeException no lo obliga
class Longitud_mail_erronea extends Exception{
	//cuando creas una clase con exception propia es necesario declarar 2 constructores
	//vacio y con un mensaje
	public Longitud_mail_erronea(){}
	public Longitud_mail_erronea(String msj_error){
		super(msj_error);
	}
}
