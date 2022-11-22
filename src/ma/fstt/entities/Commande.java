package ma.fstt.entities;

import java.sql.Date;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Commande {
	private int idCmd;
	private Date dateCmd;
	private int idUtil;

	public Commande() {
		super();
	}

	public Commande(int idCmd, Date dateCmd, int idUtil) {
		super();
		this.idCmd = idCmd;
		this.dateCmd = dateCmd;
		this.idUtil = idUtil;
	}

	public int getIdCmd() {
		return idCmd;
	}

	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public int getIdUtil() {
		return idUtil;
	}

	public void setIdUtil(int idUtil) {
		this.idUtil = idUtil;
	}

	@Override
	public String toString() {
		return "Commande [idCmd=" + idCmd + ", dateCmd=" + dateCmd + ", idUtil=" + idUtil + "]";
	}
}
