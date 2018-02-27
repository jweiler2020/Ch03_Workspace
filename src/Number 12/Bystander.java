import java.awt.*;

public class Bystander extends Walker
{
	private boolean footTurned;

	public Bystander(int x, int y, Image leftPic, Image rightPic)
	{
		super(x, y, leftPic, rightPic);
		footTurned = false;
	}

	// Overridden from Walker
	public void firstStep()
	{
		getLeftFoot().turn(-45);
		footTurned = true;
	}

	// Overridden from Walker
	public void nextStep()
	{
		if(footTurned)
			getLeftFoot().turn(45);
		else
			getLeftFoot().turn(-45);
		footTurned = !footTurned;
	}

	// Overridden from Walker
	public void stop()
	{
		if(footTurned)
			getLeftFoot().turn(45);
		footTurned = false;
	}
}
