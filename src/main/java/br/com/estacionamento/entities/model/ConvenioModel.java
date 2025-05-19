package br.com.estacionamento.entities.model;


import jakarta.persistence.*;

@Entity
@Table (name = "convenios")
public class ConvenioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor", length = 225, nullable = false)
    private double valor;

    @Column(name = "qnt_horas", length = 2, nullable = false)
    private int qntHoras;

    @Column(name = "qnt_vagas", length = 3, nullable = false)
    private int qntVagas;

    @Column(name = "qnt_veiculos", length = 3, nullable = false)
    private int qntVeiculos;

    // falta o many alguma coisa

    public ConvenioModel() {
    }

    public ConvenioModel(Long id, int qntHoras, int qntVagas, int qntVeiculos, double valor) {
        this.id = id;
        this.qntHoras = qntHoras;
        this.qntVagas = qntVagas;
        this.qntVeiculos = qntVeiculos;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQntHoras() {
        return qntHoras;
    }

    public void setQntHoras(int qntHoras) {
        this.qntHoras = qntHoras;
    }

    public int getQntVagas() {
        return qntVagas;
    }

    public void setQntVagas(int qntVagas) {
        this.qntVagas = qntVagas;
    }

    public int getQntVeiculos() {
        return qntVeiculos;
    }

    public void setQntVeiculos(int qntVeiculos) {
        this.qntVeiculos = qntVeiculos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // faltam os metodos de negocio

}
