package GUI;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Statistic extends JPanel{
	private JLabel label=new JLabel("Statistics:");
	private JComboBox chooseHW=new JComboBox();
	private JButton cal=new JButton("Calculate");
	private JButton back=new JButton("back");
	private static Font labelFont = new Font("Dialog", Font.PLAIN, 20);
	
	Statistic(){
		label.setFont(labelFont);
		cal.setFont(labelFont);
		back.setFont(labelFont);
		
		this.add(label);
		this.add(chooseHW);
		this.add(cal);
		this.add(back);
       }
	public JButton getCalButton() {
		return this.cal;
	}
	public JButton getBackButton() {
		return this.back;
	}
	public JComboBox getchooseHW() {
		return this.chooseHW;
	}
	
	public void SetforCombo(String[] t) {
		DefaultComboBoxModel model = new DefaultComboBoxModel(t);
		this.chooseHW.setModel(model);
		//this.chooseHW=new JComboBox(t);
	
	}
	
	}

