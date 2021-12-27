import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class G2Frame extends JFrame
{
	StringConfig config;//where all the methods that have to do with printing the tab
	FretPanel fretPanel; //panel that displays the fretboard buttons
	FretPanel2 fretPanel2; //panel that displays the slide, hammer, pull buttons
	UIPanel uiPanel;//panel that has ui buttons
	JLayeredPane mainPane = new JLayeredPane();//main pane that all panels are placed on
	
	int frameWidth = 1400;
	int frameHeight = 350;
	int fretWidth = 1200;
	int fretHeight = 200;
	int fret2Width = 130;
	G2Frame()
	{
	//setting up main pane
		mainPane.setBounds(0, 0, frameWidth, frameHeight);
		mainPane.setOpaque(true);
		add(mainPane);
	//setting up FretPanel, panel with main fretboard buttons
		fretPanel = new FretPanel(this);
		fretPanel.setOpaque(true);
		fretPanel.setBounds(30,0,fretWidth, fretHeight);
		mainPane.add(fretPanel);
	//setting up FretPanel2, panel with slide, hammer, pull buttons
		fretPanel2 = new FretPanel2(this);
		fretPanel2.setOpaque(true);
		fretPanel2.setBounds(fretWidth+35,0,fret2Width,fretHeight);
		mainPane.add(fretPanel2);
	//setting of UIPanel, panel with back, space, shift buttons and labels
		uiPanel = new UIPanel(this);
		uiPanel.setOpaque(true);
		mainPane.add(uiPanel);
	//add string config
		config = new StringConfig();
	//setting up frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);
		setTitle("Guitar Tab Maker");
		setLayout(null);//manually placing panels
		setVisible(true);
	//print initial string tab
		config.printStrings();
	}
	public JLayeredPane getLPane()
	{
		return mainPane;
	}
	public StringConfig getConfig()
	{
		return config;
	}
	public UIPanel getUI()
	{
		return uiPanel;
	}
}
