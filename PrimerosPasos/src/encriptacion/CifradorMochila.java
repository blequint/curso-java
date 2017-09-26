
package encriptacion;

import java.util.*;

/**
 * <p>Title: Cifrador de la mochila tramposa</p>
 * @author Juan Ant. Recio
 * @version 1.0
 */

public class CifradorMochila {

  int[] clave_privada;
  int[] clave_publica;
  int m;               // sumatorio de la sucesion supercreciente -> clave privada
  public int d,h;      // h = inverso de d
  public int n;
  int l;               // longitud de las claves

  public String getClavePublica()
  {
     String cad ="";
     for (int i=0; i<clave_publica.length; i++)
        cad += clave_publica[i] + " ";
     return "Clave Publica (sucesion) = ("+cad+")";
  }
  public String getClavePrivada()
  {
     String cad ="";
     for (int i=0; i<clave_privada.length; i++)
        cad += clave_privada[i] + " ";
     return "Clave Privada (sucesion,n,d) = ("+cad+" , "+n+" , "+d+")";
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

    /**
     * Devuelve la representacion en binario de la cadena texto.
     * Cada caracter se cifra con 8 bits, con lo que tenemos un alfabeto de 256 cars maximo
     * @param texto
     * @return
     * @throws Exception
     */
    public int[] aBinario(String texto) throws Exception
    {
      int[] bin = new int[texto.length() * 8];   // 256 cars maximo
      char caracter = 0;
      int ordinal = 0;
      String bite ="";

      for (int i = 0; i< texto.length(); i++)
      {
        caracter= texto.charAt(i);
        ordinal = ord(caracter);
        bite = Algoritmos1.convierteBase(String.valueOf(ordinal),10,2);

        while (bite.length() < 8) bite = "0"+bite;

        for (int j = 0; j < 8; j++)
          bin[(8*i) + j] = Integer.parseInt( String.valueOf(bite.charAt(j)) );
      }

      return bin;
    }


/********************************************************/
/********************************************************/

  /**
   * Constructora.
   * Necesita una sucesion supercreciente no negativa y el alfabeto
   * @param supercreciente
   * @throws Exception
   */
  public CifradorMochila(int[] supercreciente, String abc) throws Exception
  {
    creaAlfabeto(abc);
    clave_privada = new int[supercreciente.length];

    // Compruebo que es supercreciente
    int aux =0;
    for (int i=0; i<supercreciente.length; i++)
      if (aux>supercreciente[i]) throw new Exception("La clave privada no es una sucesion supercreciente");
      else aux += supercreciente[i];

    m=0;
    // M = sumatorio de la clave privada
    for (int i=0; i<supercreciente.length; i++)
    {
      clave_privada[i] = supercreciente[i];
      m+= clave_privada[i];
    }
    // hallo n
    n = (int) (m + ((Math.random() * m)));      // m < n < 2m

    d = n;
    // hallo d t.q. mcd(d,n)=1
    while (Algoritmos1.mcd(d,n) != 1)
      d =(int)( 2 +(Math.random() * (n-2)));

    // hallo h inversa de d modulo n
    h = inversaZn(d,n);

    // longitud de las claves. (por cododidad)
    l = clave_privada.length;

    // hallo la clave publica.
    clave_publica = new int[clave_privada.length];
    for (int i=0; i<clave_publica.length; i++)
      clave_publica[i] = (clave_privada[i] * d) % n;
  }

  /**
   * Cifra una cadena de texto.
   * Para cifrar, primero convierte el texto a una cadena con los caracteres en binario.
   * Despues lo divide en bloques de la misma longitud que la clave publica y
   * calcula el sumatorio segun indiquen los bits.
   * @param texto
   * @return
   * @throws Exception
   */
  public int[] cifrar(String texto) throws Exception
  {
    while (((texto.length()*8) % l) != 0) texto+=" ";
    int[] textoBinario = aBinario(texto);
    int bloques = (textoBinario.length / l);
    int[] cifrado = new int[bloques];

    int acum = 0;
    for (int i = 0; i< bloques ; i++)
    {
       acum = 0;
       // Cifro el bloque segun los bits del texto binario
       for (int j = 0; j < l; j++)
          acum += textoBinario[(i * l) +j] * clave_publica[l-j-1];
       cifrado[i] = acum ;
    }
    return cifrado;
  }

  /**
   * Descifra un array de enteros cifrados con el método de la mochila.
   * Resuelve el problema facil de la mochila con cada numero del array de entrada.
   * Para ello necesita la clave privada.
   * Luego junta todo en un texto en binario y lo convierte a caracteres
   *
   * @param cifrado
   * @return
   * @throws Exception
   */
  public String descifrar (int [] cifrado) throws Exception
  {
    String texto = "";
    String textoBinario = "";
    String caracter;

    // Desciframos cada bloque.
    for (int i = 0; i<cifrado.length; i++)
    {
        caracter = mochila(cifrado[i]*h % n);
        textoBinario += caracter;
    }

    //Convertimos los valores binarios a decimales. Y de ahí, a caracter
    for (int i = 0; i<textoBinario.length()/8 ; i++)
    {
      caracter ="";
      for (int j=0; j<8; j++)
        caracter += textoBinario.charAt((i*8)+j);
      texto += chr(Integer.parseInt (Algoritmos2.convierteBase(caracter,2,10)));
    }
    return texto;
  }

  /**
   * Resuelve el problema facil de la mochila.
   * Utiliza el algoritmo voraz con la ventaja de tener valores binarios
   * Devuelve una cadena en binario
   * @param num
   * @return
   */
  public String mochila (int num)
  {
    String res ="";
    for (int i=l-1; i>=0; i--)
    {
      if (num >= clave_privada[i])
      {
        num = num -clave_privada[i];
        res+=1;
      }
      else
        res+=0;
    }
    return res;
  }

  // Muestra un array
  public void muestraArray(int [] a)
  {
    for(int i=0; i< a.length; i++)
      System.out.print(a[i] + ",");
  }
  public String arrayACad (int [] a)
  {
     String cad ="";
     for (int i=0; i<a.length; i++)
        cad += a[i] + " ";
     return cad;
  }

  public static void main(String[] args)
  {
    try {

    int sc[] = {1,2,5,12,30,72,150,411,900,1912,4154,9721};
    String abc="abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ .,:;1234567890@";
    CifradorMochila m = new CifradorMochila(sc,abc);

    int[] cifrao = m.cifrar("En un lugar de la Mancha , de cuyo ...");
    System.out.print("Array Cifrado: ");
    m.muestraArray(cifrao);
    String descifrao = m.descifrar(cifrao);
    System.out.println("\nDvuelve: "+descifrao);
  } catch (Exception e) {System.out.println(e);}
  }
}