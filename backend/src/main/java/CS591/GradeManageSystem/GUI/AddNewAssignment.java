package CS591.GradeManageSystem.GUI;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddNewAssignment extends JPanel{
	private JLabel addassignmentLabel,extralabel ,totalPercentLabel, assignmentnameLabel, percentLabel, maximumLabel, deductpointLabel;
	private JTextField assignmentField, percentField, maximumField;
	private JCheckBox pointBox;

	// porblem bounsBox
	private JCheckBox bounsBox;
	private JButton confirmButton, cancelButton;
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 24);
	private static Font labelFont = new Font("Dialog", Font.ITALIC, 14);

	public AddNewAssignment() {

		super(null);

		totalPercentLabel = new JLabel("Current total: 0%");
		totalPercentLabel.setFont(labelFont);
		totalPercentLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalPercentLabel.setBounds(880, 240, 200, 40);

		addassignmentLabel = new JLabel("Add New Assignment");
		addassignmentLabel.setFont(labelFont_big);
		addassignmentLabel.setBounds(550, 100, 300, 50);
		addassignmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addassignmentLabel.setVerticalAlignment(SwingConstants.CENTER);

		assignmentnameLabel = new JLabel("Assignment Name:");
		assignmentnameLabel.setFont(labelFont);
		assignmentnameLabel.setVerticalAlignment(SwingConstants.CENTER);
		assignmentnameLabel.setBounds(520, 175, 240, 50);

		percentLabel = new JLabel("Percent in total criterion:");
		percentLabel.setFont(labelFont);
		percentLabel.setVerticalAlignment(SwingConstants.CENTER);
		percentLabel.setBounds(520, 225, 200, 50);

		extralabel = new JLabel("Extra Bonus?");
		extralabel.setFont(labelFont);
		extralabel.setVerticalAlignment(SwingConstants.CENTER);
		extralabel.setBounds(520, 375, 200, 50);

		maximumLabel = new JLabel("Maximum Points:");
		maximumLabel.setFont(labelFont);
		maximumLabel.setVerticalAlignment(SwingConstants.CENTER);
		maximumLabel.setBounds(520, 275, 200, 50);

		deductpointLabel = new JLabel("Deduct points or not:");
		deductpointLabel.setFont(labelFont);
		deductpointLabel.setVerticalAlignment(SwingConstants.CENTER);
		deductpointLabel.setBounds(520, 325, 200, 50);

		assignmentField = new JTextField();
		assignmentField.setToolTipText("Enter assignment name");
		assignmentField.setBounds(750, 175, 130, 40);

		percentField = new JTextField();
		percentField.setToolTipText("Enter Precent in total criterion");
		percentField.setBounds(750, 240, 130, 40);

		maximumField = new JTextField();
		maximumField.setToolTipText("Enter maxmum points");
		maximumField.setBounds(750, 290, 130, 40);

		pointBox = new JCheckBox("");
		pointBox.setVerticalAlignment(SwingConstants.CENTER);
		pointBox.setBounds(780, 330, 200, 50);

		bounsBox = new JCheckBox("");
		bounsBox.setVerticalAlignment(SwingConstants.CENTER);
		bounsBox.setBounds(780, 375, 200, 50);

		confirmButton = new JButton("", new ImageIcon("images/Confirm2.png"));
		confirmButton.setBounds(500, 500, 130, 70);

		cancelButton = new JButton("", new ImageIcon("images/Cancel2.png"));
		cancelButton.setBounds(750, 500, 130, 70);
		this.add(addassignmentLabel);
		this.add(assignmentnameLabel);
		this.add(percentLabel);
		this.add(maximumLabel);
		this.add(deductpointLabel);
		this.add(assignmentField);
		this.add(percentField);
		this.add(maximumField);
		this.add(pointBox);
		this.add(bounsBox);
		this.add(confirmButton);
		this.add(cancelButton);
		this.add(totalPercentLabel);
		this.add(extralabel);


	}

	public JLabel getaddassignmentLabel() {
		return this.addassignmentLabel;
	}

	public JLabel getassignmentnameLabel() {
		return this.assignmentnameLabel;
	}

	public JLabel getpercentLabel() {
		return this.percentLabel;
	}

	public JLabel getmaximumLabel() {
		return this.maximumLabel;
	}

	public JLabel getdeductpointLabel() {
		return this.deductpointLabel;
	}

	public JLabel getTotalPercentLabel() { return this.totalPercentLabel; }

	public void setAssignmentField(String s) { this.assignmentField.setText(s); }

	public void setPercentField(String s) { this.percentField.setText(s); }

	public void setMaximumField(String s) { this.maximumField.setText(s); }

	public String getassignmentField() {
		return this.assignmentField.getText();
	}

	public String getpercentField() {
		return this.percentField.getText();
	}

	public String getmaximumField() {
		return this.maximumField.getText();
	}

	public JCheckBox getpointBox() {
		return this.pointBox;
	}

	public JCheckBox getextraBox() {
		return this.bounsBox;
	}

	public JButton getConfirmButton() {
		return this.confirmButton;
	}

	public JButton getCancelButton() {
		return this.cancelButton;
	}
}
