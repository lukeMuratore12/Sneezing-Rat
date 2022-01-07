import java.awt.*;
import java.awt.event.*;

public class sideMenu
{
	private int x, y;
	private int width, height;
	public sideMenu(int xx, int yy)
	{
		x=xx;
		y=yy;
		width=100;
		height=500;
	}
	public Rectangle getRectangle()
		{
			return new Rectangle(x, y, width, height);
	}
	public void draw(Graphics2D g)
		{
			g.setColor(Color.red);
			g.fillRect(x,y,width, height);
	}
}