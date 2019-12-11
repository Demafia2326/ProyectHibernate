/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Pérez Ramírez
 */
@Entity
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByCodigo", query = "SELECT p FROM Pago p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pago.findByNumero", query = "SELECT p FROM Pago p WHERE p.numero = :numero"),
    @NamedQuery(name = "Pago.findByConcepto", query = "SELECT p FROM Pago p WHERE p.concepto = :concepto"),
    @NamedQuery(name = "Pago.findByCantidad", query = "SELECT p FROM Pago p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Pago.findByFechaPago", query = "SELECT p FROM Pago p WHERE p.fechaPago = :fechaPago")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "concepto")
    private String concepto;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @JoinColumn(name = "nif_colaborador", referencedColumnName = "nif")
    @ManyToOne(optional = false)
    private Colaborador nifColaborador;

    public Pago() {
    }

    public Pago(Integer codigo) {
        this.codigo = codigo;
    }

    public Pago(int numero, String concepto, int cantidad, Date fechaPago, Colaborador nifColaborador) {
        this.numero = numero;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.fechaPago = fechaPago;
        this.nifColaborador = nifColaborador;
    }

    public Pago(int numero, String concepto, int cantidad, Date fechaPago) {
        this.numero = numero;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.fechaPago = fechaPago;
    }
    
    
    
    

    public Pago(Integer codigo, int numero, String concepto, int cantidad) {
        this.codigo = codigo;
        this.numero = numero;
        this.concepto = concepto;
        this.cantidad = cantidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pago[ codigo=" + codigo + " ]";
    }
    
}
