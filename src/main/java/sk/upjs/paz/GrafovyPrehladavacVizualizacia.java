package sk.upjs.paz;

import java.awt.Color;
import java.util.*;
import sk.upjs.paz.graph.*;
import sk.upjs.paz.graph.visualization.GraphVisualizer;

public class GrafovyPrehladavacVizualizacia {

    /**
     * Graf, ktory je prehladavany a skumany.
     */
    private Graph g;

    /**
     * Visualizator skumaneho grafu.
     */
    private GraphVisualizer gv;

    /**
     * Vytvori novy grafovy prehladavac.
     *
     * @param g
     *            graf, ktory ma byt vytvorenym prehladavacom prehladavany.
     */
    public GrafovyPrehladavacVizualizacia(Graph g) {
        this.g = g;
        this.gv = new GraphVisualizer(g);
    }

    /**
     * Realizuje prehladavanie do sirky
     *
     * @param start
     *            startovaci vrchol, v ktorom startujeme vyhladavanie
     *
     * @return mapa, ktora urcuje, ci sa vrchol navstivil podla prehladavania
     */
    public Map<Vertex, Boolean> bfs(Vertex start) {
        // Vytvorime mapu vrcholov a vsetky vrcholy nastavime ako nenavstivene
        Map<Vertex, Boolean> navstiveny = g.createVertexMap(false);

        // Vytvorime rad pre navstivene vrcholy, ktorych susedov sme zatial
        // neskusali navstivit
        Queue<Vertex> rad = new LinkedList<Vertex>();

        // Nechame vizualizovat map-u a rad
        gv.addToMonitor("navstiveny", navstiveny);
        gv.addToMonitor("rad", rad);

        gv.pause("Po inicializacii.");

        // Na zaciatku je navstiveny iba startovaci vrchol
        navstiveny.put(start, true);
        rad.offer(start);

        gv.setColor(start, Color.green);
        gv.pause("Po spracovani startovacieho vrcholu.");

        // Kym rad nie je prazdny
        while (!rad.isEmpty()) {
            gv.pause("Nova iteracia while-cyklu");

            // Vyberieme prvy vrchol v rade
            Vertex v = rad.poll();

            gv.setColor(v, Color.red);
            gv.pause("Po vybrani spracovavaneho vrcholu: " + v);

            // Postupne vsetkych nenavstivenych susedov vrcholu v oznacime ako
            // navstivenych a pridame ich do radu
            for (Vertex sused : v.getOutNeighbours())
                if (!navstiveny.get(sused)) {
                    navstiveny.put(sused, true);
                    rad.offer(sused);

                    // Poznacime objavitelnu hranu a to, ze sused bol navstiveny
                    gv.setColor(g.getEdge(v, sused), Color.red);
                    gv.setColor(sused, Color.green);
                    gv.pause("Novy nenavstiveny sused " + sused + " vrcholu "
                            + v);
                }

            gv.setColor(v, Color.green);
        }

        gv.pause("BFS skoncene");
        gv.removeFromMonitor(navstiveny);
        gv.removeFromMonitor(rad);
        gv.resetAllColors();

        return navstiveny;
    }

    /**
     * Realizuje rekurzivne prehladavanie do hlbky
     *
     * @param v
     *            vrchol, ktory ideme navstivit
     * @param navstiveny
     *            mapa, v ktorej mame informaciu o tom, ktore vrcholy boli
     *            navstivene
     */
    private void dfs(Vertex v, Map<Vertex, Boolean> navstiveny) {
        navstiveny.put(v, true);
        gv.setColor(v, Color.red);
        gv.pause("Navstevujeme vrchol " + v);

        // Navstivime vsetkych nenavstivenych susedov
        for (Vertex sused : v.getOutNeighbours())
            if (!navstiveny.get(sused)) {
                gv.setColor(g.getEdge(v, sused), Color.red);
                dfs(sused, navstiveny);
            }

        gv.setColor(v, Color.green);
    }

    /**
     * Realizuje (spusti) rekurzivne prehladavanie do hlbky
     *
     * @param start
     *            startovaci vrchol, v ktorom startujeme vyhladavanie
     *
     * @return mapa, ktora urcuje, ci sa vrchol navstivil podla prehladavania
     */
    public Map<Vertex, Boolean> dfsRekurzivne(Vertex start) {
        // Vytvorime mapu vrcholov a vsetky vrcholy nastavime ako nenavstivene
        Map<Vertex, Boolean> navstiveny = g.createVertexMap(false);

        // Nechame vizualizovat map-u a rad
        gv.addToMonitor("navstiveny", navstiveny);
        gv.pause("Po inicializacii.");

        // Spustime vyhladavanie z aktualneho vrchola
        dfs(start, navstiveny);

        gv.pause("Po skonceni rekurzivneho DFS");
        gv.removeFromMonitor(navstiveny);
        gv.resetAllColors();
        return navstiveny;
    }

    /**
     * Realizuje nerekurzivne prehladavanie do hlbky
     *
     * @param start
     *            startovaci vrchol, v ktorom startujeme vyhladavanie
     *
     * @return mapa, ktora urcuje, ci sa vrchol navstivil podla prehladavania
     */
    public Map<Vertex, Boolean> dfsNerekurzivne(Vertex start) {
        // Vytvorime mapu vrcholov a vsetky vrcholy nastavime ako nenavstivene
        Map<Vertex, Boolean> navstiveny = g.createVertexMap(false);

        // Vytvorime zasobnik pre vrcholy, ktore mame navstivit
        Stack<Vertex> zasobnik = new Stack<Vertex>();

        // Poznacime si, ze mame preskumat startovaci vrchol
        zasobnik.push(start);

        // Nechame vizualizovat map-u a zasobnik
        gv.addToMonitor("navstiveny", navstiveny);
        gv.addToMonitor("zasobnik", zasobnik);
        gv.pause("Po inicializacii.");

        // Kym zasobnik nie je prazdny
        while (!zasobnik.isEmpty()) {
            // Vyberieme vrchol na vrchu zasobnika
            Vertex v = zasobnik.pop();

            gv.setColor(v, Color.red);
            gv.pause("Zo zasobnika sme vybrali " + v);

            // Ak uz bol navstiveny, tak "nie je co robit" a ideme dalej
            if (navstiveny.get(v)) {
                gv.setColor(v, Color.green);
                continue;
            }

            // Oznacime, ze vrchol je navstiveny
            navstiveny.put(v, true);

            // Vsetkych nenavstiveny susedov vrcholu v pridame do zasobnika
            for (Vertex sused : v.getOutNeighbours())
                if (!navstiveny.get(sused))
                    zasobnik.push(sused);

            gv.setColor(v, Color.green);
            gv.pause("Po spracovani nenavstiveneho " + v);
        }

        gv.pause("Po skonceni nerekurzivneho DFS");
        gv.removeFromMonitor(navstiveny);
        gv.removeFromMonitor(zasobnik);
        gv.resetAllColors();

        return navstiveny;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Vytvorime graf nacitanim zo suboru
        Graph g = Graph.createFromFile("/Users/laurakubanova/Documents/PAZ KODY/PAZ1b_CV/src/main/java/sk/upjs/paz/graf.txt");

        // Vytvorime grafovy prehladavac vytvoreneho grafu
        GrafovyPrehladavacVizualizacia gp = new GrafovyPrehladavacVizualizacia(g);

        // Spustime bfs (prehladavanie do sirky)
        System.out.println(gp.bfs(g.getVertex("0")));
    }
}
