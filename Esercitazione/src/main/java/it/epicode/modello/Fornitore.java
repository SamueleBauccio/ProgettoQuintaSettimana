package it.epicode.modello;

public class Fornitore {
	private int codiceFornitore;
	private String nomeFornitore;
	private String indirizzo;
	private String citta;

	public Fornitore(int codiceFornitore, String nomeFornitore, String indirizzo, String citta) {

		this.codiceFornitore = codiceFornitore;
		this.nomeFornitore = nomeFornitore;
		this.indirizzo = indirizzo;
		this.citta = citta;

	}

	public int getCodiceFornitore() {
		return codiceFornitore;
	}

	public void setCodiceFornitore(int codiceFornitore) {
		this.codiceFornitore = codiceFornitore;
	}

	public String getNomeFornitore() {
		return nomeFornitore;
	}

	public void setNomeFornitore(String nomeFornitore) {
		this.nomeFornitore = nomeFornitore;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

}
