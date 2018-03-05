package fr.futurskill.tutorial.jpa.bo;

import fr.futurskill.tutorial.jpa.model.Module;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

        return em.merge(module);
    }

    public Module modifie(Long id, String titre, String description) {
        Module module = em.find(Module.class, id);

        module.setTitre(titre);
        module.setDescription(description);

        return em.merge(module);
    }


    public void activeModule(Long id, boolean actif) {
        Module module = em.find(Module.class, id);

        module.setActif(actif);
        em.merge(module);
    }

    public List<Module> listeActif() {
        return em.createQuery("SELECT m FROM Module m WHERE m.actif=true").getResultList();
    }

    public List<Module> listeInactif() {
        return em.createQuery("SELECT m FROM Module m WHERE m.actif=false").getResultList();
    }
}
