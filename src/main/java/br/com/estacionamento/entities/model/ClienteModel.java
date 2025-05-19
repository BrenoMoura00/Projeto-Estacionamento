package br.com.estacionamento.entities.model;

import br.com.estacionamento.entities.Pessoa;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class ClienteModel extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VeiculoModel> veiculos = new ArrayList<>();

    // Construtor
    public ClienteModel() {
    }

    public ClienteModel(String nome, String cpf, String telefone, LocalDate dataNasc) {
        super(nome, cpf, telefone, dataNasc);
    }

    // Métodos de negócio
    public void adicionarVeiculo(VeiculoModel veiculo) {
        veiculos.add(veiculo);
        veiculo.setCliente(this);
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public List<VeiculoModel> getVeiculos() {
        return veiculos;
    }

    @Override
    public String getTipo() {
        return "CLIENTE";
    }
}