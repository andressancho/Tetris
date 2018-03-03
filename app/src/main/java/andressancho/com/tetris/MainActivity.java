package andressancho.com.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gl = findViewById(R.id.gl);
        ArrayList<View> views= new ArrayList<View>();

        for(int x=0;x<13;x++){
            for(int y=0;y<18;y++){
                ImageView iv= new ImageView(this);
                iv.setTag(Integer.toString(x)+Integer.toString(y));
                iv.setImageResource(R.drawable.pieza);
                ViewGroup.LayoutParams params = iv.getLayoutParams();
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                iv.setLayoutParams(params);
                views.add(iv);
            }

        }
        gl.addChildrenForAccessibility(views);

    }
}
