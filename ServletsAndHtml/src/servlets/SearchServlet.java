package servlets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchCriteria = request.getParameter("skills");
		
		{
			
			Socket clientSocket = null;
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;
			try
			{
				clientSocket = new Socket("localhost",8080);
				oos = new ObjectOutputStream(clientSocket.getOutputStream());
				ois = new ObjectInputStream(clientSocket.getInputStream());
				
				oos.writeObject(searchType);
				oos.flush();
				oos.writeObject(searchCriteria);
				oos.flush();
				
				ois.close();
				oos.close();
				clientSocket.close();
				
			}
			catch (ConnectException e){
				System.out.println("Server probably not running dumbass :D.");
				e.printStackTrace();
				System.exit(1);
				
			} 
			catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
