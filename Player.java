import java.awt.*;
import java.awt.event.*;

public class Player
{
	private int x, y, b;
	private int width, height;
	private boolean left, right, up, down, restart, pause,p;

	public Player(int passedX, int passedY)
	{
		x = passedX;
		y = passedY;
		width = 15;
		height = 30/2;
	}
	public void setX(int newY)
		{
			x=newY;
	}
	public boolean restarts()
	{
		if(restart)
			return true;
		return false;
	}
	public boolean paused()
	{
		if(pause&&p)
			p=false;
		else if(pause&&!p)
			p=true;
		return p;
	}
	public void reset()
	{
		x=220;
		restart=false;
	}
	public void update(Enemy enemy, wall l, wall r, acorn[] ac)
	{
		move();
		checkCollision(l, r);
		checkAcorn(ac);
	}

	public void move()
	{
		if(left)
		{
			x-=5;
		}
		if(right)
		{
			x+=5;
		}

	}
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void keyPressed(KeyEvent key)
	{
		switch(key.getKeyCode())
		{

			case KeyEvent.VK_LEFT:
			left = true;
			break;
			case KeyEvent.VK_RIGHT:
			right = true;
			break;

			case KeyEvent.VK_R:
			restart=true;
			break;
			case KeyEvent.VK_P:
			pause=true;
			break;
		}
	}
	public int rand()
	{
		return b;
	}
	public void randome(acorn[] acr)
	{int f=0;
	b=0;
	int ddd=0;
		while(f<acr.length)
		{
			f=0;
		ddd=(int)(Math.random()*470)+10;
		for(acorn c: acr)
		{
			if(!(ddd<=c.getX()-5&&c.getX()-5<=ddd+35&&ddd<=c.getX()+15&&c.getX()+15<=ddd+35))
				f++;
		}
	}
	x=ddd;
	}

	public void keyReleased(KeyEvent key)
	{
		switch(key.getKeyCode())
		{
			case KeyEvent.VK_UP:
			up = false;
			break;
			case KeyEvent.VK_DOWN:
						b=1;
			break;
			case KeyEvent.VK_LEFT:
			left = false;
			break;
			case KeyEvent.VK_RIGHT:
			right = false;
			break;

		}
	}

	public Rectangle getRectangle()
	{
		return new Rectangle(x,y,width,height);
	}

	public void checkCollision(wall l, wall r)
	{
		if(getRectangle().intersects(l.getRectangle()))  //intersects is a method of the Rectangle class
		{
			if(x>445)
				x=445;

		}
		if(getRectangle().intersects(r.getRectangle()))  //intersects is a method of the Rectangle class
				{
					if(x<10)
						x=10;

		}
	}
	public boolean checkAcorn(acorn[] ac)
	{
		for(acorn acor:ac)
				{
					if(getRectangle().intersects(acor.getRectangle()))
					return true;
		}
		return false;
	}

	public void draw(Graphics2D g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(x,y,width, height);
	}
}