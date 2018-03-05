package fr.futurskill.tutorial.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ModuleCalendrier implements Serializable {

    private static final long serialVersionUID = -7673152138554894459L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date debut;

    @Temporal(TemporalType.DATE)
    private Date fin;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Module module;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleCalendrier that = (ModuleCalendrier) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ModuleCalendrier{" +
                "id=" + id +
                ", debut=" + debut +
                ", fin=" + fin +
                ", module=" + module +
                '}';
    }
}
