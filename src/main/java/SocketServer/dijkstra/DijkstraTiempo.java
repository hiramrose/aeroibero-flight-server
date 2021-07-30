package SocketServer.dijkstra;
import java.util.*;

public class DijkstraTiempo{

    // Am I mapping this correctly by looking at the below graph?
    // looks to me I got this wrong?
    private static final Graph.Edge[] GRAPH = {
            new Graph.Edge("La Comarca","Rivendel",1.5),
            new Graph.Edge("Rivendel","La Comarca",1.5),
            new Graph.Edge("Rivendel","Reino del Bosque",2.4),
            new Graph.Edge("Rivendel","Rohan",1.6),
            new Graph.Edge("Rivendel","Telmar",5.2),
            new Graph.Edge("Rohan","Rivendel",1.6),
            new Graph.Edge("Rohan","Isengard",1.3),
            new Graph.Edge("Rohan","Gondor",1.7),
            new Graph.Edge("Gondor","Rohan",1.7),
            new Graph.Edge("Gondor","Erebor",3.0),
            new Graph.Edge("Gondor","Mordor",3.4),
            new Graph.Edge("Gondor","Narnia",4.1),
            new Graph.Edge("Gondor","Ciudad Esmeralda",5.2),
            new Graph.Edge("Mordor","Isengard",1.6),
            new Graph.Edge("Mordor","Winkie",3.2),
            new Graph.Edge("Isengard","Rohan",1.3),
            new Graph.Edge("Isengard","Moria",1.3),
            new Graph.Edge("Moria","Isengard",1.3),
            new Graph.Edge("Moria","Erebor",2.3),
            new Graph.Edge("Erebor","Moria",2.3),
            new Graph.Edge("Erebor","Gondor",3.0),
            new Graph.Edge("Reino del Bosque","Erebor",4.5),
            new Graph.Edge("Reino del Bosque","Rivendel",2.4),
            new Graph.Edge("Narnia","Telmar",1.3),
            new Graph.Edge("Narnia","Charn",3.4),
            new Graph.Edge("Narnia","Gondor",4.1),
            new Graph.Edge("Narnia","Ciudad Esmeralda",5.6),
            new Graph.Edge("Telmar","Narnia",1.3),
            new Graph.Edge("Telmar","Rivendel",5.2),
            new Graph.Edge("Charn","Narnia",3.4),
            new Graph.Edge("Charn","Winkie",3.4),
            new Graph.Edge("Ciudad Esmeralda","Munchkin",0.9),
            new Graph.Edge("Ciudad Esmeralda","Winkie",3.1),
            new Graph.Edge("Ciudad Esmeralda","Gondor",5.2),
            new Graph.Edge("Ciudad Esmeralda","Narnia",5.6),
            new Graph.Edge("Winkie","Ciudad Esmeralda",2.1),
            new Graph.Edge("Winkie","Mordor",3.2),
            new Graph.Edge("Winkie","Charn",3.4),
            new Graph.Edge("Munchkin","Ciudad Esmeralda",0.9),
    };

    private static final String START = "Mordor";
    private static final String END = "Narnia";

    public static void main(String[] args) {
        Graph g = new Graph(GRAPH);
        g.dijkstra(START);
        //  print the shortest path using Dijkstra algorithm
        g.printPath(END);
        //g.printAllPaths();
    }
}