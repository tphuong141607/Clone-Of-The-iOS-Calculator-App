 /**
  *  Created by Thao Phuong, 6/20/2017
  */

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
	
	Float firstOperand; 
	int operation;
	Float result; 
	
    @FXML
    private TextField display;
   
    // Operand
    @FXML
    private Button addition;
    @FXML
    private Button substract;
    @FXML
    private Button multiplication;
    @FXML
    private Button division; 
    @FXML
    private Button equals; 
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@FXML  // Display input
	private void displayInput(ActionEvent event) {
		
		display.setStyle("-fx-background-color: black;-fx-text-inner-color: white;");
		String text = ((Button) event.getSource()).getText();
		display.setText(display.getText() + text);
	}
	
	@FXML // Delete Button
	protected void DeleteButton(ActionEvent event) {
		
		
		if (display.getText().length() > 0 ) {
    			StringBuilder strB = new StringBuilder(display.getText());
    			strB.deleteCharAt(display.getText().length() - 1);
    			String strB1 = strB.toString();
    			display.setText(strB1);
		}
	}
	
	@FXML // Negative Button
	private void NegativeButton(ActionEvent event) {
		
		if (display.getText().length() > 0) {
			
			if (display.getText().contains(".")) { // double or float number
				double currentNum = Double.parseDouble(String.valueOf(display.getText()));
				currentNum = currentNum * (-1);
				display.setText(String.valueOf(currentNum));
				
			} else { // Integer number
				int currentNum = Integer.parseInt(String.valueOf(display.getText()));
				currentNum = currentNum * (-1);
				display.setText(String.valueOf(currentNum));
			}	
			
		} else {
			display.setText("0");
		}	
	}
	
	@FXML // Clear "C" Button 
	private void CButton(ActionEvent event) {
			display.setText("");
	}
	
	@FXML 
	private void operationButton(ActionEvent event) {
		
		if (event.getSource() == addition) {
			firstOperand = Float.parseFloat(display.getText());
            operation = 1; 
            display.setText(" ");
            
            
        } else if (event.getSource() == substract) {
        		firstOperand = Float.parseFloat(display.getText());
            operation = 2; 
            display.setText(" ");
            
        } else if (event.getSource() == multiplication) {
        		firstOperand = Float.parseFloat(display.getText());
            operation = 3; 
            display.setText(" ");
            
        } else if (event.getSource() == division) {
        	 	firstOperand = Float.parseFloat(display.getText());
            operation = 4; 
            display.setText(" ");
            
        } else if (event.getSource() == equals) {
            Float secondOperand = Float.parseFloat(display.getText());
            
            switch (operation) {
                case 1: 
                    	result = firstOperand + secondOperand;
                    display.setText(String.valueOf(result)); break;
                case 2: 
                		result = firstOperand - secondOperand;
                    display.setText(String.valueOf(result)); break;
                case 3: 
                		result = firstOperand * secondOperand;
                    display.setText(String.valueOf(result)); break;
                case 4: 
                     result = firstOperand / secondOperand;
                     display.setText(String.valueOf(result)); break;
            }                 
           
            
            }
        
		}
}
