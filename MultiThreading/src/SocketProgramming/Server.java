package SocketProgramming;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	Socket socket;
	ServerSocket server;
	DataInputStream in;
	public Server(int port) throws InterruptedException {
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
			System.out.println("Waiting for client...");
			socket = server.accept();
			System.out.println("Connection with client made");
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			String line = "";
			while(!line.equals("Over")){
				line = in.readUTF();
				System.out.println(line);
			}
			System.out.println("Closing connection");
			socket.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Server server = new Server(5000);
	}

}
