package grafo;

public class Grafo {
    public Vertice vertices[];
    public Adjacente adj;
    public int numVet;

    public Grafo() {

    }

    public void setGrafo(int n) {
        this.numVet = n;
        this.adj = new Adjacente(this.numVet);

        this.vertices = new Vertice[n];
        for (int i = 0; i < this.numVet; i++) {
            vertices[i] = new Vertice(i);
        }
    }

}
