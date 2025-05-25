package br.com.estacionamento.view;

import java.util.Scanner;

import br.com.estacionamento.entities.model.Endereco;
import br.com.estacionamento.entities.model.EstacionamentoModel;
import br.com.estacionamento.services.EstacionamentoService;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ResponsavelView responsavelView;
    private static FuncionarioView funcionarioView;
    private static ClienteView clienteView;

    public static void main(String[] args) {
        inicializarViews();
        
        while (true) {
            System.out.println("\n==== GERENCIADOR ESTACIONA + ====");
            System.out.println("1 - Acesso Responsável");
            System.out.println("2 - Acesso Funcionário");
            System.out.println("3 - Acesso Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    responsavelView.exibirMenu();
                    break;
                case 2:
                    funcionarioView.exibirMenu();
                    break;
                case 3:
                    clienteView.exibirMenu();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void inicializarViews() {
        responsavelView = new ResponsavelView(scanner);
        funcionarioView = new FuncionarioView(scanner);
        clienteView = new ClienteView(scanner);
    }

    public void inicializar(){
        EstacionamentoModel estacionamento = new EstacionamentoModel();
        EstacionamentoService estacionamentoService = new EstacionamentoService();
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