package javatv2;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class SimpleWebBrowser extends JPanel {

  public SimpleWebBrowser(int tab) {
    super(new BorderLayout());
    JPanel webBrowserPanel = new JPanel(new BorderLayout());
    final JWebBrowser webBrowser = new JWebBrowser();
    if(tab==0)
    	webBrowser.navigate("https://www.youtube.com/embed/qq82Q_oxzfw"); //cctv
    else if(tab==1)
    	webBrowser.navigate("https://www.youtube.com/embed/YyiwBOOGvj0"); //arirang
    else if(tab==2)
	    webBrowser.navigate("https://www.youtube.com/embed/gq11un3xqsA"); //france24
    else if(tab==3)
    	webBrowser.navigate("https://www.youtube.com/embed/gNosnzCaS4I"); //dw
    webBrowser.setBarsVisible(false);
    webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
    add(webBrowserPanel, BorderLayout.CENTER);    
  }

}
