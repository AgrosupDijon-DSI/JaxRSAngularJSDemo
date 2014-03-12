package org.msi.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {
	
	private String nom;
	private String prenom;
	private Integer age;
	
	public Contact() {
		
	}
	
	public Contact(String nom, String prenom, Integer age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return nom + " " + prenom + " " + age;
	}
	

}
