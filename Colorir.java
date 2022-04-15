
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import grafo.*;

public class Colorir {
    public String[] colorirGrafo(Grafo g, int inicio, ArrayList<String> cores){
        Queue<Integer> q = new LinkedList<>();
        String[] colored=new String[g.numVet];
        Arrays.fill(colored,"null");

        g.vertices[inicio].cor=cores.get(0);
        colored[inicio]=cores.get(0);
        q.add(inicio);

        while(q.size()>0){
            int vertice=q.remove();
            Iterator<Integer> i = g.adj.listaAdj[vertice].iterator();
            while(i.hasNext()){
                int next = i.next();
                System.out.println(next);
                if(colored[next]=="null"){
                    ArrayList<String> disponivel= new ArrayList<>(cores);
                    for (int adj : g.adj.listaAdj[next]) {
                        if(g.vertices[adj].cor!="null" && (disponivel.indexOf((g.vertices[adj].cor))!=-1)){
                                disponivel.remove(disponivel.indexOf((g.vertices[adj].cor)));
                    
                        }
                        // if(g.vertices[adj].cor!="null" && disponivel!=null){
                        //    if((disponivel.indexOf((g.vertices[adj].cor))!=-1)){
                        //         disponivel.remove(disponivel.indexOf((g.vertices[adj].cor)));
                        //    }
                        // }
                    }
                    if(disponivel.size()==0){
                        return null;
                    }
                    colored[next]=disponivel.get(0);
                    g.vertices[next].cor=disponivel.get(0);
                    q.add(next);
                }
            }
        }
        return colored;
    }
}
