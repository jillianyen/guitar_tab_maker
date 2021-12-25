import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//panel that contains the back, space, and shift button. also contains the side "eBGDAE" labels that appear on left side of fretboard
//also contains keypressed stuff
//TODO: make sure inititial shift press adds a beat
public class MiscPanel extends JPanel implements ActionListener, KeyListener
{
	GuitarFrame frame;
	JButton backspace;
	JButton spaceButton;
	JButton shiftButton; 
	JLabel shiftPressedLabel;
	JLabel shiftOnOffLabel;
	boolean shiftOn = false;
	int shiftCount = 0; 
	
	String e;
	String B;
	String G;
	String D;
	String A;
	String E;
	
	MiscPanel (GuitarFrame frame)
	{
		this.frame = frame;
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
		createSideLabels();
		
		e = frame.getFretPanel().gete();
		B = frame.getFretPanel().getB();
		G = frame.getFretPanel().getG();
		D = frame.getFretPanel().getD();
		A = frame.getFretPanel().getA();
		E = frame.getFretPanel().getE();
		
		backspace = new JButton("back");
		backspace.setOpaque(true);
		backspace.setBackground(Color.gray);
		backspace.setForeground(Color.white);
		backspace.setBounds(830,240,125,90);
		backspace.setFocusable(false);
		frame.getLPane().add(backspace);
		backspace.addActionListener(this);
		
		spaceButton = new JButton("space");
		spaceButton.setOpaque(true);
		spaceButton.setBackground(Color.gray);
		spaceButton.setForeground(Color.white);
		spaceButton.setBounds(700,240,125,90);
		spaceButton.setFocusable(false);
		frame.getLPane().add(spaceButton);
		spaceButton.addActionListener(this);
		
		shiftButton = new JButton("shift");
		shiftButton.setOpaque(true);
		shiftButton.setBackground(Color.gray);
		shiftButton.setForeground(Color.white);
		shiftButton.setBounds(758,340,140,80);
		shiftButton.setFocusable(false);
		frame.getLPane().add(shiftButton);
		shiftButton.addActionListener(this);
		
		shiftPressedLabel = new JLabel();
		shiftPressedLabel.setOpaque(true);
		shiftPressedLabel.setBounds(795,425,10,10);
		shiftPressedLabel.setBackground(Color.RED);
		frame.getLPane().add(shiftPressedLabel);
		
		shiftOnOffLabel = new JLabel("shift off");
		shiftOnOffLabel.setOpaque(true);
		shiftOnOffLabel.setBounds(810,425,100,10);
		frame.getLPane().add(shiftOnOffLabel);
	}
	public void createSideLabels()
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
	public void actionPerformed(ActionEvent ev)
	{//BUTTONS
		if(ev.getSource() == backspace)
		{
			//checking if any string has a number in it
			if(checkForNums(frame.getFretPanel().gete())==true||checkForNums(frame.getFretPanel().getB())==true||checkForNums(frame.getFretPanel().getG())==true||checkForNums(frame.getFretPanel().getD())==true||checkForNums(frame.getFretPanel().getA())==true||checkForNums(frame.getFretPanel().getE())==true)
			{//if it does have a number, delete until last note
				frame.getFretPanel().deleteNote();
			} else {//else delete only one beat at a time
				frame.getFretPanel().deleteBeat();
			}
			frame.getFretPanel().printStrings();
		}
		if(ev.getSource() == spaceButton)
		{
			frame.getFretPanel().appendBeat();
			frame.getFretPanel().printStrings();
		}
		if(ev.getSource() == shiftButton)
		{
			shiftCount++;
			if(shiftCount%2==0) {
				frame.getFretPanel().appendBeat();
				shiftPressedLabel.setBackground(Color.RED);
				shiftOnOffLabel.setText("shift off");
				shiftOn = false;
				checkLength();
				frame.getFretPanel().printStrings();
			} else {
				frame.getFretPanel().appendBeat();
				shiftPressedLabel.setBackground(Color.GREEN);
				shiftOnOffLabel.setText("shift on");
				shiftOn = true;
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		if(code == 16) { //shift
			if(!shiftOn) {//so a space is added before adding simultaneous notes, only needed for keypressed
				frame.getFretPanel().appendBeat();
			}
			shiftCount++;
			shiftOn = true;
			shiftPressedLabel.setBackground(Color.GREEN);
			shiftOnOffLabel.setText("shift on");
		}
		if(code == 32) {//space
			frame.getFretPanel().appendBeat();
			frame.getFretPanel().printStrings();
		}
		if(code == 8) {//backspace
			frame.getFretPanel().deleteNote();
			frame.getFretPanel().printStrings();
		}
	}
	@Override
	public void keyReleased(KeyEvent ev)
	{
		int code = ev.getKeyCode();
		if(code == 16) { //shift
			shiftCount++;
			shiftOn = false;
			shiftPressedLabel.setBackground(Color.RED);
			shiftOnOffLabel.setText("shift off");
			checkLength();
			frame.getFretPanel().appendBeat();
			frame.getFretPanel().printStrings();
		}
	}
	public boolean getShift()
	{
		return shiftOn;
	}
	//when doing shift simultaneous notes, check the length of each string so that they end up being the same length after
	public void checkLength()
	{
		int lengthe = frame.getFretPanel().gete().length();
		int lengthB = frame.getFretPanel().getB().length();
		int lengthG = frame.getFretPanel().getG().length();
		int lengthD = frame.getFretPanel().getD().length();
		int lengthA = frame.getFretPanel().getA().length();
		int lengthE = frame.getFretPanel().getE().length();
		
		//so the number of chars is the same in each string after doing shift notes
		if(lengthe<lengthE||lengthe<lengthA||lengthe<lengthD||lengthe<lengthG||lengthe<lengthB) {
			frame.getFretPanel().addOnee();
		} if(lengthE<lengthA||lengthE<lengthD||lengthE<lengthG||lengthE<lengthB||lengthE<lengthe) {
			frame.getFretPanel().addOneE();
		} if(lengthA<lengthE||lengthA<lengthD||lengthA<lengthG||lengthA<lengthB||lengthA<lengthe) {
			frame.getFretPanel().addOneA();
		} if(lengthD<lengthE||lengthD<lengthA||lengthD<lengthG||lengthD<lengthB||lengthD<lengthe) {
			frame.getFretPanel().addOneD();
		} if(lengthG<lengthE||lengthG<lengthA||lengthG<lengthD||lengthG<lengthB||lengthG<lengthe) {
			frame.getFretPanel().addOneG();
		} if(lengthB<lengthE||lengthB<lengthA||lengthB<lengthD||lengthB<lengthG||lengthB<lengthe) {
			frame.getFretPanel().addOneB();
		}
	}
	//check if there are nums in string
	public boolean checkForNums(String str)
	{
		boolean containsDigit = false;
	    if (str != null && !str.isEmpty()) {
	        for (char c : str.toCharArray()) {
	            if (containsDigit = Character.isDigit(c)) {
	                break;
	            }
	        }
	    }
	    return containsDigit;
	}
}
