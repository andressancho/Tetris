package andressancho.com.tetris;

/**
 * Created by Usuario on 06/03/2018.
 */

public class Pieza {

    private int eje_x;
    private int eje_y;
    private String color;
    Pieza(int x,int y, String s){
        eje_x=x;
        eje_y=y;
        color=s;

    }

    public int getEje_x() {
        return eje_x;
    }

    public int getEje_y() {
        return eje_y;
    }

    public void setEje_x(int eje_x) {
        this.eje_x = eje_x;
    }

    public void setEje_y(int eje_y) {
        this.eje_y = eje_y;
    }
}
