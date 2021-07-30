package SocketServer;

import SocketServer.dijkstra.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class SocketServidor {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int puerto = 8000;

        try {

            Graph.Edge[] GRAPHTIEMPO = {
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

            Graph.Edge[] GRAPHDISTANCIA = {
                    new Graph.Edge("La Comarca","Rivendel",500),
                    new Graph.Edge("Rivendel","La Comarca",500),
                    new Graph.Edge("Rivendel","Reino del Bosque",950),
                    new Graph.Edge("Rivendel","Rohan",550),
                    new Graph.Edge("Rivendel","Telmar",1100),
                    new Graph.Edge("Rohan","Rivendel",550),
                    new Graph.Edge("Rohan","Isengard",400),
                    new Graph.Edge("Rohan","Gondor",600),
                    new Graph.Edge("Gondor","Rohan",600),
                    new Graph.Edge("Gondor","Erebor",1250),
                    new Graph.Edge("Gondor","Mordor",450),
                    new Graph.Edge("Gondor","Narnia",550),
                    new Graph.Edge("Gondor","Ciudad Esmeralda",1100),
                    new Graph.Edge("Mordor","Isengard",550),
                    new Graph.Edge("Mordor","Winkie",600),
                    new Graph.Edge("Isengard","Rohan",400),
                    new Graph.Edge("Isengard","Moria",400),
                    new Graph.Edge("Moria","Isengard",400),
                    new Graph.Edge("Moria","Erebor",900),
                    new Graph.Edge("Erebor","Moria",900),
                    new Graph.Edge("Erebor","Gondor",1250),
                    new Graph.Edge("Reino del Bosque","Erebor",500),
                    new Graph.Edge("Reino del Bosque","Rivendel",950),
                    new Graph.Edge("Narnia","Telmar",400),
                    new Graph.Edge("Narnia","Charn",450),
                    new Graph.Edge("Narnia","Gondor",550),
                    new Graph.Edge("Narnia","Ciudad Esmeralda",1300),
                    new Graph.Edge("Telmar","Narnia",400),
                    new Graph.Edge("Telmar","Rivendel",1100),
                    new Graph.Edge("Charn","Narnia",450),
                    new Graph.Edge("Charn","Winkie",700),
                    new Graph.Edge("Ciudad Esmeralda","Munchkin",200),
                    new Graph.Edge("Ciudad Esmeralda","Winkie",300),
                    new Graph.Edge("Ciudad Esmeralda","Gondor",1100),
                    new Graph.Edge("Ciudad Esmeralda","Narnia",1300),
                    new Graph.Edge("Winkie","Ciudad Esmeralda",300),
                    new Graph.Edge("Winkie","Mordor",600),
                    new Graph.Edge("Winkie","Charn",700),
                    new Graph.Edge("Munchkin","Ciudad Esmeralda",200),
            };

            Graph.Edge[] GRAPHPRECIO = {
                    new Graph.Edge("La Comarca","Rivendel",1550),
                    new Graph.Edge("Rivendel","La Comarca",1850),
                    new Graph.Edge("Rivendel","Reino del Bosque",2400),
                    new Graph.Edge("Rivendel","Rohan",1975),
                    new Graph.Edge("Rivendel","Telmar",3750),
                    new Graph.Edge("Rohan","Rivendel",1675),
                    new Graph.Edge("Rohan","Isengard",1300),
                    new Graph.Edge("Rohan","Gondor",1550),
                    new Graph.Edge("Gondor","Rohan",2350),
                    new Graph.Edge("Gondor","Erebor",4225),
                    new Graph.Edge("Gondor","Mordor",3125),
                    new Graph.Edge("Gondor","Narnia",1975),
                    new Graph.Edge("Gondor","Ciudad Esmeralda",4250),
                    new Graph.Edge("Mordor","Isengard",1375),
                    new Graph.Edge("Mordor","Winkie",1500),
                    new Graph.Edge("Isengard","Rohan",1300),
                    new Graph.Edge("Isengard","Moria",1100),
                    new Graph.Edge("Moria","Isengard",1300),
                    new Graph.Edge("Moria","Erebor",2225),
                    new Graph.Edge("Erebor","Moria",2000),
                    new Graph.Edge("Erebor","Gondor",3525),
                    new Graph.Edge("Reino del Bosque","Erebor",2450),
                    new Graph.Edge("Reino del Bosque","Rivendel",2100),
                    new Graph.Edge("Narnia","Telmar",1800),
                    new Graph.Edge("Narnia","Charn",3125),
                    new Graph.Edge("Narnia","Gondor",2875),
                    new Graph.Edge("Narnia","Ciudad Esmeralda",4750),
                    new Graph.Edge("Telmar","Narnia",1500),
                    new Graph.Edge("Telmar","Rivendel",3750),
                    new Graph.Edge("Charn","Narnia",1225),
                    new Graph.Edge("Charn","Winkie",875),
                    new Graph.Edge("Ciudad Esmeralda","Munchkin",1600),
                    new Graph.Edge("Ciudad Esmeralda","Winkie",2250),
                    new Graph.Edge("Ciudad Esmeralda","Gondor",4250),
                    new Graph.Edge("Ciudad Esmeralda","Narnia",4750),
                    new Graph.Edge("Winkie","Ciudad Esmeralda",1950),
                    new Graph.Edge("Winkie","Mordor",750),
                    new Graph.Edge("Winkie","Charn",875),
                    new Graph.Edge("Munchkin","Ciudad Esmeralda",1200),
            };

            Graph gTiempo = new Graph(GRAPHTIEMPO);
            Graph gDistancia = new Graph(GRAPHDISTANCIA);
            Graph gPrecio = new Graph(GRAPHPRECIO);


            ServerSocket miServidor = new ServerSocket(puerto);
            Socket miCliente;

            Boolean flag = true;

            while(flag) {


                System.out.println("Esperando conexion...");

                miCliente = miServidor.accept();

                System.out.println("Conexin Aceptada");

                InputStreamReader streamSocket = new InputStreamReader(miCliente.getInputStream());
                BufferedReader lectorSocket = new BufferedReader(streamSocket);

                PrintWriter escritorSocket = new PrintWriter(miCliente.getOutputStream(), true);

                String mensajeRecibido, mensajeEnviado, mensajeTransmitido;
                System.out.println("Esperando mensaje...");
                mensajeRecibido=lectorSocket.readLine();
                System.out.print("Mensaje del cliente: "+mensajeRecibido +"\n");
                String[] parts = mensajeRecibido.split(":");
                String opcion = parts[0]; // 123
                String origen = parts[1]; // 654321
                String destino = parts[2]; // 654321

                gTiempo.dijkstra(origen);
                gDistancia.dijkstra(origen);
                gPrecio.dijkstra(origen);

                //Armado
                gPrecio.printPath(destino);
                gTiempo.printPath(destino);
                gDistancia.printPath(destino);
                //gDistancia.printPath(ciudadFinal);
                //gPrecio.printPath(ciudadFinal);
                //  print the shortest path using Dijkstra algorithm
                //g.printAllPaths();

                //String jsonText = Graph.obtenerMensaje();
                //System.out.println(jsonText);
                //String tiempo = "";

                ArrayList<String> mensaje = Graph.obtenerMensaje();
                //mensaje.add(gTiempo.printPathFinal(ciudadFinal, jsonText));

                System.out.println("Aqui estamos");
                String jsonTexto = "";
                for (int i = 0; i < mensaje.size(); i++) {
                    //System.out.printf(mensaje.get(i).toString());
                    jsonTexto += mensaje.get(i);
                }

                jsonTexto = jsonTexto.replace("\n", "");

                //System.out.println(tiempo);
                /*System.out.println(tiempo);
                System.out.println(tiempo);
                System.out.println(tiempo);*/

                System.out.println(opcion);
                if(mensajeRecibido.contains("GET")) {
                    mensajeRecibido = "GET";
                }

                switch (opcion) {
                    case "GET" :
                    case "get" :
                    case "Get" :
                        mensajeTransmitido = jsonTexto;
                        System.out.println(mensajeTransmitido);
                        escritorSocket.println(jsonTexto);
                        miCliente.close();
                        System.out.println("The server is shut down!");
                        Graph.limpiarArreglo();
                        break;
                    default:
                        mensajeTransmitido = "{'name':'John', 'age':31, 'city':'New York'}";
                        System.out.println(mensajeTransmitido);
                        escritorSocket.println(mensajeTransmitido);
                        break;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


}
