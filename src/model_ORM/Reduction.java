package model_ORM;
// Generated 29 janv. 2017 01:16:12 by Hibernate Tools 5.2.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import connector_DAO.HibernateSessionFactory;

/**
 * Reduction generated by hbm2java
 */
public class Reduction implements java.io.Serializable {

	private Integer idReduction;
	private Date dateDebutReduction;
	private Date dateFinReduction;
	private double pourcentageReduction;
	private Set menus = new HashSet(0);

	public Reduction() {
	}

	public Reduction(Date dateDebutReduction, Date dateFinReduction, double pourcentageReduction) {
		this.dateDebutReduction = dateDebutReduction;
		this.dateFinReduction = dateFinReduction;
		this.pourcentageReduction = pourcentageReduction;
	}

	public Reduction(Date dateDebutReduction, Date dateFinReduction, double pourcentageReduction, Set menus) {
		this.dateDebutReduction = dateDebutReduction;
		this.dateFinReduction = dateFinReduction;
		this.pourcentageReduction = pourcentageReduction;
		this.menus = menus;
	}

	public Integer getIdReduction() {
		return this.idReduction;
	}

	public void setIdReduction(Integer idReduction) {
		this.idReduction = idReduction;
	}

	public Date getDateDebutReduction() {
		return this.dateDebutReduction;
	}

	public void setDateDebutReduction(Date dateDebutReduction) {
		this.dateDebutReduction = dateDebutReduction;
	}

	public Date getDateFinReduction() {
		return this.dateFinReduction;
	}

	public void setDateFinReduction(Date dateFinReduction) {
		this.dateFinReduction = dateFinReduction;
	}

	public double getPourcentageReduction() {
		return this.pourcentageReduction;
	}

	public void setPourcentageReduction(double pourcentageReduction) {
		this.pourcentageReduction = pourcentageReduction;
	}

	public Set getMenus() {
		return this.menus;
	}

	public void setMenus(Set menus) {
		this.menus = menus;
	}
	public Reduction getReduction(int id){
		
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Reduction.class);
		cr.add(Restrictions.eq("idReduction", id));
		Reduction r = (Reduction) cr.uniqueResult();
		tx.commit();
		
		return r;
		
	}

}
