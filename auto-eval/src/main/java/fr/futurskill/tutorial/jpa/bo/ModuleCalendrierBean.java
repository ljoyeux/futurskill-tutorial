package fr.futurskill.tutorial.jpa.bo;

import fr.futurskill.tutorial.jpa.model.Module;
import fr.futurskill.tutorial.jpa.model.ModuleCalendrier;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
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

    public void supprime(Long moduleCalendrierd) {
        ModuleCalendrier moduleCalendrier = em.find(ModuleCalendrier.class, moduleCalendrierd);
        em.remove(moduleCalendrier);
    }

    @SuppressWarnings("unchecked")
    public List<ModuleCalendrier> liste(Date debut, Date fin) {
        StringBuilder builder = new StringBuilder("SELECT mc FROM ModuleCalendrier mc WHERE 1=1 ");

        if (debut != null) {
            builder.append("AND mc.debut>=:debut");
        }

        if (fin != null) {
            builder.append("AND mc.fin<=:fin");
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

    public static ModuleCalendrier jpaToBean(ModuleCalendrier entity) {
        ModuleCalendrier bean = new ModuleCalendrier();

        bean.setId(entity.getId());
        bean.setDebut(entity.getDebut());
        bean.setFin(entity.getFin());
        bean.setModule(ModuleBean.jpaToBean(entity.getModule()));

        return bean;
    }

    @SuppressWarnings("unused")
    public static List<ModuleCalendrier> jpaToBean(Collection<ModuleCalendrier> entities) {
        List<ModuleCalendrier> beans = new ArrayList<>();

        for(ModuleCalendrier entity: entities) {
            beans.add(jpaToBean(entity));
        }

        return beans;
    }

}
