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
    ArrayList<ArrayList<Integer>> tablero= new ArrayList<ArrayList<Integer>>();
    ImageView[][] views= new ImageView[rows][columns];

    Pieza[][] piezas=new Pieza[rows][columns];
    Fabrica fabrica= new Fabrica();
    ArrayList<Pieza> figura= new ArrayList<Pieza>();
    ArrayList<Pieza> pp= new ArrayList<Pieza>();


    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        figura=fabrica.I();
        pp=new ArrayList<Pieza>();

        initTablero();
        iniciarJuego();





    }
    public void initTablero(){
        GridLayout gl = findViewById(R.id.gl);

        for(int x=0;x<rows;x++){
            tablero.add(new ArrayList<Integer>());
            for(int y=0;y<columns;y++){

                ImageView iv= new ImageView(this);
                iv.setTag(Integer.toString(x)+Integer.toString(y));
                iv.setImageResource(R.drawable.pieza_gris);
                gl.addView(iv);
                tablero.get(x).add(0);
                views[x][y]=iv;
            }
        }
    }
    public void iniciarJuego(){
        for(Pieza p:figura){
            piezas[p.getEje_x()][p.getEje_y()]=p;
        }

        runnable= new Runnable() {
            @Override
            public void run() {
                Log.d("info",String.valueOf(figura.get(0).getEje_x()));
                for(int x=0;x<rows;x++){
                    for(int y=0;y<columns;y++){
                        if(piezas[x][y]!=null){
                            views[x][y].setImageResource(R.drawable.pieza_amarillo);
                        }else{
                            views[x][y].setImageResource(R.drawable.pieza_gris);
                        }
                    }
                }

                for(Pieza p:figura) {
                    if (!piezanueva){
                        piezas[p.getEje_x()][p.getEje_y()]=null;}
                }
                for (Pieza p:figura) {
                    if(p.getEje_x()+1==rows) {
                        colision = true;
                    }
                }
                for(Pieza p:figura) {
                    if(!colision) {
                        p.setEje_x(p.getEje_x() + 1);
                        piezas[p.getEje_x()][p.getEje_y()] = p;
                    }
                    else{
                        piezanueva=true;
                    }
                }

                if(piezanueva) {

                    Log.d("info",String.valueOf(figura.get(0).getEje_x()));
                    figura=fabrica.I();

                    piezanueva = false;
                    colision = false;
                    sleep=true;


                }
                handler.postDelayed(runnable,1000);

            }
        };
        handler.postDelayed(runnable,1000);


    }


}

