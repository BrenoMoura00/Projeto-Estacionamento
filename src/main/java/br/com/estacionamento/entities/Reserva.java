package br.com.estacionamento.entities;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private Vaga vaga;
    private Veiculo veiculo;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private double valor;

    public Reserva() {
    }

    public Reserva(int id, Vaga vaga, Veiculo veiculo, LocalDateTime dataHoraEntrada) {
        this.id = id;
        this.vaga = vaga;
        this.veiculo = veiculo;
        this.dataHoraEntrada = dataHoraEntrada;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
