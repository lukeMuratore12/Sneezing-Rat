import javax.swing.*;
import java.awt.*;

//Starts the game. The only thing that should be changed in this class is the name of the game in the JFrame constructor
public class GameStart
{
	public static void main(String args[])
	{
		JFrame window = new JFrame("Sneezing Rat");  //this affects the name on top of the window
		window.setLayout(new GridLayout(2, 1));
		GamePanel gp = new GamePanel(window);
		window.setContentPane(gp);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.pack();
		JPanel jp=new JPanel();
		JLabel cb = new JLabel();
		jp.setBackground(Color.white);
		window.add(jp);
		cb.setIcon(new ImageIcon("1280px-CollegeBoard.svg.png"));
		jp.add(cb);
		window.setVisible(true);
		gp.init();

	}
}
