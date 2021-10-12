package ba.unsa.etf.rma.lamija.algoritminadgrafovima;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lamija on 8/16/19.
 */

public class AdapterPrikaziListuAlgoritama extends ArrayAdapter {

    List lista= new ArrayList();

    public AdapterPrikaziListuAlgoritama(@NonNull Context context, int resource, ArrayList<Algoritam> vrste_algoritama) {
        super(context, resource);
        lista=vrste_algoritama;
    }

    static class DataHandler {
        ImageView Slikica;
        TextView Naziv;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        lista.add(object);
    }

    @Override
    public int getCount() { return this.lista.size(); }

    @Nullable
    @Override
    public Object getItem(int position) { return this.lista.get(position); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View red;
        red=convertView;
        AdapterPrikaziListuAlgoritama.DataHandler handler;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            red = inflater.inflate(R.layout.element_odabrane_kategorije, parent, false);
            handler = new AdapterPrikaziListuAlgoritama.DataHandler();
            handler.Naziv = (TextView) red.findViewById(R.id.nazivAlgoritma);
            handler.Slikica = (ImageView) red.findViewById(R.id.slikaAlgoritma);
            red.setTag(handler);
        }
        else {
            handler = (AdapterPrikaziListuAlgoritama.DataHandler) red.getTag();
        }

        Algoritam a;
        a = (Algoritam) this.getItem(position);
        if (a!=null) {
            handler.Naziv.setText(a.getNaziv());
            handler.Slikica.setImageResource(a.getSlika());
        }
        else{
            handler.Naziv.setText("Nema naziva");
            handler.Slikica.setImageResource(R.drawable.slikica_pocetna);
        }
        return red;
    }
}
