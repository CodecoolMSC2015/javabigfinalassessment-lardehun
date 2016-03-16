package employeeManagerServerClasses;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class PersonStoreServerSocket {
	DataReader store;
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		SearchType searchType = null;

			try
			{
				serverSocket = new ServerSocket(8080);
				System.out.println("Waiting for client...");
				clientSocket = serverSocket.accept();
				oos = new ObjectOutputStream(clientSocket.getOutputStream());
				ois = new ObjectInputStream(clientSocket.getInputStream());
				
				String searchTypeString = (String) ois.readObject();
				String searchCriteria = (String) ois.readObject();
				if (searchTypeString == "mandatory") {
					searchType = SearchType.Mandatory;
				}
				else {
					searchType = SearchType.Optional;
				}
				
				DataReader reader = new CSVDataReader("C:\\GIT\\javabigfinalassessment-lardehun\\Documentation\\persons.csv");
				reader.getPersons(searchCriteria, searchType);
			}
			
			catch (Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
}
