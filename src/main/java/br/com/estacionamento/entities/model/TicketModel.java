package br.com.estacionamento.entities.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "tempo_permanencia", nullable = false)
    private Integer tempoPermanencia;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private VeiculoModel veiculo;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncionarioModel funcionario;

    public TicketModel() {
    }

    public TicketModel(BigDecimal valor, Integer tempoPermanencia, VeiculoModel veiculo) {
        this.valor = valor;
        this.tempoPermanencia = tempoPermanencia;
        this.veiculo = veiculo;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getTempoPermanencia() {
        return tempoPermanencia;
    }

    public void setTempoPermanencia(Integer tempoPermanencia) {
        this.tempoPermanencia = tempoPermanencia;
    }

    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }
}