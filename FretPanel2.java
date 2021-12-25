import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//panel that contains the "/,h,p" buttons
public class FretPanel2 extends JPanel implements ActionListener
{
	GuitarFrame frame;
	JButton[][] buttons;
	
	FretPanel2(GuitarFrame frame)
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
		for(int i = 0; i < buttons.length; i++) 
		{
			for(int j = 0; j < buttons[i].length; j++) 
			{
				if(ev.getSource() == buttons[i][j])
				{
					if(i==0) 
					{
						if(j==0) {
							frame.getFretPanel().lastChare("/");
							frame.getFretPanel().printStrings();
						}
						if(j==1) {
							frame.getFretPanel().lastChare("h");
							frame.getFretPanel().printStrings();
						}
						if(j==2) {
							frame.getFretPanel().lastChare("p");
							frame.getFretPanel().printStrings();
						}
					}
					if(i==1) 
					{
						if(j==0) {
							frame.getFretPanel().lastCharB("/");
							frame.getFretPanel().printStrings();
						}
						if(j==1) {
							frame.getFretPanel().lastCharB("h");
							frame.getFretPanel().printStrings();
						}
						if(j==2) {
							frame.getFretPanel().lastCharB("p");
							frame.getFretPanel().printStrings();
						}
					}
					if(i==2) 
					{
						if(j==0) {
							frame.getFretPanel().lastCharG("/");
							frame.getFretPanel().printStrings();
						}
						if(j==1) {
							frame.getFretPanel().lastCharG("h");
							frame.getFretPanel().printStrings();
						}
						if(j==2) {
							frame.getFretPanel().lastCharG("p");
							frame.getFretPanel().printStrings();
						}
					}
					if(i==3) 
					{
						if(j==0) {
							frame.getFretPanel().lastCharD("/");
							frame.getFretPanel().printStrings();
						}
						if(j==1) {
							frame.getFretPanel().lastCharD("h");
							frame.getFretPanel().printStrings();
						}
						if(j==2) {
							frame.getFretPanel().lastCharD("p");
							frame.getFretPanel().printStrings();
						}
					}
					if(i==4) 
					{
						if(j==0) {
							frame.getFretPanel().lastCharA("/");
							frame.getFretPanel().printStrings();
						}
						if(j==1) {
							frame.getFretPanel().lastCharA("h");
							frame.getFretPanel().printStrings();
						}
						if(j==2) {
							frame.getFretPanel().lastCharA("p");
							frame.getFretPanel().printStrings();
						}
					}
					if(i==5) 
					{
						if(j==0) {
							frame.getFretPanel().lastCharE("/");
							frame.getFretPanel().printStrings();
						}
						if(j==1) {
							frame.getFretPanel().lastCharE("h");
							frame.getFretPanel().printStrings();
						}
						if(j==2) {
							frame.getFretPanel().lastCharE("p");
							frame.getFretPanel().printStrings();
						}
					}
				}
			}
		}
	}
}
