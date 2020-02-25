/*
 *tesing how to build java web app
 * 
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


public class server{
	public static void main(String[] args)
		throws Exception{
		ServerSocket serv = new ServerSocket(80);
		System.out.println("Listening for connection on port 80 ....");
		while (true){
			//stuff
			Socket client = serv.accept();
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
            		BufferedReader reader = new BufferedReader(isr);
			String line = reader.readLine();
			while(!line.isEmpty()) {
				System.out.println(line);
				line = reader.readLine();
			}
			try {
				Date today = new Date();
				String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
				client.getOutputStream().write(httpResponse.getBytes("UTF-8"));
			}
			catch(Exception ee){
				System.out.println("Error occured...");
			}
		}
	}
}
