/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 5442
 */
public class ThreadServer {
  public static void main(String[] args) throws IOException {
        final int PORT = 8080;
        ServerSocket serverSocket = new ServerSocket(PORT);
        
        System.out.println("Server started...");
        System.out.println("Wating for clients...");
        
        while (true) {
            final Socket clientSocket = serverSocket.accept();
            Thread t = new Thread() {
                public void run() {
                    try (
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        Scanner in = new Scanner(clientSocket.getInputStream());
                    ) {
                        while (in.hasNextLine()) {
                            String input = in.nextLine();
                            if (input.equalsIgnoreCase("exit")) {
                                break;
                            }
                            System.out.println("Received radius from client: " + input);
                            
//                            double radius = Double.valueOf(input);
//                            double area = Math.PI* radius *radius ;
//                            out.println(area);
                        }
                    } catch (IOException e) { }
                }
            };
            t.start();
        }
    }   

    public static Socket accept() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ThreadServer(int port) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ThreadServer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
