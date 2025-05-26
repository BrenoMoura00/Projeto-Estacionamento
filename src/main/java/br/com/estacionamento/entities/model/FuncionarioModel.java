package br.com.estacionamento.entities.model;

import br.com.estacionamento.entities.Pessoa;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcionarios")
// @PrimaryKeyJoinColumn(name = "funcionario_id")
public class FuncionarioModel extends Pessoa {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    @Column(name = "pis", unique = true, length = 14, nullable = false)
    private String pis;

    @Column(name = "cargo", nullable = false, length = 50)
    private String cargo;

    @Column(name = "salario", precision = 10, scale = 2, nullable = false)
    private BigDecimal salario;

    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TelefoneFuncionarioModel> telefone = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "estacionamento_id")
    private EstacionamentoModel estacionamento;

    @Embedded
    private Endereco endereco;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "endereco_id", nullable = false)
    // private EnderecoModel endereco;

    public EstacionamentoModel getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(EstacionamentoModel estacionamento) {
        this.estacionamento = estacionamento;
    }

    public FuncionarioModel() {}

    // public FuncionarioModel(Long id,String nome, String cpf, String telefone, LocalDate dataNasc,
    //                         String pis, String cargo, BigDecimal salario,
    //                         LocalDate dataAdmissao ,Endereco endereco) {
    //     super(id, nome, cpf, telefone, dataNasc);
    //     this.pis = pis;
    //     this.cargo = cargo;
    //     this.salario = salario;
    //     this.dataAdmissao = dataAdmissao;
    //     this.endereco = endereco;
    // }

    // public Long getId() {
    //     return id;
    // }
    public String getPis() {
        return pis;
    }
    public void setPis(String pis) {
        this.pis = pis;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public BigDecimal getSalario() {
        return salario;
    }
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }
    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    @Override
    public String getTipo() {
        return "FUNCIONARIO";
    }
}