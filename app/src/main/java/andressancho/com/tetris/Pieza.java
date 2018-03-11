package andressancho.com.tetris;

/**
 * Created by Usuario on 06/03/2018.
 */

public class Pieza {

    private int eje_x;
    private int eje_y;
    public int x1,y1;
    private int tipo;
    private String color;

    public int getTipo() {
        return tipo;
    }

    Pieza(int x, int y, int x1, int x2, String s, int t){
        eje_x=x;
        eje_y=y;
        this.x1=x1;
        this.y1=x2;

        color=s;
        tipo=t;

    }

    public int getEje_x() {
        return eje_x;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
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
