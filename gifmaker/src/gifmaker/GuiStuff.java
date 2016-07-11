package gifmaker;

import java.awt.*;  
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
 
@SuppressWarnings("serial")
public class GuiStuff extends JFrame implements ActionListener, WindowListener {
   private JTextField tfInput;
   private JTextField tfInput2;
   private JButton btnStart;
   private long time;
   private long totalTime;
   private long track;
   
   //Constructor for GUI components and event handling
   public GuiStuff() {
      setLayout(new FlowLayout());                    // "super" Frame sets to FlowLayout
      add(new JLabel("Time per screenshot (ms)"));   // "super" Frame adds an anonymous Label
      tfInput = new JTextField("250", 4);           // Construct TextField
      add(tfInput);                                // "super" Frame adds TextField 
      add(new JLabel("Total time (ms)"));         // "super" Frame adds an anonymous Label
      tfInput2 = new JTextField("5000", 6);      // Construct TextField
      add(tfInput2);                            // "super" Frame adds TextField
      btnStart = new JButton("Start");         // Declare and allocate a Button
      add(btnStart);                          // "super" Frame adds btnCount
      btnStart.setToolTipText("Screen Capture Starts in 4 seconds");
      add(new JLabel("<html> Saves a gifmaker folder holding screenshots and the resulting .gif file, in the Public folder. <br> Screen capturing ends automatically once the the input Total Time is reached. <br> May your gifs forever be zesty. </html>"));
      try {
          BufferedImage img = ImageIO.read(new File("dank.png"));
          ImageIcon icon = new ImageIcon(img);
          add(new JLabel(icon));
       } catch (IOException e) {
          e.printStackTrace();
       } 
      btnStart.addActionListener(this);  
      addWindowListener(this);
      setTitle("Rapid Screenshots and Gif Maker!");
      setSize(600, 400);
      setVisible(true);
      new GifMaker();
   }

   public static void main(String[] args) {
      new GuiStuff();
   }
 
   /** ActionEvent handler */
   @Override
   public void actionPerformed(ActionEvent evt) {
      
    	File dir = new File("C://Users/Public/gifmaker");
    	dir.mkdir();
        time = Long.parseLong(tfInput.getText());
        totalTime = Long.parseLong(tfInput2.getText());
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
  		BufferedImage capture = null;
  		long start = System.currentTimeMillis();
  		track = start+4000;
  		int n=0;
  		BufferedImage[] tryit = new BufferedImage[200];
  		
  		while(System.currentTimeMillis()- start < totalTime + 4000){ 
  			System.out.print("while");
  			if(System.currentTimeMillis()-track>=time){
  				System.out.println(System.currentTimeMillis()-start+", "+time);
  				try {
					capture = new Robot().createScreenCapture(screenRect);
					tryit[n]=capture;
				} catch (AWTException e) {
					e.printStackTrace();
				}
  				try {
					ImageIO.write(capture, "png", new File("C://Users/Public/gifmaker/pic"+n+".png"));
					n++;
				} catch (IOException e) {
					e.printStackTrace();
				}
  				track+=time;
  			}
  		}
  		
  		BufferedImage[] trimmed = new BufferedImage[n];
  		for(int i=0; i<n; i++){
  			trimmed[i]=tryit[i];
  		}
  		
  		try {            
			GifMaker.makeGifs(new File("C://Users/Public/gifmaker/result.gif"), trimmed, time);
		} catch (Exception e1) {
			e1.printStackTrace();
		}  
   }//WindowEvent handlers
   @Override
   public void windowClosing(WindowEvent e) {
      System.exit(0);
   }// Not Used, but need to provide an empty body
   @Override
   public void windowOpened(WindowEvent e) { }
   @Override
   public void windowClosed(WindowEvent e) { }
   @Override
   public void windowIconified(WindowEvent e) { }
   @Override
   public void windowDeiconified(WindowEvent e) { }
   @Override
   public void windowActivated(WindowEvent e) { }
   @Override
   public void windowDeactivated(WindowEvent e) { }
}
