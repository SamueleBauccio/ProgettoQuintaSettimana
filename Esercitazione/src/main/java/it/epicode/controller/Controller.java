package it.epicode.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.connessione.AbstractFornitoreDAO;
import it.epicode.connessione.FornitoreDAO;
import it.epicode.modello.Fornitore;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHIAVE_LISTA_FORNITORI = "CHIAVE_LISTA_FORNITORI";
	public static final String LISTA_FORNITORI_DESTINATION = "archivioFornitore.jsp";
	public static final String CHIAVE_INSERIMENTO_FORNITORE = "CHIAVE_INSERIMENTO_FORNITORE";
	public static final String PAGINA_ERRORE_DESTINATION = "paginaDiErrore.jsp";
	public static final String INSERIMENTO_FORNITORE_DESTINATION = "insertFornitore.jsp";

	private AbstractFornitoreDAO fornitoreDAO = new FornitoreDAO();
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
// nel caso venisse lanciata la class not fount acchiappala e trasformala in runtimeException: assumo che se manchi il driver crashera il programma
			throw new RuntimeException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		int pos = path.lastIndexOf('/');
		String action = path.substring(pos + 1, path.length() - 3);

		try {
			switch (action) {
			case "listaFornitori":
				listaFornitori(request, response);
				break;
			case "aggiungiFornitore":
				aggiungiFornitore(request, response);
				break;
			case "listaProdotti":
				listaProdotti(request, response);
				break;
			case "formInserimentoFornitore":
				mostraFormInserimentoFornitore(request, response);
				break;
			case "cancellaFornitore":
				cancellaFornitore(request, response);
				break;
			default:
				mostraPaginaErrore(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			mostraPaginaErrore(request, response);
		}

	}

	private void listaFornitori(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Fornitore> result = fornitoreDAO.listaFornitori();
		request.setAttribute(CHIAVE_LISTA_FORNITORI, result);
		RequestDispatcher disp = request.getRequestDispatcher(LISTA_FORNITORI_DESTINATION);
		disp.forward(request, response);
	}

	private void listaProdotti(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

	}

	private void aggiungiFornitore(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String codiceString = request.getParameter("codiceFornitore");
		int codice = Integer.parseInt(codiceString);
		String nomeFornitore = request.getParameter("nomeFornitore");
		String indirizzo = request.getParameter("indirizzo");
		String citta = request.getParameter("citta");
		fornitoreDAO.insertFornitore(new Fornitore(codice, nomeFornitore, indirizzo, citta));
		listaFornitori(request, response);
	}

	private void mostraFormInserimentoFornitore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(INSERIMENTO_FORNITORE_DESTINATION);
		disp.forward(request, response);
	}

	private void cancellaFornitore(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int codice = Integer.parseInt(request.getParameter("id"));
		fornitoreDAO.rimuoviFornitore(codice);
		listaFornitori(request, response);

	}

	private void mostraPaginaErrore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(PAGINA_ERRORE_DESTINATION);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
