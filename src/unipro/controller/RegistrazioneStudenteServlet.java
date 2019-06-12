package unipro.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constraintsAndUtil.ErrorCodes;
import constraintsAndUtil.Utils;
import unipro.model.Studente;
import unipro.model.dao.StudenteDAO;
import unipro.model.dao.impl.StudenteDaoImpl;

/**
 * Servlet implementation class RegistrazioneStudenteServlet
 */
@WebServlet("/RegistrazioneStudenteServlet")
public class RegistrazioneStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static StudenteDAO studenteDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneStudenteServlet() {
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
		
		String matricola = request.getParameter("matricola");
		Studente st = studenteDao.getByMatricola(matricola);
		
		if(st == null) {
			
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String sesso = request.getParameter("sesso");
			
			String nascita = request.getParameter("nascita");
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
		    Date dataNascita = null;
			try {
				dataNascita = formatter.parse(nascita);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}  
			String indirizzo = request.getParameter("indirizzo");
			String citta = request.getParameter("citta");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Studente s = new Studente();
			
			s.setMatricola(matricola);
			s.setNome(nome);
			s.setCognome(cognome);
			s.setSesso(sesso);
			s.setDataNascita(dataNascita);
			s.setIndirizzo(indirizzo);
			s.setCitta(citta);
			s.setEmail(email);
			s.setPassword(password);
			
			studenteDao.save(s);
			
			RequestDispatcher rd=request.getRequestDispatcher("/view/visualizzaInserimentoStudenteAvvenuto.jsp");
			rd.forward(request, response);
			
		} else {
			
			request.setAttribute("codiceErrore", ErrorCodes.ALREADYENTERED);
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
