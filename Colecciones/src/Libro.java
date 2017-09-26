
public class Libro {
	public Libro(String titulo, String autor, int ISBN){
		this.titulo=titulo;
		this.autor=autor;
		this.ISBN=ISBN;
	}
	public String getDatos(){
		return "El titulo es: "+titulo+". El autor es: "+autor+". Y el ISBN es: "+ISBN;
	}
	
	//metodo manual
	//public boolean equals(Object obj){
		
		 //Otra manera con hashcode en el main 
		  
		 
		//pregunta de el objecto es una instancia de libro
		//if(obj instanceof Libro){
			//se hace un casting de la clase object a la clase libro
		//	Libro otro=(Libro)obj;
			//ahora si se pueden comparar los objetos con equals
			/*if(this.ISBN==otro.ISBN){
				return true;
			}else  return false; 
			
		}else 
		return false;
		
		
	}*/
	
	private String titulo, autor;
	
	//metodos generados por eclipce en source generate hashcode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (ISBN != other.ISBN)
			return false;
		return true;
	}

	private int ISBN;
}
