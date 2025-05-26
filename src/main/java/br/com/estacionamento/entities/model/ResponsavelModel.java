package br.com.estacionamento.entities.model;

import java.util.ArrayList;
import java.util.List;

import br.com.estacionamento.entities.Pessoa;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "responsavel")
public class ResponsavelModel extends Pessoa {

    private Endereco endereco;

    @OneToMany(mappedBy = "responsavel")
    private List<EstacionamentoModel> estacionamento;

    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TelefoneResponsavelModel> telefone = new ArrayList<>();
    
    public ResponsavelModel(){
        
    }

    public List<EstacionamentoModel> getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(List<EstacionamentoModel> estacionamento) {
        this.estacionamento = estacionamento;
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getTipo() {
        return "RESPONSAVEL";
    }

    
}
