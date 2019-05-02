package GUI;
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
	private JLabel addassignmentLabel, assignmentnameLabel, extraBonusLabel, percentLabel, maximumLabel, deductpointLabel;
	private JTextField assignmentField, percentField, maximumField;
	private JCheckBox pointBox;
	private JCheckBox extraBonusBox;
	private JButton confirmButton, cancelButton;
	private static Font labelFont_big = new Font("Dialog", Font.BOLD, 24);
	private static Font labelFont = new Font("Dialog", Font.ITALIC, 14);
	
	public AddNewAssignment() {
		
		super(null);
		
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
		
		extraBonusLabel = new JLabel("Extra Bonus?");
		extraBonusLabel.setFont(labelFont);
		extraBonusLabel.setVerticalAlignment(SwingConstants.CENTER);
		extraBonusLabel.setBounds(520, 375, 200, 50);
		
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
		
		extraBonusBox = new JCheckBox("");
		extraBonusBox.setVerticalAlignment(SwingConstants.CENTER);
		extraBonusBox.setBounds(780, 375, 200, 50);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(500, 500, 130, 100);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(750, 500, 130, 100);
		
		this.add(addassignmentLabel);
		this.add(assignmentnameLabel);
		this.add(percentLabel);
		this.add(maximumLabel);
		this.add(deductpointLabel);
		this.add(assignmentField);
		this.add(percentField);
		this.add(maximumField);
		this.add(pointBox);
		this.add(extraBonusLabel);
		this.add(extraBonusBox);
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
	
	public JTextField getassignmentField() {
		return this.assignmentField;
	}
	
	public JTextField getpercentField() {
		return this.percentField;
	}
	
	public JTextField getmaximumField() {
		return this.maximumField;
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
