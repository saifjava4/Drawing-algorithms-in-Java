import javax.swing.*;
import java.awt.*;

public class BresenhamCircleDrawingBySaif {
    public static void putPixel (Graphics g , int x, int y){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.ORANGE);
        g2.setStroke(new BasicStroke(4));
        g.drawLine(x, y, x, y);
    }

    public static void delay() {
        try {
            Thread.sleep(40);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int width = 600;
        int height = 600;
        int r = 200;

        int xc = width / 2;
        int yc = height / 2;

        JFrame frame = new JFrame("Bresenham Circle Drawing By Saif Java");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Canvas canvas = new Canvas() {

            public void paint(Graphics g){
                int x = 0;
                int y = r;
                int Pk = 3 - 2 * r;

                while (x <= y){
                    if (Pk < 0){
                        y = y;
                        Pk = Pk + 4 * x + 6;
                    } else {
                        y = y - 1;
                        Pk = Pk + 4 * (x-y) + 10;
                    }

                    putPixel(g, xc + x, yc - y);
                    putPixel(g, xc + x, yc + y);
                    putPixel(g, xc - x, yc - y);
                    putPixel(g, xc - x, yc + y);

                    putPixel(g, xc + y, yc - x);
                    putPixel(g, xc + y, yc + x);
                    putPixel(g, xc - y, yc - x);
                    putPixel(g, xc - y, yc + x);

                    delay();
                    x = x + 1;
                }

            }

        };

        frame.add(canvas);
    }
}
