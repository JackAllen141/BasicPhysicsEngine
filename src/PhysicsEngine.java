import javax.swing.*;

public class PhysicsEngine extends JFrame {

    MyPanel panel;


    PhysicsEngine(int Width, int Height,double Gravity){

        panel = new MyPanel(Width,Height,Gravity);
    }
    void start(){
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    void ChangeLocation(int x , int y){
        panel.ChangeLocation(x,y);
    }

    void Bounce (int num) {
        panel.Bounce(num);
    }

    void Add(double y , double x , double u , double  Spead,double Bounce){
        panel.Add(y,x,u,Spead,Bounce);
    }
}
