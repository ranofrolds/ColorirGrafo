import grafo.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class LerGrafo {
    public LerGrafo(Grafo g, String fileName) throws IOException {

        String path = "C:\\Users\\pedro\\Documents\\UEM\\GRAFOS\\trab2\\grafos_de_entrada\\" + fileName;
        FileReader fr = abrirArquivo(path);
        BufferedReader br = new BufferedReader(fr);

        String n[];
        String aresta[];
        String aux = br.readLine();

        if (aux.equals("dl")) {
            br.readLine();
            n = br.readLine().split("=");
            // System.out.println(n[1]);
            g.setGrafo(Integer.parseInt(n[1]));
            br.readLine();
            aux = br.readLine();
            while (aux != null) {
                aresta = aux.split(" ");
                g.adj.adicionarAdjacente(Integer.parseInt(aresta[0]) - 1, Integer.parseInt(aresta[1]) - 1);
                aux = br.readLine();
            }
        }

    }

    public FileReader abrirArquivo(String path) throws FileNotFoundException {
        FileReader fr = new FileReader(path);

        return fr;
    }
}
