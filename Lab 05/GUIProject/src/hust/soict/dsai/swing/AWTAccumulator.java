package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame{
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;		// Accumulated sum, init to 0
	
	// Constructor to set up the GUI components and event handlers
	public AWTAccumulator() {
		setLayout(new GridLayout(2,2));
		
		add (new Label("Enter an Integer: "));
		
		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		add(new Label("The accumulated sum is: "));
		
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);
		
		// Add the window listener to handle the 'X' button click
		addWindowListener(new MyWindowListener());
		
		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWTAccumulator();
	}
	
	private class TFInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
	
	// Inner class handling the window closing sequence
	private class MyWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent evt) {
			System.exit(0);
		}
	}
}
