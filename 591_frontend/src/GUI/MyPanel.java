package GUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	ImageIcon icon = new ImageIcon();
	Image img=icon.getImage();
	MyPanel(){
		
	}
	
	  MyPanel(String s){
//		 super();
//		 this.icon = new ImageIcon(s); 
//         this.img = icon.getImage();  
         //g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());  
	  };
	  protected void paintComponent(Graphics g) {  
          super.paintComponent(g);
          
          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
      }  
	  
	  public void setPic(String s) {
		  icon = new ImageIcon(s);
		  img=icon.getImage();
		  repaint();
		  
	  }

}
