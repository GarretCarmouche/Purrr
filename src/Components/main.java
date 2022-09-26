package Components;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

import Components.Cell;
import java.io.*;
import com.sun.net.httpserver.HttpServer;


public class main{

   static int run;

   static Cell catLocation;

    public static void main(String[] args) throws IOException{
        // Program start
        Scanner scan = new Scanner(System.in);
        System.out.println("Program starting: Enter 1 to continue, 0 to end");
        run = scan.nextInt();
        scan.close();


        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

        server.createContext("/api/components/placeWall", (exchange ->{
            if (exchange.getRequestMethod().equals("POST")){
                System.out.println("GOT A POST");
            }
        }));

        System.in.read();
    
        // Generate the board -- walls

        //HTTP Listener
    
        // Select cat location
        catLocation = new Cell();
    
        int x;

    }
    
    public static Cell getMouseMove(){
        //Return the cel that the cat moves to
        // Where the AI goes
        return new Cell();
    }


}


