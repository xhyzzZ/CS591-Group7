package CS591.GradeManageSystem.GUI;
import java.awt.Font;

import javax.swing.*;

public class UpdateAssignment extends JPanel {
    private JLabel chooseassignmentLabel, extraBonusLabel, addassignmentLabel, assignmentnameLabel, percentLabel, maximumLabel, deductpointLabel;
    private JTextField assignmentField, percentField, maximumField;
    private JCheckBox pointBox;
    private JCheckBox extraBonusBox;
    private JComboBox chooseHwBox;
    private JButton confirmButton, cancelButton;
    private static Font labelFont_big = new Font("Dialog", Font.BOLD, 24);
    private static Font labelFont = new Font("Dialog", Font.ITALIC, 14);

    public UpdateAssignment() {

        super(null);

        addassignmentLabel = new JLabel("Update Assignment");
        addassignmentLabel.setFont(labelFont_big);
        addassignmentLabel.setBounds(550, 100, 300, 50);
        addassignmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addassignmentLabel.setVerticalAlignment(SwingConstants.CENTER);

        chooseassignmentLabel = new JLabel("Choose Assignment");
        chooseassignmentLabel.setFont(labelFont);
        chooseassignmentLabel.setVerticalAlignment(SwingConstants.CENTER);
        chooseassignmentLabel.setBounds(520, 175, 240, 50);

        assignmentnameLabel = new JLabel("Assignment Name:");
        assignmentnameLabel.setFont(labelFont);
        assignmentnameLabel.setVerticalAlignment(SwingConstants.CENTER);
        assignmentnameLabel.setBounds(520, 225, 240, 50);

        percentLabel = new JLabel("Percent in total criterion:");
        percentLabel.setFont(labelFont);
        percentLabel.setVerticalAlignment(SwingConstants.CENTER);
        percentLabel.setBounds(520, 275, 200, 50);

        maximumLabel = new JLabel("Maximum Points:");
        maximumLabel.setFont(labelFont);
        maximumLabel.setVerticalAlignment(SwingConstants.CENTER);
        maximumLabel.setBounds(520, 325, 200, 50);

        deductpointLabel = new JLabel("Deduct points or not:");
        deductpointLabel.setFont(labelFont);
        deductpointLabel.setVerticalAlignment(SwingConstants.CENTER);
        deductpointLabel.setBounds(520, 375, 200, 50);

        extraBonusLabel = new JLabel("Extra Bonus:");
        extraBonusLabel.setFont(labelFont);
        extraBonusLabel.setVerticalAlignment(SwingConstants.CENTER);
        extraBonusLabel.setBounds(520, 425, 200, 50);

        assignmentField = new JTextField();
        assignmentField.setToolTipText("Enter assignment name");
        assignmentField.setBounds(750, 225, 130, 40);

        percentField = new JTextField();
        percentField.setToolTipText("Enter Precent in total criterion");
        percentField.setBounds(750, 275, 130, 40);

        maximumField = new JTextField();
        maximumField.setToolTipText("Enter maxmum points");
        maximumField.setBounds(750, 325, 130, 40);

        pointBox = new JCheckBox("");
        pointBox.setVerticalAlignment(SwingConstants.CENTER);
        pointBox.setBounds(780, 375, 200, 50);

        extraBonusBox = new JCheckBox();
        extraBonusBox.setVerticalAlignment(SwingConstants.CENTER);
        extraBonusBox.setBounds(780, 425, 200, 50);

        chooseHwBox = new JComboBox();
        //chooseHwBox.setVerticalAlignment(SwingConstants.CENTER);
        chooseHwBox.setBounds(750, 175, 170, 40);

        confirmButton = new JButton("", new ImageIcon("images/Confirm2.png"));
        confirmButton.setBounds(530, 500, 130, 70);

        cancelButton = new JButton("", new ImageIcon("images/Cancel2.png"));
        cancelButton.setBounds(780, 500, 130, 70);

        this.add(addassignmentLabel);
        this.add(chooseassignmentLabel);
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
        this.add(chooseHwBox);
        this.add(extraBonusBox);
        this.add(extraBonusLabel);

    }

    public JComboBox getchooseHwBox() {
        return this.chooseHwBox;
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

    public JCheckBox getExtraBonusBox() {
        return this.extraBonusBox;
    }

    public void SetforCombo(String[] t) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(t);
        this.chooseHwBox.setModel(model);
    }
}
