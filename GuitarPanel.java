import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GuitarPanel extends JPanel implements ActionListener, KeyListener
{
	JButton[][] neckButtons;
	GuitarFrame frame; 
	JButton backspace;
	JButton spaceButton;//eg append beat
	boolean shift = false;
	
	String e = "e|--";
	String B = "B|--";
	String G = "G|--";
	String D = "D|--";
	String A = "A|--";
	String E = "E|--";
	

	
	GuitarPanel(GuitarFrame frame)
	{
		this.frame = frame;
		setLayout(new GridLayout(6,20));
		neckButtons = new JButton[6][20];
		buildNeck();
		backspace = new JButton();
		backspace.setText("<-");
		backspace.addActionListener(this);
	//	add(backspace);
		spaceButton = new JButton();
		spaceButton.addActionListener(this);
	//	add(spaceButton);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		printStrings();
	}
	//make grid of buttons. each button represents a string and fret
	public void buildNeck()
	{
		for(int i = 0; i < neckButtons.length; i++) {
			for(int j = 0; j < neckButtons[i].length; j++) {
				neckButtons[i][j] = new JButton();
				neckButtons[i][j].addActionListener(this);
				neckButtons[i][j].setFocusable(false);
				neckButtons[i][j].setBackground(new Color(92,66,47));//brown for background
				neckButtons[i][j].setForeground(new Color(245,235,193));//yellow for numbers text
				neckButtons[i][j].setText(""+j);
				//adding fret board colors
				if((i==1||i==2||i==3||i==4)&&(j==3||j==5||j==7||j==9||j==12||j==15||j==17)) {
					neckButtons[i][j].setBackground(Color.lightGray);
					neckButtons[i][j].setForeground(new Color(70,70,70));
				}
				add(neckButtons[i][j]);
			}
		}
	}
	public void printStrings()
	{
		System.out.println(e);
		System.out.println(B);
		System.out.println(G);
		System.out.println(D);
		System.out.println(A);
		System.out.println(E);
		System.out.println();
	}
	public void appendBeat()
	{
		e += "-";
		B += "-";
		G += "-";
		D += "-";
		A += "-";
		E += "-";
	}
	public void deleteBeat()
	{
		e = e.substring(0,e.length()-1);
		B = B.substring(0,B.length()-1);
		G = G.substring(0,G.length()-1);
		D = D.substring(0,D.length()-1);
		A = A.substring(0,A.length()-1);
		E = E.substring(0,E.length()-1);
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		//spacebar = 32. backspace = 8. shift = 16
		int code = e.getKeyCode();
		if(code == 32) {
			appendBeat();
			printStrings();
		}
		if(code == 8) {
			deleteBeat();
			printStrings();
		}
		if(code == 16) {
			if(!shift) {//so a space is added before adding simultaneous notes
				appendBeat();
			}
			shift = true;
		}
	}
	@Override
	public void actionPerformed(ActionEvent ev)
	{
		int laste = e.length()-1;
		int lastB = B.length()-1;
		int lastG = G.length()-1;
		int lastD = D.length()-1;
		int lastA = A.length()-1;
		int lastE = E.length()-1;
		
		for(int i = 0; i < neckButtons.length; i++) 
		{
			for(int j = 0; j < neckButtons[i].length; j++) 
			{
				if(ev.getSource() == neckButtons[i][j])
				{
					if(shift==true)//adding notes to different strings on the same beat (eg for chords)
					{
						if(i==0) 
						{
							//if last two elements in string are hyphens
							if(e.charAt(laste)=='-'&&e.charAt(laste-1)=='-') {
								e = e.substring(0,e.length()-1)+j;
								printStrings();
							}//if last element is number and second to last element is hyphen
							else if(e.charAt(laste)!='-'&&e.charAt(laste-1)=='-') {
								e = e.substring(0,e.length()-1)+j;
								printStrings();
							}//if last two elements are numbers
							else if(e.charAt(laste)!='-'&&e.charAt(laste-1)!='-') {
								e = e.substring(0,e.length()-1);
								e = e.substring(0,e.length()-1)+j;
								printStrings();
							}
							
						}
						if(i==1) 
						{
							//if last two elements in string are hyphens
							if(B.charAt(lastB)=='-'&&B.charAt(lastB-1)=='-') {
								B = B.substring(0,B.length()-1)+j;
								printStrings();
							}//if last element is number and second to last element is hyphen
							else if(B.charAt(lastB)!='-'&&B.charAt(lastB-1)=='-') {
								B = B.substring(0,B.length()-1)+j;
								printStrings();
							}//if last two elements are numbers
							else if(B.charAt(lastB)!='-'&&B.charAt(lastB-1)!='-') {
								B = B.substring(0,B.length()-1);
								B = B.substring(0,B.length()-1)+j;
								printStrings();
							}
						}
						if(i==2) 
						{
							//if last two elements in string are hyphens
							if(G.charAt(lastG)=='-'&&G.charAt(lastG-1)=='-') {
								G = G.substring(0,G.length()-1)+j;
								printStrings();
							}//if last element is number and second to last element is hyphen
							else if(G.charAt(lastG)!='-'&&G.charAt(lastG-1)=='-') {
								G = G.substring(0,G.length()-1)+j;
								printStrings();
							}//if last two elements are numbers
							else if(G.charAt(lastG)!='-'&&G.charAt(lastG-1)!='-') {
								G = G.substring(0,G.length()-1);
								G = G.substring(0,G.length()-1)+j;
								printStrings();
							}
						}
						if(i==3) 
						{
							//if last two elements in string are hyphens
							if(D.charAt(lastD)=='-'&&D.charAt(lastD-1)=='-') {
								D = D.substring(0,D.length()-1)+j;
								printStrings();
							}//if last element is number and second to last element is hyphen
							else if(D.charAt(lastD)!='-'&&D.charAt(lastD-1)=='-') {
								D = D.substring(0,D.length()-1)+j;
								printStrings();
							}//if last two elements are numbers
							else if(D.charAt(lastD)!='-'&&D.charAt(lastD-1)!='-') {
								D = D.substring(0,D.length()-1);
								D = D.substring(0,D.length()-1)+j;
								printStrings();
							}
						}
						if(i==4) 
						{
							//if last two elements in string are hyphens
							if(A.charAt(lastA)=='-'&&A.charAt(lastA-1)=='-') {
								A = A.substring(0,A.length()-1)+j;
								printStrings();
							}//if last element is number and second to last element is hyphen
							else if(A.charAt(lastA)!='-'&&A.charAt(lastA-1)=='-') {
								A = A.substring(0,A.length()-1)+j;
								printStrings();
							}//if last two elements are numbers
							else if(A.charAt(lastA)!='-'&&A.charAt(lastA-1)!='-') {
								A = A.substring(0,A.length()-1);
								A = A.substring(0,A.length()-1)+j;
								printStrings();
							}
						}
						if(i==5) 
						{
							//if last two elements in string are hyphens
							if(E.charAt(lastE)=='-'&&E.charAt(lastE-1)=='-') {
								E = E.substring(0,E.length()-1)+j;
								printStrings();
							}//if last element is number and second to last element is hyphen
							else if(E.charAt(lastE)!='-'&&E.charAt(lastE-1)=='-') {
								E = E.substring(0,E.length()-1)+j;
								printStrings();
							}//if last two elements are numbers
							else if(E.charAt(lastE)!='-'&&E.charAt(lastE-1)!='-') {
								E = E.substring(0,E.length()-1);
								E = E.substring(0,E.length()-1)+j;
								printStrings();
							}
						}
					}
					else //adding indiv notes on separate beats (eg arpeggio)
					{
						if(i==0) 
						{
							if(j>9) {
								e += j;
								B += "--";
								G += "--";
								D += "--";
								A += "--";
								E += "--";
								appendBeat();
								printStrings();
							} else {
								e += j;
								B += "-";
								G += "-";
								D += "-";
								A += "-";
								E += "-";
								appendBeat();
								printStrings();
							}
						}
						if(i==1) 
						{
							if(j>9) {
								e += "--";
								B += j;
								G += "--";
								D += "--";
								A += "--";
								E += "--";
								appendBeat();
								printStrings();
							} else {
								e += "-";
								B += j;
								G += "-";
								D += "-";
								A += "-";
								E += "-";
								appendBeat();
								printStrings();
							}
						}
						if(i==2) 
						{
							if(j>9) {
								e += "--";
								B += "--";
								G += j;
								D += "--";
								A += "--";
								E += "--";
								appendBeat();
								printStrings();
							} else {
								e += "-";
								B += "-";
								G += j;
								D += "-";
								A += "-";
								E += "-";
								appendBeat();
								printStrings();
							}
						}
						if(i==3) 
						{
							if(j>9) {
								e += "--";
								B += "--";
								G += "--";
								D += j;
								A += "--";
								E += "--";
								appendBeat();
								printStrings();
							} else {
								e += "-";
								B += "-";
								G += "-";
								D += j;
								A += "-";
								E += "-";
								appendBeat();
								printStrings();
							}
						}
						if(i==4) 
						{
							if(j>9) {
								e += "--";
								B += "--";
								G += "--";
								D += "--";
								A += j;
								E += "--";
								appendBeat();
								printStrings();
							} else {
								e += "-";
								B += "-";
								G += "-";
								D += "-";
								A += j;
								E += "-";
								appendBeat();
								printStrings();
							}
						}
						if(i==5) 
						{
							if(j>9) {
								e += "--";
								B += "--";
								G += "--";
								D += "--";
								A += "--";
								E += j;
								appendBeat();
								printStrings();
							} else {
								e += "-";
								B += "-";
								G += "-";
								D += "-";
								A += "-";
								E += j;
								appendBeat();
								printStrings();
							}
						}
					}
				}
			}
		}
		
		if(ev.getSource() == backspace)
		{
			deleteBeat();
			printStrings();
		}
		if(ev.getSource() == spaceButton)
		{
			appendBeat();
			printStrings();
		}
	}
	@Override
	public void keyTyped(KeyEvent e){}
	
	@Override
	public void keyReleased(KeyEvent ev) 
	{
		int lengthe = e.length();
		int lengthB = B.length();
		int lengthG = G.length();
		int lengthD = D.length();
		int lengthA = A.length();
		int lengthE = E.length();
		int code = ev.getKeyCode();
		if(code==16) {
			shift = false;
			if(lengthe<lengthE||lengthe<lengthA||lengthe<lengthD||lengthe<lengthG||lengthe<lengthB) {
				e+="-";
			} if(lengthE<lengthA||lengthE<lengthD||lengthE<lengthG||lengthE<lengthB||lengthE<lengthe) {
				E+="-";
			} if(lengthA<lengthE||lengthA<lengthD||lengthA<lengthG||lengthA<lengthB||lengthA<lengthe) {
				A+="-";
			} if(lengthD<lengthE||lengthD<lengthA||lengthD<lengthG||lengthD<lengthB||lengthD<lengthe) {
				D+="-";
			} if(lengthG<lengthE||lengthG<lengthA||lengthG<lengthD||lengthG<lengthB||lengthG<lengthe) {
				G+="-";
			} if(lengthB<lengthE||lengthB<lengthA||lengthB<lengthD||lengthB<lengthG||lengthB<lengthe) {
				B+="-";
			}
			appendBeat();
			printStrings();
		}
	}
}
