//video 22 https://www.youtube.com/watch?v=V1Wgi_FsehM&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=22
import javax.swing.JOptionPane;


public class CompruebaMail {

	public static void main(String[] args) {
		int arroba=0;
		boolean punto=false;
		
		String mail=JOptionPane.showInputDialog("Introduce mail");
		
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
