import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class temperatureWindow extends JFrame implements ActionListener {
    private Container pane;

    private JButton FtoC;
    private JButton CtoF;

    private JTextField t;

 
    //CONSTRUCTOR SETS EVERYTHING UP
    public temperatureWindow() {
    		this.setTitle("Temperature Converter");
    		this.setSize(600,400);
    		this.setLocation(100,100);
    		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    pane = this.getContentPane();
	    pane.setLayout(new FlowLayout());
	    
	    CtoF = new JButton("Celcius to Fahrenheit");
	    FtoC = new JButton("Fahrenheit to Celcius");
	    
	    t = new JTextField(100);
	
	    t.addActionListener(this);
		FtoC.addActionListener(this);
		CtoF.addActionListener(this);
		
		pane.add(t);
		pane.add(FtoC);
		pane.add(CtoF);
	    }
    }
    

    
    public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		System.out.println(s);
		double temp = Double.parseDouble(t.getText());
		
		if(s.equals("FtoC")){
			try{
		    		t.setText("" + (temp - 32) * 5.0 / 9.0);
		    } 
		    catch (NumberFormatException exc){
		        System.out.println(">:( insert number");
		    }
		}
	
		if(s.equals("CtoF")){
		    try{
		    		t.setText("" + (temp * 9.0 / 5.0 + 32));
		    }
		    catch (NumberFormatException exc){
		    		System.out.println(">:( insert number");
		    }
		}
    }

}


 
