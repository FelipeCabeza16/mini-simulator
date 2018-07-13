/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minisimulator;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Felipe Cabeza @felipe cabeza16
 */

public class MiniSimulator extends JFrame implements ActionListener {
int balls=8;
Random rn;   
JMenuBar jmenubar;
JMenuItem automate,background, exit, contact;
JMenu jmenu;
JButton simulate;
BigInteger color;
Container cn;
    public MiniSimulator(){
    super("Random Draw");  
    

    
    jmenubar = new JMenuBar();
    this.setJMenuBar(jmenubar);
    jmenu = new JMenu("Options"); 
    jmenubar.add(jmenu);
    
    automate = new JMenuItem("Automate");
    contact = new JMenuItem("Contact");
    background = new JMenuItem("Background Color");
   exit = new JMenuItem("Exit :(");
   jmenu.add(automate);
   jmenu.add(background);
   jmenu.add(contact);
   jmenu.add(exit);
   final int SHORTCUT_MASK =
           Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        
   automate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, SHORTCUT_MASK));
   automate.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { try {
                                   automate();
                                   } catch (AWTException ex) {
                                       Logger.getLogger(MiniSimulator.class.getName()).log(Level.SEVERE, null, ex);
                                   }
}

                 private void automate() throws AWTException {
                  Robot robot = new Robot();
               /*  int steps=10;
                  
                    for (int i=0; i<steps; i++)
                    {
                    robot.mouseMove(708, 730);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    System.out.println("Click "+i);
                    try { Thread.sleep(1000); } catch(Exception e) {} 
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    }
*/
                  //System.out.println(MouseInfo.getPointerInfo().getLocation());
//                  robot.mouseMove(300, 800);
                  
                 }
                  
   });
   
   
   background.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, SHORTCUT_MASK));
    background.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { background(); }

                 private void background() {
                    BigInteger color=null;
                     
                    try
                    { 
                        String hexcolor=null;
                            try
                            {
                            hexcolor = JOptionPane.showInputDialog("Please enter a color in hex, EXAMPLE FFFFFF or 0xffffff");
                            }catch(Exception e){System.out.println("Esc");}
                            
                        if (hexcolor.contains("0x"))
                        hexcolor = hexcolor.substring(2, hexcolor.length());
                         
                     
                     
                     color = new BigInteger(hexcolor, 16);
                    
                    }
                     catch ( NumberFormatException nfe )
                    {
                       JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                    } 
                     
                 changeColor(new Color(color.intValue()));
                 //cn.setBackground(Color.red);
                // changeColor(Color.RED);
                 }
            });
                 

         contact.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, SHORTCUT_MASK));
            contact.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { contact(); }

                 private void contact() {

                     String url = "https://www.twitter.com/FelipeCabeza16";
        Runtime aplication = Runtime.getRuntime();
        
        if (System.getProperty("os.name").equals("Linux"))
          
        {
                try{
                 aplication.exec("firefox --new-window https://www.twitter.com/FelipeCabeza16");
                } catch (Exception e){ 
                }
            
        }
        else{
           String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (osName.startsWith("Mac OS X")) {
                // Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                Runtime.getRuntime().exec("open " + url);
            } else {
                System.out.println("Please open a browser and go to "+ url);
            }
        } catch (IOException e) {
            System.out.println("Failed to start a browser to open the url " + url);
            e.printStackTrace();
        } 
            
        }
                 }
            });
    
         exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, SHORTCUT_MASK));
            exit.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { exit(); }

                 private void exit() {

                     System.exit(0);
                 }
            });    
    
    rn = new Random();
    simulate = new JButton("Simulate");
    setBounds(500,0,435,715);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cn = getContentPane();
    cn.setLayout(new BorderLayout());
    simulate.addActionListener(this);
    cn.add(simulate, BorderLayout.SOUTH);
 
    cn.setBackground(Color.gray);
try{
balls = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of circles"));    
}
catch ( NumberFormatException nfe )
{
    JOptionPane.showMessageDialog(null, "Please, enter a INT NUMBER!");
    System.exit(1);
    JOptionPane.showMessageDialog(null, "Exiting...!");
}
    setVisible(true);
    
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MiniSimulator q = new MiniSimulator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if (e.getSource() == simulate)
    {
       
            repaint();

       
    }
        }
    public void paint(Graphics g){
    super.paint(g);
    
//Color e = Color.getColor("ffff00");
    g.setColor(Color.BLUE);

    //System.out.println(Color.BLUE);
    
    /*
    THIS TOP OF THE BUCLE IT'S THE QUANTITY OF BLUE CIRCLES YOU CAN CHANGE IT   
    */





//int posX = rn.nextInt(400);
//int posY = rn.nextInt(400);
int x=0, y=0;
String number;
for (int i=0; i<balls; i++)
    {               //System.out.println("Height -->"+this.getSize().height+" and width -->" +this.getSize().width);
          
        x=rn.nextInt(400);
        y=rn.nextInt(600)+70;
        g.setColor(Color.blue);
        g.fillOval(x, y, 20, 20);
        g.setColor(Color.YELLOW); 
        number = String.valueOf(i+1);
        g.drawString(number, x, y);
    }
    }


    public void changeColor(Color color){
cn.setBackground(color);
}
}

