package ba.unsa.etf.rma.lamija.algoritminadgrafovima;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;

//pocetna lista vrsta algoritama koje cu pokazati u aplikaciji

public class PocetnaListaAlgoritama extends AppCompatActivity implements PocetniFragment.OnItemClick {

    public ListView lista_algoritama;
    AdapterPrikaziListuAlgoritama adapter_prikazi;
    public ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GlobalnaAlgoritmi globalna = new GlobalnaAlgoritmi();

        FragmentManager manager= getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        FrameLayout fp = (FrameLayout)findViewById(R.id.pocetniF1);

        PocetniFragment pocetni;
        pocetni = (PocetniFragment)manager.findFragmentById(R.id.pocetniF1);

        if(pocetni == null) {
            pocetni = new PocetniFragment();
            transaction.replace(R.id.pocetniF1,pocetni).commit();
        }

    }


    @Override
    public void onItemClick(int pos) {
        ListaOdabranogAlgoritmaFragment fodabrana = new ListaOdabranogAlgoritmaFragment();
        getFragmentManager().beginTransaction().replace(R.id.pocetniF1,fodabrana).addToBackStack(null).commit();

    }
}
