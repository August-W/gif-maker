package javatv2;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

public class GuiVision {
	static JFrame frame = new JFrame("Java TV");
	static JTabbedPane tabbedPane = new JTabbedPane();
	static String[] names = new String[6];
    static JComponent[] panels = new JComponent[6];
    
	public static void main(String[] args) {
	    NativeInterface.open();
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	    	  names[0]="CCTV";
	    	  names[1]="Arirang";
	    	  names[2]="France24";
	    	  names[3]="DW";
	    	  for(int i=0;i<4;i++){
	    		  panels[i] = new SimpleWebBrowser(i); 
	    		  tabbedPane.addTab(names[i], panels[i]);
	    	  }
	          frame.add(tabbedPane);
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.setSize(800, 600);
	          frame.setLocationByPlatform(true);
	          frame.setVisible(true);
	      }
	    });
	    NativeInterface.runEventPump();
	  }
}
