

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServ
 */
public class CartServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] productlist=request.getParameterValues("product");
		List<String>list=new ArrayList<>();
		if(productlist!=null) {
			
			for(int i=0;i<productlist.length;i++)
			{
				list.add(productlist[i]);
			}
			HttpSession session=request.getSession();
			session.setAttribute("cart", list);
			response.sendRedirect("ViewServ");}else {
			
			response.getWriter().println("you are not selected..!!");
		}
			
		
	}

}
