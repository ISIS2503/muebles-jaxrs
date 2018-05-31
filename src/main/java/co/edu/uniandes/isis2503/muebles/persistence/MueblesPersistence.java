/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.muebles.persistence;

import co.edu.uniandes.isis2503.muebles.logic.dto.MueblePageDTO;
import co.edu.uniandes.isis2503.muebles.persistence.entity.MuebleEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author jd.gonzaleza
 * Febrero 2018
 */
public class MueblesPersistence {

    protected EntityManagerFactory emf;
    protected EntityManager entityManager;

    public MueblesPersistence() {
        emf = Persistence.createEntityManagerFactory("Muebles");
    }

    
    public Response getAllPage(Integer page, Integer maxRecords) {
 
        MueblePageDTO muebles = null;
        entityManager = emf.createEntityManager();
        int status = 200;
        try{
            entityManager.getTransaction().begin();
            Query count = entityManager.createQuery("select count(u) from MuebleEntity u");
            Long regCount = 0L;
            regCount = Long.parseLong(count.getSingleResult().toString());
            Query query = entityManager.createQuery("select u from MuebleEntity u");
            if(page != null && maxRecords != null){
                query.setFirstResult((page-1)*maxRecords);
                query.setMaxResults(maxRecords);
            }
            muebles = new MueblePageDTO();
            muebles.setTotalRecords(regCount);
            muebles.setMuebles(query.getResultList());
            entityManager.getTransaction().commit();
 
 
        }catch(Exception e){
            if (entityManager.isOpen());
            entityManager.close();
            status = 500;
        }finally {
            if (entityManager.isOpen());
            entityManager.close();
        }
        return Response.status(status).header("Access-Control-Allow-Origin", "*").entity(muebles).build();
    }

    public Response createCompetitor(MuebleEntity mueble) {
        int status = 200;
        Long resp = 0L;
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(mueble);
            entityManager.getTransaction().commit();
            resp = mueble.getReferencia();
        } catch (Exception e) {
            if (entityManager.isOpen());
            entityManager.close();
            status = 500;
        } finally {
            if (entityManager.isOpen());
            entityManager.close();
        }
        return Response.status(status).header("Access-Control-Allow-Origin", "*").entity(resp).build();
    }

}
