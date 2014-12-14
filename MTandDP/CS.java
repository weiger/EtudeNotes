
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class EchoClient extends Thread {
    DataOutputStream os;
    DataInputStream is;
    public void run(){
	Socket echoSocket = null;
	try {
	    echoSocket = new Socket("127.0.0.1", 8888);
	    System.out.println("Connection successfully");
	    os = new DataOutputStream(echoSocket.getOutputStream());
	    is = new DataInputStream(echoSocket.getInputStream());
	    String userInput;
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
		    userInput = cin.nextLine();
		    if(userInput.equalsIgnoreCase("QUIT"))
			break;
		    os.writeBytes(userInput);
		    os.writeByte('\n');
		    System.out.println("echo: " + is.readLine());
		}
		os.close();
		is.close();
		echoSocket.close();
	} catch (UnknownHostException e) {
	    System.err
	    .println("Don't know about host: richard.rchland.ibm.com");
	} catch (IOException e){
	    System.err
	    .println("Couldn't get I/O for the connection to: 127.0.0.1");
	}
    }
    public static void main(String[] args) throws IOException {
	new EchoClient().start();
    }

}



import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class EchoServer {
    static int count = 1;
    public static void main(String[] args) throws IOException {
	
	System.out.println("The EchoServer is starting.");
        ServerSocket listener = new ServerSocket(8888);
        
        try {
            while (true) {
        	Thread t = new ServerService(listener.accept());
        	t.setPriority((int)(10 * Math.random()));
        	System.out.println("The "+count+"th thread priority is "+t.getPriority());
        	t.start();   
        	count++;
            }
            
        } finally {
            listener.close();
            System.out.println("The EchoServer is closed.");
        }
    }
 }
class ServerService extends Thread{
	private Socket ClientSocket;
	private BufferedReader is;
	private PrintWriter os;
	public ServerService(Socket socket){
	    this.ClientSocket = socket;
	}
	public void run(){
	    try {
		String inputLine;
		is = new BufferedReader(new InputStreamReader(
			ClientSocket.getInputStream()));
		os = new PrintWriter(new BufferedOutputStream(
			ClientSocket.getOutputStream(), 1024), false);
		while ((inputLine = is.readLine()) != null) {
		    // Echo the line out
		    if (inputLine.equalsIgnoreCase("QUIT"))
			break;
		    System.out.println("Input [" + inputLine + "] come in");
		    os.println(inputLine);
		    os.flush();
		}
		is.close();
		os.close();
		ClientSocket.close();
	    } catch (UnknownHostException e){
		System.err
		    .println("Don't know about host: richard.rchland.ibm.com");
	    }
	    catch (IOException e) {
		System.err
		    .println("Couldn't get I/O for the connection");
	    }
	}
	
}
