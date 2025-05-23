package br.com.estacionamento.entities.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class ReservaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    private VagaModel vaga;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @Column(name = "data_hora_entrada", nullable = false)
    private LocalDateTime dataHoraEntrada;

    @Column(name = "data_hora_saida")
    private LocalDateTime dataHoraSaida;

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    public ReservaModel() {
    }

    // public ReservaModel(VagaModel vaga, VeiculoModel veiculo, LocalDateTime dataHoraEntrada) {
    //     this.vaga = vaga;
    //     this.veiculo = veiculo;
    //     this.dataHoraEntrada = dataHoraEntrada;
    // }

    
    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }


    public Integer getId() {
        return id;
    }

    public VagaModel getVaga() {
        return vaga;
    }

    public void setVaga(VagaModel vaga) {
        this.vaga = vaga;
    }

    public ClienteModel getcliente() {
        return cliente;
    }

    public void setcliente(ClienteModel cliente) {
        this.cliente = cliente;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}