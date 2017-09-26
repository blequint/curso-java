package encriptacion;

import java.math.*;
import java.util.*;
import java.lang.*;

/**
* Clase que codifica y decodifica siguiendo el método de RSA.
* */
public class ClaseRSA {

        /* clave publica = n,b   */
        /* clave privada = p,q,a */
        int p,q,a;
	int b,n;

        public String getClavePublica()
        {
          return "Clave Publica (n,b) = ("+n+" , "+b+")";
        }
        public String getClavePrivada()
        {
          return "Clave Privada (p,q,a) = ("+p+" , "+q+" , "+a+")";
        }

/********************************************************/
/***************   Funciones Auxiliares  ****************/
/********************************************************/

  protected  String alfabeto;

  /**
  * Almacena la cadena que contiene el alfabeto
  */
  public  void creaAlfabeto(String s)
  {
    alfabeto = new String(s+'\n');
  }

  /**
   * Devuelve el ordinal de un caracter
   */
  public int ord(char car) throws Exception
  {
    int i=0;
    while ((i<alfabeto.length())&&(alfabeto.charAt(i)!=car)) i++;
    if (i==alfabeto.length())
        throw new Exception("El caracter: "+car+" no se encuentra en el alfabeto");
    return i;
  }
  /**
   * Devuelve el caracter con dicho ordinal
   */
  public char chr(int num) throws Exception
  {
    if (num >= alfabeto.length())
        throw new Exception("El caracter: "+num+" no existe");
    return alfabeto.charAt(num);
  }
  /**
   * Calcula la inversa de un número en Zn
   */
  public  int inversaZn(int a, int n) throws Exception
    {
      double[] valores = Algoritmos1.identidad(a,n);
      double inv = valores[0];
      if (inv < 0) inv+=n;
      return (int)inv;
    }


/********************************************************/
/********************************************************/

  /**
   * Constructora de la clase.
   * @throws Exception
   */
  public ClaseRSA(int pparam, int qparam, String alfabeto) throws Exception
  {
    creaAlfabeto(alfabeto+"\n"+"\t");
    //Comprobamos que p es primo
    if (Algoritmos2.primoMR(pparam,25)) p=pparam;
    else throw new Exception(pparam + " no es primo");
    if (Algoritmos2.primoMR(qparam,25)) q=qparam;
    else throw new Exception(qparam + " no es primo");

    int fi = (p-1)*(q-1);
    b = fi;
    while (Algoritmos2.mcd(b,fi)!=1)
      b = (int)Math.floor(Math.random()*(fi-1))+1;
    a = inversaZn(b,fi);

    if (p*q<alfabeto.length()) throw new Exception(p + " * " + q +" ha de ser mayor que la longitud del alfabeto");
    else { n=p*q; }
}


   /**
    * Codifica un caracter
    * */
   private double esubk(int x)
   {
      return Algoritmos2.expRapida((double)x,(double)b,n);
   }

   /**
    * Decodifica un numero
    */
   private double dsubk(int y)
   {
      return Algoritmos2.expRapida((double)y,(double)a,n);
   }

    /**
     * Codifica un texto
     * @param entrada
     * @return ArrayList -> Lista de numeros
     * @throws Exception
     */
   public ArrayList codificar(String entrada) throws Exception
   {
      String cad;
      int ordinal, indice;
      double cod;
      ArrayList lista = new ArrayList();
      for (int i=0; i<entrada.length(); i++)
      {
	ordinal=ord(entrada.charAt(i));
	cod=esubk(ordinal);
        lista.add(new Double(cod));
      }
      return lista;
   }

    /**
     * Decodifica una lista de numeros (resultante de codificar con RSA)
     * Devuelve la cadena de texto
     * @param lista
     * @return
     * @throws Exception
     */
   public String decodificar(ArrayList lista) throws Exception
  {
    Double c;
    double c2;
    double i2;
    char car;
    String cod="";

    for(int i=0; i<lista.size();i++)
    {
	c=(Double)lista.get(i);
        c2=c.doubleValue();
        i2=dsubk((int)c2);
        car= chr((int)i2);
        cod=cod + String.valueOf(car);
     }
     return cod;
  }

   public static void main(String args[])
	{
	}

}