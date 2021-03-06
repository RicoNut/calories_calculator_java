package calories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CaloriesCalculator {

    private JRadioButton rbtnMale;
    private JRadioButton rbtnFemale;
    private JTextField txtFeet;
    private JTextField txtInches;
    private JTextField txtWeight;
    private JTextField txtAge;
    private JTextField txtCalories;
    private JButton btnCalculate;
    DecimalFormat decimalFormat = new DecimalFormat("#.######");

    public void InitializeComponent() {
        JFrame jFrame = new JFrame("CaloriesCalculator");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel panalRadio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup btnGroup = new ButtonGroup();
        rbtnMale = new JRadioButton("Male");
        rbtnFemale = new JRadioButton("Female");
        rbtnMale.setSelected(true);
        btnGroup.add(rbtnMale);
        btnGroup.add(rbtnFemale);
        panalRadio.add(rbtnMale);
        panalRadio.add(rbtnFemale);


        JPanel panalHeight = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panalHeight.add(new JLabel(" Height:"));
        txtFeet = new JTextField("5", 8);
        panalHeight.add(txtFeet);
        panalHeight.add(new JLabel("ft"));
        txtInches = new JTextField("1", 8);
        panalHeight.add(txtInches);
        panalHeight.add(new JLabel("in"));


        JPanel panalWeight = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panalWeight.add(new JLabel("Weight:"));
        txtWeight = new JTextField("110", 8);
        panalWeight.add(txtWeight);
        panalWeight.add(new JLabel("lb"));


        JPanel panalAge = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panalAge.add(new JLabel("      Age:"));
        txtAge = new JTextField("12", 8);
        panalAge.add(txtAge);
        panalAge.add(new JLabel("year"));

        JPanel panalCalc = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Calculate();
            }

        });
        panalCalc.add(btnCalculate);

        JPanel panalCalories = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panalCalories.add(new JLabel("Recommended Daily Amount:"));
        txtCalories = new JTextField(8);
        panalCalories.add(txtCalories);

        Box vBox = Box.createVerticalBox();
        vBox.add(panalRadio);
        vBox.add(panalHeight);
        vBox.add(panalWeight);
        vBox.add(panalAge);
        vBox.add(panalCalc);
        vBox.add(panalCalories);

        jFrame.setContentPane(vBox);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    private void Calculate() {
        if (rbtnMale.isSelected()) {
            txtCalories.setText(decimalFormat.format(66
                    + (6.3 * Double.valueOf(txtWeight.getText()))
                    + (12.9 * ((Double.valueOf(txtFeet.getText()) * 12)
                    + Double.valueOf(txtInches.getText())))
                    - (6.8 * Double.valueOf(txtAge.getText()))));
        } else {
            txtCalories.setText(decimalFormat.format(655
                    + (4.3 * Double.valueOf(txtWeight.getText()))
                    + (4.7 * ((Double.valueOf(txtFeet.getText()) * 12)
                    + Double.valueOf(txtInches.getText())))
                    - (4.7 * Double.valueOf(txtAge.getText()))));
        }
    }


    public static void main(String[] args) {
        CaloriesCalculator cc = new CaloriesCalculator();
        cc.InitializeComponent();
    }
}
