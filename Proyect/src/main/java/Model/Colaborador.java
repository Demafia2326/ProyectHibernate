/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel Pérez Ramírez
 */
@Entity
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c"),
    @NamedQuery(name = "Colaborador.findByCodigo", query = "SELECT c FROM Colaborador c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Colaborador.findByNombre", query = "SELECT c FROM Colaborador c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Colaborador.findByDomicilio", query = "SELECT c FROM Colaborador c WHERE c.domicilio = :domicilio"),
    @NamedQuery(name = "Colaborador.findByBanco", query = "SELECT c FROM Colaborador c WHERE c.banco = :banco"),
    @NamedQuery(name = "Colaborador.findByNumCuenta", query = "SELECT c FROM Colaborador c WHERE c.numCuenta = :numCuenta"),
    @NamedQuery(name = "Colaborador.findByNif", query = "SELECT c FROM Colaborador c WHERE c.nif = :nif"),
    @NamedQuery(name = "Colaborador.findByTelefono", query = "SELECT c FROM Colaborador c WHERE c.telefono = :telefono")})
public class Colaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "domicilio")
    private String domicilio;
    @Basic(optional = false)
    @Column(name = "banco")
    private String banco;
    @Basic(optional = false)
    @Column(name = "num_cuenta")
    private int numCuenta;
    @Basic(optional = false)
    @Column(name = "nif")
    private String nif;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nifColaborador")
    private Collection<Participan> participanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nifColaborador")
    private Collection<Pago> pagoCollection;

    public Colaborador() {
    }

    public Colaborador(Integer codigo) {
        this.codigo = codigo;
    }

    public Colaborador(String nombre, String domicilio, String banco, int numCuenta, String nif, int telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.banco = banco;
        this.numCuenta = numCuenta;
        this.nif = nif;
        this.telefono = telefono;
    }
    
    

    public Colaborador(Integer codigo, String nombre, String domicilio, String banco, int numCuenta, String nif, int telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.banco = banco;
        this.numCuenta = numCuenta;
        this.nif = nif;
        this.telefono = telefono;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Participan> getParticipanCollection() {
        return participanCollection;
    }

    public void setParticipanCollection(Collection<Participan> participanCollection) {
        this.participanCollection = participanCollection;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
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
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Colaborador[ codigo=" + codigo + " ]";
    }
    
}
