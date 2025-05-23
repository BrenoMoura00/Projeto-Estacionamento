package br.com.estacionamento.entities.model;

import java.util.List;

import br.com.estacionamento.entities.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "responsavel")
public class ResponsavelModel extends Pessoa {

    private Endereco endereco;

    @OneToMany(mappedBy = "responsavel")
    private List<EstacionamentoModel> estacionamento;

    
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
