package org.msi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.msi.model.Contact;

@Singleton
@Startup
public class ContactDAO {
	
	List<Contact> annuaire = new ArrayList<Contact>();
	
	public ContactDAO() {
		annuaire.add(new Contact("Duplantier", "Bebert", 38));
		annuaire.add(new Contact("Lasalle", "Gégé", 53));
		annuaire.add(new Contact("Martin", "Loulou", 25));
		annuaire.add(new Contact("Dupont", "Riton", 34));
		annuaire.add(new Contact("Ménard", "Bibi", 47));
	}
	
	public List<Contact> getAnnuaire () {
		return annuaire;
	}
	
	public Contact getContact (int index) {
		return annuaire.get(index);
	}
	
	public Contact getContact (String nom) {
		for (Contact contact: annuaire) {
			if (contact.getNom().toLowerCase().contains(nom.toLowerCase())) {
				return contact;
			}
		}
		return null;
	}
	
	public int addContact (Contact contact) {
		annuaire.add(contact);
		return 1;
	}

	public int deleteContact (int index) {
		annuaire.remove(index);
		return 1;
	}
	
	public int updateContact (int index, Contact contact) {
		System.out.println(String.valueOf(index) + " " + contact.getNom() + " " + contact.getPrenom() + " " + contact.getAge());
		if (index < annuaire.size()) {
			annuaire.set(index, contact);
			return 1;
		} else {
			return 0;
		}
	}
}
