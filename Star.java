import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Star extends JFrame implements MouseListener{
    int x1,y1,x2,y2;
    Graphics g;

    Star(){
        setSize(500,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Star Object");
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

    public void drawObject(int x1, int y1){
        g.setColor(Color.blue);
        dda(x1-50,y1,x1+50,y1);
        dda(x1,y1-50,x1,y1+50);

        double teta = Math.toRadians(45);
        g.setColor(Color.red);
        dda(x1,y1,(int)(x1+50*Math.cos(teta)), (int)(y1+50*Math.sin(teta)));
        dda(x1,y1,(int)(x1-50*Math.cos(teta)), (int)(y1+50*Math.sin(teta)));
        dda(x1,y1,(int)(x1-50*Math.cos(teta)), (int)(y1-50*Math.sin(teta)));
        dda(x1,y1,(int)(x1+50*Math.cos(teta)), (int)(y1-50*Math.sin(teta)));
    }

    public void mouseEntered(MouseEvent m){}
    public void mouseClicked(MouseEvent m){
        x1 = m.getX();
        y1 = m.getY();

        drawObject(x1,y1);
        
    }
    public void mousePressed(MouseEvent m){}
    public void mouseReleased(MouseEvent m){}
    public void mouseExited(MouseEvent m){}

    public static void main(String[] args){
        new Star();
    }

}