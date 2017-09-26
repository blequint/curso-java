package excepciones_I;
import java.io.EOFException;

//video 22 y 146 https://www.youtube.com/watch?v=V1Wgi_FsehM&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=22
//creacion de excepciones manuales
import javax.swing.JOptionPane;


public class CompruebaMail {

	public static void main(String[] args) {
	
		
		String mail=JOptionPane.showInputDialog("Introduce mail");
		try{
		examina_mail(mail);
		}catch(Exception e){
			System.out.println("correo invalido");
		}
	}	
	static void examina_mail(String mail)throws EOFException{
		int arroba=0;
		boolean punto=false;
		
		if(mail.length()<=3){
			//un exception cualquiera
			//ArrayIndexOutOfBoundsException miexception=new ArrayIndexOutOfBoundsException();
			//throw miexception;
			//no obligada con try catch
			//throw new ArrayIndexOutOfBoundsException();
			//obligada try catch
			throw new EOFException();
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
