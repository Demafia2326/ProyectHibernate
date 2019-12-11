/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel Pérez Ramírez
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByCodigo", query = "SELECT p FROM Proyecto p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT p FROM Proyecto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Proyecto.findByFechaFin", query = "SELECT p FROM Proyecto p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Proyecto.findByCuantia", query = "SELECT p FROM Proyecto p WHERE p.cuantia = :cuantia")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "cuantia")
    private int cuantia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProyecto")
    private Collection<Participan> participanCollection;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Cliente codCliente;

    public Proyecto() {
    }

    public Proyecto(String descripcion, Date fechaInicio, Date fechaFin, int cuantia, Collection<Participan> participanCollection, Cliente codCliente) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cuantia = cuantia;
        this.participanCollection = participanCollection;
        this.codCliente = codCliente;
    }

    public Proyecto(String descripcion, Date fechaInicio, Date fechaFin, int cuantia, Cliente codCliente) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cuantia = cuantia;
        this.codCliente = codCliente;
    }
    
    

    public Proyecto(Integer codigo, String descripcion, Date fechaInicio, Date fechaFin, int cuantia, Collection<Participan> participanCollection, Cliente codCliente) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cuantia = cuantia;
        this.participanCollection = participanCollection;
        this.codCliente = codCliente;
    }
    

    public Proyecto(Integer codigo) {
        this.codigo = codigo;
    }

    public Proyecto(Integer codigo, int cuantia) {
        this.codigo = codigo;
        this.cuantia = cuantia;
    }

    public Proyecto(Proyecto d1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCuantia() {
        return cuantia;
    }

    public void setCuantia(int cuantia) {
        this.cuantia = cuantia;
    }

    @XmlTransient
    public Collection<Participan> getParticipanCollection() {
        return participanCollection;
    }

    public void setParticipanCollection(Collection<Participan> participanCollection) {
        this.participanCollection = participanCollection;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Proyecto[ codigo=" + codigo + " ]";
    }
    
}
