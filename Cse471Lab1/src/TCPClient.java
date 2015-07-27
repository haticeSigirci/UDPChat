import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String sentence;
		String modifiedSentence;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 6789);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		while(true) {
			
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + "\n");
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER : " + modifiedSentence);
		}
		

	}

}
