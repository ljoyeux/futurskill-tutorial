package fr.futurskill.tutorial.jpa.bo;

import fr.futurskill.tutorial.jpa.model.Module;
import fr.futurskill.tutorial.jpa.model.ModuleCalendrier;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class ModuleCalendrierBean {
    @PersistenceContext
    private EntityManager em;


    public ModuleCalendrier ajoute(Long moduleId, Date debut, Date fin) {
        Module module = em.find(Module.class, moduleId);

        ModuleCalendrier moduleCalendrier = new ModuleCalendrier();
        moduleCalendrier.setDebut(debut);
        moduleCalendrier.setFin(fin);
        moduleCalendrier.setModule(module);


        return em.merge(moduleCalendrier);
    }

    public void supprime(Long moduleCalendarId) {
        ModuleCalendrier moduleCalendrier = em.find(ModuleCalendrier.class, moduleCalendarId);
        em.remove(moduleCalendrier);
    }

    public List<ModuleCalendrier> liste(Date debut, Date fin) {
        StringBuilder builder = new StringBuilder("SELECT mc FROM ModuleCalendrier mc WHERE 1=1");

        if (debut != null) {
            builder.append("AND mn.debut>=:debut");
        }

        if (fin != null) {
            builder.append("AND mn.fin<=:fin");
        }

        Query query = em.createQuery(builder.toString());

        if (debut != null) {
            query.setParameter("debut", debut);
        }

        if (fin != null) {
            query.setParameter("fin", fin);
        }

        return query.getResultList();
    }

}
