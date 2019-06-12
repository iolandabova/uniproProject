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

import constraintsAndUtil.Utils;
import unipro.model.Studente;
import unipro.model.dao.StudenteDAO;
import unipro.model.dao.impl.StudenteDaoImpl;

/**
 * Servlet implementation class RestituisciAnagraficaStudenteServlet
 */
@WebServlet("/RestituisciAnagraficaStudenteServlet")
public class RestituisciAnagraficaStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static StudenteDAO studenteDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestituisciAnagraficaStudenteServlet() {
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
		
		Utils.checkedLogged(request, response);
		
		HttpSession session = request.getSession(true);
		String matricola = (String) session.getAttribute("utenteRegistrato");
		Studente s = studenteDao.getByMatricola(matricola);
		
		request.setAttribute("datiStudente", s);
		RequestDispatcher rd=request.getRequestDispatcher("/view/visualizzaAnagraficaStudente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
