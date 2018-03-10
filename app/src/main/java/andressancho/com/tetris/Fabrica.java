
package andressancho.com.tetris;

import java.util.ArrayList;

/**
 * Created by Usuario on 06/03/2018.
 */

public class Fabrica {
    private ArrayList<Pieza> piezas;
    private ArrayList<int[][]> rotaciones;
    public ArrayList<Pieza> I(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,1,0,"azul"));
        piezas.add(new Pieza(1,5,1,1,"azul"));
        piezas.add(new Pieza(2,5,1,2,"azul"));
        piezas.add(new Pieza(3,5,1,3,"azul"));
        return piezas;
    }
    public ArrayList<int[][]> obtenerRotacionesI(){
        rotaciones=new ArrayList<int[][]>();
        int[][] matriz= {{3,3},{2,2},{1,1},{0,0}};
        rotaciones.add(matriz);
        int[][] matriz1= {{-3,-3},{-2,-2},{-1,-1},{0,0}};
        rotaciones.add(matriz1);
        return rotaciones;
    }
    public ArrayList<Pieza> T(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,2,0,"azul"));
        piezas.add(new Pieza(0,6,2,1,"azul"));
        piezas.add(new Pieza(0,7,2,2,"azul"));
        piezas.add(new Pieza(1,6,3,1,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> L(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,1,0,"azul"));
        piezas.add(new Pieza(1,5,2,0,"azul"));
        piezas.add(new Pieza(1,6,2,1,"azul"));
        piezas.add(new Pieza(1,7,2,2,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> cuadrado(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,1,0,"azul"));
        piezas.add(new Pieza(1,5,2,0,"azul"));
        piezas.add(new Pieza(0,6,1,1,"azul"));
        piezas.add(new Pieza(1,6,2,1,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> S(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,6,1,1,"azul"));
        piezas.add(new Pieza(0,7,1,2,"azul"));
        piezas.add(new Pieza(1,5,2,0,"azul"));
        piezas.add(new Pieza(1,6,2,1,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> Z(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(0,5,1,1,"azul"));
        piezas.add(new Pieza(0,4,1,0,"azul"));
        piezas.add(new Pieza(1,5,2,1,"azul"));
        piezas.add(new Pieza(1,6,2,2,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> otraL(){
        piezas= new ArrayList<Pieza>();
        piezas.add(new Pieza(1,5,2,0,"azul"));
        piezas.add(new Pieza(0,7,1,2,"azul"));
        piezas.add(new Pieza(1,7,2,2,"azul"));
        piezas.add(new Pieza(1,6,2,1,"azul"));
        return piezas;
    }
    public ArrayList<Pieza> obtenerPieza() {
        int random= (int) (Math.random()*6);
        switch (random) {
            case 0:
                return otraL();
            case 1:
                return S();
            case 2:
                return Z();
            case 3:
                return L();
            case 4:
                return cuadrado();
            case 5:
                return T();
            case 6:
                return I();
        }
        return null;
    }
}
