package it.epicode.connessione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.epicode.modello.Fornitore;

public class FornitoreDAO implements AbstractFornitoreDAO {
	public static final String LISTA_FORNITORI = "SELECT codice_fornitore, nome_fornitore, indirizzo, citta FROM negozio.fornitore";

	@Override
	public List<Fornitore> listaFornitori() throws SQLException {
		List<Fornitore> listaFornitori = new ArrayList<>();
		try (Connection connect = ConnessioneUtils.createConnection();
				Statement st = connect.createStatement();
				ResultSet rs = st.executeQuery(LISTA_FORNITORI)) {
			while (rs.next()) {
				listaFornitori.add(new Fornitore(rs.getInt("codice_fornitore"), rs.getString("nome_fornitore"),
						rs.getString("indirizzo"), rs.getString("citta")));
			}
		}
		return listaFornitori;
	}

	public static final String INSERISCI_NUOVO_FORNITORE = "INSERT INTO negozio.fornitore (codice_fornitore, nome_fornitore, indirizzo, citta) VALUES(?,?,?,?)";

	@Override
	public Fornitore insertFornitore(Fornitore f) throws SQLException {
		try (Connection connect = ConnessioneUtils.createConnection();
				PreparedStatement ps = connect.prepareStatement(INSERISCI_NUOVO_FORNITORE)) {
			ps.setInt(1, f.getCodiceFornitore());
			ps.setString(2, f.getNomeFornitore());
			ps.setString(3, f.getIndirizzo());
			ps.setString(4, f.getCitta());

			ps.executeUpdate();
		}
		return f;
	}

	public static final String RIMUOVI_FORNITORE = "DELETE FROM negozio.fornitore WHERE codice_fornitore=?";

	@Override
	public void rimuoviFornitore(int codice) throws SQLException {
		try (Connection connect = ConnessioneUtils.createConnection();
				PreparedStatement ps = connect.prepareStatement(RIMUOVI_FORNITORE)) {
			ps.setInt(1, codice);
			ps.executeUpdate();

		}

	}

}
