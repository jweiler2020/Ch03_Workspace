import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpinningFoot extends JPanel
	implements ActionListener
{
	private Foot foot;

	public SpinningFoot(int x, int y, Image pic)
	{
		foot = new Foot(x, y, pic);
		Timer clock = new Timer(30, this);
		clock.start();
	}

	public static void main(String[] args)
	{
		JFrame window = new JFrame("Spinning Foot");
		window.setBounds(100, 100, 800, 600);
		Container c = window.getContentPane();
		c.setBackground(Color.WHITE);
		SpinningFoot sf = new SpinningFoot(window.getWidth()/2, window.getHeight()/2, (new ImageIcon("leftshoe.gif")).getImage());
		c.add(sf);

		window.setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		foot.draw(g);
	}

	public void actionPerformed(ActionEvent e)
	{
		foot.turn(6);
		repaint();
	}
}
