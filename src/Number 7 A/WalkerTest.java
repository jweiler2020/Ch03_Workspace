import java.awt.*;
import javax.swing.*;

public class WalkerTest extends JPanel
{
	private Walker walker;

	public WalkerTest()
	{
		Image leftShoe = new ImageIcon("leftshoe.gif").getImage();
		Image rightShoe = new ImageIcon("rightshoe.gif").getImage();
		walker = new Walker(-50, 300, leftShoe, rightShoe);
	}

	public void paintComponent(Graphics g)
	{
		for (int i = 0; i < 4; i++)
		{
			walker.firstStep();
			walker.stop();
			walker.draw(g);
		}
	}

	public static void main(String[] args)
	{
		JFrame window = new JFrame("WalkerTest");
		window.setBounds(100, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		WalkerTest panel = new WalkerTest();
		panel.setBackground(Color.WHITE);
		Container c = window.getContentPane();
		c.add(panel);

		window.setVisible(true);
	}
}
