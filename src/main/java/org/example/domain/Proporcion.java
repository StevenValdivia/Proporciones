package org.example.domain;

public class Proporcion {

    private int id;
    private int total;
    private int medida1;
    private int medida2;
    private int separador;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMedida1() {
        return medida1;
    }

    public void setMedida1(int medida1) {
        this.medida1 = medida1;
    }

    public int getMedida2() {
        return medida2;
    }

    public void setMedida2(int medida2) {
        this.medida2 = medida2;
    }

    public int getSeparador() {
        return separador;
    }

    public void setSeparador(int separador) {
        this.separador = separador;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int calcularPrimeraDistancia(int medida1, int separador) {
        return medida1 - (separador * 3 / 2);
    }

    public int calcularSegundaDistancia(int medidaTotal, int medida1, int separador) {
        return medidaTotal - medida1 - (separador * 3 / 2);
    }
}
