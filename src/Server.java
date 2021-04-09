import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        int num1,num2;
        String data;
        String[] numbers;
        ServerSocket my_socket = new ServerSocket(6789);

        while(true){
            //wait for connection
            System.out.println("\nWaiting new connection...");
            Socket connection = my_socket.accept();
            System.out.println("Connection accepted\n");

            //create "filedescriptor" for i/o
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());

            //read data from client
            data = inFromClient.readLine();

            if(data != null){
                numbers = data.split(" ");
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[1]);

                data = Integer.toString(num1+num2);

                Thread.sleep(10000);

                //send data to client
                outToClient.writeBytes(data);
                System.out.println("Risultato: " + data);
            }



            connection.close();
        }

    }



}
