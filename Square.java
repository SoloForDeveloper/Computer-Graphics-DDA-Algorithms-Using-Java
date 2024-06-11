import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends JFrame implements MouseListener{
    int x1,y1,x2,y2;
    Graphics g;

    Square(){
        setSize(400,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("First JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(this);
        g = getGraphics();
    }
    //DDA Line Drawing algorithm
    public void dda(int x1,int y1, int x2, int y2){
        int dx,dy;
        double xinc, yinc, x, y, step;

        dx = x2 - x1;
        dy = y2 - y1;

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
            x = x+xinc;
            y = y+yinc;
            g.drawLine((int)Math.round(x), (int)Math.round(y), (int)Math.round(x),(int)Math.round(y));
        }
    }

    public void mouseEntered(MouseEvent m){}
    public void mouseClicked(MouseEvent m){
        x1 = m.getX();
        y1 = m.getY();

        g.setColor(Color.green);
        dda(x1,y1,x1,y1+100);
        dda(x1,y1,x1+150,y1);
        dda(x1+150,y1,x1+150,y1+100);
        dda(x1+150, y1+100, x1, y1+100);
    }
    public void mousePressed(MouseEvent m){}
    public void mouseReleased(MouseEvent m){}
    public void mouseExited(MouseEvent m){}

    public static void main(String[] args){
        new Square();
    }

}