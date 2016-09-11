package hw;


import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Mypart1 {

  
   public static void main(String[] args) {
	   	double scale = Double.parseDouble(args[1]);
	   	int lines = Integer.parseInt(args[0]);
	   	int alias = Integer.parseInt(args[2]);
	    int width = 512;
	    int height = width;
	    int x1 = width/2, y1 = height/2;	//get the center
	    double cutOff = 2*(Math.PI/lines);
	    System.out.println(cutOff);
	    double slope = 0;
	    int dark_pix = 0xff000000 | ((0 & 0xff) << 16) | ((0 & 0xff) << 8) | (0 & 0xff);
	    boolean anchor_x;					//judge the way up or down
	    
	    //Draw the picture with all white and initialized size
	    
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
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
	    	double degree = cutOff*i+0.5;
	    	System.out.println(degree);
	    	
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
		int Width2 = (int)Math.floor(width/scale);
		int Height2 = Width2;
		BufferedImage img1 = new BufferedImage(Width2, Height2,
				BufferedImage.TYPE_INT_RGB);
	    if(alias==0){
//		int Width2 = (int)Math.floor(width/scale);
//		int Height2 = Width2;
//		BufferedImage img1 = new BufferedImage(Width2, Height2,
//				BufferedImage.TYPE_INT_RGB);
		for(int m = 0; m < Width2; m++){
			for(int j = 0; j < Height2; j++)
			{
				int x = (int)Math.floor(m*scale);
				int y = (int)Math.floor(j*scale);
				img1.setRGB(m, j, img.getRGB(x, y));
			}
		}
	   }
	    else{
			for(int m = 0; m < Width2; m++){
				for(int j = 0; j < Height2; j++)
				{
					int x = (int)Math.floor(m*scale);
					int y = (int)Math.floor(j*scale);
					img1.setRGB(m, j, img.getRGB(x, y));
//					 		for (int v = 1; v <= height - 2; v++) {
//					 			for (int u = 1; u <= width - 2; u++) {
//								    int sum1 = 0;
//								    int sum2 =0 ;
//								    int sum3 = 0;
//								    int pr = 0;
//								    int pg = 0;
//								    int pb = 0;
//								    for (int jb = v-1; jb <= v+1; jb++) {
//								    	for (int i = u-1; i <= u+1; i++) {
//										      pr = (img.getRGB(jb, i) & 0xff0000) >> 16;
//										      pg = (img.getRGB(jb, i) & 0xff0000) >> 8;
//										      pb = (img.getRGB(jb, i) & 0xff0000);
//										      sum1 = sum1 + pr;
//										      sum2 = sum2 + pg;
//										      sum3 = sum3 + pb;
//								    	}
//								    }
//								    int q1 = (int) (sum1 / 9.0);
//								    int q2 = (int) (sum2 / 9.0);
//								    int q3 = (int) (sum3 / 9.0);
//						    
//								    int new_pix =  (255 << 24) | (q1 << 16) | (q2 <<8 )| q3;//
//									img1.setRGB(m, j, new_pix);
//						   }
//						  }
				}
			}
			
			for (int v = 1; v <= Height2 - 2; v++) {
	 			for (int u = 1; u <= Width2 - 2; u++) {
				    int sum1 = 0;
				    int sum2 =0 ;
				    int sum3 = 0;
				    int pr = 0;
				    int pg = 0;
				    int pb = 0;
				    for (int jb = v-1; jb <= v+1; jb++) {
				    	for (int i = u-1; i <= u+1; i++) {
						      pr = (img1.getRGB(jb, i) & 0xff0000) >> 16;
						      pg = (img1.getRGB(jb, i) & 0x00ff00) >> 8;
						      pb = (img1.getRGB(jb, i) & 0x0000ff);
						      sum1 = sum1 + pr;
						      sum2 = sum2 + pg;
						      sum3 = sum3 + pb;
				    	}
				    }
				    int q1 = (int) (sum1 / 9.0);
				    int q2 = (int) (sum2 / 9.0);
				    int q3 = (int) (sum3 / 9.0);
		    
				    int new_pix =  (0xff000000) | (q1 << 16) | (q2 <<8 )| q3;//
					img1.setRGB(v, u, new_pix);
		   }
		  }
	    	
	    }
	//save image to png format so that you can check   
    try{
        BufferedImage bi = img;
        File f = new File("MyLine.png");
        ImageIO.write(bi, "PNG", f);
    }
    catch(Exception e){
        e.printStackTrace();
    }
    

    // Use a panel and label to display the image
    JPanel  panel = new JPanel ();
    panel.add (new JLabel (new ImageIcon (img)));
    panel.add (new JLabel (new ImageIcon (img1)));
    
    JFrame frame = new JFrame("Display images");
    
    frame.getContentPane().add (panel);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   }
}