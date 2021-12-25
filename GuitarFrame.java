import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuitarFrame extends JFrame
{
	FretPanel fretPanel;
	FretPanel2 fretPanel2;
	MiscPanel panel2;
	JLayeredPane lPane = new JLayeredPane();
	
	GuitarFrame()
	{ 
		lPane.setBounds(0,0,1400,500);//right, down, width, height
		this.add(lPane); 
		fretPanel = new FretPanel(this);
		fretPanel.setOpaque(true);
		fretPanel.setBounds(30,0,1200,200);
		lPane.add(fretPanel);
		
		fretPanel2 = new FretPanel2(this);
		fretPanel2.setOpaque(true);
		fretPanel2.setBounds(1235, 0, 130, 200); 
		lPane.add(fretPanel2);
		
		panel2 = new MiscPanel(this); //the black buttons
		panel2.setOpaque(true);
		lPane.add(panel2);//make keys pressed work
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension (1350,500));
		this.setLayout(null);
		this.setResizable(false);
		//setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public JLayeredPane getLPane()
	{
		return lPane;
	}
	public FretPanel getFretPanel()
	{
		return fretPanel;
	}
	public MiscPanel getMiscPanel()
	{
		return panel2;
	}
}

