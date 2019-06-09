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

import unipro.model.Appello;
import unipro.model.Docente;
import unipro.model.dao.AppelloDAO;
import unipro.model.dao.impl.AppelloDaoImpl;

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
		
		String idEsameScelto = request.getParameter("esameScelto");
		
		List<Appello> listaAppelli = appelloDao.getAllByIdEsame(idEsameScelto);

		
		/*
		List<Appello> listaAppelli = new  ArrayList<Appello>();
		Docente doc1 = new Docente();
		doc1.setCognome("grazioso");
		doc1.setNome("marco");
		
		Appello a1 = new Appello();
		a1.setIdEsame(request.getParameter(("esameScelto")));
		a1.setIdAppello("AP1");
		a1.setAula("A1");
		Date d1 = new Date(10000);
		a1.setData(d1);		
		a1.setDoc(doc1);
		
		Appello a2 = new Appello();
		a2.setIdEsame(request.getParameter(("esameScelto")));
		a2.setIdAppello("AP2");
		a2.setAula("A2");
		Date d2 = new Date(300000000);
		a2.setData(d2);
		a2.setDoc(doc1);
		
		listaAppelli.add(a1);
		listaAppelli.add(a2);
		*/
		
		
		ArrayList<String> idAppelli = new ArrayList<String>();		
		ArrayList<String> idEsami = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> aule = new ArrayList<String>();
		ArrayList<String> datiDocente = new ArrayList<String>();
		
		for (Appello a : listaAppelli) {
			
			idAppelli.add(a.getIdAppello());
			idEsami.add(a.getIdEsame());
			
			DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");  
			String dataInStringa = dateFormat.format(a.getData());
			date.add(dataInStringa);
			
			String datiDocenteStringa = a.getDoc().getCognome() + " " + a.getDoc().getNome(); 
			datiDocente.add(datiDocenteStringa);
			
			aule.add(a.getAula());
			
		}
		
		
		request.setAttribute("idAppelli", idAppelli);
		request.setAttribute("idEsami", idEsami);
		request.setAttribute("date", date);
		request.setAttribute("aule", aule);
		request.setAttribute("datiDocente", datiDocente);
		
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
