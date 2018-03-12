package fr.futurskill.tutorial.jpa.bo;

import fr.futurskill.tutorial.jpa.model.Module;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
@LocalBean
public class ModuleBean {

    @PersistenceContext
    private EntityManager em;


    public Module creer(String titre, String description) {
        Module module = new Module();
        module.setTitre(titre);
        module.setDescription(description);
        module.setActif(true);


        return jpaToBean(em.merge(module));
    }

    public Module modifie(Long id, String titre, String description) {
        Module module = em.find(Module.class, id);

        module.setTitre(titre);
        module.setDescription(description);

        return jpaToBean(em.merge(module));
    }


    public void activeModule(Long id, boolean actif) {
        Module module = em.find(Module.class, id);

        module.setActif(actif);
        em.merge(module);
    }

    @SuppressWarnings("unchecked")
    public List<Module> listeActif() {
        return jpaToBean(em.createQuery("SELECT m FROM Module m WHERE m.actif=true").getResultList());
    }

    @SuppressWarnings("unchecked")
    public List<Module> listeInactif() {
        return jpaToBean(em.createQuery("SELECT m FROM Module m WHERE m.actif=false").getResultList());
    }

    public static Module jpaToBean(Module entity) {
        Module bean = new Module();

        bean.setId(entity.getId());
        bean.setTitre(entity.getTitre());
        bean.setDescription(entity.getDescription());
        bean.setActif(entity.getActif());

        return bean;
    }

    @SuppressWarnings("WeakerAccess")
    public static List<Module> jpaToBean(Collection<Module> entities) {
        List<Module> beans = new ArrayList<>();
        for(Module moduleEntity: entities) {
            beans.add(jpaToBean(moduleEntity));
        }

        return beans;
    }
}
