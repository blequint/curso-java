package encriptacion;
import java.lang.Math;

/**
 *
 * <p>Title: Algoritmos de la parte 1</p>
 * @author Juan Ant. Recio
 * @version 1.0
 */
public class Algoritmos1{

 /**
  * Implementa la exponenciacion rapida modular
  */
 public static double expRapida(double num,double b,double n)
  {
    double z, x, resul;
    z = b;
    x = num;
    resul = 1;
    while (z>0)
    {
      if ((z%2)== 1)
      {
        resul = (resul*x) % n;
        z--;
      }else
      {
        x = (x*x) % n;
        z = java.lang.Math.floor(z/2);
      }
    }
    return resul;
  }

 /**
  * Implementa la exponenciacion rapida
  */
 public static double expRapida(double num,double b)
  {
    double z, x, resul;
    z = b;
    x = num;
    resul = 1;

    while (z>0)
    {
      if ((z%2)== 1)
      {
        resul = (resul*x) ;
        z--;
      }else
      {
        x = (x*x) ;
        z = java.lang.Math.floor(z/2);
      }
    }
    return resul;
  }


    /**
     * Cambia un numero de base (base N a base M)
     */
     public static String convierteBase(String num,int baseN,int baseM) throws Exception
     {
       String result="";

 	    int resto;
	    double cociente,numaux;
            if((baseN<=0)||(baseM<=0))
                throw new Exception("La base debe estar comprendida entre 2 y 36");
            //primero a base 10
	    numaux=convertir(num,baseN);
	    cociente =java.lang.Math.floor(numaux/baseM);
            resto = (int)(numaux%baseM);

            while (cociente != 0 )
            {
               result=String.valueOf(Character.forDigit(resto,baseM))+result;
               numaux = cociente;
               cociente =java.lang.Math.floor(numaux/baseM);
               resto = (int)numaux%baseM;
            }
    	    result = String.valueOf(Character.forDigit(resto,baseM))+result;
    	    return result;
	  }

      /**
       * Devuelve en decimal un numero de base b
       */
	protected static double convertir(String n,int b) throws Exception
        {
          double acum, res, coc;
	  acum = 0;
          if (b<2)
                throw new Exception("La base debe estar comprendida entre 2 y 36");
          for (int j=0;j<n.length();j++){
              if(Character.getNumericValue(n.charAt(j))>=b)
                throw new Exception("El número de entrada incorrecto "+b);
              acum = acum + Character.digit(n.charAt(j),b)*expRapida(b,n.length()-1-j);
          }
         return acum;
        }


        /**
         * Calcula los valores que cumplen la identidad de Bezout
         */
        public static double[] identidad(double x,double y)throws Exception
        {

            double c,aux;
            double j1,j2,j3,k1,k2,k3,l1,l2,l3;

            if((x<0) || (y<0))
                  throw new Exception("Los números deben ser positivos");
            j1=x; j3=y; l1=1; l3=0;  k1=0; k3=1;

            while (j3!=0)
            {
                c=java.lang.Math.floor(j1/j3);
                j2=j1%j3; l2=l1-c*l3; k2=k1-c*k3;
                j1=j3; j3=j2; l1=l3;
                l3=l2; k1=k3; k3=k2;
            }
            double[] res = new double[2];
            res[0]=l1; res[1]=k1;
            return res;
    }
      /** Cálculo del máximo común divisor siguiendo el algoritmo de Euclides */

        public static double mcd(double x,double y )
        {
            double a,b;
            a = x; b = y;
            while( a != b )
            {
               if( a < b )
                  b = b - a;
               else
                  a = a - b;
              }
            return(a);
        }

        /* Funcion principal */
        public static void main(String args[]){
 	}

}