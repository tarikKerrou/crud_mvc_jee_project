package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LigneDeCommande {
	private int idLigneCmd;
	private int quantite;
	private int idCmd;
	private int idProd;

	public LigneDeCommande() {
		super();
	}

	public LigneDeCommande(int idLigneCmd, int quantite, int idCmd, int idProd) {
		super();
		this.idLigneCmd = idLigneCmd;
		this.quantite = quantite;
		this.idCmd = idCmd;
		this.idProd = idProd;
	}

	public int getIdLigneCmd() {
		return idLigneCmd;
	}

	public void setIdLigneCmd(int idLigneCmd) {
		this.idLigneCmd = idLigneCmd;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getIdCmd() {
		return idCmd;
	}

	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	@Override
	public String toString() {
		return "LigneDeCommande [idLigneCmd=" + idLigneCmd + ", quantite=" + quantite + ", idCmd=" + idCmd + ", idProd="
				+ idProd + "]";
	}
}
