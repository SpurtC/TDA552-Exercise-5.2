package tda551;

import tda551.adapter.IPolygon;

import javax.swing.*;
import java.awt.*;

public class PolygonViewer extends JComponent{
    public JFrame frame;
    PolygonModel pM;

    PolygonViewer(PolygonModel pM){
        this.pM = pM;
        createStartFrame();
    }

    public void createStartFrame(){
        frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(30, 30, 300, 300);
        frame.getContentPane().add(this); // this = Det nuvarande objektet
        frame.setVisible(true);

    }

    public void paint(Graphics g) {
        for (IPolygon currentPolygon : pM.getPolygonList()) {
            currentPolygon.paint(g);
        }
    }
}
