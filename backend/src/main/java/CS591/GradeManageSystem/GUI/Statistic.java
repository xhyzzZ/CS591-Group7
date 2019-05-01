package CS591.GradeManageSystem.GUI;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Statistic extends JPanel{
	private JLabel label=new JLabel("Statistics:");
	private JComboBox chooseHW = new JComboBox();
	private JButton cal=new JButton("Calculate");
	private JButton back=new JButton("back");
	
	Statistic() {
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
	}
}

