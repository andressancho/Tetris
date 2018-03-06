package andressancho.com.tetris;

import android.os.Bundle;
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

    ArrayList<ArrayList<Integer>> tablero= new ArrayList<ArrayList<Integer>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initTablero();


    }
    public void initTablero(){
        GridLayout gl = findViewById(R.id.gl);

        for(int x=0;x<20;x++){
            tablero.add(new ArrayList<Integer>());
            for(int y=0;y<13;y++){
                tablero.get(x).add(0);
                ImageView iv= new ImageView(this);
                iv.setTag(Integer.toString(x)+Integer.toString(y));

                iv.setImageResource(R.drawable.pieza_verde);
                gl.addView(iv);

            }
        }
        Log.d("d",tablero.toString());

        T
    }
}

