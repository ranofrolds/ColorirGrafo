package grafo;

import java.util.*;

public class Adjacente {
    public LinkedList<Integer>[] listaAdj;

    public Adjacente(int n) {
        listaAdj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            listaAdj[i] = new LinkedList<Integer>();
        }
    }

    public void adicionarAdjacente(int i, int j) {
        listaAdj[i].add(j);
        listaAdj[j].add(i);
    }

}
