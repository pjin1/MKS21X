import javax.swing.*;
import java.awt.*;
public class temp extends JFrame {
    private Container pane;

    private JButton FtoC;
    private JButton CtoF;
    private JLabel l;
    private JTextField t;
    private JCheckBox c;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public Window2() {
    this.setTitle("temp converter");
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
    c = new JButton("f to c");
    f = new JButton("c to f");
    l = new JLabel("temp",null,JLabel.CENTER);
    t = new JTextField(12);

    pane.add(l);
    pane.add(b);
    pane.add(t);
    pane.add(c);
    }


    
    public class Convert{
    public static double CtoF(double t){
        return t * 9.0 / 5.0 + 32;
    }

    public static double FtoC(double t){
        return (t - 32) * 5.0 / 9.0 ;
    }

    }
}