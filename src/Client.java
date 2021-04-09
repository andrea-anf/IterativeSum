import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        String address = "localhost";
        int port = 6789;
        String num1, num2;
        String data;
        Scanner user_input = new Scanner(System.in);

        //Create connection
        System.out.println("Connecting to server...");
        Socket connection = new Socket("localhost", 6789);
        System.out.println("Successfull connected\n");

        //crete "file descriptor" for i/o
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        DataOutputStream outToServer = new DataOutputStream(connection.getOutputStream());

        System.out.println("Waiting first number: ");
        num1 = Integer.toString(user_input.nextInt());

        System.out.println("Waiting second number: ");
        num2 = Integer.toString(user_input.nextInt());

        data = num1 + " " + num2;

        //send data to server
        outToServer.writeBytes(data+"\n");

        //read data from server
        data = inFromServer.readLine();
        System.out.println("Risultato: " + data);

        connection.close();

    }
}
