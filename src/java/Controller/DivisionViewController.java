/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Division;
import Entities.Team;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("DivisionViewController")
@Stateless
public class DivisionViewController {
    
    @PersistenceContext(unitName = "MRHAWebAppPU")
    private EntityManager em;
        
    public Division getDivisionByID(Integer divisionID){
        return em.createNamedQuery("Division.byID", Division.class).setParameter("id", divisionID).getSingleResult();
    }
    
    public List<Team> getTeamByDivision(Division division) {
        return em.createNamedQuery("Team.findByDivision", Team.class).setParameter("division", division).getResultList();
    }
    
}
