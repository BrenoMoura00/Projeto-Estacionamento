package br.com.estacionamento.entities.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vagas")
public class VagaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", unique = true, nullable = false)
    private Integer numero;

    @Column(name = "setor", length = 50, nullable = false)
    private String setor;

    @Column(name = "andar", length = 20, nullable = false)
    private String andar;

    @Column(name = "disponivel", nullable = false)
    private Boolean disponivel = true;

    @ManyToOne
    @JoinColumn(name = "estacionamento_id", nullable = false)
    private EstacionamentoModel estacionamento;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
    private List<ReservaModel> reservas = new ArrayList<>();

    // Construtores
    public VagaModel() {
    }

    public VagaModel(Integer numero, String setor, String andar, EstacionamentoModel estacionamento) {
        this.numero = numero;
        this.setor = setor;
        this.andar = andar;
        this.estacionamento = estacionamento;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public Boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public EstacionamentoModel getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(EstacionamentoModel estacionamento) {
        this.estacionamento = estacionamento;
    }

    public List<ReservaModel> getReservas() {
        return reservas;
    }

    // Método de negócio
    public boolean reservar() {
        if (this.disponivel) {
            this.disponivel = false;
            return true;
        }
        return false;
    }

    public void liberar() {
        this.disponivel = true;
    }
}