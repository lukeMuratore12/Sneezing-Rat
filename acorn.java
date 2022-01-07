import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class acorn
{
	private int x, y, c;
	private int width, height;
	private Color color;
	double fallspeed;
	Color[] colorList = {Color.RED, Color.GRAY, Color.PINK, Color.WHITE, Color.LIGHT_GRAY, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.CYAN};
	public acorn(int passedX, int passedY)
	{
		x=passedX;
		y=passedY;
		int d =(int)(Math.random()*25)+5;
		int p =(int)(Math.random()*25)+5;
		width=d;
		height=p;
		fallspeed=Math.random()*3+1;
		color = colorList[(int)(Math.random()*9)];
	}
	public void fall()
	{
		y+=fallspeed;
		if(y>490)
		{
			y=100;
			x=(int)(Math.random()*440)+20;
			double sp=Math.random();
			if(sp>.5&&sp<.9)
			fallspeed++;
			else if(sp>.9)
			fallspeed+=2;
			else if(sp<.2&&fallspeed>1)
			fallspeed--;
			int d =(int)(Math.random()*25)+5;
			int p =(int)(Math.random()*25)+5;
			width=d;
			height=p;
			c++;
			if(c==10)
			{
				fallspeed=0;
				y=-1000;
			}
		}

	}
	public void setY(int newY)
	{
		y=newY;
	}
	public int getX()
	{
		return x;
	}
	public void speedChange()
	{
		fallspeed=Math.random()*4+2;
	}
	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}
	public void draw(Graphics2D g)
	{	
		g.setColor(color);
		g.fillRect(x,y,width, height);
	}
}