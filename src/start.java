import java.awt.Dimension;
import java.awt.Toolkit;

public class start {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        PhysicsEngine test = new PhysicsEngine(screenSize.width,screenSize.height-75,9.81);
        test.Add(10,50,0,5,85);
        test.start();
    }
}
