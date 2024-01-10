// Mostapha A
// Network Programming
// Lab 10
// Server side code to send a message and receive messages

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) {
		// declaring variables and creating objects
		// port to communicate on
		int port = 1254;
		// input object, using buffered reader instead as method readLine() is deprecated for DataInputStream
		BufferedReader is;
		// output object
		DataOutputStream os;
		// server socket object
		ServerSocket server;
		// socket object
		Socket client;
		// variable for received input
		String input;
		

		// put in a try catch for IOexceptions
		try {
			// set the server port
			server = new ServerSocket(port);
			// accept a connection
			client = server.accept();
			// take what is being sent by the socket or other clients
			is = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// send to the socket
			os = new DataOutputStream(client.getOutputStream());
			// send a message to the socket
			os.writeBytes("Hello\n");

			// read the input and loop for continued input
			while ((input = is.readLine()) != null) {
			// print what was received from the socket
			System.out.println(input);
			}
			
			// close resources
			client.close();
			server.close();
			//is.close();
			os.close();

		} catch (IOException e) {
			// print the exception if caught
			System.out.println(e);
		}

		// close the streams

	}

}
