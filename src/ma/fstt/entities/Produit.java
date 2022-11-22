package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Produit {
	private int idProd;
	private String nomProd;
	private double prixProd;

	public Produit() {
		super();
	}

	public Produit(int idProd, String nomProd, double prixProd) {
		super();
		this.idProd = idProd;
		this.nomProd = nomProd;
		this.prixProd = prixProd;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getNomProd() {
		return nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public double getPrixProd() {
		return prixProd;
	}

	public void setPrixProd(double prixProd) {
		this.prixProd = prixProd;
	}

	@Override
	public String toString() {
		return "Produit [idProd=" + idProd + ", nomProd=" + nomProd + ", prixProd=" + prixProd + "]";
	}
}
