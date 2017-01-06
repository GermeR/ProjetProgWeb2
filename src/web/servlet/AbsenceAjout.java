package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.struct.Personne;

@WebServlet("/servlet/abs")
public class AbsenceAjout extends HttpServlet {
	static final String NOM = "germer";
	static final String MDP = "moi";
	static final String URL = "jdbc:postgresql://psqlserv/n3p1";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		if (session.getAttribute("login")==null)
			res.sendRedirect("../login.html");
		else if(((Personne) (session.getAttribute("personne"))).getRole().equals("prof")){ 
			PrintWriter out = res.getWriter();
			out.println("<!DOCTYPE html><html lang='fr'>"
					+ "<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>"
					+ "<title>Menu</title>"
					+ "<!-- Bootstrap core CSS --><link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' rel='stylesheet'>"
					+ "</head>"
					+ "<body>"
					+ "<div class='container'>"
					+ "<div class='page-header'>"
					+ "<h1>Ajouter une Absence</h1>"
					+ "</div>"
					+ "<div class='row'>"
					+ "<div class='col-xs-12'>"
					+ "<form class='form-horizontal' method='get' action='New2'>"
					+ "<div class='form-group'>"
					+ "<label for='inputLogin' class='col-sm-2 control-label'>Nom de l'etudiant</label>"
					+ "<div class='col-sm-10'>"
					+ "<input type='text' class='form-control' id='inputLogin' name='login'>"
					+ "</div>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label for='inputDateDeb' class='col-sm-2 control-label'>Date de debut</label>"
					+ "<div class='col-sm-10'>"
					+ "<input type='text' class='form-control' id='inputPassword' name='mdp'>"
					+ "</div>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<br>A partir du Matin <INPUT type=\"checkbox\" name=\"choix1\" value=\"1\"> "
					+ "A partir de l'Apres-Midi<INPUT type=\"checkbox\" name=\"choix2\" value=\"2\">"
					+ "<br>"
					+ "<label for='inputDateFin' class='col-sm-2 control-label'>Date de Fin</label>"
					+ "<div class='col-sm-10'>"
					+ "<input type='text' class='form-control' id='inputNom' name='nom'>"
					+ "</div></div><br>A partir du Matin <INPUT type=\"checkbox\" name=\"choix3\" value=\"3\"> "
					+ "A partir de l'Apres-Midi<INPUT type=\"checkbox\" name=\"choix4\" value=\"4\">"
					+ "<br>"
					+ "<div class='form-group'>"
					+ "<div class='col-sm-offset-2 col-sm-10'>"
					+ "<button type='submit' class='btn btn-primary'>Ajouter l'absence</button>"
					+ "</div>"
					+ "</div>"
					+ "</form>"
					+ "</div></div></div></body></html>");
		}else{
			res.sendRedirect("../menu.jsp");
		}
	}
}
