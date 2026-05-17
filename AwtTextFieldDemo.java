import java.awt.*;
import java.awt.event.*;

public class AwtTextFieldDemo extends Frame {
    public AwtTextFieldDemo() {
        TextField t1 = new TextField(10);
        TextField t2 = new TextField(10);
        Button b = new Button("Copy");

        setLayout(new FlowLayout());
        add(t1);
        add(b);
        add(t2);

        b.addActionListener(e -> t2.setText(t1.getText()));

        setSize(300, 100);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new AwtTextFieldDemo();
    }
}