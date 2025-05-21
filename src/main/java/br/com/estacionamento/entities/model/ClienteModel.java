package br.com.estacionamento.entities.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf", nullable = false, unique = true, length = 255)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "telefone", length = 255)
    private String telefone;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VeiculoModel> veiculos = new ArrayList<>();

    public ClienteModel() {}

    public ClienteModel(String nome, String cpf, String telefone, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    public void adicionarVeiculo(VeiculoModel veiculo) {
        veiculos.add(veiculo);
        veiculo.setCliente(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<VeiculoModel> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoModel> veiculos) {
        this.veiculos = veiculos;
    }
}