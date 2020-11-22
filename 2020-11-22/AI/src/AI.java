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
	Image heroImg[][]= new Image[4][3];
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg =heroImg[3][1];
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
				currentImg=heroImg[0][0];
			}
			else
			{
			    currentImg=heroImg[0][2]; 	    
			}
			x=x-1;

		}
		else if(action ==RIGHT){

			if(x%2==0)
			{
				currentImg=heroImg[1][0];
			}
			else
			{
			  	currentImg=heroImg[1][2];
			}x=x+1;

			}
		else if(action == DOWN){
			if(y%2==0)
			{
					currentImg=heroImg[3][0];
			}
			else
			{
				currentImg=heroImg[3][2];
			}y=y+1;
		 }	
		else if(action ==UP){
				if(y%2==0)
			{
				currentImg=heroImg[2][0];
			}
			else
			{
			  	currentImg=heroImg[2][2];
			}y=y-1;

		}
		
	else {
	        currentImg =heroImg[3][1];
			}
		repaint();
	}
}