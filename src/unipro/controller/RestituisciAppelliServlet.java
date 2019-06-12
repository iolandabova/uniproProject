package unipro.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constraintsAndUtil.Utils;
import unipro.model.Appello;
import unipro.model.Docente;
import unipro.model.dao.AppelloDAO;
import unipro.model.dao.impl.AppelloDaoImpl;
import unipro.model.dto.AppelloDTO;

/**
 * Servlet implementation class RestituisciAppelliServlet
 */
@WebServlet("/RestituisciAppelliServlet")
public class RestituisciAppelliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static AppelloDAO appelloDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestituisciAppelliServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		appelloDao = new AppelloDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utils.checkedLogged(request, response);
		
		String idEsameScelto = request.getParameter("esameScelto");
		
		if(idEsameScelto == null) {
			
			idEsameScelto = (String) request.getSession().getAttribute("idEsameSessione");
		} else {
			
			request.getSession().setAttribute("idEsameSessione", idEsameScelto);
		}
		List<AppelloDTO> listaAppelli = appelloDao.getAllByIdEsame(idEsameScelto);

		request.setAttribute("listaAppelli", listaAppelli);
		RequestDispatcher rd=request.getRequestDispatcher("./view/visualizzaAppelli.jsp");
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
