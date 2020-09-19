import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame {
    public static void main(String[] args) {
        new Draw();
    }

    public Draw() {
        setTitle("My Window");
        setSize(400, 600);
        setVisible(true);
        JLabel label = new JLabel();
        label.setText("Menu");
        setCursor(Cursor.getDefaultCursor());


    }

    public void paint(Graphics g) {
        g.drawRect(50, 50, 85, 25);
        g.setColor(new Color(0, 0, 255));
        g.fillRect(50, 50, 85, 25);
        g.setColor(Color.GREEN);
        g.drawString("Menu", 80, 65);
    }
}
