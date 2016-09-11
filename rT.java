package hw;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class rT extends JLabel implements Runnable {
    int width =512;
    int height = 512;
    double accelerate = 0.1;
    int lines;
    double scale;
    double alia;
    boolean isOrigin;

    public rT (int lines, double scale, double alia,boolean isOrigin ){
    	this.lines = lines;
    	this.scale = scale;
    	this.alia = alia;
    	this.isOrigin = isOrigin;
    }
    
    
    public static void rotateTheImg(BufferedImage img, int lines, int width, int height,double accelerate){
	   double cutOff = 2*(Math.PI/lines);
	   int dark_pix = 0xff000000 | ((0 & 0xff) << 16) | ((0 & 0xff) << 8) | (0 & 0xff);
//	   double accelerate = 0.1;
	   int x1 = width/2, y1 = height/2;
//	   double accelerate +=2*(Math.PI/(lines-10));			   	
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				byte r = (byte)255;
				byte g = (byte)255;
				byte b = (byte)255;
				int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
				img.setRGB(x,y,pix);
			}
		}
	    for(int i = 0; i < lines; i++){
	    	double degree = cutOff*i+accelerate;
//	    	System.out.println(degree);
//	    	
	    	while(degree>2*(Math.PI)){
	    		degree = degree - 2*(Math.PI);
	    	}
	    	
	    	if(degree==0.0){
	    		for(int y = y1; y < height; y++){
	    			int x=x1;
	    			img.setRGB(x, y, dark_pix);
	    		}
	    	}
	    	if(degree==(Math.PI/2)){
	    		for(int x = x1; x < width; x++){
	    			int y=y1;
	    			img.setRGB(x, y, dark_pix);
	    		}
	    	}
	    	if(degree==(Math.PI)){
	    		for(int y = y1; y >= 0 ; y--){
	    			int x=x1;
	    			img.setRGB(x, y, dark_pix);
	    		}
	    	}
	    	if(degree==3*(Math.PI/2)){
	    		for(int x = x1; x >= 0; x--){
	    			int y=y1;
	    			img.setRGB(x, y, dark_pix);
	    		}
	    	}
	    	if((degree <= (Math.PI/4))&&(degree > 0.0)){
	    		double y = y1+0.5;
	    		for(int x = x1; x < width-1; x++){
	    			y += Math.tan(degree); 
	    			img.setRGB(x, (int)Math.floor(y), dark_pix);
	    		}
	    	}
	    	if((degree > (Math.PI/4))&&(degree < (Math.PI/2))){
	    		double x = x1+0.5;
	    		for(int y = y1; y < height-1; y++){
	    			x += 1/Math.tan(degree); 
	    			img.setRGB((int)Math.floor(x),y, dark_pix);
	    		}
	    	}
	    	
	    	if((degree < 3*(Math.PI/4))&&(degree > (Math.PI/2))){
	    		double x = x1+0.5;
	    		for(int y = y1; y < height-1; y++){
	    			x += 1/Math.tan(degree); 
	    			img.setRGB((int)Math.floor(x),y, dark_pix);
	    		}
	    	}
	    	if((degree >= 3*(Math.PI/4))&&(degree < (Math.PI))){
	    		double y = y1+0.5;
	    		for(int x = x1; x > 1;  x--){
	    			y -= Math.tan(degree); 
	    			img.setRGB(x, (int)Math.floor(y), dark_pix);
	    		}
	    	}
	    	
	    	if((degree <= 5*(Math.PI/4))&&(degree > (Math.PI))){
	    		double y = y1+0.5;
	    		for(int x = x1; x > 1;  x--){
	    			y -= Math.tan(degree); 
	    			img.setRGB(x, (int)Math.floor(y), dark_pix);
	    		}
	    	}
	    	
	    	if((degree < 3*(Math.PI/2))&&(degree > 5*(Math.PI/4))){
	    		double x = x1+0.5;
	    		for(int y = y1; y > 1; y--){
	    			x -= 1/Math.tan(degree); 
	    			img.setRGB((int)Math.floor(x),y, dark_pix);
	    		}
	    	}
	    	
	    	if((degree <= 7*(Math.PI/4))&&(degree > 3*(Math.PI/2))){
	    		double x = x1+0.5;
	    		for(int y = y1; y > 1; y--){
	    			x -= 1/Math.tan(degree); 
	    			img.setRGB((int)Math.floor(x),y, dark_pix);
	    		}
	    	}
	    	
	    	if((degree < 2*(Math.PI))&&(degree > 7*(Math.PI/4))){
	    		double y = y1+0.5;
	    		for(int x = x1; x < width-1; x++){
	    			y += Math.tan(degree); 
	    			img.setRGB(x, (int)Math.floor(y), dark_pix);
	    		}
	    	}
	    }
		   
//		   try{
////		       BufferedImage bi = img;
////		       File f = new File("MyLine.png");
////		       ImageIO.write(bi, "PNG", f);
//		   }
//		   catch(Exception e){
//		       e.printStackTrace();
//		   }
		}

   @Override
   public void run() { 
//		    int width =512;
//		    int height = 512;
//		    double accelerate = 0.1;
//		    int lines = 60;
//		    int scale =3;
//		    JFrame frame = new JFrame("Display images");
//		    JPanel  panel = new JPanel ();
//		    frame.getContentPane().add (panel);
//		    frame.pack();
//		    frame.setVisible(true);
//		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		    setIcon(new ImageIcon(img));
			while(true){
					try {
						if(isOrigin){
							Thread.sleep(1);
							accelerate +=(2*Math.PI*scale)/1000;
						}
						else{
							Thread.sleep((int)(1000/alia));
							accelerate +=(2*Math.PI*scale)/alia;
							System.out.println((2*Math.PI*scale)/alia);
						}
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					accelerate +=(2*Math.PI*scale)/20;
					rotateTheImg(img,lines,width,height,accelerate);
					setIcon(new ImageIcon(img));
//					rotateTheImg(img2,lines,width,height,accelerate);
//			repaint();
//	
		   }
	
	   }
   
}