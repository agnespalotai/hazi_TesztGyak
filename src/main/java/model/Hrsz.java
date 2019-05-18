package model;

import javax.persistence.*;

@Entity
@Table(name = "Hrsz")
public class Hrsz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Helyrajziszam")
    private String helyrajziszam;

    @Column(name = "Cim")
    private String cim;

    @Column(name = "Varosresz")
    private String varosresz;

    public Hrsz(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHrsz() {
        return helyrajziszam;
    }

    public void setHrsz(String hrsz) {
        this.helyrajziszam = hrsz;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getVarosresz() {
        return varosresz;
    }

    public void setVarosresz(String varosresz) {
        this.varosresz = varosresz;
    }

    @Override
    public String toString() {
        return "Hrsz{" +
                "id=" + id +
                ", hrsz='" + helyrajziszam + '\'' +
                ", cim='" + cim + '\'' +
                ", varosresz='" + varosresz + '\'' +
                '}' + '\n';
    }
}
