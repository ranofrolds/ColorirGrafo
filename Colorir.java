import java.util.ArrayList;
import java.util.Arrays;

import grafo.*;

public class Colorir {
    public String[] colorir(Grafo g){
        String[] colored=new String[g.numVet];
        Arrays.fill(colored,"null");
        
        for(int i=0;i< g.vertices.length;i++){
            if(g.vertices[i].cor=="null"){
                g.vertices[i].cores=checarAdj(g.vertices[i], g);
            }
            if(g.vertices[i].cores.size()<=0){
                
                g.vertices[i].cor="null";
                colored[i]="null";

                int j=i-1;
                
                Vertice vert=g.vertices[j]; 
                while((vert.cores.indexOf(vert.cor)+1)>=vert.cores.size()){//{"Preto", "Vermelho",     }  cor="Preto"  indexOf(Preto)-> 0+1
                    vert.cor="null";
                    colored[vert.valor]="null";
                    j--;
                    if(j==-1){ 
                        System.out.println("Deu trevo Pssor!!");
                        System.out.println("NOSSO CODIGO E HORRIVEL, PUTA MATERIA HORRIVEL LIXO!!");
                        return null;
                    }
                    vert=g.vertices[j];
                }

                vert.cor=vert.cores.get(vert.cores.indexOf(vert.cor)+1);
                colored[vert.valor]=vert.cor;
                i=j;   
            }
            else{
                g.vertices[i].cor=g.vertices[i].cores.get(0);
                colored[i]=g.vertices[i].cor;
            }
        }

        
        return colored;
    }

    public ArrayList<String> checarAdj(Vertice vertice, Grafo g){
        ArrayList<String> disponivel = new ArrayList<String>();
        disponivel.add("Preto");
        disponivel.add("Verde");
        disponivel.add("Branco");
        disponivel.add("Vermelho");

        for (int adj : g.adj.listaAdj[vertice.valor]) {
            if(g.vertices[adj].cor!="null" && (disponivel.indexOf((g.vertices[adj].cor))!=-1)){
                disponivel.remove(disponivel.indexOf((g.vertices[adj].cor)));
            }
        }

        return disponivel;
    }
}

