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
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int rows=22;
    int columns=13;
    int numR=0;
    boolean colision=false;
    boolean piezanueva=false;
    ImageView[][] views= new ImageView[rows][columns];
    ImageView[][] mViews= new ImageView[4][4];

    Pieza[][] piezas=new Pieza[rows][columns];
    Pieza[][] piecita= new Pieza[4][4];
    Fabrica fabrica= new Fabrica();
    ArrayList<Pieza> figura= new ArrayList<Pieza>();
    ArrayList<Pieza> figuraSiguiente= new ArrayList<Pieza>();

    ArrayList<int[][]>rotaciones;
    int filasEliminadas=0;
    boolean terminar=false;


    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        figura=fabrica.obtenerPieza();
        rotaciones=fabrica.obtenerRotaciones();
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
                i.setImageResource(R.drawable.pieza_negra);
                mgl.addView(i);
                mViews[x][y]=i;
            }
        }
    }
    public void iniciarJuego(){
        runnable= new Runnable() {
            @Override
            public void run() {
                if(!terminar){
                    for(Pieza p:figura){
                        piezas[p.getEje_x()][p.getEje_y()]=p;
                    }

                    pintar();

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
                            figura=fabrica.obtenerPieza();
                            rotaciones=fabrica.obtenerRotaciones();
                            numR=0;
                            figuraSiguiente=fabrica.obtenerPieza();

                        }
                    }
                    if(piezanueva){
                        colision=false;
                        piezanueva=false;
                        verificarFila();
                        terminarJuego();
                    }

                }
                else {
                    pintar();
                    Toast t=Toast.makeText(getApplicationContext(),"Has perdido",Toast.LENGTH_SHORT);
                    t.show();
                }
                handler.postDelayed(runnable,1000);
            }
        };
        handler.postDelayed(runnable,1000);


    }
    public void reiniciar(View view){
        terminar=false;
        figura=fabrica.obtenerPieza();
        rotaciones=fabrica.obtenerRotaciones();
        for(int x=0;x<rows;x++){
            for(int y=0;y<columns;y++){
               piezas[x][y]=null;
            }
        }

    }
    public void toLeft(View view){

        pintar();
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
        pintar();
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
        pintar();
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
    public void rotate(View view){
        boolean colisionR=false;
        for(Pieza p:figura){
            piezas[p.getEje_x()][p.getEje_y()]=null;
        }

        for(int i=0;i<4;i++){
            if(figura.get(i).getEje_y()+rotaciones.get(numR)[i][1]<0 ||
               figura.get(i).getEje_y()+rotaciones.get(numR)[i][1]>=columns ||
               figura.get(i).getEje_x()+rotaciones.get(numR)[i][0]>=rows ||
               piezas[figura.get(i).getEje_x()+rotaciones.get(numR)[i][0]][figura.get(i).getEje_y()+rotaciones.get(numR)[i][1]]!=null ){

                colisionR=true;
            }
        }
        if(!colisionR){
            for(int x=0;x<4;x++){
                figura.get(x).setEje_x(figura.get(x).getEje_x()+rotaciones.get(numR)[x][0]);
                figura.get(x).setEje_y(figura.get(x).getEje_y()+rotaciones.get(numR)[x][1]);
            }
            if(figura.get(0).getTipo()==0){
                if(numR==1){
                    numR=0;
                }
                else{
                    numR++;
                }
            }
            else if(figura.get(0).getTipo()==1){
                if(numR==3){
                    numR=0;
                }
                else{
                    numR++;
                }
            }
            else{
                numR=0;
            }
        }


    }
    public void pintar(){
        TextView txt = findViewById(R.id.txt);
        txt.setText(Integer.toString(filasEliminadas));
        for(int x=0;x<rows;x++){
            for(int y=0;y<columns;y++){
                if(piezas[x][y]!=null){
                    switch (piezas[x][y].getColor()){
                        case 0:
                            views[x][y].setImageResource(R.drawable.pieza_amarillo);
                            break;
                        case 1:
                            views[x][y].setImageResource(R.drawable.pieza_vino);
                            break;
                        case 2:
                            views[x][y].setImageResource(R.drawable.pieza_turquesa);
                            break;
                        case 3:
                            views[x][y].setImageResource(R.drawable.pieza_verde);
                            break;
                        case 4:
                            views[x][y].setImageResource(R.drawable.pieza_azul);
                            break;
                    }

                }else{
                    views[x][y].setImageResource(R.drawable.pieza_gris);
                }
            }
        }
    }
    public void verificarFila(){
        boolean borrar=true;
        for(int x=0;x<rows;x++){
            for(int y=0;y<columns;y++){
                if(piezas[x][y]==null){
                    borrar=false;
                }
            }
            if(borrar){
                filasEliminadas++;
                for(int i=rows-1;i>=0;i--){
                    for(int j=columns-1;j>=0;j--){
                        if(i==x){
                            piezas[i][j]=null;
                        }
                        if(i<x){
                            piezas[i+1][j]=piezas[i][j];
                            piezas[i][j]=null;
                        }
                    }
                }
            }
            borrar=true;
        }
        pintar();
    }
    public void terminarJuego(){
        for(Pieza p: figura){
            if(piezas[p.getEje_x()][p.getEje_y()]!=null){
                terminar=true;
            }
        }
    }


}

