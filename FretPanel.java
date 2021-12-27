import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

//panel with main fretboard buttons
public class FretPanel extends JPanel implements ActionListener
{
	JButton[][] neckButtons;
	G2Frame frame;
	
	FretPanel(G2Frame frame)
	{
		this.frame = frame;
		setLayout(new GridLayout(6,20));
		neckButtons = new JButton[6][20];
		buildNeck();
	}
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
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for(int i = 0; i < neckButtons.length; i++) {
			for(int j = 0; j < neckButtons[i].length; j++) {
				if(e.getSource() == neckButtons[i][j]) {
					if(frame.getUI().getShift()==false) {
						if(i==0) {
							if(j>9) {//add note at fret j to e string
								frame.getConfig().addeNote(1, j);
							}else {
								frame.getConfig().addeNote(2, j);
							}
						}
						if(i==1) {//add note at fret j to B string
							if(j>9) {
								frame.getConfig().addBNote(1, j);
							}else {
								frame.getConfig().addBNote(2, j);
							}				
						}
						if(i==2) {//add note at fret j to G string
							if(j>9) {
								frame.getConfig().addGNote(1, j);
							}else {
								frame.getConfig().addGNote(2, j);
							}
						}
						if(i==3) {//add note at fret j to D strign
							if(j>9) {
								frame.getConfig().addDNote(1, j);
							}else {
								frame.getConfig().addDNote(2, j);
							}
						}
						if(i==4) {//add note at fret j to A string
							if(j>9) {
								frame.getConfig().addANote(1, j);
							}else {
								frame.getConfig().addANote(2, j);
							}
						}
						if(i==5) {//add note at fret j to E string
							if(j>9) {
								frame.getConfig().addENote(1, j);
							}else {
								frame.getConfig().addENote(2, j);
							}
						}
					} else {
						if(i==0) {
							frame.getConfig().eshift(j);
						}
						if(i==1) {
							frame.getConfig().Bshift(j);
						}
						if(i==2) {
							frame.getConfig().Gshift(j);
						}
						if(i==3) {
							frame.getConfig().Dshift(j);
						}
						if(i==4) {
							frame.getConfig().Ashift(j);
						}
						if(i==5) {
							frame.getConfig().Eshift(j);
						}
					}
				}
			}
		}
	}
}
