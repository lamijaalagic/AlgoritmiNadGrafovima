package ba.unsa.etf.rma.lamija.algoritminadgrafovima;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by lamija on 8/17/19.
 */

//pocetni fragment na kojem je lista vrsta algoritama koristenih u aplikaciji
public class PocetniFragment extends Fragment {

    public View v;
    public ListView lista_algoritama;
    AdapterPrikaziListuAlgoritama adapter_prikazi;
    public ArrayAdapter<String> adapter;

    private OnItemClick oic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_pocetni_lista_alg, container, false);
        lista_algoritama=(ListView)v.findViewById(R.id.listaAlgoritama);
        final ArrayList<String> kategorije= new ArrayList<String>();
        kategorije.add("Obilazak grafa");
        kategorije.add("Najmanje obuhvatno stablo");
        kategorije.add("Najkraći put");
        //adapter za prikaz vrsta algoritama
        adapter= new ArrayAdapter<String>(getActivity(), R.layout.element_liste_algoritama,R.id.NazivVrsteAlg,kategorije);
        //adapter_prikazi= new AdapterPrikaziListuAlgoritama(getApplicationContext(),R.layout.element_liste_algoritama,a.kategorije_algoritama);
        lista_algoritama.setAdapter(adapter);

        try {
            oic=(OnItemClick)getActivity();
        }
        catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()+"Potrebno je implementirati OnItemClick");
        }

        lista_algoritama.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                while(!GlobalnaAlgoritmi.algoritmi_kategorije.isEmpty())
                    GlobalnaAlgoritmi.algoritmi_kategorije.remove(0);
                for (int j = 0; j < GlobalnaAlgoritmi.algoritmi.size(); j++) {
                    if (GlobalnaAlgoritmi.algoritmi.get(j).getKategorija() == kategorije.get(i))
                        GlobalnaAlgoritmi.algoritmi_kategorije.add(GlobalnaAlgoritmi.algoritmi.get(j));
                }
                oic.onItemClick(i);

            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public interface OnItemClick{
        public void onItemClick(int pos);


    }
}
