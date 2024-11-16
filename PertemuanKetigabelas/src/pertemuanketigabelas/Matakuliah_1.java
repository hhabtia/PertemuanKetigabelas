/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeduabelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Habtia Humaira
 */
@Entity
@Table(name = "matakuliah")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matakuliah_1.findAll", query = "SELECT m FROM Matakuliah_1 m"),
    @NamedQuery(name = "Matakuliah_1.findByKodemk", query = "SELECT m FROM Matakuliah_1 m WHERE m.kodemk = :kodemk"),
    @NamedQuery(name = "Matakuliah_1.findBySks", query = "SELECT m FROM Matakuliah_1 m WHERE m.sks = :sks"),
    @NamedQuery(name = "Matakuliah_1.findByNamamk", query = "SELECT m FROM Matakuliah_1 m WHERE m.namamk = :namamk"),
    @NamedQuery(name = "Matakuliah_1.findBySemesterajar", query = "SELECT m FROM Matakuliah_1 m WHERE m.semesterajar = :semesterajar")})
public class Matakuliah_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kodemk")
    private String kodemk;
    @Column(name = "sks")
    private String sks;
    @Column(name = "namamk")
    private String namamk;
    @Column(name = "semesterajar")
    private String semesterajar;

    public Matakuliah_1() {
    }

    public Matakuliah_1(String kodemk) {
        this.kodemk = kodemk;
    }

    public String getKodemk() {
        return kodemk;
    }

    public void setKodemk(String kodemk) {
        this.kodemk = kodemk;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getNamamk() {
        return namamk;
    }

    public void setNamamk(String namamk) {
        this.namamk = namamk;
    }

    public String getSemesterajar() {
        return semesterajar;
    }

    public void setSemesterajar(String semesterajar) {
        this.semesterajar = semesterajar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodemk != null ? kodemk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matakuliah_1)) {
            return false;
        }
        Matakuliah_1 other = (Matakuliah_1) object;
        if ((this.kodemk == null && other.kodemk != null) || (this.kodemk != null && !this.kodemk.equals(other.kodemk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pertemuankeduabelas.Matakuliah_1[ kodemk=" + kodemk + " ]";
    }
    
}
