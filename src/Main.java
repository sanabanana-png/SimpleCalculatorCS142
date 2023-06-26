import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame  {
    private JFrame f;
    public String calctext = new String("");

    public Main() {

        JFrame f = new JFrame();

        this.f = f;

        ArrayList<JButton> numbers = new ArrayList<JButton>();
        ArrayList<JButton> oper = new ArrayList<JButton>();

        
        final JTextField text1 = new JTextField();

        text1.setBounds(50, 50, 200, 30);


        //Buttons 0-9 are numbers

        class SetText implements ActionListener {
            String txt;

            public SetText(String text) {
                txt = text;
            }

            public void actionPerformed(ActionEvent e) {
                calctext = calctext + txt;
                text1.setText(calctext);

            }
        } //weird action listener class that miles wrote????

        class Calculate implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String equation = text1.getText();
                Calculator c = new Calculator();
                double result = c.calculate(equation);
                text1.setText(Double.toString(result));
            }
        }

        class clearText implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setText("");
                calctext = "";
            }
        }

        for (int i = 0; i <= 9; i++) {
            numbers.add(new JButton(String.valueOf(i)));
            numbers.get(i).setEnabled(true);
            f.add(numbers.get(i));
            numbers.get(i).addActionListener(new SetText(String.valueOf(i)));
        } //making nums

        {JButton equal = new JButton("=");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");

        JButton clear = new JButton("C");


        equal.setBackground(Color.RED);
        equal.setOpaque(true);
        f.add(equal);
        equal.setBounds(270, 50, 50, 30);
        clear.setBounds(190, 310, 60, 60);
        clear.setBackground(Color.RED);
        clear.setOpaque(true);
        f.add(clear);
        equal.addActionListener(new Calculate());
        clear.addActionListener(new clearText());

        oper.add(plus); //0
        oper.add(minus); //1
        oper.add(multiply); //2
        oper.add(divide); //3
        } //adding the operations to their seperate arraylist

        for (int i = 0; i <= 3; i++) {
            oper.get(i).setBackground(Color.GREEN);
            oper.get(i).setOpaque(true);
            f.add(oper.get(i));
        } //setting the opers to be ... green

        {oper.get(0).setBounds(270, 100, 50, 60 );
        oper.get(1).setBounds(270, 170, 50, 60 );
        oper.get(2).setBounds(270, 240, 50, 60 );
        oper.get(3).setBounds(270, 310, 50, 60 );

        } //another chunk of code that tells the computer where the oper buttons are spawning

        {numbers.get(0).setBounds(50,310,130,60);

        numbers.get(1).setBounds(50,240,60,60);
        numbers.get(2).setBounds(120,240,60,60);
        numbers.get(3).setBounds(190,240,60,60);

        numbers.get(4).setBounds(50,170,60,60);
        numbers.get(5).setBounds(120,170,60,60);
        numbers.get(6).setBounds(190,170,60,60);

        numbers.get(7).setBounds(50,100,60,60);
        numbers.get(8).setBounds(120,100,60,60);
        numbers.get(9).setBounds(190,100,60,60);} //big damn chunk of code that tells the computer where the buttons are spawning

        {
            oper.get(0).addActionListener(new SetText("+"));
            oper.get(1).addActionListener(new SetText("-"));
            oper.get(2).addActionListener(new SetText("*"));
            oper.get(3).addActionListener(new SetText("/"));
        } //adding action listeners to opers

        f.add(text1);

        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);

        f.setDefaultCloseOperation(EXIT_ON_CLOSE); //telling it to close when X is hit
    }
    public static void main(String[] args) {

       Main bleh = new Main();

    }
}
