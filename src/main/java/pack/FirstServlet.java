package pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException { //to initialize the the Servlet
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("Servlet started...");
    }
    
    @Override
    // to process the incomming requests of type Get.
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//super.doGet(req, resp);
    	resp.setContentType("text/html"); // resp.setContentType use to define response content format.
    	PrintWriter out = resp.getWriter(); //PrintWriter used insert content on html page. -> resp.getWriter() creates a html file to write.
    	out.println("helloworld. welcome to"); //normal string
    	out.println("<em>Prajwal</em>"); //html element
    	out.println("<form method=\"GET\">"); //html element
    	out.println("<input type=\"text\" name=\"a\" placeholder=\"enter val of a\"/>"); //html element
    	out.println("<input type=\"text\" name=\"b\" placeholder=\"enter val of b\"/>"); //html element
    	out.println("<input type=\"submit\" name=\"submit\" value=\"cal\"/>"); //html element
    	out.println("</form>"); //html element
    	
    	String reqval= req.getParameter("submit");
    	if(reqval!=null) {
    		int a = Integer.parseInt( req.getParameter("a"));
        	int b = Integer.parseInt( req.getParameter("b"));
        	out.println("<em>Sum ="+(a+b)+"</em>"); //html element
    	}
    	
    	
    	
    }
    
    private void destory() { //to deallocate Servlet memory from stack.
		// TODO Auto-generated method stub
    	System.out.println("Servlet execution complete...");
	}

}
