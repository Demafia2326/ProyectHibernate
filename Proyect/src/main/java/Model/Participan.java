/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Pérez Ramírez
 */
@Entity
@Table(name = "participan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participan.findAll", query = "SELECT p FROM Participan p"),
    @NamedQuery(name = "Participan.findById", query = "SELECT p FROM Participan p WHERE p.id = :id")})
public class Participan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cod_proyecto", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Proyecto codProyecto;
    @JoinColumn(name = "nif_colaborador", referencedColumnName = "nif")
    @ManyToOne(optional = false)
    private Colaborador nifColaborador;

    public Participan() {
    }

    public Participan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proyecto getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(Proyecto codProyecto) {
        this.codProyecto = codProyecto;
    }

    public Colaborador getNifColaborador() {
        return nifColaborador;
    }

    public void setNifColaborador(Colaborador nifColaborador) {
        this.nifColaborador = nifColaborador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participan)) {
            return false;
        }
        Participan other = (Participan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Participan[ id=" + id + " ]";
    }
    
}
