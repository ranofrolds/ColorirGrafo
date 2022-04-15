import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import grafo.*;


public class Main{
    public static void main(String[] args) throws IOException {
        int n=0; //numero do grafo(arquivo)
        ArrayList<String> cores= new ArrayList();
        cores.add("Preto");
        cores.add("Verde");
        cores.add("Branco");
        cores.add("Vermelho");
        Main main= new Main();
        if(n>=0 && n<60){

            String fileName= Integer.toString(n)+"_grafo.txt";
            Grafo g=new Grafo();
            LerGrafo read=new LerGrafo(g, fileName);
            main.printarListaAdj(g);
            Colorir col=new Colorir();
            for (String string : col.colorirGrafo(g, 0, cores)) {
                System.out.println(string);
            }
            
        }
        
    }

    public void printarListaAdj(Grafo g){
        for(int i=0; i<g.numVet;i++){
            for (Integer v : g.adj.listaAdj[i]) {
                System.out.println(i+" "+v);
            }
        }
        
    }
}