import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorRefactored implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JButton[] numberButtons = new JButton[10];
	private JButton[] functionButtons = new JButton[9];
	private JButton addButton, subButton, multiplyButton, divideButton;
	private JButton decimalButton, equalsButton, deleteButton, clearButton, negativeButton;
	private JPanel panel;
	
	Font numberFont = new Font("Courier", Font.PLAIN, 30);
	Font textFont = new Font("Courier", Font.PLAIN, 20);
	
	double holder1 = 0, holder2 = 0, result = 0;
	char operator;
	
	public CalculatorRefactored() {
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(numberFont);
		textField.setEditable(false);
		
		//call to method to create the buttons and add them to the appropriate array
		createButtons();
		
		//setting the position of the negative, delete and clear buttons
		negativeButton.setBounds(50,430, 100, 50);
		deleteButton.setBounds(150, 430, 100, 50);
		clearButton.setBounds(250, 430, 100, 50);
		
		//setting the panel and layout
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		addButtonsPanel(panel,numberButtons,functionButtons);
		addToFrame(frame,negativeButton, deleteButton,clearButton, textField);
		
		
	}
	
	public void createButtons() {

		//setting up the number buttons and adding to array
		for (int i = 0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));	
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(numberFont);
			numberButtons[i].setFocusable(false);	
		}
		
		//setting up the function buttons and adding to array
		addButton = new JButton("+");
		functionButtons[0] = addButton;
		subButton = new JButton("-");
		functionButtons[1] = subButton;
		multiplyButton = new JButton("*");
		functionButtons[2] = multiplyButton;
		divideButton = new JButton("/");
		functionButtons[3] = divideButton;
		decimalButton = new JButton("."); 
		functionButtons[4] = decimalButton;
		equalsButton = new JButton("=");
		functionButtons[5] = equalsButton;
		deleteButton = new JButton("DELETE");
		functionButtons[6] = deleteButton;
		clearButton = new JButton("CLEAR");
		functionButtons[7] = clearButton;
		negativeButton = new JButton("(-)");
		functionButtons[8] = negativeButton;
		
		for (int i = 0; i<9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(textFont);
			functionButtons[i].setFocusable(false);			
		}
	}
	
	public void addButtonsPanel(JPanel panel, JButton[] numberButtons, JButton[] functionButtons) {
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multiplyButton);
		panel.add(decimalButton);
		panel.add(numberButtons[0]);
		panel.add(equalsButton);
		panel.add(divideButton);
	}
	
	public void addToFrame(JFrame frame, JButton negativeButton, JButton deleteButton, JButton clearButton, JTextField textField) {
		frame.add(panel);
		frame.add(negativeButton);
		frame.add(deleteButton);
		frame.add(clearButton);
		frame.add(textField);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i<10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decimalButton) {
			decimalButton();
		} else if (e.getSource() == addButton) {
			addButton();
		} else if (e.getSource() == subButton) {
			subButton();
		} else if (e.getSource() == multiplyButton) {
			multiplyButton();
		} else if (e.getSource() == divideButton) {
			divideButton();
		} else if (e.getSource() == equalsButton) {
			equalsButton();
		} else if (e.getSource() == clearButton) {
			clearButton();
		} else if (e.getSource() == deleteButton) {
			deleteButton();
		} else if (e.getSource() == negativeButton) {
			negativeButton();
		}
		
	}
	
	public void decimalButton() {
		textField.setText(textField.getText().concat("."));
	}
	public void addButton() {
		holder1 = Double.parseDouble(textField.getText());
		operator = '+';
		textField.setText("");
		//textField.setText(String.valueOf(holder1) + '+');
	}
	public void subButton() {
		holder1 = Double.parseDouble(textField.getText());
		operator = '-';
		textField.setText("");
	}
	public void multiplyButton() {
		holder1 = Double.parseDouble(textField.getText());
		operator = '*';
		textField.setText("");
	}
	public void divideButton() {
		holder1 = Double.parseDouble(textField.getText());
		operator = '/';
		textField.setText("");
	}
	public void equalsButton() {
		holder2 = Double.parseDouble(textField.getText());
		switch(operator) {
		case '+':
			result = holder1 + holder2;
			break;
		case '-':
			result = holder1 - holder2;
			break;
		case '*':
			result = holder1 * holder2;
			break;
		case '/':
			result = holder1 / holder2;
			break;		
		}
		textField.setText(String.valueOf(result));
		holder1 = result;
	}
	public void clearButton() {
		textField.setText("");
	}
	public void deleteButton() {
		String string = textField.getText();
		textField.setText("");
		for (int i=0; i<string.length()-1; i++) {
			textField.setText(textField.getText()+string.charAt(i));
		}
	}
	public void negativeButton() {
		double temp = Double.parseDouble(textField.getText());
		temp *= -1;
		textField.setText(String.valueOf(temp));
	}
	
	public static void main(String[] args) {
		CalculatorRefactored calc = new CalculatorRefactored();
	}

}
