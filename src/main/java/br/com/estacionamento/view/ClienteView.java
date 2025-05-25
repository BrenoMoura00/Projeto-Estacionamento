package br.com.estacionamento.view;

import java.util.Scanner;
import java.util.List;
import br.com.estacionamento.services.VeiculoService;
import br.com.estacionamento.services.ClienteService;
import br.com.estacionamento.entities.model.VeiculoModel;
import br.com.estacionamento.entities.model.ClienteModel;

public class ClienteView {
    private Scanner scanner;
    private VeiculoService veiculoService;
    private ClienteService clienteService;

    public ClienteView(Scanner scanner) {
        this.scanner = scanner;
        this.veiculoService = new VeiculoService();
        this.clienteService = new ClienteService();
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.println("1 - Meus Veículos");
            System.out.println("2 - Editar Veículo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    listarMeusVeiculos();
                    break;
                case 2:
                    menuEditarVeiculo();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menuEditarVeiculo() {
        while (true) {
            System.out.println("\n=== EDITAR VEÍCULO ===");
            System.out.println("1 - Atualizar Dados do Veículo");
            System.out.println("2 - Remover Veículo");
            System.out.println("3 - Listar clientes cadastrados");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    atualizarVeiculo();
                    break;
                case 2:
                    removerVeiculo();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void listarMeusVeiculos() {
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        
        ClienteModel cliente = clienteService.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        
        List<VeiculoModel> veiculos = veiculoService.listarTodosVeiculos();
        if (veiculos == null || veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        
        System.out.println("\n=== MEUS VEÍCULOS ===");
        boolean encontrou = false;
        for (VeiculoModel veiculo : veiculos) {
            if (veiculo.getCliente().getCpf().equals(cpf)) {
                encontrou = true;
                System.out.println("\nPlaca: " + veiculo.getPlaca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Cor: " + veiculo.getCor());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Ano: " + veiculo.getAno());
            }
        }
        
        if (!encontrou) {
            System.out.println("Você não possui veículos cadastrados.");
        }
    }

    private void atualizarVeiculo() {
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        
        ClienteModel cliente = clienteService.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        
        VeiculoModel veiculo = veiculoService.buscarVeiculoPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }
        
        if (!veiculo.getCliente().getCpf().equals(cpf)) {
            System.out.println("Este veículo não pertence a você.");
            return;
        }
        
        System.out.println("\n=== ATUALIZAR VEÍCULO ===");
        System.out.print("Novo Modelo [" + veiculo.getModelo() + "]: ");
        String modelo = scanner.nextLine();
        if (!modelo.isEmpty()) {
            veiculo.setModelo(modelo);
        }
        
        System.out.print("Nova Cor [" + veiculo.getCor() + "]: ");
        String cor = scanner.nextLine();
        if (!cor.isEmpty()) {
            veiculo.setCor(cor);
        }
        
        System.out.print("Nova Marca [" + veiculo.getMarca() + "]: ");
        String marca = scanner.nextLine();
        if (!marca.isEmpty()) {
            veiculo.setMarca(marca);
        }
        
        System.out.print("Novo Ano [" + veiculo.getAno() + "]: ");
        String ano = scanner.nextLine();
        if (!ano.isEmpty()) {
            veiculo.setAno(Integer.parseInt(ano));
        }
        
        String resultado = veiculoService.atualizarVeiculo(veiculo);
        System.out.println(resultado);
    }

    private void removerVeiculo() {
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        
        ClienteModel cliente = clienteService.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        
        VeiculoModel veiculo = veiculoService.buscarVeiculoPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }
        
        if (!veiculo.getCliente().getCpf().equals(cpf)) {
            System.out.println("Este veículo não pertence a você.");
            return;
        }
        
        String resultado = veiculoService.removerVeiculo(placa);
        System.out.println(resultado);
    }

    private void listarClientes() {
        List<ClienteModel> clientes = clienteService.listarTodosClientes();
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        
        System.out.println("\n=== CLIENTES CADASTRADOS ===");
        for (ClienteModel cliente : clientes) {
            System.out.println("\nCPF: " + cliente.getCpf());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Data de Cadastro: " + cliente.getData_cadastro());
            System.out.println("Status: " + (cliente.isAtivo() ? "Ativo" : "Inativo"));
        }
    }
} 