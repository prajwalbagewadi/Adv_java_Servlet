package loginpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Servlet implementation class ULogin
 */
@WebServlet("/ULogin")
public class ULogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection con;
	public Statement st;
	public ResultSet rs; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ULogin() {
        super();
        
    }
   @Override
   public void init() throws ServletException {
	   // TODO Auto-generated method stub
	   super.init();
	   try {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
	   Statement st = con.createStatement();
	   ResultSet rs  = st.executeQuery("select * from users");
	   while(rs.next()) {
		   System.out.println("r= "+rs.getInt(0)+rs.getString(1)+rs.getString(2));
	   }
	   }catch (SQLException e) {
		   e.printStackTrace();
	   }catch(ClassNotFoundException e) {
		   e.printStackTrace();
	   }
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); // resp.setContentType use to define response content format.
    	PrintWriter out = response.getWriter(); //PrintWriter used insert content on html page. -> resp.getWriter() creates a html file to write.
    	out.println("welcome to Login Page."); //normal string
    	//out.println("<em>Prajwal</em>"); //html element
    	out.println("<form method=\"GET\">"); //html element
    	out.println("<input type=\"text\" name=\"username\" placeholder=\"enter username\"/>"); //html element
    	out.println("<input type=\"password\" name=\"password\" placeholder=\"enter password\"/>"); //html element
    	out.println("<input type=\"submit\" name=\"submit\" value=\"Login\"/>"); //html element
    	out.println("</form>"); //html element
	}
	private void destory() {
		// TODO Auto-generated method stub

	}
}
