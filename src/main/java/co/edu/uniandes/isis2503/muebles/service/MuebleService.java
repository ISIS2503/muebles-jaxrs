/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.muebles.service;

import co.edu.uniandes.isis2503.muebles.logic.MueblesLogic;
import co.edu.uniandes.isis2503.muebles.persistence.entity.MuebleEntity;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jd.gonzaleza
 * Febrero 2018
 */
@Path("/muebles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MuebleService {
    
    protected MueblesLogic mueblesLogic;
    
    @PostConstruct
    public void loadDependencies(){
            mueblesLogic = new MueblesLogic();
    }
   
    @GET
    public Response getAllMuebles(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return mueblesLogic.getAllPage(page,maxRecords);
    }
    
    @POST
    public Response createMueble(MuebleEntity mueble){
        return mueblesLogic.createMueble(mueble);
    }    
}