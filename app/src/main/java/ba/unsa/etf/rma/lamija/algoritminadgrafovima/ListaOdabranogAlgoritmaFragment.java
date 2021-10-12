package ba.unsa.etf.rma.lamija.algoritminadgrafovima;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by lamija on 8/17/19.
 */

// fragment koji se otvara nakon pocetnog, nakon sto odaberemo neku od ponudjenih vrsta algoritama
// otvara nam se lista algoritama koji pripadaju toj kategoriji
public class ListaOdabranogAlgoritmaFragment extends Fragment {

    public View v;
    public ListView lista_odabranog_alg;
    public TextView odabrani_alg;
    AdapterPrikaziListuAlgoritama adapter_prikaza;
    public Button dPovratak;
    public Button dOtvoriDetalje;
    public Boolean obojeno_je=false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_odabrana_lista_alg, container, false);
         povratak_na_pocetnu_listu();
         lista_odabranog_alg = (ListView)v.findViewById(R.id.listaAlgKategorije);
         odabrani_alg = (TextView)v.findViewById(R.id.odabraniAlg);
         if (GlobalnaAlgoritmi.algoritmi_kategorije!=null) {
             odabrani_alg.setText(GlobalnaAlgoritmi.algoritmi_kategorije.get(0).getKategorija());
         }
         adapter_prikaza = new AdapterPrikaziListuAlgoritama(getActivity(),R.layout.element_odabrane_kategorije,GlobalnaAlgoritmi.algoritmi_kategorije);
         lista_odabranog_alg.setAdapter(adapter_prikaza);

//otvaranje novog fragmenta detalji odabranog algoritma
         lista_odabranog_alg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 if (GlobalnaAlgoritmi.odabrani_algoritam != null) {
                     GlobalnaAlgoritmi.odabrani_algoritam = null;
                 }
                     GlobalnaAlgoritmi.odabrani_algoritam = new Algoritam(GlobalnaAlgoritmi.algoritmi_kategorije.get(i));
                     //odabir i bojenje odabranog algoritma
                     view.setBackgroundColor(Color.parseColor("#a80a4571"));
                     obojeno_je=true;

             }
         });
//otvori fragment detalje, nakon odabira algoritma otvori se fragment koji prikazuje detalje tog algoritma
         dOtvoriDetalje = (Button)v.findViewById(R.id.dugmeOtvoriDetaljeOdabranogAlg);
         dOtvoriDetalje.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (obojeno_je) {
                     getActivity().setContentView(R.layout.activity_main);
                     DetaljiOdabranogAlgoritmaFragment detalji_fragment = new DetaljiOdabranogAlgoritmaFragment();
                     getFragmentManager().beginTransaction().replace(R.id.pocetniF1, detalji_fragment).addToBackStack(null).commit();
                 }
                 else {
                     Toast.makeText(ListaOdabranogAlgoritmaFragment.this.getActivity(),"Potrebno je odabrati algoritam.",Toast.LENGTH_LONG).show();
                 }
             }
         });
         return v;
    }


//povratak na prethodni fragment pocetna lista algoritama
    public void povratak_na_pocetnu_listu() {
        dPovratak = (Button)this.v.findViewById(R.id.dugmePovratakNaPocetak);
        dPovratak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setContentView(R.layout.activity_main);
                PocetniFragment pocetni=new PocetniFragment();
                getFragmentManager().beginTransaction().replace(R.id.pocetniF1,pocetni).addToBackStack(null).commit();
            }
        });
    }
}
