package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.struct.Personne;

@WebServlet("/servlet/Select")
public class Select extends HttpServlet {

	static final String NOM = "germer";
	static final String MDP = "moi";
	static final String URL = "jdbc:postgresql://psqlserv/n3p1";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Personne p = new Personne("", "", "", "", "", "");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT p.prenom,p.nom,a.date,a.demiJ FROM personne as p inner join absences as a on a.login = p.login WHERE p.role = 'etu' and p.login='"
				+ ((Personne) session.getAttribute("personne")).getLogin() + "' ;";
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, NOM, MDP);
			stmt = con.createStatement();
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		affich(out,rs);

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void affich(PrintWriter out, ResultSet rs) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Vos Absences</title>");
		out.println("<head>");
		out.println("<body>");
		out.println("<center><table>");
		try {
			out.println("<th>prenom</th> <th>nom</th> <th>date</th> <th>horaire</th>");
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td></tr>");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		out.println("</table><center>");
		out.println("</body>");
		out.println("</html>");
	}
}