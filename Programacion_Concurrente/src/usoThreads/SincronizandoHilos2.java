/*video 171*/
/*video 172
 * Forma de liberar el hilo del main y dejar en segundo plano las demas tareas
 *  */
package usoThreads;

public class SincronizandoHilos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HilosVarios01 hilo1= new HilosVarios01();
			
		
		

		//Forma de indicarle que hasta que termine el hilo 1 comience el dos
		HilosVarios2 hilo2= new HilosVarios2(hilo1);
		
		hilo2.start();
		hilo1.start();
		
		System.out.println("Terminadas las tareas");
	}

}
 class HilosVarios01 extends Thread{
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
 class HilosVarios2 extends Thread{
	 public HilosVarios2(Thread hilo){
		 this.hilo=hilo;
 }
	 public void run(){
		 try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	 private Thread hilo;
 }