package ba.unsa.etf.rma.lamija.algoritminadgrafovima;

import android.app.Application;
import android.util.Pair;

import java.util.ArrayList;

/**
 * Created by lamija on 8/16/19.
 */

public class GlobalnaAlgoritmi extends Application {
    public static ArrayList<String> kategorije_algoritama = new ArrayList<String>();
    public static ArrayList<Algoritam> algoritmi = new ArrayList<Algoritam>();
    public static ArrayList<Algoritam> algoritmi_kategorije = new ArrayList<Algoritam>();
    public static Algoritam odabrani_algoritam;

    Algoritam a1,a2,a3,a4;
    ArrayList<Pair<Integer,Integer>> k1 = new ArrayList<Pair<Integer, Integer>>();
    ArrayList<Pair<Integer,Integer>> k2 = new ArrayList<Pair<Integer, Integer>>();
    ArrayList<Pair<Integer,Integer>> k3 = new ArrayList<Pair<Integer, Integer>>();
    ArrayList<Pair<Integer,Integer>> k4 = new ArrayList<Pair<Integer, Integer>>();
    Pair<Integer,Integer> p1;

    public GlobalnaAlgoritmi() {
        kategorije_algoritama.add("Obilazak grafa");
        kategorije_algoritama.add("Najmanje obuhvatno stablo");
        kategorije_algoritama.add("Najkraći put");

//koraci rjesavanja DFS algoritma

        p1=new Pair<Integer, Integer>(R.string.DFSkorak1,R.drawable.dfs_s1);
        k1.add(p1);
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak1,R.drawable.dfs_s2));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak1,R.drawable.dfs_s3));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak2,R.drawable.dfs_s4));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak2,R.drawable.dfs_s5));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak3,R.drawable.dfs_s6));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak4,R.drawable.dfs_s7));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak4,R.drawable.dfs_s8));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak5,R.drawable.dfs_s9));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak6,R.drawable.dfs_s10));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak6,R.drawable.dfs_s11));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak7,R.drawable.dfs_s12));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak8,R.drawable.dfs_s13));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak9,R.drawable.dfs_s14));
        k1.add(new Pair<Integer, Integer>(R.string.DFSkorak9,R.drawable.dfs_s15));

//koraci rjesavanja BFS algoritma

        k2.add(new Pair<Integer, Integer>(R.string.BFSkorak1,R.drawable.dfs_s1));
        k2.add(new Pair<Integer, Integer>(R.string.BFSkorak1,R.drawable.bfs_s1));
        k2.add(new Pair<Integer, Integer>(R.string.BFSkorak2,R.drawable.bfs_s2));
        k2.add(new Pair<Integer, Integer>(R.string.BFSkorak3,R.drawable.bfs_s3));
        k2.add(new Pair<Integer, Integer>(R.string.BFSkorak4,R.drawable.bfs_s4));
        k2.add(new Pair<Integer, Integer>(R.string.BFSkorak5,R.drawable.bfs_s5));
        k2.add(new Pair<Integer, Integer>(R.string.BFSkorak6,R.drawable.bfs_s6));

//koraci rjesavanja Kruskalogov algoritma

        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak1,R.drawable.kruskal_s1));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak1,R.drawable.kruskal_s12));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak2,R.drawable.kruskal_s2));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak3,R.drawable.kruskal_s3));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak4,R.drawable.kruskal_s4));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak5,R.drawable.kruskal_s5));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak6,R.drawable.kruskal_s6));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak7,R.drawable.kruskal_s7));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak8,R.drawable.kruskal_s7));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak9,R.drawable.kruskal_s9));
        k3.add(new Pair<Integer, Integer>(R.string.kruskalkorak10,R.drawable.kruskal_s10));

//koraci rjesavanja Dijkstrinog algoritma

        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak1,R.drawable.kruskal_s1));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak1,R.drawable.dijkstra_w1));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak1,R.drawable.dijkstra_w2));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak2,R.drawable.dijkstra_w3));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak2,R.drawable.dijkstra_w4));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak3,R.drawable.dijkstra_w5));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak3,R.drawable.dijkstra_w6));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak4,R.drawable.dijkstra_w7));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak4,R.drawable.dijkstra_w8));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak5,R.drawable.dijkstra_w9));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak6,R.drawable.dijkstra_w10));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak7,R.drawable.dijkstra_w11));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak7,R.drawable.dijkstra_w12));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak8,R.drawable.dijkstra_w13));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak8,R.drawable.dijkstra_w14));
        k4.add(new Pair<Integer, Integer>(R.string.dijkstrakorak9,R.drawable.dijkstra_w15));

        a1= new Algoritam(1,"Obilazak po dubini (DFS)",kategorije_algoritama.get(0),R.string.defDFS,R.string.logikaDFS,R.drawable.dfs,k1);
        a2= new Algoritam(2,"Obilazak po širini (BFS)",kategorije_algoritama.get(0),R.string.defBFS,R.string.logikaBFS,R.drawable.bfs,k2);
        a3= new Algoritam(3,"Kruskalov algoritam",kategorije_algoritama.get(1),R.string.defKruskal,R.string.logikaKruskal,R.drawable.kruskal_s1,k3);
        a4= new Algoritam(4,"Dijkstrin algoritam",kategorije_algoritama.get(2),R.string.defDijkstra,R.string.logikaDijkstra,R.drawable.kruskal_s1,k4);

        algoritmi.add(a1);
        algoritmi.add(a2);
        algoritmi.add(a3);
        algoritmi.add(a4);
    }

}
