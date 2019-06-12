package unipro.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		String matricola = request.getParameter("matricola");
		Studente st = studenteDao.getByMatricola(matricola);
		int error = 0;
		
		if(st == null) {
			
			String password = request.getParameter("pass");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String dataNascita = request.getParameter("nascita");
			Studente s = new Studente();
			s.setMatricola(matricola);
			s.setPassword(password);
			s.setNome(nome);
			s.setCognome(cognome);
			//u.setDataNascita(dataNascita);
			
			studenteDao.save(s);
			
			RequestDispatcher rd=request.getRequestDispatcher("./view/login.jsp");
			rd.forward(request, response);
			
		} else {
			
			error = 2; 
			request.setAttribute("errore", error);
			RequestDispatcher d = request.getRequestDispatcher("./view/gestoreErrori.jsp");
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
