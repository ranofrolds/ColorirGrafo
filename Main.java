import java.io.IOException;
import java.util.ArrayList;

import grafo.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n =28 ; // numero do grafo(arquivo)
        ArrayList<String> cores = new ArrayList<String>();
        cores.add("Preto");
        cores.add("Verde");
        cores.add("Branco");
        cores.add("Vermelho");
        Main main = new Main();
        if (n >= 0 && n <= 61) {//61 pois criamos 2 grafos para testar o codigo
            // for(n=1; i<=n;i++){ //realizar coloração de todos os grafos
                System.out.println("GRAFO NUMERO = "+n);
                System.out.println("Lendo o grafo...");
                String fileName = Integer.toString(n) + "_grafo.txt";
                Grafo g = new Grafo();
                LerGrafo read = new LerGrafo(g, fileName);
                // main.printarListaAdj(g);
                System.out.println("Grafo acessado. Realizando a coloração...");
                Colorir col = new Colorir();
                String[] result= col.colorir(g);
                if(result!=null){
                    System.out.println("Grafo colorido com sucesso, segue as combinações:");
                    int j=0;
                    for (String string : result) {
                        System.out.println((j+1)+" - "+string);
                        j++;
                    }
                }
                else{
                    System.out.println("Retorno = null");
                }
            // }
            
            

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