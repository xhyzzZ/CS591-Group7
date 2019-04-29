package CS591.GradeManageSystem.GUI;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddNewAssignment extends JPanel{
	private JLabel addassignmentLabel, assignmentnameLabel, percentLabel, maximumLabel, deductpointLabel;
	private JTextField assignmentField, percentField, maximumField;
	private JCheckBox pointBox;

	// porblem bounsBox
	private JCheckBox bounsBox;
	private JButton confirmButton, cancelButton;
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 24);
	private static Font labelFont = new Font("Dialog", Font.ITALIC, 14);

	public AddNewAssignment() {

		super(null);

		addassignmentLabel = new JLabel("Add New Assignment");
		addassignmentLabel.setFont(labelFont_big);
		addassignmentLabel.setBounds(370, 100, 300, 50);
		addassignmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addassignmentLabel.setVerticalAlignment(SwingConstants.CENTER);

		assignmentnameLabel = new JLabel("Assignment Name:");
		assignmentnameLabel.setFont(labelFont);
		assignmentnameLabel.setVerticalAlignment(SwingConstants.CENTER);
		assignmentnameLabel.setBounds(300, 175, 240, 50);

		percentLabel = new JLabel("Percent in total criterion:");
		percentLabel.setFont(labelFont);
		percentLabel.setVerticalAlignment(SwingConstants.CENTER);
		percentLabel.setBounds(300, 225, 200, 50);

		maximumLabel = new JLabel("Maximum Points:");
		maximumLabel.setFont(labelFont);
		maximumLabel.setVerticalAlignment(SwingConstants.CENTER);
		maximumLabel.setBounds(300, 275, 200, 50);

		deductpointLabel = new JLabel("Deduct points or not:");
		deductpointLabel.setFont(labelFont);
		deductpointLabel.setVerticalAlignment(SwingConstants.CENTER);
		deductpointLabel.setBounds(300, 325, 200, 50);

		assignmentField = new JTextField();
		assignmentField.setToolTipText("Enter assignment name");
		assignmentField.setBounds(500, 175, 130, 40);

		percentField = new JTextField();
		percentField.setToolTipText("Enter Precent in total criterion");
		percentField.setBounds(500, 240, 130, 40);

		maximumField = new JTextField();
		maximumField.setToolTipText("Enter maxmum points");
		maximumField.setBounds(500, 290, 130, 40);

		pointBox = new JCheckBox("");
		pointBox.setVerticalAlignment(SwingConstants.CENTER);
		pointBox.setBounds(530, 325, 200, 50);

		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(300, 400, 150, 50);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(500, 400, 150, 50);

		this.add(addassignmentLabel);
		this.add(assignmentnameLabel);
		this.add(percentLabel);
		this.add(maximumLabel);
		this.add(deductpointLabel);
		this.add(assignmentField);
		this.add(percentField);
		this.add(maximumField);
		this.add(pointBox);
		this.add(confirmButton);
		this.add(cancelButton);


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

	public String getassignmentField() {
		return this.assignmentField.getText();
	}

	public int getpercentField() {
		return Integer.parseInt(this.percentField.getText());
	}

	public int getmaximumField() {
		return Integer.parseInt(this.maximumField.getText());
	}

	public JCheckBox getpointBox() {
		return this.pointBox;
	}

	public JButton getConfirmButton() {
		return this.confirmButton;
	}

	public JButton getCancelButton() {
		return this.cancelButton;
	}
}
