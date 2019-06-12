package unipro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constraintsAndUtil.Utils;
import unipro.model.Esame;
import unipro.model.dao.EsameDAO;
import unipro.model.dao.impl.EsameDaoImpl;


/**
 * Servlet implementation class VisualizzaEsamiServlet
 */
@WebServlet("/RestituisciEsamiServlet")
public class RestituisciEsamiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static EsameDAO esameDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public RestituisciEsamiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		
		esameDao = new EsameDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utils.checkedLogged(request, response);
		
		List<Esame> listaEsami = esameDao.getAll();
		
		request.setAttribute("listaEsami", listaEsami);
		
		RequestDispatcher rd=request.getRequestDispatcher("/view/visualizzaEsami.jsp");
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
