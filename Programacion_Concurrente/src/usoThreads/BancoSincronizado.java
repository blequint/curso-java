/**video 178 otra forma de sincronizar hilos, a diferencia de que unicamente se puede crear una sola condicion*/
package usoThreads;

import java.util.concurrent.locks.*;

public class BancoSincronizado{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco2 b=new Banco2();
		for(int i=0; i<100; i++){
			//1 - 100 cuentas aleatorias
			EjecucionTransferencias2 r=new EjecucionTransferencias2(b,i,2000);
			Thread t=new Thread(r);
			t.start();
		}
	}

}

class Banco2{
	public Banco2(){
		cuentas=new double[100];
		for(int i=0; i<cuentas.length; i++){
			cuentas[i]=2000;
		}
	
	}
	
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
		//sunchronized hace que el codigo se bloquee cuando un hilo entra para que no puedan entrar los demas
		
		if(cuentas[cuentaOrigen]< cantidad){
			//para indicar que el hilo se espere
			wait();
		}
		cuentas[cuentaOrigen]-=cantidad; //dinero que sale de la cuenta origen
		//imprimir en consola
		System.out.printf("%10.2f de %d para ", cantidad, cuentaOrigen, cuentaDestino);
		
		cuentas[cuentaDestino]+=cantidad;
		
		System.out.printf("Saldo total: %10.2f%n" , getSaldoTotal());
	
		//informa a todos los hilos en espera que se ha realizado una operacion
		//equivalente a signalAll
		notifyAll();
		
		
	}	
	public double getSaldoTotal(){
		double suma_cuentas=0;
		for(double a: cuentas){
			suma_cuentas+=a;
		}
		return suma_cuentas;
	}
	
	//es final porque no se debe de modificar y debe ser inicializado en el constructor
	private final double[] cuentas;
	
}

class EjecucionTransferencias2 implements Runnable{
	//Banco: para usar todas las funciones
	//de: para saber de que cuenta
	//max saber la cantidad
	public EjecucionTransferencias2(Banco2 b, int de, double max ){
		banco=b;
		deLaCuenta=de;
		cantidadMax=max;
	}

	@Override
	public void run() {
		//un bucle de transferencias infinitas
		try{
		while(true){
			int paraLaCuenta=(int)(Math.random()*100);
			
			double cantidad=cantidadMax*Math.random();
			banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
			
			Thread.sleep((int)(Math.random()*10));
			
			
		}
		}catch(InterruptedException e){
			
		}
	}
	private Banco2 banco;
	private int deLaCuenta;
	private double cantidadMax;
	
}