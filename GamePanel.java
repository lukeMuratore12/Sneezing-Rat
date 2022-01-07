import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class GamePanel extends JPanel implements Runnable, KeyListener
{
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;

	private JFrame window;

	//game thread
	private Thread thread;
	private boolean running;
	private int FPS = 70; //change this to change FPS
	private long targetTime = 1000/FPS;  //number of milliseconds between frames. Don't change

	//image
	private BufferedImage image;
	private Graphics2D g;

	private Player player;
	private Enemy enemy;
	private wall lWall, rWall;
    private acorn[] a;
	private Timer t;
	private TimerTask task;
	private int secondsPassed;
	private JLabel timelabel, sneezeLabel;
	private sideMenu sm;
	private String ready;

	public GamePanel(JFrame window)
	{
		super();
		this.window = window;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);


	}

	public void init()
	{
		t = new Timer();
		task = new TimerT();
		secondsPassed=0;
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		ready="Ready";
		timelabel=new JLabel("Time: "+secondsPassed);
		sneezeLabel=new JLabel("Sneeze Label"+ready);
		player = new Player(250,400);
		enemy = new Enemy(125, 0);
		lWall=new wall(0,0);
		rWall=new wall(475, 0);
		sm=new sideMenu(485, 0);
		a=new acorn[20];
		for(int b=0;b<a.length;b++)
		{
		acorn ac=new acorn((int)(Math.random()*440)+20,100);
		 a[b] = ac;
	 }
		running = true;
		thread = new Thread(this);
		thread.start();

	}

	@Override
	public void run()    //The main game loop. This controls the game
	{
		boolean t=false;
		boolean p=false;
		while(running)
		{
			long start;
			long elapsed;
			long wait;  //how much time is left until next update


			start = System.nanoTime();

			window.setSize(new Dimension(WIDTH, HEIGHT));
			if(!t&&!p)
			{
			update();
			draw(g);
			drawToScreen();
			while(player.rand()>0)

				player.randome(a);


		    }


			if(player.checkAcorn(a))
			t=true;

			if(player.paused()&&p)
				p=false;
			if(player.paused()&&!p)
				p=true;

			if(player.restarts())
			{
			for(acorn acr:a){
				acr.setY(50);
				acr.speedChange();
			}

			player.setX(230);
			t=false;
			player.reset();
			}


			elapsed = System.nanoTime() - start;

			wait = targetTime - elapsed / 10000000; //necessary because targetTime is in milliseconds

			try
			{
				if(wait > 0)
				{
					Thread.sleep(wait);     //keeps the game from updating too fast
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();     //this is here as a formality. Basically it's watching for an error that will never occur
			}

		}
	}

	//appropriate to check for collisions, update movement, etc.
	private void update()
	{
		player.update(enemy, rWall, lWall, a);
		enemy.update(player);
		player.checkAcorn(a);
		for(acorn ac: a)
			ac.fall();
	}

	//where things get drawn. Passing g to the draw method of other classes allows them to draw on the screen.
	private void draw(Graphics2D g)
	{
		player.draw(g);
		enemy.draw(g);
		rWall.draw(g);
		lWall.draw(g);
		sm.draw(g);
		for(acorn ac:a)
			ac.draw(g);
	}

	//don't change.
	private void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g2.dispose();
		g.clearRect(0,0,WIDTH,HEIGHT);
	}

	@Override
	public void keyPressed(KeyEvent key)
	{
		player.keyPressed(key);
	}

	@Override
	public void keyReleased(KeyEvent key)
	{
		player.keyReleased(key);
	}

	public void keyTyped(KeyEvent arg0) {}  //not used

}
