package br.com.estacionamento.entities.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veiculos")
public class VeiculoModel {

    @Id
    @Column(name = "placa", length = 7, unique = true, nullable = false)
    private String placa;

    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "cor", length = 30, nullable = false)
    private String cor;

    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel proprietario;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservaModel> reservas = new ArrayList<>();

    // Construtores
    public VeiculoModel() {
    }

    public VeiculoModel(String placa, String modelo, String cor, String marca, Integer ano, ClienteModel proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.ano = ano;
        this.proprietario = proprietario;
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

    public ClienteModel getProprietario() {
        return proprietario;
    }

    public void setProprietario(ClienteModel proprietario) {
        this.proprietario = proprietario;
    }

    public List<ReservaModel> getReservas() {
        return reservas;
    }

    // Método utilitário
    public void adicionarReserva(ReservaModel reserva) {
        this.reservas.add(reserva);
        reserva.setVeiculo(this);
    }
}