package tda551;

import tda551.adapter.IPolygon;
import java.util.List;

public class PolygonModel {
    private List <IPolygon> polygonList;

    PolygonModel(List<IPolygon> polygonList){
       this.polygonList = polygonList;

    }

    List<IPolygon> getPolygonList (){
        return polygonList;
    }
}
