package dz.mycompany.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
				requestDispatcher = request.getRequestDispatcher("/Acces.jsp");	
				break;		
		}
		
		requestDispatcher.forward(request, response);
	
	}
}
