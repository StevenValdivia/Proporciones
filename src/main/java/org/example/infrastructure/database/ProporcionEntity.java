package org.example.infrastructure.database;

import javax.persistence.*;

@Entity
@Table(name = "proporciones")
public class ProporcionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "total")
    private Integer total;

    @Column(name = "medida1")
    private Integer medida1;

    @Column(name = "medida2")
    private Integer medida2;

    @Column(name = "separador")
    private Integer separador;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getTotal()
    {
        return total;
    }

    public void setTotal(Integer total)
    {
        this.total = total;
    }

    public Integer getMedida1()
    {
        return medida1;
    }

    public void setMedida1(Integer medida1)
    {
        this.medida1 = medida1;
    }

    public Integer getMedida2()
    {
        return medida2;
    }

    public void setMedida2(Integer medida2)
    {
        this.medida2 = medida2;
    }

    public Integer getSeparador()
    {
        return separador;
    }

    public void setSeparador(Integer separador)
    {
        this.separador = separador;
    }
}
