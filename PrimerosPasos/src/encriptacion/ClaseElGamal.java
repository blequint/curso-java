package encriptacion;

import java.util.*;
import java.math.*;

/**
 * Clase que codifica y decodifica siguiendo el método de ElGamal.
 * @author Juan Ant. Recio
 * @version 1.0
 */

public class ClaseElGamal {

  /* clave publica = p, alfa, beta   */
  /* clave privada = a */
  int p, alfa, beta, a;

  public String getClavePublica()
  {
     return "Clave Publica (p,alfa,beta) = ("+p+" , "+alfa+" , "+beta+")";
  }
  public String getClavePrivada()
  {
     return "Clave Privada (a) = ("+a+")";
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
   * Constructora
   * @param pparam Indica el cuerpo Zp en el que trabajamos. Es un primo grande
   * @param alfaparam Elemento primitivo de Zp
   * @param aparam Clave Privada
   * @param alfabeto
   * @throws Exception
   */
  public ClaseElGamal( int pparam, int alfaparam, int aparam, String alfabeto)throws Exception
  {
    creaAlfabeto(alfabeto);

    if (Algoritmos2.primoMR(pparam,25)) p=pparam;
    else throw new Exception(pparam + " no es primo");

    if (eltoPrimitivo(alfaparam,p)) alfa=alfaparam;
    else throw new Exception(alfaparam + " no es elemento primitivo de Z"+p);

    a=aparam;
    //Beta = alfa^a mod p
    beta =(int) Algoritmos2.expRapidaJ(alfa,a,p);
  }

   /**
    * Comprueba si a es elto primitivo en Zn
    * */
  private boolean eltoPrimitivo(int a, int n)
  {
    int i=1;
    while ((Algoritmos2.expRapidaJ(a,i,n)!=1) && (i<n)) i++;
    return (i==n-1);
  }

  /**
   * Codifica un caracter
   * */
   private Tupla esubk(int x, int k)
  {
      int y1, y2;
      y1=(int) Algoritmos2.expRapidaJ(alfa,k,p);
      y2=(int) Algoritmos2.expRapidaJ(beta,k,p);
      y2=y2*x % p;
      return new Tupla(y1,y2);
  }

  /**
   * Decodifica una tupla
   * */
  private double dsubk (int y1, int y2)
  {
    double r;
    r= Algoritmos2.expRapidaJ(y1,-a,p);
    r=r*y2 % p;
    return r;
  }

  /**
   * Codifica un texto. Devuelve una lista de tuplas
   * @param entrada
   * @return
   * @throws Exception
   */
  public ArrayList codificar(String entrada) throws Exception
  {
    char c;
    int k;
    Tupla tup;
    ArrayList lista = new ArrayList();

    for(int i=0; i<entrada.length(); i++)
      {
	c=entrada.charAt(i);
        k=(int)((Math.random()*100) %(p-2)); //k ha de ser primo en Zp-1
	tup=esubk(ord(c),k);
        lista.add(tup);
      }
    return lista;
  }

  /**
   * Decodifia a texto una lista de Tuplas resultado de cifrar con este metodo
   * @param lista
   * @return
   * @throws Exception
   */
  public String decodificar(ArrayList lista) throws Exception
  {
    Tupla c;
    double valor;
    char car;
    String cod="";
    for (int i=0;i<lista.size(); i++)
    {
	c=(Tupla)lista.get(i);
        valor=dsubk(c.getX(), c.getY());
        car=chr((int)valor);
        cod=cod + String.valueOf(car);
    }
    return cod;
  }

  public static void main(String args[])
  {
    char d,e;
    int i;
    ClaseElGamal clase;
    String cad, cad2;
    ArrayList res;


    try
    {
    clase= new ClaseElGamal(919,101,8,"abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ .,:;1234567890@");
    res=clase.codificar("cripto");
    System.out.println("El resultado de codificar es: \n" +res);
    cad2=clase.decodificar(res);
    System.out.println("El resultado de decodificar es: \n" +cad2);
    }
    catch (Exception ex)
    {
      System.out.println( "Parametros del alfabeto incorrectos :" +ex.getMessage());
    }

 }

/********************************************************/
/***************     Clase Interna       ****************/
/********************************************************/


  public class Tupla {

  private int x;
  private int y;
  public Tupla( int x1, int y1)
  {
    x=x1;
    y=y1;
  }
  public int getX()
  {
    return x;
  }
  public int getY()
  {
    return y;
  }
  public String toString()
  {
    return ("("+x+","+ y+")");
  }
  }
}