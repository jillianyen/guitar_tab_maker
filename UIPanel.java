import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//panel with ui buttons eg back, space, shift buttons, and labels
public class UIPanel extends JPanel implements ActionListener, KeyListener
{
	G2Frame frame;
	JButton backspace;
	JButton spaceButton;
	JButton shiftButton; 
	JLabel shiftPressedLabel;//red or green indicator
	JLabel shiftOnOffLabel;//text "on" or "off" label
	boolean shiftOn = false;
	int shiftCount = 0; 
	
	UIPanel(G2Frame frame)
	{
		this.frame = frame;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		placeUIButtons();
		placeLabels();
	}
	//place back, space, and shift buttons on panel
	public void placeUIButtons()
	{
		backspace = new JButton("back");
		backspace.setOpaque(true);
		backspace.setBackground(Color.gray);
		backspace.setForeground(Color.white);
		backspace.setBounds(500,230,125,60);
		backspace.setFocusable(false);
		frame.getLPane().add(backspace);
		backspace.addActionListener(this);
		
		spaceButton = new JButton("space");
		spaceButton.setOpaque(true);
		spaceButton.setBackground(Color.gray);
		spaceButton.setForeground(Color.white);
		spaceButton.setBounds(630,230,125,60);
		spaceButton.setFocusable(false);
		frame.getLPane().add(spaceButton);
		spaceButton.addActionListener(this);
		
		shiftButton = new JButton("shift");
		shiftButton.setOpaque(true);
		shiftButton.setBackground(Color.gray);
		shiftButton.setForeground(Color.white);
		shiftButton.setBounds(130,230,125,60);
		shiftButton.setFocusable(false);
		frame.getLPane().add(shiftButton);
		shiftButton.addActionListener(this);
		
		shiftPressedLabel = new JLabel();
		shiftPressedLabel.setOpaque(true);
		shiftPressedLabel.setBounds(105,247,10,10);
		shiftPressedLabel.setBackground(Color.RED);
		frame.getLPane().add(shiftPressedLabel);
		
		shiftOnOffLabel = new JLabel("off");
		shiftOnOffLabel.setOpaque(true);
		shiftOnOffLabel.setBounds(102,255,25,19);
		frame.getLPane().add(shiftOnOffLabel);
	}
	//place the eBGDAE side label
	public void placeLabels()
	{
		JLabel e = new JLabel("e");
		e.setOpaque(true);
		e.setBounds(0,0,30,30);
		e.setHorizontalAlignment(JLabel.CENTER);
		frame.getLPane().add(e);
		
		JLabel B = new JLabel("B");
		B.setOpaque(true);
		B.setBounds(0,35,30,30);
		B.setHorizontalAlignment(JLabel.CENTER);
		frame.getLPane().add(B);
		
		JLabel G = new JLabel("G");
		G.setOpaque(true);
		G.setBounds(0,67,30,30);
		G.setHorizontalAlignment(JLabel.CENTER);
		frame.getLPane().add(G);
		
		JLabel D = new JLabel("D");
		D.setOpaque(true);
		D.setBounds(0,100,30,30);
		D.setHorizontalAlignment(JLabel.CENTER);
		frame.getLPane().add(D);
		
		JLabel A = new JLabel("A");
		A.setOpaque(true);
		A.setBounds(0,135,30,30);
		A.setHorizontalAlignment(JLabel.CENTER);
		frame.getLPane().add(A);
		
		JLabel E = new JLabel("E");
		E.setOpaque(true);
		E.setBounds(0,165,30,30);
		E.setHorizontalAlignment(JLabel.CENTER);
		frame.getLPane().add(E);
	}
	@Override
	public void keyPressed(KeyEvent ev)
	{
		int code = ev.getKeyCode();
		if(code==32) {//spacebar
			frame.getConfig().appendBeat();
			frame.getConfig().printStrings();
		}
		if(code==8) {//backspace
			if(frame.getConfig().tabEmpty()==true) {
				frame.getConfig().deleteBeat();//delete one char at a time
			}else {
				frame.getConfig().deleteNote();//delete one note at a time
			}
			frame.getConfig().printStrings();
		}
		if(code==16) {//shift
			if(!shiftOn) {
				frame.getConfig().appendBeat();
			}
			shiftCount++;
			shiftOn = true;
			shiftPressedLabel.setBackground(Color.GREEN);
			shiftOnOffLabel.setText("on");
		}
	}
	@Override
	public void keyReleased(KeyEvent ev)
	{
		if(ev.getKeyCode()==16) {
			shiftCount++;
			shiftOn = false;
			shiftPressedLabel.setBackground(Color.RED);
			shiftOnOffLabel.setText("off");
			frame.getConfig().makeSameLength();
			frame.getConfig().appendBeat();
			frame.getConfig().printStrings();
		}
	}
	@Override
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource()==spaceButton) {
			frame.getConfig().appendBeat();
			frame.getConfig().printStrings();
		}
		if(ev.getSource()==backspace) {
			if(frame.getConfig().tabEmpty()==true) {
				frame.getConfig().deleteBeat();//delete one char at a time
			}else {
				frame.getConfig().deleteNote();//delete one note at a time
			}
			frame.getConfig().printStrings();
		}
		if(ev.getSource()==shiftButton) {
			shiftCount++;
			if(shiftCount%2==0) {
				frame.getConfig().appendBeat();
				shiftPressedLabel.setBackground(Color.RED);
				shiftOnOffLabel.setText("off");
				shiftOn=false;
				frame.getConfig().makeSameLength();
				frame.getConfig().printStrings();
			} else {
				frame.getConfig().appendBeat();
				shiftPressedLabel.setBackground(Color.GREEN);
				shiftOnOffLabel.setText("on");
				shiftOn = true;
			}
		}
	}
	public boolean getShift()
	{
		return shiftOn;
	}
	@Override//not used
	public void keyTyped(KeyEvent ev){}
}
