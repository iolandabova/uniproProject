package constraintsAndUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils {
	
	public static void checkedLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("utenteRegistrato") == null) {
	
			request.setAttribute("codiceErrore", ErrorCodes.LOGINNOTMADE);
			RequestDispatcher d = request.getRequestDispatcher("/view/gestoreErrori.jsp");
			d.forward(request, response);
		}
	}

}
