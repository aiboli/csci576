

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mypart2 {

    
    public static void main(String[] args) {
    	int lines = Integer.parseInt(args[0]);
    	double scale = Double.parseDouble(args[1]);
    	double alias = Double.parseDouble(args[2]);
    	
    	rT img1 = new rT(lines,scale,0,true);
    	rT img2 = new rT(lines,scale,alias,false);
    	JFrame frame = new JFrame("Display images");
    	JPanel panel = new JPanel();
    	panel.add(img1);
    	panel.add(img2);
    	frame.getContentPane().add (panel);
    	Thread rimg1 = new Thread(img1);
    	Thread rimg2 = new Thread(img2);
	    frame.pack();
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    rimg1.start();
	    rimg2.start();
        
        // You can call interrupt() if you want
        // to interrupt a thread. The thread itself
        // decides how to handle interrupts.
        // worker1.interrupt();
    }
    
}