package br.com.estacionamento.entities.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valores", length = 255, nullable = false)
    private double valor;

    @Column(name = "tempo_de_permanencia", length = 6, nullable = false)
    private double tempoDePermanencia;

    // falta o many alguma coisa //


    public TicketModel() {
    }

    public TicketModel(Long id, double tempoDePermanencia, double valor) {
        this.id = id;
        this.tempoDePermanencia = tempoDePermanencia;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTempoDePermanencia() {
        return tempoDePermanencia;
    }

    public void setTempoDePermanencia(double tempoDePermanencia) {
        this.tempoDePermanencia = tempoDePermanencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // faltam os métodos de negócio


}
