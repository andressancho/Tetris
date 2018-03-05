package andressancho.com.tetris;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initTablero();

    }
    public void initTablero(){
        GridLayout gl = findViewById(R.id.gl);

        for(int x=0;x<20;x++){
            for(int y=0;y<13;y++){
                ImageView iv= new ImageView(this);
                iv.setTag(Integer.toString(x)+Integer.toString(y));
                //iv.setImageResource(R.drawable.pieza);
                gl.addView(iv);
            }
        }
    }
}

