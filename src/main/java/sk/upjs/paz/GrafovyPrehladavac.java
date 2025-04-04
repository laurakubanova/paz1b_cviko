package sk.upjs.paz;

import sk.upjs.paz.graph.*;

import java.util.*;

public class GrafovyPrehladavac {

    private Graph g;

    public GrafovyPrehladavac(Graph g) {
        this.g = g;
    }

    public Map<Vertex, Integer> bfsVzdialenost(Vertex start) {
        Map<Vertex, Integer> vzdialenosti = g.createVertexMap(-1);

        Queue<Vertex> rad = new LinkedList<>();
        rad.offer(start);
        vzdialenosti.put(start, 0);

        while (!rad.isEmpty()) {
            Vertex aktulny = rad.poll();
            for (Vertex sused : aktulny.getNeighbours()) {
                if (vzdialenosti.get(sused)==-1) {
                    vzdialenosti.put(sused,vzdialenosti.get(aktulny)+1);
                    rad.offer(sused);
                }
            }
        }

        return vzdialenosti;
    }

    private void dfs(int v, boolean[] navstiveny, boolean[][] maticaSusednoti) {
        navstiveny[v]=true;
        for (int i = 0; i < navstiveny.length; i++) {
            if (!navstiveny[i]&& maticaSusednoti[v][i]){
                dfs(i,navstiveny,maticaSusednoti);
            }
        }
    }

//    public Map<Vertex, Boolean> dfs(Vertex start) {
//        Map<Vertex, Boolean> navstiveny = g.createVertexMap(false);
//        dfs(start, navstiveny);
//        return navstiveny;
//    }

    public boolean jeSpojity(){
        boolean [][] maticaSusednosti = grafNaMaticuSusednosti(g);
        boolean [] navstiveny = new boolean[maticaSusednosti.length];
        dfs(0,navstiveny,maticaSusednosti);
        for (int i = 0; i < navstiveny.length; i++) {
            if (!navstiveny[i]){
                return false;
            }
        }
        return true;
    }


    public Map<Vertex, Boolean> dfsNerekurzivne(Vertex start) {
        Map<Vertex, Boolean> navstiveny = g.createVertexMap(false);

        Stack<Vertex> zasobnik = new Stack<>();
        zasobnik.push(start);

        while (!zasobnik.isEmpty()) {
            Vertex v = zasobnik.pop();
            if (navstiveny.get(v)) {
                continue;
            }
            navstiveny.put(v, true);
            for (Vertex sused : v.getNeighbours()) {
                if (!navstiveny.get(sused)) {
                    zasobnik.push(sused);
                }
            }
        }

        return navstiveny;
    }


    public static List<Vertex> cestaZ(Graph g, Map<Vertex, Integer> vzdialenosti, Vertex kam){
        List<Vertex> cesta= new ArrayList<>();
        cesta.add(kam);
        int aktualnaVzdialenosti = vzdialenosti.get(kam);
        Vertex aktulany = kam;
        while (aktualnaVzdialenosti>0){
            for (Vertex sused : aktulany.getNeighbours()) {
                if (vzdialenosti.get(sused)==aktualnaVzdialenosti-1){
                    aktulany=sused;
                    aktualnaVzdialenosti--;
                    cesta.add(aktulany);
                }
            }
        }
        Collections.reverse(cesta);
        return cesta;
    }

    public static boolean[][] grafNaMaticuSusednosti(Graph g) {
        Vertex[] vrcholyVPoli = g.createVertexArray();
        boolean[][] matica = g.createAdjacencyMatrix(vrcholyVPoli);
        return matica;
    }

    public int pocetKomponentov(Graph g){
        //spocitali pocet komponentov
        //dfs abo bfs
        //kuknut git
        
        boolean[] navstiveny;
        int counter = 0;


        return 0;
    }


    public static void main(String[] args) {
        Graph g = Graph.createFromFile("/Users/laurakubanova/Documents/PAZ KODY/PAZ1b_CV/src/main/java/sk/upjs/paz/graf.txt");
        GrafovyPrehladavac gp = new GrafovyPrehladavac(g);
        System.out.println(gp.bfsVzdialenost(g.getVertex("0")));
        //System.out.println(gp.dfs(g.getVertex("")));
        System.out.println(g.getSize());

    }
}
