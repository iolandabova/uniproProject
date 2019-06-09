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
		
		
		List<Esame> listaEsami = esameDao.getAll();
		
		/*
		Esame e1 = new Esame();
		e1.setNomeEsame("analisi 1");
		e1.setIdEsame("anal1");
		e1.setCfu(9);
		Esame e2 = new Esame();
		e2.setNomeEsame("analisi 2");
		e2.setIdEsame("anal2");
		e2.setCfu(12);
		Esame e3 = new Esame();
		e3.setNomeEsame("fisica 1");
		e3.setIdEsame("fi1");
		e3.setCfu(6);
		
		List<Esame> listaEsami = new ArrayList<Esame>();
		listaEsami.add(e1);
		listaEsami.add(e2);
		listaEsami.add(e3);
		*/
		
		ArrayList<String> idEsami = new ArrayList<String>();
		ArrayList<String> nomiEsami = new ArrayList<String>();
		ArrayList<Integer> cfuEsami = new ArrayList<Integer>();
		
		for (Esame e : listaEsami) {
			idEsami.add(e.getIdEsame());
			nomiEsami.add(e.getNomeEsame());
			cfuEsami.add(e.getCfu());
			
		}
		request.setAttribute("idEsami", idEsami);
		request.setAttribute("nomiEsami", nomiEsami);
		request.setAttribute("cfuEsami", cfuEsami);
		
		// OPPURE CHIEDERE A MARCO SE E' MEGLIO:
		//request.setAttribute("listaEsami",listaEsami);
		
		RequestDispatcher rd=request.getRequestDispatcher("./view/visualizzaEsami.jsp");
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
