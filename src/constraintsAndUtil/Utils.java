package constraintsAndUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils {
	
	public static void checkedLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SONO DENTRO!!");
		System.out.println(request.getSession().getAttribute("utenteRegistrato"));
		if(request.getSession().getAttribute("utenteRegistrato") == null) {
			System.out.println("SONO DENTRO2!!");
			request.setAttribute("codiceErrore", ErrorCodes.NOTMADELOGIN);
			RequestDispatcher d = request.getRequestDispatcher("./gestoreErrori.jsp");
			d.forward(request, response);
		}
	}

}
