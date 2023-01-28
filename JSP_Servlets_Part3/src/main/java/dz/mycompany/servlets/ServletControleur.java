package dz.mycompany.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dz.mycompany.metier.Validation;



public class ServletControleur extends HttpServlet {
	
	Validation validation;
	
    public ServletControleur() {
        super();
        
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	validation = new Validation();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	int idEcran = Integer.parseInt(request.getParameter("idEcran"));
    	
    	switch (idEcran) {
    	
    		case 1: //Requête venant de l'écran 1 (accueil.html)
    			
    			//Récupérer le username et le mot de passe saisis à partir de la requête
    			String username = request.getParameter("username");
    			String password = request.getParameter("password");		
    			
    			//Valider le username et le mot de passe saisis
    			int resultat = validation.valider(username, password);	
    			
    			if(resultat == 0) { //Utilisateur inconnu
    				request.getRequestDispatcher("/UtilisateurInconnu.jsp").forward(request, response);
    			}else {
    				if(resultat == 1) { //Mot de passe incorrect
    					request.getRequestDispatcher("/MotDePasseIncorrect.jsp").forward(request, response);
    				}else {
    					if(resultat == 2) { // Accès
    						//Enregistement du nom d'utilisateur en attribut de session (Contexte session)
    						HttpSession session = request.getSession();
    						session.setAttribute("nomUtil", username);	
    						
    						System.out.println("Okkkkkkkkkkkkk");
    						
    						request.getRequestDispatcher("/Informations.html").forward(request, response);    						
    					}
    				}
    			}   			
    		
    			break;
    		case 4: //Requête venant de l'écran 4 (informations.html)
			
    			request.getRequestDispatcher("/Recap.jsp").forward(request, response);

    		default: //Requête venant des autres écrans
			
    			request.getRequestDispatcher("/Accueil.html").forward(request, response);
    			break;
		}
	}
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
}
