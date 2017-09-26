/*video 28 y 29 y 30 y 31 y 32 y 32
 * https://www.youtube.com/watch?v=ZY5pwm92cWQ&index=28&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk*/

package poo;

public class Coche {

	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso;
	
	private int peso_total;
	private String color;
	private boolean asientosCuero, climatizador;
	public Coche(){
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso=500;
		
	}
	
	public String getRuedas(){
		
		return "Tu coche tiene "+this.ruedas+" ruedas";
	}
	
	public void setRuedas(int ruedas){
		this.ruedas=ruedas;
	}
	public String getLargo(){
		return "El largo de tu coche es de "+this.largo+" cm";
	}
	public void setLargo(int largo){
		this.largo=largo;
	}
	public String getAncho(){
		return "El ancho de tu coche es de "+ this.ancho+" cm";
	}
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public String getMotor(){
		return "Tu motor es de "+this.motor+" cm";
	}
	public void setMotor(int motor){
		this.motor=motor;
	}
	public String getPeso(){
		return "El peso de tu coche es de "+this.peso+" kg";
	}
	public void setPeso(int peso){
		this.peso=peso;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getColor(){
		return this.color;
	}
	public String getDatosGenerales(){
		return "La plataforma del vehicula tiene "+ this.ruedas
				+" ruedas. Mide "+this.largo/1000+ " metros con un ancho de "
				+this.ancho + " cm"+ " y un peso de "+this.peso+" kg";
	}
	public void setAsientosCuero(String asientosCuero){
		if(asientosCuero.equalsIgnoreCase("Si")){
			this.asientosCuero=true;
		}else this.asientosCuero=false;
	}
	public String getAsientosCuero(){
		if(asientosCuero==true){
			return "El coche tiene asientos de cuero";
		}else return "El coche NO tiene asientos de cuero";
	
	}
	public void setClimatizador(String climatizador){
		if(climatizador.equalsIgnoreCase("Si")){
		this.climatizador=true;
		}else
			this.climatizador=false;
	}
	public String getClimatizador(){
		if(this.climatizador==true){
			return "El coche SI tiene cliema";
		}else
			return "El coche NO tiene clima";
	}
	public String CalculaPesoTotal(){
		int pesoCarroceria=500;
		this.peso_total=this.peso_total+pesoCarroceria;
		
		if(asientosCuero==true){
			this.peso_total=this.peso_total+50;
		} if(climatizador==true){
			this.peso_total=this.peso_total+20;
		}
		
		return "El peso total es de "+this.peso_total+" kg";
	}
	public int CalculaPrecio(){
		int precioFinal=10000;
		if(this.asientosCuero==true){
			precioFinal+=2000;
		}
		if(this.climatizador==true){
			precioFinal+=1500;
		}
		return precioFinal;
	}
}
