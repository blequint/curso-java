package encriptacion;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;

/* Las funciones que no son de la interfaz están al final de este archivo */

/**
 * <p>Title: Interfaz para los cifradores</p>
 * @author Juan Ant. Recio
 * @version 1.0
 */

public class Interfaz4 extends JApplet {
  boolean isStandalone = false;
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  Border border1;
  Border border2;
  TitledBorder titledBorder1;
  JTextPane textoClaro = new JTextPane();
  JScrollPane jScrollPane1 = new JScrollPane(textoClaro);
  Border border3;
  TitledBorder titledBorder2;
  JLabel jLabel1 = new JLabel();
  JTextPane textoEncriptado = new JTextPane();
  JScrollPane jScrollPane2 = new JScrollPane(textoEncriptado);
  JLabel jLabel2 = new JLabel();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JButton jButton4 = new JButton();
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JButton jButton5 = new JButton();
  JLabel jLabel3 = new JLabel();
  JTextField textoAlfabeto = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField jTextField1 = new JTextField();
  JTextField jTextField2 = new JTextField();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField jTextField3 = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextField jTextField4 = new JTextField();
  JLabel jLabel9 = new JLabel();
  JTextField jTextField5 = new JTextField();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JTextField jTextField6 = new JTextField();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();

  //Get a parameter value
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  //Construct the applet
  public Interfaz4() {
  }
  //Initialize the applet
  public void init() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //Component initialization
  private void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(134, 134, 134));
    border2 = BorderFactory.createEtchedBorder(Color.white,new Color(178, 178, 178));
    titledBorder1 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(178, 178, 178),new Color(124, 124, 124)),"Texto claro");
    border3 = BorderFactory.createEtchedBorder(Color.white,new Color(134, 134, 134));
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(134, 134, 134)),"");
    this.setSize(new Dimension(600,450));
    jPanel1.setMinimumSize(new Dimension(600, 450));
    jPanel1.setPreferredSize(new Dimension(600, 450));
    jPanel1.setLayout(null);
    jPanel2.setBorder(border1);
    jPanel2.setBounds(new Rectangle(9, 8, 581, 290));
    jPanel2.setLayout(null);
    jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
    jScrollPane1.setPreferredSize(new Dimension(380, 150));
    jScrollPane1.setBounds(new Rectangle(7, 29, 270, 220));
    jLabel1.setText("Texto claro");
    jLabel1.setBounds(new Rectangle(6, 6, 216, 24));
    jScrollPane2.setBounds(new Rectangle(300, 29, 270, 220));
    jLabel2.setText("Texto encriptado");
    jLabel2.setBounds(new Rectangle(291, 8, 185, 21));
    jButton1.setBounds(new Rectangle(498, 254, 70, 26));
    jButton1.setText("Borrar");
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        jButton1_mouseClicked(e);
      }
    });
    jButton2.setText("Borrar");
    jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        jButton2_mouseClicked(e);
      }
    });
    jButton2.setBounds(new Rectangle(8, 254, 70, 26));
    jButton3.setBounds(new Rectangle(170, 254, 105, 26));
    jButton3.setForeground(Color.red);
    jButton3.setText("Encriptar");
    jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        jButton3_mouseClicked(e);
      }
    });
    jButton4.setText("Desencriptar");
    jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        jButton4_mouseClicked(e);
      }
    });
    jButton4.setBounds(new Rectangle(298, 254, 105, 26));
    jButton4.setForeground(Color.red);
    jTabbedPane1.setBounds(new Rectangle(10, 309, 578, 107));
    jButton5.setBounds(new Rectangle(84, 254, 77, 26));
    jButton5.setText("Quijote");
    jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        jButton5_mouseClicked(e);
      }
    });
    jLabel3.setText("Alfabeto");
    jLabel3.setBounds(new Rectangle(11, 424, 51, 21));
    textoAlfabeto.setToolTipText("el caracter de salto de linea se añade automaticamente");
    textoAlfabeto.setText("abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ .,:;1234567890@");
    textoAlfabeto.setBounds(new Rectangle(65, 423, 522, 21));
    jPanel3.setLayout(null);

    jPanel4.setLayout(null);

    jPanel5.setLayout(null);
    jLabel4.setText("Introduzca 2 numeros primos");
    jLabel4.setBounds(new Rectangle(7, 8, 177, 22));
    jTextField1.setText("929");
    jTextField1.setBounds(new Rectangle(195, 9, 162, 21));
    jTextField2.setBounds(new Rectangle(394, 9, 162, 21));
    jTextField2.setText("919");
    jLabel5.setBounds(new Rectangle(6, 35, 558, 20));
    jLabel6.setBounds(new Rectangle(5, 55, 558, 21));
    jLabel7.setText("Numero Primo (grande):");
    jLabel7.setBounds(new Rectangle(4, 10, 142, 17));
    jTextField3.setText("919");
    jTextField3.setBounds(new Rectangle(146, 9, 60, 19));
    jLabel8.setText("Elto primitivo de Zp:");
    jLabel8.setBounds(new Rectangle(219, 11, 119, 17));
    jTextField4.setBounds(new Rectangle(331, 10, 60, 19));
    jTextField4.setText("101");
    jLabel9.setText("Clave Privada:");
    jLabel9.setBounds(new Rectangle(403, 11, 89, 18));
    jTextField5.setBounds(new Rectangle(491, 10, 72, 19));
    jTextField5.setText("8");
    jLabel10.setBounds(new Rectangle(4, 31, 559, 26));
    jLabel11.setBounds(new Rectangle(5, 53, 559, 23));
    jLabel12.setText("Sucesion supercreciente:");
    jLabel12.setBounds(new Rectangle(6, 8, 149, 21));
    jTextField6.setText("1,2,5,12,30,72,150,411,900,1912");
    jTextField6.setBounds(new Rectangle(158, 7, 403, 21));
    jLabel13.setBounds(new Rectangle(6, 32, 554, 23));
    jLabel14.setBounds(new Rectangle(6, 51, 557, 24));
    jTabbedPane1.add("Mochila Tramposa",jPanel3);
    jPanel3.add(jTextField6, null);
    jPanel3.add(jLabel12, null);
    jPanel3.add(jLabel13, null);
    jPanel3.add(jLabel14, null);
    jTabbedPane1.add("El Gamal",jPanel4);
    jPanel4.add(jTextField3, null);
    jPanel4.add(jLabel7, null);
    jPanel4.add(jLabel8, null);
    jPanel4.add(jTextField4, null);
    jPanel4.add(jTextField5, null);
    jPanel4.add(jLabel9, null);
    jPanel4.add(jLabel10, null);
    jPanel4.add(jLabel11, null);
    jTabbedPane1.add("RSA",jPanel5);
    jPanel5.add(jLabel4, null);
    jPanel5.add(jTextField1, null);
    jPanel5.add(jTextField2, null);
    jPanel5.add(jLabel5, null);
    jPanel5.add(jLabel6, null);
    jPanel1.add(textoAlfabeto, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jPanel2, null);
    jPanel2.add(jScrollPane1, null);
    jPanel2.add(jLabel1, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jButton2, null);
    jPanel2.add(jButton3, null);
    jPanel2.add(jScrollPane2, null);
    jPanel2.add(jButton4, null);
    jPanel2.add(jButton1, null);
    jPanel2.add(jButton5, null);
    jPanel1.add(jTabbedPane1, null);
    this.getContentPane().add(jPanel1, BorderLayout.SOUTH);
  }
  //Start the applet
  public void start() {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ex) {}
  }
  //Stop the applet
  public void stop() {
  }
  //Destroy the applet
  public void destroy() {
  }
  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }
  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }
  //Main method
  public static void main(String[] args) {
    Interfaz4 applet = new Interfaz4();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setDefaultCloseOperation(3);
    frame.setTitle("Applet Frame");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(600,450);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }

  //static initializer for setting look & feel
  static {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch(Exception e) {
    }
  }

  void jButton2_mouseClicked(MouseEvent e) {
  textoClaro.setText("");
  }

  void jButton1_mouseClicked(MouseEvent e) {
  textoEncriptado.setText("");
  }

  void jButton5_mouseClicked(MouseEvent e) {
  cargarQuijote();
  }


  void jButton3_mouseClicked(MouseEvent e) {
  encripta();
  }

  void jButton4_mouseClicked(MouseEvent e) {
  desencripta();
  }

/******* aqui empiezan las funciones que no son de la interfaz **********/

  ClaseRSA cifradorRSA;
  ArrayList textoCifradoRSA;
  ClaseElGamal cifradorGamal;
  ArrayList textoCifradoGamal;
  CifradorMochila cMochila;
  int[] textoCifradoMochila;


  /**
   * Carga el texto predefinido
   */
  void cargarQuijote()
  {
  textoClaro.setText("la libertad, sancho, es uno de los mas preciosos dones que a los hombres dieron los cielos, con ella no pueden igualarse los tesoros que encierra la tierra ni el mar encubre. por la libertad, asicomo por la honra, se puede y debe aventurar la vida, y, por el contrario, el cautiverio es el mayor mal que puede venir a los hombres. digo esto, sancho, porque bien has visto el regalo, la abundancia que en este castillo que dejamos hemos tenido, pues en metad de aquellos banquetes sazonados y de aquellas bebidas de nieve, me parecia a mi que estaba metido entre las estrechezas de la hambre, porque no lo gozaba con la libertad que lo gozara si fueran mios, que las obligaciones de las recompensas de los beneficios y mercedes recebidas son ataduras que no dejan campear al animo libre. venturoso aquel a quien el cielo dio un pedazo de pan, sin que le quede obligacion de agradecerlo a otro que al mismo cielo.");
  textoClaro.setCaretPosition(0);
  }


  /**
   * llama a las distintas funciones de encriptacion
   */
 public void encripta()
  {
    textoEncriptado.setText("");
    String limpio = textoClaro.getText();
    String encrip = "";
    try
    {
      switch (jTabbedPane1.getSelectedIndex())
      {
        case 0:
          cMochila = new CifradorMochila(sucesion(),textoAlfabeto.getText());
          jLabel13.setText(cMochila.getClavePrivada());
          jLabel14.setText(cMochila.getClavePublica());
          textoCifradoMochila = cMochila.cifrar(limpio);
          encrip = cMochila.arrayACad(textoCifradoMochila);
          break;
        case 1:
          cifradorGamal = new ClaseElGamal(Integer.parseInt(jTextField3.getText()),Integer.parseInt(jTextField4.getText()),Integer.parseInt(jTextField5.getText()),textoAlfabeto.getText());
          jLabel10.setText(cifradorGamal.getClavePrivada());
          jLabel11.setText(cifradorGamal.getClavePublica());
          textoCifradoGamal = cifradorGamal.codificar(limpio);
          encrip = textoCifradoGamal.toString();
          break;
        case 2:
          cifradorRSA = new ClaseRSA(Integer.parseInt(jTextField1.getText()) ,Integer.parseInt(jTextField2.getText()),textoAlfabeto.getText());
          jLabel5.setText(cifradorRSA.getClavePrivada());
          jLabel6.setText(cifradorRSA.getClavePublica());
          textoCifradoRSA = cifradorRSA.codificar(limpio);
          encrip = textoCifradoRSA.toString();
          break;
      }
    textoEncriptado.setText(encrip);
    textoEncriptado.setCaretPosition(0);

    } catch (Exception ex)
    {
     JOptionPane.showMessageDialog(null, "Error al encriptar. "+ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * Llama  a las distintas funciones para desencriptar
  */

  public void desencripta()
  {
    textoClaro.setText("");
    String encrip = textoEncriptado.getText();
    String limpio = "";
    try
    {
      switch (jTabbedPane1.getSelectedIndex())
      {
        case 0:
          limpio = cMochila.descifrar(textoCifradoMochila);
          break;
        case 1:
          limpio = cifradorGamal.decodificar(textoCifradoGamal);
          break;
        case 2:
          limpio = cifradorRSA.decodificar(textoCifradoRSA);
          break;
      }
    textoClaro.setText(limpio);
    textoClaro.setCaretPosition(0);
    } catch (Exception ex)
    {
     JOptionPane.showMessageDialog(null, "Error al desencriptar. "+ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public int[] sucesion()
  {
    ArrayList lista = new ArrayList();
    String n = "";
    String linea = jTextField6.getText();
    // quito las comas
    for (int i = 0; i < linea.length(); i++)
    {
      if (linea.charAt(i)!=',')
        n = n+linea.charAt(i);
      else
      {
         lista.add(new Integer(n));
         n = "";
      }
    }
    lista.add(new Integer(n));
    int[] vector = new int[lista.size()];
    for (int i=0; i< lista.size();i++)
      vector[i]= ((Integer)lista.get(i)).intValue();
    return vector;
  }
}