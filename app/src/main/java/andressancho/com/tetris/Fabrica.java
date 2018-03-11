
package andressancho.com.tetris;

import java.util.ArrayList;

/**
 * Created by Usuario on 06/03/2018.
 */

public class Fabrica {
    private ArrayList<Pieza> piezas;
    private ArrayList<int[][]> rotaciones;
    int tipoPieza=-1;
    public ArrayList<Pieza> I(){
        piezas= new ArrayList<Pieza>();
        int random= (int) (Math.random()*5);
        piezas.add(new Pieza(0,5,1,0,random,0));
        piezas.add(new Pieza(1,5,1,1,random,0));
        piezas.add(new Pieza(2,5,1,2,random,0));
        piezas.add(new Pieza(3,5,1,3,random,0));
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
        int random= (int) (Math.random()*5);
        piezas.add(new Pieza(0,6,2,1,random,1));
        piezas.add(new Pieza(1,5,3,0,random,1));
        piezas.add(new Pieza(1,6,3,1,random,1));
        piezas.add(new Pieza(1,7,3,2,random,1));
                return piezas;
    }
    public ArrayList<int[][]> obtenerRotacionesT(){
        rotaciones=new ArrayList<int[][]>();
        int[][] matriz= {{1,1},{-1,1},{0,0},{1,-1}};
        rotaciones.add(matriz);
        int[][] matriz1= {{1,-1},{1,1},{0,0},{-1,-1}};
        rotaciones.add(matriz1);
        int[][] matriz2= {{-1,-1},{1,-1},{0,0},{-1,1}};
        rotaciones.add(matriz2);
        int[][] matriz3= {{-1,1},{-1,-1},{0,0},{1,1}};
        rotaciones.add(matriz3);
        return rotaciones;
    }
    public ArrayList<Pieza> L(){
        piezas= new ArrayList<Pieza>();
        int random= (int) (Math.random()*5);
        piezas.add(new Pieza(0,5,1,0,random,1));
        piezas.add(new Pieza(1,5,2,0,random,1));
        piezas.add(new Pieza(2,5,3,0,random,1));
        piezas.add(new Pieza(2,6,3,1,random,1));
        return piezas;
    }
    public ArrayList<int[][]> obtenerRotacionesL(){
        rotaciones=new ArrayList<int[][]>();
        int[][] matriz= {{1,1},{0,0},{-1,-1},{0,-2}};
        rotaciones.add(matriz);
        int[][] matriz1= {{1,-1},{0,0},{-1,1},{-2,-0}};
        rotaciones.add(matriz1);
        int[][] matriz2= {{-1,-1},{0,0},{1,1},{0,2}};
        rotaciones.add(matriz2);
        int[][] matriz3= {{-1,1},{0,0},{1,-1},{2,0}};
        rotaciones.add(matriz3);
        return rotaciones;
    }
    public ArrayList<Pieza> O(){
        piezas= new ArrayList<Pieza>();
        int random= (int) (Math.random()*5);
        piezas.add(new Pieza(0,5,1,0,random,2));
        piezas.add(new Pieza(1,5,2,0,random,2));
        piezas.add(new Pieza(0,6,1,1,random,2));
        piezas.add(new Pieza(1,6,2,1,random,2));
        return piezas;
    }
    public ArrayList<int[][]> obtenerRotacionesO(){
        rotaciones=new ArrayList<int[][]>();
        int[][] matriz= {{0,0},{0,0},{0,0},{0,0}};
        rotaciones.add(matriz);
        return rotaciones;
    }
    public ArrayList<Pieza> S(){
        piezas= new ArrayList<Pieza>();
        int random= (int) (Math.random()*5);
        piezas.add(new Pieza(0,7,1,2,random,0));
        piezas.add(new Pieza(0,6,1,1,random,0));
        piezas.add(new Pieza(1,6,2,1,random,0));
        piezas.add(new Pieza(1,5,2,0,random,0));
        return piezas;
    }
    public ArrayList<int[][]> obtenerRotacionesS(){
        rotaciones=new ArrayList<int[][]>();
        int[][] matriz= {{2,0},{1,1},{0,0},{-1,1}};
        rotaciones.add(matriz);
        int[][] matriz1= {{-2,0},{-1,-1},{0,0},{1,-1}};
        rotaciones.add(matriz1);
        return rotaciones;
    }
    public ArrayList<Pieza> Z(){
        piezas= new ArrayList<Pieza>();
        int random= (int) (Math.random()*5);
        piezas.add(new Pieza(0,5,1,0,random,0));
        piezas.add(new Pieza(0,6,1,1,random,0));
        piezas.add(new Pieza(1,6,2,1,random,0));
        piezas.add(new Pieza(1,7,2,2,random,0));
        return piezas;
    }
    public ArrayList<int[][]> obtenerRotacionesZ(){
        rotaciones=new ArrayList<int[][]>();
        int[][] matriz= {{0,2},{1,1},{0,0},{1,-1}};
        rotaciones.add(matriz);
        int[][] matriz1= {{0,-2},{-1,-1},{0,0},{-1,1}};
        rotaciones.add(matriz1);
        return rotaciones;
    }
    public ArrayList<Pieza> J(){
        piezas= new ArrayList<Pieza>();
        int random= (int) (Math.random()*5);
        piezas.add(new Pieza(0,6,0,2,random,1));
        piezas.add(new Pieza(1,6,1,2,random,1));
        piezas.add(new Pieza(2,6,2,2,random,1));
        piezas.add(new Pieza(2,5,2,1,random,1));
        return piezas;
    }
    public ArrayList<int[][]> obtenerRotacionesJ(){
        rotaciones=new ArrayList<int[][]>();
        int[][] matriz= {{1,1},{0,0},{-1,-1},{-2,0}};
        rotaciones.add(matriz);
        int[][] matriz1= {{1,-1},{0,0},{-1,1},{0,2}};
        rotaciones.add(matriz1);
        int[][] matriz2= {{-1,-1},{0,0},{1,1},{2,0}};
        rotaciones.add(matriz2);
        int[][] matriz3= {{-1,1},{0,0},{1,-1},{0,-2}};
        rotaciones.add(matriz3);
        return rotaciones;
    }
    public ArrayList<Pieza> obtenerPieza() {
        int random= (int) (Math.random()*7);
        tipoPieza=random;
        switch (random) {
            case 0:
                return J();
            case 1:
                return S();
            case 2:
                return Z();
            case 3:
                return L();
            case 4:
                return O();
            case 5:
                return T();
            case 6:
                return I();
        }
        return null;
    }
    public ArrayList<int[][]> obtenerRotaciones(){
        switch (tipoPieza) {
            case 0:
                return obtenerRotacionesJ();
            case 1:
                return obtenerRotacionesS();
            case 2:
                return obtenerRotacionesZ();
            case 3:
                return obtenerRotacionesL();
            case 4:
                return obtenerRotacionesO();
            case 5:
                return obtenerRotacionesT();
            case 6:
                return obtenerRotacionesI();
        }
        return null;
    }
}
