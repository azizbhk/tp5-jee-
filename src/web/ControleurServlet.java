package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IvoyageDao;
import dao.voyageDaoImpl;
import metier.entities.voyage;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	
	 IvoyageDao metier;
	 @Override
	public void init() throws ServletException {
		metier = new voyageDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
			request.getRequestDispatcher("voyages.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String motCle=request.getParameter("motCle");
			voyageModele model= new voyageModele();
			model.setMotCle(motCle);
			List<voyage> prods = metier.voyagesParMC(motCle);
			model.setvoyages(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("voyages.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do")  )
		{
			request.getRequestDispatcher("saisievoyage.jsp").forward(request,response);
		}
		else if (path.equals("/save.do")  && request.getMethod().equals("POST"))
		{
		    String nom=request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			voyage p = metier.save(new voyage(nom,prix));
			request.setAttribute("voyage", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/supprimer.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier.deletevoyage(id);
		    response.sendRedirect("chercher.do?motCle=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/editer.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    voyage p = metier.getvoyage(id);
		    request.setAttribute("voyage", p);
			request.getRequestDispatcher("editervoyage.jsp").forward(request,response);
		}
		else if (path.equals("/update.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 double prix = Double.parseDouble(request.getParameter("prix"));
			 voyage p = new voyage();
			 p.setIdvoyage(id);
			 p.setNomvoyage(nom);
			 p.setPrix(prix);
			 metier.updatevoyage(p);
			 request.setAttribute("voyage", p);
			 request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
