import java.util.ArrayList;
import java.util.Arrays;

import grafo.*;

public class Colorir {
    public String[] colorir(Grafo g){
        String[] colored=new String[g.numVet];
        Arrays.fill(colored,"null");
        
        for(int i=0;i< g.vertices.length;i++){
            if(g.vertices[i].cor=="null"){//caso nao tenha cor checa os adjacentes
                g.vertices[i].cores=checarAdj(g.vertices[i], g);
            }
            if(g.vertices[i].cores.size()<=0){//se nao tiver cor disponivel para realizar a pintura
                
                g.vertices[i].cor="null";
                colored[i]="null";

                int j=i-1;//indice do vertice previamente colorido
                
                Vertice vert=g.vertices[j]; //realiza o loop, para encontrar o primeiro vertice anterior com a possiblidade de realizar a troca de cor, e testar uma nova combinação
                while((vert.cores.indexOf(vert.cor)+1)>=vert.cores.size()){//{"Preto", "Vermelho",     }  cor="Preto"  indexOf(Preto)-> 0+1
                    vert.cor="null";
                    colored[vert.valor]="null";
                    j--;
                    if(j==-1){ //se chegar no ultimo elemento e nao tive rmais combinções
                        System.out.println("Nao foi possivel encontrar uma combinação com 4 cores!!");
                        return null;
                    }
                    vert=g.vertices[j];
                }

                vert.cor=vert.cores.get(vert.cores.indexOf(vert.cor)+1);//pega a proxima cor e coloca como atual
                colored[vert.valor]=vert.cor;
                i=j;   
            }
            else{
                g.vertices[i].cor=g.vertices[i].cores.get(0); //a cor escolhida é a primeira disponivel
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

        for (int adj : g.adj.listaAdj[vertice.valor]) {//checa a cor de todos os adjacentes
            if(g.vertices[adj].cor!="null" && (disponivel.indexOf((g.vertices[adj].cor))!=-1)){//se existir cor, e ainda nao tiver sido retirada
                disponivel.remove(disponivel.indexOf((g.vertices[adj].cor)));
            }
        }

        return disponivel;//retorna cores disponiveis para colorior o vertice
    }
}

