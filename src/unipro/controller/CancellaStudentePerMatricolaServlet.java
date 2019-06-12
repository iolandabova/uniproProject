package unipro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constraintsAndUtil.Utils;
import unipro.model.dao.StudenteDAO;
import unipro.model.dao.impl.StudenteDaoImpl;

/**
 * Servlet implementation class CancellaStudentePerMatricolaServlet
 */
@WebServlet("/CancellaStudentePerMatricolaServlet")
public class CancellaStudentePerMatricolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static StudenteDAO studenteDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellaStudentePerMatricolaServlet() {
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
		
		String matricola = request.getParameter("eliminaMatricola");
		Boolean ok = studenteDao.deleteByMatricola(matricola);
		
		request.setAttribute("esitoCancellazioneStudente", ok);
		RequestDispatcher rd=request.getRequestDispatcher("/view/cancellaStudentePerMatricola.jsp");
		
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
