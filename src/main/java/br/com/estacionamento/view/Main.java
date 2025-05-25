package br.com.estacionamento.view;

import java.util.Scanner;

import br.com.estacionamento.entities.model.Endereco;
import br.com.estacionamento.entities.model.EstacionamentoModel;
import br.com.estacionamento.services.ClienteService;
import br.com.estacionamento.services.ConvenioService;
import br.com.estacionamento.services.EstacionamentoService;
import br.com.estacionamento.services.FuncionarioService;
import br.com.estacionamento.services.ReservaService;
import br.com.estacionamento.services.ResponsavelService;
import br.com.estacionamento.services.TicketService;
import br.com.estacionamento.services.VagaService;
import br.com.estacionamento.services.VeiculoService;

public class Main {
    private  ReservaService reservaService = new ReservaService();
    private  TicketService ticketService = new TicketService();
    private  ClienteService clienteService = new ClienteService();
    private  ConvenioService convenioService = new ConvenioService();
    private  FuncionarioService funcionarioService = new FuncionarioService();
    private  ResponsavelService responsavelService = new ResponsavelService();
    private  VagaService vagaService = new VagaService();
    private  VeiculoService veiculoService = new VeiculoService();
    private  EstacionamentoService estacionamentoService = new EstacionamentoService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Criar três opções de entrada 
         * Funcionario, Cliente, e Responsavel
         * Responsavel : Crud de estacionamentos, crud vagas
         * 
         */
        while (true) {
            System.out.println("====Estacionamento SANTANA====");
        }
    }
    public void inicializar(){
        EstacionamentoModel estacionamento = new EstacionamentoModel();
        estacionamento.setCnpj("12.345.678/0001-95");
        Endereco endereco = new Endereco();
        endereco.setBairro("livramento");
        endereco.setCep("3506-5264");
        endereco.setCidade("Nazare da mata");
        endereco.setComplemento("Proximo ao cajazeiro");
        endereco.setRua("Rua rosa");
        endereco.setUf("PE");
        estacionamento.setEndereco(endereco);
        estacionamentoService.criarEstacionamentoSeCnpjNaoExistir(estacionamento);
    }
}