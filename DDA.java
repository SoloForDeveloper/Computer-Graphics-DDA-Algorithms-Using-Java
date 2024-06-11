import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DDA extends JFrame implements MouseListener{
    int x1,y1,x2,y2;
    Graphics g;
    DDA(){
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("DDA Algorithm");

        //add mouse events
        addMouseListener(this);
        g = getGraphics();
    }

    public void ddaMethod(int x1, int y1, int x2, int y2){
        int dx, dy;
        double step, xinc, yinc, x, y;

        dx = x2-x1;
        dy = y2-y1;

        if(Math.abs(dx)>Math.abs(dy)){
            step = Math.abs(dx);
        }else{
            step = Math.abs(dy);
        }

        xinc = dx / step;
        yinc = dy / step;
        x = x1;
        y = y1;

        for(int i=0; i<=step; i++){
            x = x + xinc;
            y = y + yinc;
            g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
        }
    }

    public void mouseEntered(MouseEvent m){}
    public void mousePressed(MouseEvent m){
        x1 = m.getX();
        y1 = m.getY();
    }
    public void mouseClicked(MouseEvent m){}
    public void mouseReleased(MouseEvent m){
        x2 = m.getX();
        y2 = m.getY();
        ddaMethod(x1,y1,x2,y2);
    }
    public void mouseExited(MouseEvent m){}

    public static void main(String[] args){
        new DDA();
    }
}