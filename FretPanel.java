import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

//contains main panel and fretboard buttons and actionlistener for those buttons
public class FretPanel extends JPanel implements ActionListener
{
	JPanel sideButtons;
	JButton[][] neckButtons;
	GuitarFrame frame; 
	
	String e = "e|--";
	String B = "B|--";
	String G = "G|--";
	String D = "D|--";
	String A = "A|--";
	String E = "E|--";
	
	FretPanel(GuitarFrame frame)
	{
		this.frame = frame;
		setLayout(new GridLayout(6,20));
		neckButtons = new JButton[6][20];
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
	public void deleteBeat()//delete the very last char on each string
	{
		e = e.substring(0,e.length()-1);
		B = B.substring(0,B.length()-1);
		G = G.substring(0,G.length()-1);
		D = D.substring(0,D.length()-1);
		A = A.substring(0,A.length()-1);
		E = E.substring(0,E.length()-1);
	}
	public void deleteNote()//delete end of every string until last note
	{
		reverseAll();
		int smallest;
		int ei = firstNumIndex(e);
		int Bi = firstNumIndex(B);
		int Gi = firstNumIndex(G);
		int Di = firstNumIndex(D);
		int Ai = firstNumIndex(A);
		int Ei = firstNumIndex(E);
		smallest = smallesti(ei,Bi,Gi, Di,Ai,Ei);
		reverseAll();
		deleteUntilSmallest(smallest);
	}
	//only used in reverseAll
	public String reverse(String string)
	{
		char ch;
		String reversedString = "";
		for (int i=0; i<string.length(); i++) {
			ch = string.charAt(i);
			reversedString = ch+reversedString;
	    }
		return reversedString;
	}
	public void reverseAll()
	{
		e = reverse(e);
		B = reverse(B);
		G = reverse(G);
		D = reverse(D);
		A = reverse(A);
		E = reverse(E);
	}
	public int firstNumIndex(String str)
	{
		int count = 1; 
		for(int i = 0; i<str.length();i++) {
			if(str.charAt(i) == '-') {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
	public int smallesti(int e, int B, int G, int D, int A, int E)
	{
		int[] temp = {e,B,G,D,A,E};
		Arrays.sort(temp);
		return temp[0];
	}
	public void deleteUntilSmallest(int i)
	{
		e = e.substring(0,e.length()-i);
		B = B.substring(0,B.length()-i);
		G = G.substring(0,G.length()-i);
		D = D.substring(0,D.length()-i);
		A = A.substring(0,A.length()-i);
		E = E.substring(0,E.length()-i);
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
					if(frame.getMiscPanel().getShift() == true)//doing chords or simultaneous notes
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
					else //arpeggio
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
	}
	public void lastChare(String sym)
	{
		e=e.substring(0,e.length()-1)+sym;
	}
	public void lastCharB(String sym)
	{
		B=B.substring(0,B.length()-1)+sym;
	}
	public void lastCharG(String sym)
	{
		G=G.substring(0,G.length()-1)+sym;
	}
	public void lastCharD(String sym)
	{
		D=D.substring(0,D.length()-1)+sym;
	}
	public void lastCharA(String sym)
	{
		A=A.substring(0,A.length()-1)+sym;
	}
	public void lastCharE(String sym)
	{
		E=E.substring(0,E.length()-1)+sym;
	}
	
	public void addOnee()
	{
		e+="-";
	}
	public void addOneB()
	{
		B+="-";
	}
	public void addOneG()
	{
		G+="-";
	}
	public void addOneD()
	{
		D+="-";
	}
	public void addOneA()
	{
		A+="-";
	}
	public void addOneE()
	{
		E+="-";
	}
	
	public String gete()
	{
		return e;
	}
	public String getB()
	{
		return e;
	}
	public String getG()
	{
		return G;
	}
	public String getD()
	{
		return D;
	}
	public String getA()
	{
		return A;
	}
	public String getE()
	{
		return E;
	}
}
