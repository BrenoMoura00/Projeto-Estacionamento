package br.com.estacionamento.entities.model;

import jakarta.persistence.*;

import java.time.LocalDate;
// import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.estacionamento.entities.Pessoa;

@Entity
@Table(name = "clientes")
public class ClienteModel extends Pessoa{

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Integer id;

    // @Column(name = "cpf", nullable = false, unique = true, length = 255)
    // private String cpf;

    // @Column(name = "nome", nullable = false, length = 255)
    // private String nome;

    // @Column(name = "telefone", length = 255)
    // private String telefone;

    // @Column(name = "data_nasc", nullable = false, updatable = false)
    // private LocalDate dataNasc;
    
    @Embedded
    private Endereco endereco;
    
    private boolean ativo; 

    private LocalDate data_cadastro;

    @OneToMany(mappedBy = "cliente")
    private List<TicketModel> ticket;

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private ConvenioModel convenio;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservaModel> reservas = new ArrayList<>();


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VeiculoModel> veiculos = new ArrayList<>();

   
    
    /*public ClienteModel(String nome, String cpf, String telefone, LocalDate data_cadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    } */

     public Endereco getEndereco() {
        return endereco;
    }



    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }



    public boolean isAtivo() {
        return ativo;
    }



    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }



    public ClienteModel() {}

    
    
    public List<ReservaModel> getReservas() {
        return reservas;
    }


    public void setReservas(List<ReservaModel> reservas) {
        this.reservas = reservas;
    }
    
    public List<TicketModel> getTicket() {
        return ticket;
    }

    public void setTicket(List<TicketModel> ticket) {
        this.ticket = ticket;
    }

    public ConvenioModel getConvenio() {
        return convenio;
    }

    public void setConvenio(ConvenioModel convenio) {
        this.convenio = convenio;
    }

    public void adicionarVeiculo(VeiculoModel veiculo) {
        veiculos.add(veiculo);
        veiculo.setCliente(this);
    }

    public boolean isativo() {
        return ativo;
    }

    public void setativo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    /* 
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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
    */

    public List<VeiculoModel> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoModel> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String getTipo(){
        return "CLIENTE";
    }



    @Override
    public String toString() {
        return "ClienteModel [endereco=" + endereco + ", ativo=" + ativo + ", data_cadastro=" + data_cadastro
                + ", convenio=" + convenio + "]";
    }

    

}