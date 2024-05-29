import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyPanel extends JPanel implements ActionListener {

    final int WIDTH;
    final int HEIGHT;
    final int DELAY = 1;
    final double PIXEL_SIZE = 0.26;
    final double RASH = 1000/PIXEL_SIZE;

    ArrayList<Object> data = new ArrayList<>();
    double xStart = 0;
    double yStart = 0;
    double y = 0;
    double GRAVITY;

    Image Object;
    Timer timer;

    MyPanel(int Width, int Height,double Gravity){

        if (Width == 0){
            WIDTH = (int) (float)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        }else { WIDTH = Width;}

        if (Height == 0){
            HEIGHT= -100 + (int) (float)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        }else { HEIGHT = Height;}

        GRAVITY = Gravity;
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.black);
        Object = new ImageIcon("download.png").getImage();
        timer = new Timer(DELAY, this);
        GRAVITY = GRAVITY * RASH;
        timer.start();
    }

    void Add(double y , double x , double u , double  Spead ,double Bounce){
        u = u*RASH;
        double uSpeed = Math.sqrt(2*GRAVITY*((HEIGHT- Object.getHeight(null)) - y))+u;
        double Time = ((2*HEIGHT- Object.getHeight(null))/(uSpeed+u));
        data.add(new Object
                (WIDTH - Object.getWidth(null),HEIGHT - Object.getHeight(null),x,GRAVITY,Spead,y,uSpeed,Bounce,Time));
    }

    public void paint(Graphics g){

        super.paint(g);

        Graphics g2D = g;
        for (Object datum : data) {
            g2D.drawImage(Object, datum.GetX(), datum.GetY(), null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Object datum : data) {
            datum.Horizontal();
            datum.Vertical();
        }

        repaint();
    }

    void ChangeLocation(int x , int y1){
        yStart = y1;
        xStart = x;
        y = y1;
    }

    void Bounce (int num){
        for (Object datum : data) {
            datum.Bounce(num);
        }
    }
}
