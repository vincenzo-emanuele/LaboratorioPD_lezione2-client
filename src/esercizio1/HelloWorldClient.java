package esercizio1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HelloWorldClient {

    public static void main(String[] args) {

        Socket socket = null;
        Scanner sc = new Scanner(System.in);
        String hostAddress = "";
        int port = 0;

        try{

            System.out.println("Insert host address");
            hostAddress = sc.nextLine();
            System.out.println("Insert host port");
            port = sc.nextInt();
            socket = new Socket(hostAddress, port);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            out.writeObject("Enzo");
            System.out.println(in.readObject());

        } catch(UnknownHostException e){

            System.out.println("Cannot resolve host " + hostAddress + ":" + port);

        }  catch (Exception e){

            System.out.println("Error!");

        } finally {

            try {

                socket.close();

            } catch (Exception e){

                System.exit(-1);

            }

        }

    }

}
