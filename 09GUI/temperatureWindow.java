import javax.swing.*;
import java.awt.*;
public class temperatureWindow extends JFrame implements ActionListener {
    private Container pane;

    private JButton FtoC;
    private JButton CtoF;
    private JLabel l;
    private JTextField t;
    private JCheckBox c;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public temperatureWindow() {
    this.setTitle("Temperature Converter");
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    
    c = new JButton("f to c");
    f = new JButton("c to f");
    l = new JLabel("Temperature Converter",null,JLabel.CENTER);
    t = new JTextField(100);

    pane.add(c);
    pane.add(f);
    pane.add(l);
    pane.add(t);
    }
    
    public class Convert{
	    public static double CtoF(double t){
	        return t * 9.0 / 5.0 + 32;
	    }

	    public static double FtoC(double t){
	        return (t - 32) * 5.0 / 9.0 ;
	    }

    }
    
    public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		System.out.println(s);

		if (s.equals("Celcius to Fahrenheit")){
			    
		}
		if (s.equals("Fahrenheit to Celsius")){
		
		}
	}

}
