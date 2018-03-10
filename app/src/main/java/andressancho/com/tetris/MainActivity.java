package andressancho.com.tetris;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int rows=22;
    int columns=13;
    boolean colision=false;
    boolean piezanueva=false;
    ImageView[][] views= new ImageView[rows][columns];
    ImageView[][] mViews= new ImageView[4][4];

    Pieza[][] piezas=new Pieza[rows][columns];
    Pieza[][] piecita= new Pieza[4][4];
    Fabrica fabrica= new Fabrica();
    ArrayList<Pieza> figura= new ArrayList<Pieza>();
    ArrayList<Pieza> figuraSiguiente= new ArrayList<Pieza>();


    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        figura=fabrica.obtenerPieza();
        figuraSiguiente=new ArrayList<Pieza>();//fabrica.obtenerPieza();

        initTablero();
        iniciarJuego();

    }
    public void initTablero(){
        GridLayout gl = findViewById(R.id.gl);
        GridLayout mgl = findViewById(R.id.mgl);

        for(int x=0;x<rows;x++){
            for(int y=0;y<columns;y++){

                ImageView iv= new ImageView(this);
                iv.setImageResource(R.drawable.pieza_gris);
                gl.addView(iv);
                views[x][y]=iv;
            }
        }
        for(int x=0;x<4;x++){
            for(int y=0;y<4;y++){
                ImageView i= new ImageView(this);
                i.setImageResource(R.drawable.pieza_amarillam);
                mgl.addView(i);
                mViews[x][y]=i;
            }
        }
    }
    public void iniciarJuego(){
        runnable= new Runnable() {
            @Override
            public void run() {

                for(Pieza p:figura){
                    piezas[p.getEje_x()][p.getEje_y()]=p;
                }

                for(Pieza pieza:figura){
                    piecita[pieza.x1][pieza.y1]=pieza;
                }


                for(int x=0;x<rows;x++){
                    for(int y=0;y<columns;y++){
                        if(piezas[x][y]!=null){
                            views[x][y].setImageResource(R.drawable.pieza_amarillo);
                        }else{
                            views[x][y].setImageResource(R.drawable.pieza_gris);
                        }
                    }
                }
                for(int x=0;x<4;x++){
                    for(int y=0;y<4;y++){
                        if(piecita[x][y]!=null){
                            mViews[x][y].setImageResource(R.drawable.pieza_amarillam);
                            piecita[x][y]=null;
                        }else{
                            mViews[x][y].setImageResource(R.drawable.pieza_negra);
                        }
                    }
                }


                for(Pieza p:figura) {
                    piezas[p.getEje_x()][p.getEje_y()]=null;
                }
                for (Pieza p:figura) {

                    if(p.getEje_x()+1==rows) {
                        colision = true;
                    }
                    else{
                        if(piezas[p.getEje_x()+1][p.getEje_y()]!=null){
                            colision=true;
                        }

                    }
                }
                for(Pieza p:figura) {
                    if(!colision) {
                        p.setEje_x(p.getEje_x() + 1);
                        piezas[p.getEje_x()][p.getEje_y()] = p;
                    }
                    else{
                        piezas[p.getEje_x()][p.getEje_y()] = p;
                        piezanueva=true;
                        figura=figuraSiguiente;
                        figuraSiguiente=fabrica.obtenerPieza();




                    }
                }
                if(piezanueva){
                    colision=false;
                    piezanueva=false;


                }
                handler.postDelayed(runnable,1000);
            }
        };
        handler.postDelayed(runnable,1000);


    }
    public void toLeft(View view){

        boolean colisionIzq=false;
        for(Pieza p:figura){
            piezas[p.getEje_x()][p.getEje_y()]=null;
        }
        for(Pieza p:figura){
            if(p.getEje_y()==0 || piezas[p.getEje_x()][p.getEje_y()-1]!=null){
                colisionIzq=true;
            }
        }
        for(Pieza p:figura){
            if(!colisionIzq){
                p.setEje_y(p.getEje_y()-1);
                piezas[p.getEje_x()][p.getEje_y()]=p;
            }
            else {
                piezas[p.getEje_x()][p.getEje_y()]=p;
            }
        }
    }
    public void toRight(View view){

        boolean colisionIzq=false;
        for(Pieza p:figura){
            piezas[p.getEje_x()][p.getEje_y()]=null;
        }
        for(Pieza p:figura){
            if(p.getEje_y()==columns-1 || piezas[p.getEje_x()][p.getEje_y()+1]!=null){
                colisionIzq=true;
            }
        }
        for(Pieza p:figura){
            if(!colisionIzq){
                p.setEje_y(p.getEje_y()+1);
                piezas[p.getEje_x()][p.getEje_y()]=p;
            }
            else {
                piezas[p.getEje_x()][p.getEje_y()]=p;
            }
        }
    }
    public void toBottom(View view){

        boolean colisionIzq=false;
        for(Pieza p:figura){
            piezas[p.getEje_x()][p.getEje_y()]=null;
        }
        for(Pieza p:figura){
            if(p.getEje_x()==rows-1 || piezas[p.getEje_x()+1][p.getEje_y()]!=null){
                colisionIzq=true;
            }
        }
        for(Pieza p:figura){
            if(!colisionIzq){
                p.setEje_x(p.getEje_x()+1);
                piezas[p.getEje_x()][p.getEje_y()]=p;
            }
            else {
                piezas[p.getEje_x()][p.getEje_y()]=p;
            }
        }
    }


}

