import javax.swing.*;
import java.awt.*;

public class SaifBresenhamLineDrawing {

    public static void putPixel(Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.ORANGE);
        g2.setStroke(new BasicStroke(4));
        g.drawLine(x, y, x, y);
    }

    public static void delay() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void drawBresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        int err = dx - dy;

        while (true) {
            putPixel(g, x1, y1);
            delay();

            if (x1 == x2 && y1 == y2) {
                break;
            }

            int err2 = 2 * err;

            if (err2 > -dy) {
                err = err - dy;
                x1 = x1 + sx;
            }

            if (err2 < dx) {
                err = err + dx;
                y1 = y1 + sy;
            }
        }
    }

    public static void main(String[] args) {
        int x1 = 50;
        int y1 = 50;
        int x2 = 500;
        int y2 = 500;

        JFrame frame = new JFrame("Bresenham Line SAIF");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Canvas canvas = new Canvas() {
            public void paint(Graphics g) {
                drawBresenhamLine(g, x1, y1, x2, y2);
            }
        };

        frame.add(canvas);
    }
}
