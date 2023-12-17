import javax.swing.*;
import java.awt.*;

public class Saif_DDA_Algorithm {

    public static void putPixel (Graphics g , int x, int y){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.ORANGE);
        g2.setStroke(new BasicStroke(4));
        g.drawLine(x, y, x, y);
    }

    public static void delay() {
        try {
            Thread.sleep(10);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int x1 = 50;
        int y1 = 50;
        int x2 = 500;
        int y2 = 500;

        JFrame frame = new JFrame("DDA");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Canvas canvas = new Canvas() {

            @Override
            public void paint(Graphics g) {

                int dx = x2 - x1;
                int dy = y2 - y1;

                int steps = Math.max(Math.abs(dx), Math.abs(dy));

                float xIncrement = (float) dx / steps;
                float yIncrement = (float) dy / steps;

                float x = x1;
                float y = y1;

                for (int i = 0; i <= steps; i++) {
                    putPixel(g, Math.round(x), Math.round(y));
                    x += xIncrement;
                    y += yIncrement;
                    delay();
                }

            }

        };

        frame.add(canvas);
    }
}
