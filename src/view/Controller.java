package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Functions;
import model.Utility;

public class Controller {

	 @FXML
	  private TextField window;
	
	@FXML
    private Button seven;
	
    @FXML
    private Button memory;

    @FXML
    private Button backspace;

    @FXML
    private Button clear;

    @FXML
    private Button plus;

    @FXML
    private Button log;

    @FXML
    private Button factorial;

    @FXML
	private Button power;

	@FXML
	private Button nine;

    @FXML
    private Button eight;

    @FXML
    private Button four;

    @FXML
    private Button minus;

    @FXML
    private Button two;

    @FXML
    private Button one;

    @FXML
    private Button multiplication;

    @FXML
    private Button six;

    @FXML
    private Button five;

    @FXML
    private Button zero;

    @FXML
    private Button division;

    @FXML
    private Button three;

    @FXML
    private Button dot;

    @FXML
    private Button sqroot;

    @FXML
    private Button equalsTwo;
    
    private String data ;
    
    /**
     * when a button is pressed then setting its value
     * @param event id of hitted button
     */
    @FXML
    public void set(ActionEvent event) {
    	
    	data = null;
    
    	if(event.getSource()==six)  data = "6";
    	else if(event.getSource()==seven)  data = "7";
    	else if(event.getSource()==eight)  data = "8";
    	else if(event.getSource()==nine)  data = "9";
    
    	if(data!=null) {
    		
    		window.appendText(data);
    	}
    	//System.out.println(event.getSource());
    }
    
	/**
	 * this initialize function will call autometicly 
	 * another system of receving events of actions
	 * lambda expression is used for setting action.
	 */
    @FXML
	public void initialize() {
		
    	one.setOnAction((event)->{
    		window.appendText("1");
    	});
    	
    	two.setOnAction((event)->{
    		window.appendText("2");
    	});
    	
    	three.setOnAction((event)->{
    		window.appendText("3");
    	});
    	
    	four.setOnAction((event)->{
    		window.appendText("4");
    	});
    	
    	five.setOnAction((event)->{
    		window.appendText("5");
    	});
    	
    	zero.setOnAction((event)->{
    		window.appendText("0");
    	});
    	
    	dot.setOnAction((event)->{
    		window.appendText(".");
    	});
    	
    	plus.setOnAction((event)->{
    		window.appendText("+");
    	});
    	
    	
    	minus.setOnAction((event)->{
    		window.appendText("-");
    	});
    	
    	multiplication.setOnAction((event)->{
    		window.appendText("*");
    	});
    	
    	division.setOnAction((event)->{
    		window.appendText("/");
    	});
    	
    	
    	clear.setOnAction((event)->{
    		window.setText("");
    	});
    	
    	factorial.setOnAction((event)->{
    		
    		if(!Utility.isValidExpression(window.getText())){
    			window.setText("Syntax Error!");
    		}
    		else {
	    		long number = (long) Double.parseDouble(window.getText());
	    		if(number>20) {
	    			window.setText("Math Error!");
	    		}
	    		else {
		    		number = Functions.factorial(number);
		    		String str = Long.toString(number);
		    		window.setText(str);
	    		}
    		}
    	});
	}
}
