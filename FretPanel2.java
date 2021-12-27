import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

//panel with slide hammer pull buttons
public class FretPanel2 extends JPanel implements ActionListener
{

	G2Frame frame;
	JButton[][] buttons;
	
	FretPanel2(G2Frame frame)
	{
		this.frame = frame;
		setLayout(new GridLayout(6,3));
		buttons = new JButton[6][3];
		buildButtons();
	}
	public void buildButtons()
	{
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				buttons[i][j].setFocusable(false);
				buttons[i][j].setBackground(new Color(92,66,47));//brown
				buttons[i][j].setForeground(new Color(245,235,193));//yellow
				add(buttons[i][j]);
				if(j==0) {
					buttons[i][j].setText("/");
				}
				if(j==1) {
					buttons[i][j].setText("h");
				}
				if(j==2) {
					buttons[i][j].setText("p");
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent ev)
	{
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length; j++) {
				if(ev.getSource() == buttons[i][j]) {
					if(i==0) {//e-----------
						if(j==0) {
							frame.getConfig().lastChare("/");
						}
						if(j==1) {
							frame.getConfig().lastChare("h");
						}
						if(j==2) {
							frame.getConfig().lastChare("p");
						}
					}
					if(i==1) {//B-----------
						if(j==0) {
							frame.getConfig().lastCharB("/");
						}
						if(j==1) {
							frame.getConfig().lastCharB("h");
						}
						if(j==2) {
							frame.getConfig().lastCharB("p");
						}
					}
					if(i==2) {//G-----------
						if(j==0) {
							frame.getConfig().lastCharG("/");
						}
						if(j==1) {
							frame.getConfig().lastCharG("h");
						}
						if(j==2) {
							frame.getConfig().lastCharG("p");
						}
					}
					if(i==3) {//D-----------
						if(j==0) {
							frame.getConfig().lastCharD("/");
						}
						if(j==1) {
							frame.getConfig().lastCharD("h");
						}
						if(j==2) {
							frame.getConfig().lastCharD("p");
						}
					}
					if(i==4) {//A-----------
						if(j==0) {
							frame.getConfig().lastCharA("/");
						}
						if(j==1) {
							frame.getConfig().lastCharA("h");
						}
						if(j==2) {
							frame.getConfig().lastCharA("p");
						}
					}
					if(i==5) {//E-----------
						if(j==0) {
							frame.getConfig().lastCharE("/");
						}
						if(j==1) {
							frame.getConfig().lastCharE("h");
						}
						if(j==2) {
							frame.getConfig().lastCharE("p");
						}
					}
				}
			}
		}
	}
}
