import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Voronoi extends JPanel{
    private Point[] point;
    final int width = 600;
    final int height = 600;


    Voronoi(int points) {
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.setBackground(Color.white);

        frame.add(this);

        point = new Point[points];
        for (int i = 0; i < points; i++) {
            point[i] = new Point((int)(Math.random() * width), (int)(Math.random() * height));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(6));
        g2d.setColor(Color.red);

        for(int i = 0; i < point.length; i++) {
            g2d.draw(new Ellipse2D.Double(point[i].x-2, point[i].y-2, 4, 4));
        }

        for(int i = 0; i < point.length; i++) {
            for(int j = i; j < point.length; j++) {
                g2d.setStroke(new BasicStroke(3));
                g2d.setColor(Color.black);
                g2d.drawLine(point[j].x, point[j].y, point[i].x, point[i].y);

                g2d.setStroke(new BasicStroke(6));
                g2d.setColor(Color.green);
                g2d.draw(new Ellipse2D.Double((point[j].x + point[j+1].x) / 2.0, (point[j].y + point[i].y) / 2.0 , 4, 4));
            }
        }
    }

    public static void main(String[] args) {
        new Voronoi(2);
    }
}
