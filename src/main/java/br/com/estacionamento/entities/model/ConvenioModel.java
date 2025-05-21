package br.com.estacionamento.entities.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "convenios")
public class ConvenioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_convenio", length = 100, nullable = false)
    private String nome;

    @Column(name = "nome_empresa", length = 100, nullable = false)
    private String nomeEmpresa;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "qnt_horas", nullable = false)
    private Integer qntHoras;

    @Column(name = "qnt_vagas", nullable = false)
    private Integer qntVagas;

    @Column(name = "qnt_veiculos", nullable = false)
    private Integer qntVeiculos;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @OneToMany(mappedBy = "convenio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VeiculoModel> veiculos = new ArrayList<>();

    // Construtores
    public ConvenioModel() {
    }

    public ConvenioModel(String nome, String nomeEmpresa, BigDecimal valor,
                         Integer qntHoras, Integer qntVagas, Integer qntVeiculos) {
        this.nome = nome;
        this.nomeEmpresa = nomeEmpresa;
        this.valor = valor;
        this.qntHoras = qntHoras;
        this.qntVagas = qntVagas;
        this.qntVeiculos = qntVeiculos;
    }

    public void adicionarVeiculo(VeiculoModel veiculo) {
        if (veiculos.size() < qntVeiculos) {
            if (!veiculos.contains(veiculo)) {
                veiculos.add(veiculo);
                veiculo.setConvenio(this);
            }
        } else {
            throw new IllegalStateException("Limite de veículos do convênio atingido");
        }
    }

    public void desativar() {
        this.ativo = false;
    }

    public BigDecimal calcularValorPorVaga() {
        return valor.divide(new BigDecimal(qntVagas), 2, RoundingMode.HALF_UP);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQntHoras() {
        return qntHoras;
    }

    public void setQntHoras(Integer qntHoras) {
        this.qntHoras = qntHoras;
    }

    public Integer getQntVagas() {
        return qntVagas;
    }

    public void setQntVagas(Integer qntVagas) {
        this.qntVagas = qntVagas;
    }

    public Integer getQntVeiculos() {
        return qntVeiculos;
    }

    public void setQntVeiculos(Integer qntVeiculos) {
        this.qntVeiculos = qntVeiculos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<VeiculoModel> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoModel> veiculos) {
        this.veiculos = veiculos;
    }
}
