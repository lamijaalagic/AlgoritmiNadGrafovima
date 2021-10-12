package ba.unsa.etf.rma.lamija.algoritminadgrafovima;

import android.media.Image;
import android.util.Pair;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by lamija on 8/16/19.
 */

public class Algoritam {
    Integer id;
    String naziv;
    String kategorija;
    int teorija;
    int logika_rjesavanja;
    int slika;
    ArrayList<Pair<Integer,Integer>> koraci_primjera;

    //ArrayList<Koraci> primjer_algoritma;

    // razmisliti o ubacivanju liste koraka rjesavanja ovog algoritma, a uz svaki korak po jedna slika, zbog primjera rjesavanja algoritma

    public Algoritam (Integer id, String naziv, String kategorija, int teorija, int logika_rjesavanja, int slika, ArrayList<Pair<Integer,Integer>> koraci_primjera) {
        this.id=id;
        this.naziv=naziv;
        this.kategorija=kategorija;
        this.teorija=teorija;
        this.logika_rjesavanja=logika_rjesavanja;
        this.slika=slika;
        this.koraci_primjera=koraci_primjera;
    }

    public Algoritam (Algoritam a) {
        this.id=a.getId();
        this.naziv=a.getNaziv();
        this.kategorija=a.getKategorija();
        this.teorija=a.getTeorija();
        this.logika_rjesavanja=a.getLogika_rjesavanja();
        this.slika=a.getSlika();
        this.koraci_primjera=a.getKoraci_primjera();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKategorija() {
        return kategorija;
    }
    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public int getTeorija() {
        return teorija;
    }
    public void setTeorija(int teorija) {
        this.teorija = teorija;
    }

    public int getLogika_rjesavanja() {
        return logika_rjesavanja;
    }
    public void setLogika_rjesavanja(int logika_rjesavanja) { this.logika_rjesavanja = logika_rjesavanja; }

    public int getSlika() {
        return slika;
    }
    public void setSlika(int slika) {
        this.slika = slika;
    }

    public ArrayList<Pair<Integer, Integer>> getKoraci_primjera() { return koraci_primjera; }
    public void setKoraci_primjera(ArrayList<Pair<Integer, Integer>> koraci_primjera) { this.koraci_primjera = koraci_primjera; }
}
