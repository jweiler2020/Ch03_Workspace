import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.util.Scanner;

public class FootTest extends JPanel
{
	private Image shoe;

	private char option;

	// Constructor
	public FootTest(char userChoice)
	{
		shoe = (new ImageIcon("leftshoe.gif")).getImage();
		option = userChoice;
	}

	// Called automatically when the panel needs repainting
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		int x = 300;
		int y = 100;
		int stepLength = 100;

		Foot foot = new Foot(x, y, shoe);

		if(option == 'a')
		{
			// A
			foot.turn(-90);
			for(int i = 0; i < 4; i++)
			{
				foot.draw(g);
				foot.moveSideways(stepLength);
			}
		}
		else if(option == 'b')
		{
			// B
			foot.turn(-90);
			for (int i = 0; i < 4; i++)
			{
				foot.draw(g);
				foot.moveForward(-stepLength);
			}
		}
		else if(option == 'c')
		{
			// C
			for (int i = 0; i < 4; i++)
			{
				foot.draw(g);
				foot.moveForward(stepLength / 2);
				foot.turn(90);
				foot.moveForward(stepLength / 2);
			}
		}

		// Draw a cursor at the expected center of the first "shoe":
		g.drawLine(x - 50, y, x + 50, y);
		g.drawLine(x, y - 50, x, y + 50);
	}

	public static void main(String[] args)
	{
		JFrame window = new JFrame("Feet");
		window.setBounds(100, 100, 500, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter which one you want to do (a,b,c): ");
		char userChoice = kb.nextLine().toLowerCase().charAt(0);

		FootTest panel = new FootTest(userChoice);
		panel.setBackground(Color.WHITE);
		Container c = window.getContentPane();
		c.add(panel);

		window.setVisible(true);
	}
}