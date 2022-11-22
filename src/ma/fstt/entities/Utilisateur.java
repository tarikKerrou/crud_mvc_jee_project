package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Utilisateur {
	private int idUtil;
	private String nomUtil;
	private String passwordUtil;
	private String adresseUtil;
	private String emailUtil;
	private int typeUtil;

	public Utilisateur() {
		super();
	}

	public Utilisateur(int idUtil, String nomUtil, String passwordUtil, String adresseUtil, String emailUtil, int typeUtil) {
		super();
		this.idUtil = idUtil;
		this.nomUtil = nomUtil;
		this.passwordUtil = passwordUtil;
		this.adresseUtil = adresseUtil;
		this.emailUtil = emailUtil;
		this.typeUtil = typeUtil;
	}

	public int getIdUtil() {
		return idUtil;
	}

	public void setIdUtil(int idUtil) {
		this.idUtil = idUtil;
	}

	public String getNomUtil() {
		return nomUtil;
	}

	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
	}

	public String getPasswordUtil() {
		return passwordUtil;
	}

	public void setPasswordUtil(String passwordUtil) {
		this.passwordUtil = passwordUtil;
	}

	public String getAdresseUtil() {
		return adresseUtil;
	}

	public void setAdresseUtil(String adresseUtil) {
		this.adresseUtil = adresseUtil;
	}

	public String getEmailUtil() {
		return emailUtil;
	}

	public void setEmailUtil(String emailUtil) {
		this.emailUtil = emailUtil;
	}

	public int getTypeUtil() {
		return typeUtil;
	}

	public void setTypeUtil(int typeUtil) {
		this.typeUtil = typeUtil;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtil=" + idUtil + ", nomUtil=" + nomUtil + ", adresseUtil=" + adresseUtil
				+ ", emailUtil=" + emailUtil + ", typeUtil=" + typeUtil + "]";
	}
}
