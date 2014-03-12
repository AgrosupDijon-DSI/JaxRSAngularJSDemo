package org.msi;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.msi.dao.ContactDAO;
import org.msi.model.Contact;

@Path("")
@Stateless
public class AnnuaireWS {
	
	@EJB
	ContactDAO contactDAO = new ContactDAO();
	
	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> getAnnuaire() {
		System.out.println("LISTE : " + contactDAO.getAnnuaire().toString());
		return contactDAO.getAnnuaire();
	}
	
	@Path("/id/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public Contact getContactByID (@PathParam("id") int index) {
		System.out.println("READ : " + contactDAO.getAnnuaire().toString());
		return contactDAO.getContact(index);
	}
	
	@Path("/name/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public Contact getContactByName (@PathParam("name") String nom) {
		return contactDAO.getContact(nom);
	}
	
	@Path("/id/{id}")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public int updateContact (@PathParam("id") int index, Contact contact) {
		System.out.println("UPDATE : " + contact.toString());
		return contactDAO.updateContact(index, contact);
	}

	@Path("/id")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public int addContact (Contact contact) {
		System.out.println("CREATE : " + contact.toString());
		return contactDAO.addContact(contact);
	}

	@Path("/id/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public int deleteContact (@PathParam("id") int index) {
		System.out.println("DELETE : " + contactDAO.getContact(index).toString());
		return contactDAO.deleteContact(index);
	}
		
}
