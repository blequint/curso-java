/*video 171*/
package usoThreads;

public class SincronizandoHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HilosVarios hilo1= new HilosVarios();
		hilo1.start();	
		//el join hace que primero muera el hilo antes de que otros comiencen despues de el
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HilosVarios hilo2= new HilosVarios();
		hilo2.start();
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//si el hilo 2 no tiene el join, despues de terminar el hilo 1 seguira el printf puesto que este pertene al hilo main el cual se ejecuto primero
		System.out.println("Terminadas las tareas");
	}

}
 class HilosVarios extends Thread{
	 public void run(){
		 for(int i=0; i<15; i++){
			 //para saber que hilo se esta ejecutando
			 System.out.println("Ejecutando hilo"+getName());
			 
			 try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
 }
 