import java.awt.*;
import java.awt.event.*;

public class wall
{
	private int x, y;
	private int width, height;
	public wall(int xx, int yy)
	{
		x=xx;
		y=yy;
		width=10;
		height=500;
	}
	public Rectangle getRectangle()
		{
			return new Rectangle(x, y, width, height);
	}
	public void draw(Graphics2D g)
		{
			g.setColor(Color.yellow);
			g.fillRect(x,y,width, height);
	}
}