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

    @Column(name = "nome_convenio", length = 100, nullable = false,unique = true)
    private String nome;

    @Column(name = "nome_empresa", length = 100, nullable = false)
    private String nomeEmpresa;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "qnt_horas", nullable = false)
    private Integer qntHoras;

    @Column(name = "qnt_vagas", nullable = false)
    private Integer qntVagas;
   
    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @OneToMany(mappedBy = "convenio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClienteModel> cliente = new ArrayList<>();

    // Construtores
    public ConvenioModel() {
    }

    // public ConvenioModel(String nome, String nomeEmpresa, BigDecimal valor,
    //                      Integer qntHoras, Integer qntVagas, Integer qntcliente) {
    //     this.nome = nome;
    //     this.nomeEmpresa = nomeEmpresa;
    //     this.valor = valor;
    //     this.qntHoras = qntHoras;
    //     this.qntVagas = qntVagas;
    //     this.qntcliente = qntcliente;
    // }

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

    // public Integer getQntcliente() {
    //     return qntcliente;
    // }

    // public void setQntcliente(Integer qntcliente) {
    //     this.qntcliente = qntcliente;
    // }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "ConvenioModel [id=" + id + ", nome=" + nome + ", nomeEmpresa=" + nomeEmpresa + ", valor=" + valor
                + ", qntHoras=" + qntHoras + ", qntVagas=" + qntVagas + ", ativo=" + ativo + "]";
    }

    // public List<VeiculoModel> getcliente() {
    //     return cliente;
    // }

    // public void setcliente(List<VeiculoModel> cliente) {
    //     this.cliente = cliente;
    // }
    
}
