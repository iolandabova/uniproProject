package unipro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constraintsAndUtil.ErrorCodes;
import constraintsAndUtil.Utils;
import unipro.model.Studente;
import unipro.model.dao.StudenteDAO;
import unipro.model.dao.impl.StudenteDaoImpl;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static StudenteDAO studenteDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		studenteDao = new StudenteDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matricola = request.getParameter("matricola");
		String password = request.getParameter("pass");
		Studente s = studenteDao.getStudentByMatricolaPassword(matricola, password);
		
		if(s != null) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("utenteRegistrato", s.getMatricola());
			session.setAttribute("nomeStudente", s.getNome());
			session.setAttribute("cognomeStudente", s.getCognome());
			RequestDispatcher rd=request.getRequestDispatcher("/view/accessoStudente.jsp");
			rd.forward(request, response);
			
			
		} else {
			
			request.setAttribute("codiceErrore", ErrorCodes.WRONGLOGIN);
			RequestDispatcher d = request.getRequestDispatcher("/view/gestoreErrori.jsp");
			d.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
