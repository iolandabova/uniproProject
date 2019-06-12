package unipro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constraintsAndUtil.Utils;
import unipro.model.dao.StudenteDAO;
import unipro.model.dao.impl.StudenteDaoImpl;
import unipro.model.dto.AppelloDTO;

/**
 * Servlet implementation class RestituisciAppelliPrenotatiServlet
 */
@WebServlet("/RestituisciAppelliPrenotatiServlet")
public class RestituisciAppelliPrenotatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static StudenteDAO studenteDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestituisciAppelliPrenotatiServlet() {
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
		List<AppelloDTO> listaAppelliPrenotati = studenteDao.getAppelliPrenotati(matricola);
		
		request.setAttribute("listaAppelliPrenotati", listaAppelliPrenotati);
		RequestDispatcher rd=request.getRequestDispatcher("./view/visualizzaAppelliPrenotati.jsp");
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
