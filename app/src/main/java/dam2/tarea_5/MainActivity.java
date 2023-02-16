package dam2.tarea_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button parar, correr;
    ImageView tioCorriendo;
    AnimationDrawable animacion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correr = findViewById(R.id.correr);
        parar = findViewById(R.id.parar);
        tioCorriendo = findViewById(R.id.tioCorriendo);
        tioCorriendo.setImageResource(R.drawable.tio_andando);
        correr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                animacion = (AnimationDrawable) tioCorriendo.getDrawable();
                animacion.start();
            }
        });

        parar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                animacion.stop();
            }
        });

        ImageView casa = (ImageView) findViewById(R.id.casita);
        Animation alphaAnimation = new AlphaAnimation(1,0);

        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatCount(Animation.REVERSE);
        casa.startAnimation(alphaAnimation);
    }

    public void animar(View view)
    {
        ImageView latido = (ImageView) view;
        Drawable d = latido.getDrawable();
        if (d instanceof AnimatedVectorDrawableCompat)
        {
            AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat) d;
            avd.start();
        }
        else if (d instanceof AnimatedVectorDrawable)
        {
            AnimatedVectorDrawable avd = (AnimatedVectorDrawable) d;
            avd.start();
        }
    }
}