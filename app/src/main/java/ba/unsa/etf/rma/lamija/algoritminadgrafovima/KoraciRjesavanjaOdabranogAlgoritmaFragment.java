package ba.unsa.etf.rma.lamija.algoritminadgrafovima;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lamija on 8/20/19.
 */

public class KoraciRjesavanjaOdabranogAlgoritmaFragment extends Fragment {

    public View v;
    public TextView naslov;
    public TextView korakN;
    public ImageView slikaKorakaN;
    public Button sljedeciKorak;
    public Button nazad;
    public Integer koraci;
    public Button prethodniKorak;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_koraci_odabranog_algoritma, container, false);
        nazad_na_detalje_o_alg();
        koraci=0;

        naslov = (TextView)v.findViewById(R.id.naslovAlgoritma);
        korakN = (TextView)v.findViewById(R.id.opisKoraka);
        slikaKorakaN = (ImageView)v.findViewById(R.id.slikaKoraka);
        sljedeciKorak = (Button)v.findViewById(R.id.dugmeSljedeciKorak);
        prethodniKorak = (Button)v.findViewById(R.id.dugmePrethodniKorak);

        naslov.setText(GlobalnaAlgoritmi.odabrani_algoritam.getNaziv());
        korakN.setText(GlobalnaAlgoritmi.odabrani_algoritam.getKoraci_primjera().get(0).first);
        slikaKorakaN.setImageResource(GlobalnaAlgoritmi.odabrani_algoritam.getKoraci_primjera().get(0).second.intValue());
        prebaci_na_sljedeci_korak();
        vrati_na_prethodni_korak();

        return v;
    }

    public void prebaci_na_sljedeci_korak() {
        sljedeciKorak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (koraci < GlobalnaAlgoritmi.odabrani_algoritam.getKoraci_primjera().size()-1) {
                    koraci++;
                    korakN.setText(GlobalnaAlgoritmi.odabrani_algoritam.getKoraci_primjera().get(koraci).first);
                    slikaKorakaN.setImageResource(GlobalnaAlgoritmi.odabrani_algoritam.getKoraci_primjera().get(koraci).second.intValue());
                }
                else {
                    Toast.makeText(KoraciRjesavanjaOdabranogAlgoritmaFragment.this.getActivity(),"Ovo je zadnji korak.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void vrati_na_prethodni_korak() {
        prethodniKorak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (koraci > 0 ) {
                    koraci--;
                    korakN.setText(GlobalnaAlgoritmi.odabrani_algoritam.getKoraci_primjera().get(koraci).first);
                    slikaKorakaN.setImageResource(GlobalnaAlgoritmi.odabrani_algoritam.getKoraci_primjera().get(koraci).second.intValue());
                }
                else {
                    Toast.makeText(KoraciRjesavanjaOdabranogAlgoritmaFragment.this.getActivity(),"Ovo je prvi korak.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void nazad_na_detalje_o_alg() {
        nazad = (Button)this.v.findViewById(R.id.dugmePovratakNaDetalje);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setContentView(R.layout.activity_main);
                DetaljiOdabranogAlgoritmaFragment detalji=new DetaljiOdabranogAlgoritmaFragment();
                getFragmentManager().beginTransaction().replace(R.id.pocetniF1,detalji).addToBackStack(null).commit();
            }
        });
    }
}
