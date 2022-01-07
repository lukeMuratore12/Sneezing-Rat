import java.awt.*;
import java.util.ArrayList;
public class Enemy
{
	private int x, y;
	private int width, height;
	private Color color;
	Color[] colorList = {Color.RED, Color.GRAY, Color.PINK, Color.WHITE, Color.LIGHT_GRAY, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.CYAN};
	
	public Enemy(int passedX, int passedY)
	{
		x = passedX;
		y = passedY;
		width = 250;
		height = 50;
		color = colorList[(int)(Math.random()*9)];
	}

	public void update(Player p)
	{

	}



	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}

	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}

	public void draw(Graphics2D g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}