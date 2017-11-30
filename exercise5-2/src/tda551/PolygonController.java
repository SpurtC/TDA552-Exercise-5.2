package tda551;

import tda551.adapter.IPolygon;
import tda551.adapter.PolygonFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PolygonController {
    public PolygonModel pM;
    public PolygonViewer pV;
    public boolean direction = true;
    public int ticker = 0;

    PolygonController(){
        List <IPolygon> polygons;
        polygons = new ArrayList<>();

        polygons.add(PolygonFactory.createSquare(50, 50));
        polygons.add(PolygonFactory.createTriangle(100, 100));
        polygons.add(PolygonFactory.createRectangle(50, 150));

        pM = new PolygonModel(polygons);
        pV = new PolygonViewer(pM);

    }

    public static void main(String[] args) {
        PolygonController pC = new PolygonController();
        try {
            while (true) {
                Thread.sleep(500);
                pC.update();
            }
        } catch (InterruptedException e) {
        }
    }

    public void update() {
        ticker++;
        int value = direction ? 10 : -10;
        for (IPolygon p : pM.getPolygonList()) {
            p.updateCenter(p.getCenter().x + value, p.getCenter().y + value);
        }
        if (ticker > 10) {
            direction = !direction;
            ticker = 0;
        }
        pV.repaint();
    }

}
