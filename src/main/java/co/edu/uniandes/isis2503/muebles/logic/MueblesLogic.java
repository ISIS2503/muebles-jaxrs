/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.muebles.logic;

import co.edu.uniandes.isis2503.muebles.persistence.MueblesPersistence;
import co.edu.uniandes.isis2503.muebles.persistence.entity.MuebleEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author jd.gonzaleza
 * Febrero 2018
 */
public class MueblesLogic {

    protected MueblesPersistence persistance;

    public MueblesLogic() {
        persistance = new MueblesPersistence();
    }

    public Response getAllPage(Integer page, Integer maxRecords) {
        return persistance.getAllPage(page, maxRecords);
    }

    public Response createMueble(MuebleEntity mueble) {
        return persistance.createCompetitor(mueble);
    }

}
