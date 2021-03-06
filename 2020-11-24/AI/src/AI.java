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
class MainCanvas extends Canvas implements Runnable
{
    Thread thread;
	int heroX,heroY;
	int bossX,bossY;
	int flag;
	Image currentImg;
	Image heroImg[][]= new Image[4][3];
	Image bossImg;
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg =heroImg[3][1];
			flag=1;
			bossX=0;
			bossY=0;
			heroX=120;
			heroY=120;
            thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){
	while(true){
		try{
		Thread.sleep(250);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	  if(bossX<heroX){
	  bossX++;
	  }
	  else{
	  bossX--;
	  }
	   if(bossY<heroY){
	  bossY++;
	  }
	  else{
	  bossY--;
	  }
	  repaint();
		  }
		}
	public void paint(Graphics g){
		g.setColor(200,80,120);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
    	g.drawImage(bossImg,bossX,bossY,0);

	}
	public void ChangeAndMove(int diretion){
		if(flag==1){
			currentImg =heroImg[diretion][0];
			System.out.println("qqq");
			flag=2;
			}
		else if(flag==2){
			currentImg =heroImg[diretion][2];
			flag=1;
			}
		}

	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		if(action == LEFT){
          ChangeAndMove(0);
		  heroX=heroX-3;
		}
		if(action ==RIGHT){
          ChangeAndMove(1);
	      heroX=heroX+3;
		}
		if(action == DOWN){
			ChangeAndMove(3);
			heroY=heroY+3;	
		}
		if(action ==UP){
		  ChangeAndMove(2);
		  heroY=heroY-3;
		}	
	
	}
}