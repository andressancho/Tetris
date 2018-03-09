
package andressancho.com.tetris;

import java.util.ArrayList;

/**
 * Created by Usuario on 06/03/2018.
 */

public class Fabrica {
    private ArrayList<Pieza> piezas;
    public ArrayList<Pieza> I(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,"azul"));
        piezas.add(new Pieza(0,6,"azul"));
        piezas.add(new Pieza(0,7,"azul"));
        piezas.add(new Pieza(0,8,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> T(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,"azul"));
        piezas.add(new Pieza(0,6,"azul"));
        piezas.add(new Pieza(0,7,"azul"));
        piezas.add(new Pieza(1,6,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> L(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,"azul"));
        piezas.add(new Pieza(1,5,"azul"));
        piezas.add(new Pieza(1,6,"azul"));
        piezas.add(new Pieza(1,7,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> cuadrado(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,"azul"));
        piezas.add(new Pieza(1,5,"azul"));
        piezas.add(new Pieza(0,6,"azul"));
        piezas.add(new Pieza(1,6,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> S(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,6,"azul"));
        piezas.add(new Pieza(0,7,"azul"));
        piezas.add(new Pieza(1,5,"azul"));
        piezas.add(new Pieza(1,6,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> Z(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,"azul"));
        piezas.add(new Pieza(0,4,"azul"));
        piezas.add(new Pieza(1,5,"azul"));
        piezas.add(new Pieza(1,6,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> otraL(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(1,5,"azul"));
        piezas.add(new Pieza(0,7,"azul"));
        piezas.add(new Pieza(1,7,"azul"));
        piezas.add(new Pieza(1,6,"azul"));
        return piezas;
    }
}
