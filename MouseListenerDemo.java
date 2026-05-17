import java.awt.*;
import java.awt.event.*;

public class MouseListenerDemo extends Frame implements MouseListener {
    Label l;

    public MouseListenerDemo() {
        l = new Label("Interact with mouse inside the frame         ");
        setLayout(new FlowLayout());
        add(l);
        addMouseListener(this);
        setSize(300, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void mouseClicked(MouseEvent e) { l.setText("Mouse Clicked"); }
    public void mouseEntered(MouseEvent e) { l.setText("Mouse Entered"); }
    public void mouseExited(MouseEvent e) { l.setText("Mouse Exited"); }
    public void mousePressed(MouseEvent e) { l.setText("Mouse Pressed"); }
    public void mouseReleased(MouseEvent e) { l.setText("Mouse Released"); }

    public static void main(String[] args) {
        new MouseListenerDemo();
    }
}