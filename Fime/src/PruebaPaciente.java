
public class PruebaPaciente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente pac=new Paciente("Brenda", 23,60, 163);
		System.out.println("El IMC de "+pac.getNombre()+" "+ pac.AnalizaIMC());
		
	}

}

class Paciente {
	private String nombre;
	private int edad;
	private float estatura, peso;
	
	public Paciente(String nombre, int edad, int peso, int estatura){
		this.nombre=nombre;
		this.edad=edad;
		this.peso=peso;
		this.estatura=estatura;
	}
	
	public void Calcular(){
		
	}
	public double CalcularIMC(){
	return peso/Math.pow(estatura, 2)*10000;
	}
	public String AnalizaIMC(){
		if(CalcularIMC()<18.5){
			return "tiene un peso bajo";
		}else if(CalcularIMC()>=18.5 && CalcularIMC()<24.9){
			return "tiene un peso normal";
			
		}else return "tiene sobrepeso";
		
	}
	public String getNombre(){
		return this.nombre;
	}
}
