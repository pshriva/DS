package SocketProgramming;

import java.io.*;
import java.io.IOException;
import java.net.Socket;
public class Client {
	Socket socket;
	BufferedReader input;
	DataOutputStream out;
	public Client(String address, int port) {
		try {
			Socket socket = new Socket(address, port);
			System.out.println("Connected to server");
			out = new DataOutputStream(socket.getOutputStream());
			input = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			System.out.println(e);
		}
		String line = "";
		while(!line.equals("Over")){
			try {
				line = input.readLine();
				out.writeUTF(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			input.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String []args){
		Client client = new Client("127.0.0.1", 5000);
	}
}
