

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String newuser=request.getParameter("newuser");
		String pass1=request.getParameter("password1");
		
		try{
			if(DatabaseConnection.isUserPresent(newuser)){
				out.println("user name not available");
			}
			else{
				out.println("user name available");
			}
		} catch (SQLException e) {
			System.out.println("SQL exception occured");
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		
		
//		String pass2=request.getParameter("password2");
		
//		if(!pass1.equals(pass2)){
//			out.println("Passwords do not match<br>");
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//			rd.include(request, response);
//		} 
//		else{
//			try {
//				if(DatabaseConnection.isUserPresent(newuser)){
//				out.println("The user already exist. Please choose different name<br>");
//				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//				rd.include(request, response);
//				}
//				else{
//					DatabaseConnection.putUserData(newuser, pass1);
//					HttpSession session = request.getSession();
//					session.setAttribute("name", newuser);
//					out.println("Thanks for choosing our service");
//					RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
//					rd.include(request, response);
//				}
//			} catch (ClassNotFoundException x) {
//				System.out.println(x);
//				System.out.println("class not found exception");
//				x.printStackTrace();
//			}
//			catch(Exception e){
//				System.out.println(e);
//				System.out.println("exception found");
//				e.printStackTrace();
//			}
//	}
		
	}

}
