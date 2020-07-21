/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entities.MrhaResult;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jamie
 */
@Stateless
public class MrhaResultFacade extends AbstractFacade<MrhaResult> {

    @PersistenceContext(unitName = "MRHAWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MrhaResultFacade() {
        super(MrhaResult.class);
    }
    
}