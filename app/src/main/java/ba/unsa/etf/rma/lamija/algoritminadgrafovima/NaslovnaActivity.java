package ba.unsa.etf.rma.lamija.algoritminadgrafovima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class NaslovnaActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naslovna);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(NaslovnaActivity.this,PocetnaListaAlgoritama.class);
                startActivity(intent);
                finish();
            }
        }, 7000);
    }
}
