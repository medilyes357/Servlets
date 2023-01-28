package dz.mycompany.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dz.mycompany.metier.Validation;



public class ServletValidation extends HttpServlet {
	
	Validation validation;
	
    public ServletValidation() {
        super();
        
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	validation = new Validation();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer le username et le mot de passe saisis à partir de la requête
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		//Valider le username et le motpasse saisis
		int resultat = validation.valider(username, password);
		
		
		//Délégation de la préparation de la réponse à des JSP
		RequestDispatcher requestDispatcher = null;						
		
		switch(resultat) {
			//User inconnu
			case 0:
				requestDispatcher = request.getRequestDispatcher("/UtilisateurInconnu.jsp");	
				break;
			//Mot de passe inconnu	
			case 1:
				requestDispatcher = request.getRequestDispatcher("/MotDePasseIncorrect.jsp");		
				break;
			//Username et password corrects	
			case 2:
				//Enregistement du nom d'utilisateur en attribut de session (Contexte session)
				HttpSession session = request.getSession();
				session.setAttribute("nomUtil", username);	
				
				//Enregistrement du nom d'utilisateur en attribut de ServletContext (Contexte application)
				//ServletContext servletContext = getServletContext();
				//servletContext.setAttribute("nomUtil", username);
				
				//Passage du nom d'utilisateur par cookies
				//Cookie cookie = new Cookie("nomUtil", username);
				//response.addCookie(cookie);				
				
				requestDispatcher = request.getRequestDispatcher("/informations.html");	
				
				break;		
		}
		
		requestDispatcher.forward(request, response);	
	}
}
