package br.com.estacionamento.entities.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "veiculos")
public class VeiculoModel {

    @Id
    @Column(name = "placa", length = 7, unique = true, nullable = false)
    private String placa;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "cor", nullable = false, length = 30)
    private String cor;

    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservaModel> reservas = new ArrayList<>();

    // Construtores
    public VeiculoModel() {
    }

    public VeiculoModel(String placa, String modelo, String cor, String marca, Integer ano, ClienteModel cliente) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.ano = ano;
        this.cliente = cliente;
    }

    // Métodos de negócio
    public void adicionarReserva(ReservaModel reserva) {
        reservas.add(reserva);
        reserva.setVeiculo(this);
    }

    // Getters e Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public List<ReservaModel> getReservas() {
        return reservas;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoModel that = (VeiculoModel) o;
        return Objects.equals(placa, that.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    // toString
    @Override
    public String toString() {
        return marca + " " + modelo + " (" + placa + ")";
    }
}