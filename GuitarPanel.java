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
	
	StringBuilder e = new StringBuilder("e|--");
	StringBuilder B = new StringBuilder("B|--");
	StringBuilder G = new StringBuilder("G|--");
	StringBuilder D = new StringBuilder("D|--");
	StringBuilder A = new StringBuilder("A|--");
	StringBuilder E = new StringBuilder("E|--");
	
	GuitarPanel(GuitarFrame frame)
	{
		this.frame = frame;
		setLayout(new GridLayout(6,20));
		neckButtons = new JButton[6][20];
		backspace = new JButton();
		backspace.setText("<-");
		backspace.addActionListener(this);
	//	add(backspace);
		spaceButton = new JButton();
		spaceButton.addActionListener(this);
	//	add(spaceButton);
		this.addKeyListener(this);
		buildNeck();
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
				neckButtons[i][j].setBackground(new Color(94,64,31));
				neckButtons[i][j].setForeground(Color.white);
				neckButtons[i][j].setText(""+j);
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
		e.append("-");
		B.append("-");
		G.append("-");
		D.append("-");
		A.append("-");
		E.append("-");
	}
	public void deleteBeat()
	{
		e.delete(e.length()-1, e.length());
		B.delete(B.length()-1, B.length());
		G.delete(G.length()-1, G.length());
		D.delete(D.length()-1, D.length());
		A.delete(A.length()-1, A.length());
		E.delete(E.length()-1, E.length());
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		System.out.println("HELLOW");
	}
	@Override
	public void actionPerformed(ActionEvent ev)
	{
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
		for(int i = 0; i < neckButtons.length; i++) 
		{
			for(int j = 0; j < neckButtons[i].length; j++) 
			{
				if(ev.getSource() == neckButtons[i][j])
				{
					if(i==0) 
					{
						if(j>9)
						{
							e.append(""+j);
							B.append("--");
							G.append("--");
							D.append("--");
							A.append("--");
							E.append("--");
							appendBeat();
							printStrings();
						}else {
							e.append(""+j);
							B.append("-");
							G.append("-");
							D.append("-");
							A.append("-");
							E.append("-");
							appendBeat();
							printStrings();
						}
					}
					if(i==1) 
					{
						if(j>9) {
						e.append("--");
						B.append(""+j);
						G.append("--");
						D.append("--");
						A.append("--");
						E.append("--");
						appendBeat();
						printStrings();
						}else {
						e.append("-");
						B.append(""+j);
						G.append("-");
						D.append("-");
						A.append("-");
						E.append("-");
						appendBeat();
						printStrings();
						}
					}
					if(i==2) 
					{
						if(j>9) {
						e.append("--");
						B.append("--");
						G.append(""+j);
						D.append("--");
						A.append("--");
						E.append("--");
						appendBeat();
						printStrings();
						} else {
						e.append("-");
						B.append("-");
						G.append(""+j);
						D.append("-");
						A.append("-");
						E.append("-");
						appendBeat();
						printStrings();
						}
					}
					if(i==3) 
					{
						if(j>9) {
						e.append("--");
						B.append("--");
						G.append("--");
						D.append(""+j);
						A.append("--");
						E.append("--");
						appendBeat();
						printStrings();
						} else {
						e.append("-");
						B.append("-");
						G.append("-");
						D.append(""+j);
						A.append("-");
						E.append("-");
						appendBeat();
						printStrings();
						}
					}
					if(i==4) 
					{
						if(j>9) {
						e.append("--");
						B.append("--");
						G.append("--");
						D.append("--");
						A.append(""+j);
						E.append("--");
						appendBeat();
						printStrings();
						} else {
						e.append("-");
						B.append("-");
						G.append("-");
						D.append("-");
						A.append(""+j);
						E.append("-");
						appendBeat();
						printStrings();
						}
					}
					if(i==5) 
					{
						if(j>9) {
						e.append("--");
						B.append("--");
						G.append("--");
						D.append("--");
						A.append("--");
						E.append(""+j);
						appendBeat();
						printStrings();
						} else {
						e.append("-");
						B.append("-");
						G.append("-");
						D.append("-");
						A.append("-");
						E.append(""+j);
						appendBeat();
						printStrings();
						}
					}
				}
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e){}
	
	@Override
	public void keyReleased(KeyEvent e) {}
}
