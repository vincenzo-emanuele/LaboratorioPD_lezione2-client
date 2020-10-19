package esercizio2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class RegistroRemotoClient {

    public static void main(String[] args) {

        Socket client = null;
        Scanner sc = null;

        try {

            client = new Socket("localhost", 9000);
            sc = new Scanner(System.in);
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());

            while (true){

                System.out.println("Choose an operation:\nA: Search\nB: Insert\nQ: Quit");
                String cmd = sc.nextLine();

            switch (cmd) {

                case "A":
                    System.out.println("Insert the name of the user you are looking for");
                    String name = sc.nextLine();
                    out.writeObject(new Registro(name, null));
                    out.flush();
                    System.out.println("Prima");
                    Registro result = (Registro) in.readObject();
                    System.out.println("Fuori");
                    if(result == null){

                        System.out.println("Cannot find " + name);

                    } else {

                        System.out.println(name + "'s address is " + result.getIndirizzo());

                    }

                    break;

                case "B":
                    System.out.println("Insert the name of the user you want to add");
                    String newName = sc.nextLine();
                    System.out.println("Insert the address of the user you want to add");
                    String newAddress = sc.nextLine();
                    out.writeObject(new Registro(newName, newAddress));
                    out.flush();
                    break;

                case "Q":
                    client.close();
                    System.exit(0);

            }

        }

        } catch (Exception e){

            e.printStackTrace();

        }

    }

}
