import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x,y;
	Image currentImg;
    Image heroLeftImg[]= new Image[3];
	Image heroRightImg[]= new Image[3];
	Image heroUpImg[]= new Image[3];
	Image heroDownImg[]= new Image[3];
	public MainCanvas(){
		try
		{
			//вС
			for(int i=0;i<heroLeftImg.length;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}	
           //ср
			for(int i=0;i<heroRightImg.length;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			} 
			
			// ио
            for(int i=0;i<heroUpImg.length;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			} 
			//об
            for(int i=0;i<heroDownImg.length;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			currentImg =heroDownImg[1];
			x=120;
			y=120;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		if(action == LEFT){
			if(x%2==0)
			{
				currentImg=heroLeftImg[0];
			}
			else
			{
			   currentImg=heroLeftImg[2]; 	    
			}
			x=x-1;

		}
		else if(action ==RIGHT){

			if(x%2==0)
			{
				currentImg=heroRightImg[0];
			}
			else
			{
			   currentImg=heroRightImg[2];
			}x=x+1;

			}
		else if(action == DOWN){
			if(y%2==0)
			{
				currentImg=heroDownImg[0];
			}
			else
			{
			   currentImg=heroDownImg[2];
			}y=y+1;
		 }	
		else if(action ==UP){
				if(y%2==0)
			{
				currentImg=heroUpImg[0];
			}
			else
			{
			   currentImg=heroUpImg[2]; 	
			}y=y-1;

		}
		
	else {
	        currentImg =heroDownImg[1];
			}
		repaint();
	}
}