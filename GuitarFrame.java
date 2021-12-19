import javax.swing.JButton;
import javax.swing.JFrame;

public class GuitarFrame extends JFrame
{
	GuitarPanel panel;
//	TestPanel panel;
	GuitarFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300,300);
		panel = new GuitarPanel(this);
	//	panel = new TestPanel(this);
		this.add(panel);
		this.setVisible(true);
	}
}
