// Mostapha A
// Network Programming
// Lab 10
// Client side code to send a message to a server and receive a message

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) {
		// declaring variables and creating objects
		// port to communicate on
		int port = 1254;
		// host name
		String host = "localhost";
		// input object, using buffered reader instead as method readLine() is
		// deprecated for DataInputStream
		BufferedReader is;
		// output object
		DataOutputStream os;
		// socket object
		Socket client;

		// set in a try catch block to catch any exceptions
		try {
			// set the sockets name and port number
			client = new Socket(host, port);
			// take input from the port
			is = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// send output to the port
			os = new DataOutputStream(client.getOutputStream());
			// send out a message
			os.writeBytes("Hello\n");
			
			//test if the server keeps receiving messages
			//os.writeBytes("Second message.");
			
			// print what was received
			System.out.println(is.readLine());

			// close resources
			client.close();
			is.close();
			os.close();
		} catch (UnknownHostException e) {
			// print the exception if caught
			System.out.println(e);
		} catch (IOException e) {
			// print the exception if caught
			System.out.println(e);
		}

	}

}
