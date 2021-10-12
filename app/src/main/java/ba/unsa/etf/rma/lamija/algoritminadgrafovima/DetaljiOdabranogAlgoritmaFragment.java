package ba.unsa.etf.rma.lamija.algoritminadgrafovima;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lamija on 8/20/19.
 */

public class DetaljiOdabranogAlgoritmaFragment extends Fragment {

    public View v;
    public TextView naslov;
    public TextView detalji_alg;
    public TextView logika_alg;
    public Button povratak_na_listu;
    public Button idi_na_korake;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_detalji_odabranog_algoritma, container,false);
        povratak_nazad();
        naslov = (TextView) v.findViewById(R.id.naslovOdabranogAlg);
        naslov.setText(GlobalnaAlgoritmi.odabrani_algoritam.getNaziv());
        detalji_alg = (TextView) v.findViewById(R.id.detaljiAlgoritma);
        detalji_alg.setText(GlobalnaAlgoritmi.odabrani_algoritam.getTeorija());
        logika_alg = (TextView) v.findViewById(R.id.logikaAlgoritma);
        logika_alg.setText(GlobalnaAlgoritmi.odabrani_algoritam.getLogika_rjesavanja());

//prelazak na sljedeci fragment u kojem se opisuju koraci rjesavanja algoritma
        idi_na_korake = (Button)v.findViewById(R.id.dugmePrikazaAlg);
        idi_na_korake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setContentView(R.layout.activity_main);
                KoraciRjesavanjaOdabranogAlgoritmaFragment koraci_fragment=new KoraciRjesavanjaOdabranogAlgoritmaFragment();
                getFragmentManager().beginTransaction().replace(R.id.pocetniF1,koraci_fragment).addToBackStack(null).commit();
            }
        });


        return v;
    }

//povratak na pocetnu aktivnost liste sa vrstama algoritama
    public void povratak_nazad() {
        povratak_na_listu = (Button)this.v.findViewById(R.id.dugmePpovratakNaListu);
        povratak_na_listu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setContentView(R.layout.activity_main);
                PocetniFragment pocetni=new PocetniFragment();
                getFragmentManager().beginTransaction().replace(R.id.pocetniF1,pocetni).addToBackStack(null).commit();
            }
        });
    }
}
