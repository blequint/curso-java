/*video 173 - 177 una forma de bloquear hilos para hacerlos trabajar simultaneamente
 * Banco que cuenta con 100 cuentas con 2000 en cada una osea 200 000 euros*/
package usoThreads;

import java.util.concurrent.locks.*;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco b=new Banco();
		for(int i=0; i<100; i++){
			//1 - 100 cuentas aleatorias
			EjecucionTransferencias r=new EjecucionTransferencias(b,i,2000);
			Thread t=new Thread(r);
			t.start();
		}
	}

}

class Banco{
	public Banco(){
		cuentas=new double[100];
		for(int i=0; i<cuentas.length; i++){
			cuentas[i]=2000;
		}
		//el bloqueo se establece en base a la condicion 
		saldoSuficiente=cierreBanco.newCondition();
	}
	
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
		/*al no estar de acuerdo los hilos, o bloquearse esta funcion cuando un hilo lo esta utilizando es posible que se pierda cierta cantidad de dinero*/
		
		cierreBanco.lock();
		try{
		//controlar el saldo de la cuenta si el saldo es inferior al saldo que se quiere transferirlo
		if(cuentas[cuentaOrigen]< cantidad){
		/* 	impide que se realicen todas las transferencias:
			//saldos insuficientes
			System.out.println("---------------CANTIDAD INSUFICINTE "+cuentaOrigen+" .....SALDO: "+cuentas[cuentaOrigen]+"..."+cantidad);
			return;
		*/
		//para lograr que se hagan todas las transferencias:
			//mientras sea verdad la condicion el hilo permanece en espera (hasta que otro hilo deposite y ahora si se pueda)
			//await desbloquea el hilo el codigo
			saldoSuficiente.await();
			//Como la exception que lanza es un InterruptedException declarado en el metodo run en lugar de usar try catch se usa la instruccion throws en el metodo
		
		}else{
			//System.out.println("----- CANTIDAD OK-----"+cuentaOrigen);
		}
		//imprimir el hilo que hace esa transferencia
		System.out.println(Thread.currentThread());
		
		cuentas[cuentaOrigen]-=cantidad; //dinero que sale de la cuenta origen
		//imprimir en consola
		System.out.printf("%10.2f de %d para ", cantidad, cuentaOrigen, cuentaDestino);
		
		cuentas[cuentaDestino]+=cantidad;
		
		System.out.printf("Saldo total: %10.2f%n" , getSaldoTotal());
		//despierta todos los hilos en espera para informarles que se ha hecho una operacion para ver si ahora si pueden ejecutarse
		saldoSuficiente.signalAll();
		}finally{
			//finally se usa para que siempre entre al codigo 
			
			//desbloqueo del codigo para el siguiente codigo
			cierreBanco.unlock();
		}
		
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
	//para bloquear hilos
	private Lock cierreBanco=new ReentrantLock();
	//condicion de bloqueo de hilos
	private Condition saldoSuficiente;
}

class EjecucionTransferencias implements Runnable{
	//Banco: para usar todas las funciones
	//de: para saber de que cuenta
	//max saber la cantidad
	public EjecucionTransferencias(Banco b, int de, double max ){
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
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;
	
}