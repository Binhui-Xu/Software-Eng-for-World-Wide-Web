package com.restful;

import com.google.gson.Gson;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.*;

import javax.persistence.*;
import com.entity.studentSurvey;
import java.util.List;
import javax.ejb.Stateless;
 
import java.util.Date;
// survey resource
@Stateless
@Path("studentSurvey")
public class studentSurveyResource {
	@PersistenceContext(unitName = "surveyDB")
	private EntityManager em = Persistence.createEntityManagerFactory("surveyDB").createEntityManager();
	public studentSurveyResource(){}
	
	@POST 
	@Path("create")
	@Consumes({ "*/*" })
	public studentSurvey createSurvey( studentSurvey inputSurvey){
		studentSurvey stuSurvey = new studentSurvey();
		em.getTransaction().begin();
		em.persist(inputSurvey);
		em.getTransaction().commit();
		em.close();
		return stuSurvey;
		
	}
	@SuppressWarnings("unchecked")
	@GET
	@Produces({ "application/json"})
	@Consumes({"*/*"})
	public String findAll(){
		List<studentSurveyResource> surveyList = null;
		surveyList = em.createQuery("SELECT s FROM studentSurvey s").getResultList();

		em.close();
		System.out.println(new Gson().toJson(surveyList));
		return new Gson().toJson(surveyList);
	}
	
	@GET
	@Produces({ "application/json"})
	@Path("{studentId}")
	public String find(@PathParam("studentId") String studentId){
		List<studentSurveyResource> surveyDetails = null;
		surveyDetails = em.createQuery("SELECT s FROM studentSurvey s WHERE s.studentId LIKE :studentId").setParameter("studentId", studentId).getResultList();
		em.close();
		return new Gson().toJson(surveyDetails);
	} 
}