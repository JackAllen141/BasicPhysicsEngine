import java.lang.Math;
public class Object {

    final int W;
    final int H;

    double xStart;
    double yStart = 0;
    double GRAVITY;
    double Mult;
    double Y;
    double x;
    double t;
    double v;
    double u;
    double a;
    boolean j = true;

    Object(int w,int h,double X,double g,double s,double y,double U,double Bounce,double time){
        t = time;
        u = U;
        Y = y;
        xStart = X;
        yStart = y;
        Mult = Bounce;
        W = w;
        H = h;
        GRAVITY = g;
        x = s;
    }

    int GetX(){
        return (int) (float)xStart;
    }

    int GetY(){
        return (int) (float)yStart;
    }

    void Bounce (int num){
        Mult = num;
    }

     void Horizontal(){
        if (xStart >= W || xStart < 0) {
            x = x * -1;
        }

        xStart = xStart + (x * 5);
    }

    void Vertical(){

        if (yStart >= H) {
            u = Math.abs(v) * (Mult / 100);
            t = 0;
        }
        if (u < 500){
            u = 0;
        }
        t += 0.0025;

        if (!(GRAVITY == 0)){
            v = u + a*t;
            a = -GRAVITY;
            yStart = (H) - ((u * t) + (0.5 * a * t * t));
        }
    }

}
