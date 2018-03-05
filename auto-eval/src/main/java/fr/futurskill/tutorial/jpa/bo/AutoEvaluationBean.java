package fr.futurskill.tutorial.jpa.bo;

import fr.futurskill.tutorial.jpa.model.AutoEvaluation;
import fr.futurskill.tutorial.jpa.model.TicketAutoEvaluation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class AutoEvaluationBean {
    @PersistenceContext
    private EntityManager em;


    public AutoEvaluation creer(String nomTicket) {
        List<TicketAutoEvaluation> tickets = em.createQuery("SELECT tae FROM TicketAutoEvaluation tae WHERE tae.nom=:nom AND tae.expiration<:date AND tae.nombreTickets>0 ORDER BY tae.expiration DESC")
                                     .setParameter("nom", nomTicket)
                                     .setParameter("date", new Date(System.currentTimeMillis())).getResultList();

        if(tickets.isEmpty()) {
            throw new PersistenceException("Pas de TicketAutoEvaluation disponible");
        }

        TicketAutoEvaluation ticket = tickets.get(0);

        // verrouillage optimistic implicite

        ticket.setNombreTickets(ticket.getNombreTickets()-1);

        AutoEvaluation autoEvaluation = new AutoEvaluation();
        autoEvaluation.setDate(new Date(System.currentTimeMillis()));

        ticket.getAutoEvaluations().add(autoEvaluation);
        em.merge(ticket);

        return autoEvaluation;
    }

    public AutoEvaluation modifie(AutoEvaluation autoEvaluation) {
        AutoEvaluation autoEvaluationEntity = em.find(AutoEvaluation.class, autoEvaluation.getId());

        autoEvaluationEntity.setEvaluation(autoEvaluation.getEvaluation());
        autoEvaluationEntity.setNom(autoEvaluation.getNom());
        autoEvaluationEntity.setPrenom(autoEvaluation.getPrenom());
        autoEvaluationEntity.setNumeroTelephone(autoEvaluation.getNumeroTelephone());

        return em.merge(autoEvaluation);
    }

    public List<AutoEvaluation> listeParNomTicket(String nomTicket) {
        List<TicketAutoEvaluation> tickets = em.createQuery("SELECT tae FROM TicketAutoEvaluation tae WHERE tae.nom=:nom ORDER BY tae.expiration DESC")
                .setParameter("nom", nomTicket).getResultList();

        List<AutoEvaluation> autoEvaluations = new ArrayList<AutoEvaluation>();
        for (TicketAutoEvaluation ticket : tickets) {
            autoEvaluations.addAll(ticket.getAutoEvaluations());
        }

        return autoEvaluations;
    }

    public List<AutoEvaluation> listeParCalendrierModule(Long moduleCalendrierId) {
        List<TicketAutoEvaluation> tickets = em.createQuery("SELECT tae FROM TicketAutoEvaluation tae WHERE tae.moduleCalendrier.id=:id  ORDER BY tae.expiration DESC")
                .setParameter("id", moduleCalendrierId).getResultList();

        List<AutoEvaluation> autoEvaluations = new ArrayList<AutoEvaluation>();
        for (TicketAutoEvaluation ticket : tickets) {
            autoEvaluations.addAll(ticket.getAutoEvaluations());
        }

        return autoEvaluations;
    }
}
