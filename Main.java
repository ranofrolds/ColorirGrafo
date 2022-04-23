import java.io.IOException;
import java.util.ArrayList;

import grafo.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 61; // numero do grafo(arquivo)
        ArrayList<String> cores = new ArrayList<String>();
        cores.add("Preto");
        cores.add("Verde");
        cores.add("Branco");
        cores.add("Vermelho");
        Main main = new Main();
        if (n >= 0 && n <= 61) {
            for(int i=1; i<=n;i++){
                System.out.println("GRAFO NUMERO = "+i);
                String fileName = Integer.toString(i) + "_grafo.txt";
                Grafo g = new Grafo();
                LerGrafo read = new LerGrafo(g, fileName);
                // main.printarListaAdj(g);


                Colorir col = new Colorir();
                String[] result= col.colorir(g);
                if(result!=null){
                    for (String string : result) {
                        System.out.println(string);
                    }
                }
            }
            
            

        }

    }

    public void printarListaAdj(Grafo g) {
        for (int i = 0; i < g.numVet; i++) {
            for (Integer v : g.adj.listaAdj[i]) {
                System.out.println(i + " " + v);
            }
        }

    }
}