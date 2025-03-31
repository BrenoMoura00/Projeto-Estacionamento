package br.com.estacionamento.view;

import br.com.estacionamento.entities.*;
import br.com.estacionamento.repositories.ClienteRepository;
import br.com.estacionamento.repositories.FuncionarioRepository;
import br.com.estacionamento.repositories.ReservaRepository;
import br.com.estacionamento.repositories.VeiculoRepository;
import br.com.estacionamento.services.ClienteService;
import br.com.estacionamento.services.FuncionarioService;
import br.com.estacionamento.services.ReservaService;
import br.com.estacionamento.services.VeiculoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ClienteRepository clienteRepository = new ClienteRepository();
    private static final FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
    private static final VeiculoRepository veiculoRepository = new VeiculoRepository();
    private static final ReservaRepository reservaRepository = new ReservaRepository();

    private static final ClienteService clienteService = new ClienteService(clienteRepository);
    private static final FuncionarioService funcionarioService = new FuncionarioService(funcionarioRepository);
    private static final VeiculoService veiculoService = new VeiculoService(veiculoRepository);
    private static final ReservaService reservaService = new ReservaService(reservaRepository);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== Sistema de Estacionamento ===");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Gerenciar Veículos");
            System.out.println("4. Gerenciar Reservas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    gerenciarClientes();
                    break;
                case 2:
                    gerenciarFuncionarios();
                    break;
                case 3:
                    gerenciarVeiculos();
                    break;
                case 4:
                    gerenciarReservas();
                    break;
                case 5:
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    private static void gerenciarClientes() {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n=== Gerenciamento de Clientes ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Buscar Cliente por CPF");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Listar Todos os Clientes");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    buscarClientePorCpf();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    removerCliente();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Mensalista (S/N): ");
        boolean mensalista = scanner.nextLine().equalsIgnoreCase("S");

        Cliente cliente = new Cliente(nome, cpf, telefone, mensalista);
        try {
            clienteService.cadastrarCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void buscarClientePorCpf() {
        System.out.print("\nDigite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = clienteService.buscarClientePorCpf(cpf);
        if (cliente != null) {
            System.out.println("\nCliente encontrado:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Mensalista: " + (cliente.isMensalista() ? "Sim" : "Não"));
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void atualizarCliente() {
        System.out.print("\nDigite o CPF do cliente a ser atualizado: ");
        String cpf = scanner.nextLine();

        Cliente cliente = clienteService.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("\nAtualizando cliente: " + cliente.getNome());
        System.out.print("Novo nome (atual: " + cliente.getNome() + "): ");
        String nome = scanner.nextLine();
        System.out.print("Novo telefone (atual: " + cliente.getTelefone() + "): ");
        String telefone = scanner.nextLine();
        System.out.print("Mensalista (S/N) (atual: " + (cliente.isMensalista() ? "S" : "N") + "): ");
        boolean mensalista = scanner.nextLine().equalsIgnoreCase("S");

        cliente.setNome(nome.isEmpty() ? cliente.getNome() : nome);
        cliente.setTelefone(telefone.isEmpty() ? cliente.getTelefone() : telefone);
        cliente.setMensalista(mensalista);

        try {
            clienteService.atualizarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void removerCliente() {
        System.out.print("\nDigite o CPF do cliente a ser removido: ");
        String cpf = scanner.nextLine();

        try {
            clienteService.removerCliente(cpf);
            System.out.println("Cliente removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarClientes() {
        List<Cliente> clientes = clienteService.listarTodosClientes();

        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado!");
            return;
        }

        System.out.println("\n=== Lista de Clientes ===");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Mensalista: " + (cliente.isMensalista() ? "Sim" : "Não"));
            System.out.println("----------------------");
        }
    }

    private static void gerenciarFuncionarios() {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n=== Gerenciamento de Funcionários ===");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Buscar Funcionário por CPF");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("5. Listar Todos os Funcionários");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    buscarFuncionarioPorCpf();
                    break;
                case 3:
                    atualizarFuncionario();
                    break;
                case 4:
                    removerFuncionario();
                    break;
                case 5:
                    listarFuncionarios();
                    break;
                case 6:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n=== Cadastro de Funcionário ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome, cpf, telefone, cargo, salario);
        try {
            funcionarioService.cadastrarFuncionario(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void buscarFuncionarioPorCpf() {
        System.out.print("\nDigite o CPF do funcionário: ");
        String cpf = scanner.nextLine();

        Funcionario funcionario = funcionarioService.buscarFuncionarioPorCpf(cpf);
        if (funcionario != null) {
            System.out.println("\nFuncionário encontrado:");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Salário: " + funcionario.getSalario());
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    private static void atualizarFuncionario() {
        System.out.print("\nDigite o CPF do funcionário a ser atualizado: ");
        String cpf = scanner.nextLine();

        Funcionario funcionario = funcionarioService.buscarFuncionarioPorCpf(cpf);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        System.out.println("\nAtualizando funcionário: " + funcionario.getNome());
        System.out.print("Novo nome (atual: " + funcionario.getNome() + "): ");
        String nome = scanner.nextLine();
        System.out.print("Novo telefone (atual: " + funcionario.getTelefone() + "): ");
        String telefone = scanner.nextLine();
        System.out.print("Novo cargo (atual: " + funcionario.getCargo() + "): ");
        String cargo = scanner.nextLine();
        System.out.print("Novo salário (atual: " + funcionario.getSalario() + "): ");
        String salarioStr = scanner.nextLine();

        funcionario.setNome(nome.isEmpty() ? funcionario.getNome() : nome);
        funcionario.setTelefone(telefone.isEmpty() ? funcionario.getTelefone() : telefone);
        funcionario.setCargo(cargo.isEmpty() ? funcionario.getCargo() : cargo);
        if (!salarioStr.isEmpty()) {
            funcionario.setSalario(Double.parseDouble(salarioStr));
        }

        try {
            funcionarioService.atualizarFuncionario(funcionario);
            System.out.println("Funcionário atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void removerFuncionario() {
        System.out.print("\nDigite o CPF do funcionário a ser removido: ");
        String cpf = scanner.nextLine();

        try {
            funcionarioService.removerFuncionario(cpf);
            System.out.println("Funcionário removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarTodosFuncionarios();

        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado!");
            return;
        }

        System.out.println("\n=== Lista de Funcionários ===");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("----------------------");
        }
    }

    private static void gerenciarVeiculos() {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n=== Gerenciamento de Veículos ===");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Buscar Veículo por Placa");
            System.out.println("3. Atualizar Veículo");
            System.out.println("4. Remover Veículo");
            System.out.println("5. Listar Todos os Veículos");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    buscarVeiculoPorPlaca();
                    break;
                case 3:
                    atualizarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 5:
                    listarVeiculos();
                    break;
                case 6:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarVeiculo() {
        System.out.println("\n=== Cadastro de Veículo ===");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();

        System.out.print("CPF do proprietário: ");
        String cpf = scanner.nextLine();
        Cliente proprietario = clienteService.buscarClientePorCpf(cpf);

        if (proprietario == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        Veiculo veiculo = new Veiculo(placa, modelo, cor, proprietario);
        try {
            veiculoService.cadastrarVeiculo(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void buscarVeiculoPorPlaca() {
        System.out.print("\nDigite a placa do veículo: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = veiculoService.buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            System.out.println("\nVeículo encontrado:");
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Cor: " + veiculo.getCor());
            System.out.println("Proprietário: " + veiculo.getProprietario().getNome());
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }

    private static void atualizarVeiculo() {
        System.out.print("\nDigite a placa do veículo a ser atualizado: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = veiculoService.buscarVeiculoPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }

        System.out.println("\nAtualizando veículo: " + veiculo.getModelo());
        System.out.print("Novo modelo (atual: " + veiculo.getModelo() + "): ");
        String modelo = scanner.nextLine();
        System.out.print("Nova cor (atual: " + veiculo.getCor() + "): ");
        String cor = scanner.nextLine();

        System.out.print("Novo CPF do proprietário (atual: " + veiculo.getProprietario().getCpf() + "): ");
        String cpf = scanner.nextLine();
        Cliente proprietario = cpf.isEmpty() ? veiculo.getProprietario() : clienteService.buscarClientePorCpf(cpf);

        if (proprietario == null && !cpf.isEmpty()) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        veiculo.setModelo(modelo.isEmpty() ? veiculo.getModelo() : modelo);
        veiculo.setCor(cor.isEmpty() ? veiculo.getCor() : cor);
        if (proprietario != null) {
            veiculo.setProprietario(proprietario);
        }

        try {
            veiculoService.atualizarVeiculo(veiculo);
            System.out.println("Veículo atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void removerVeiculo() {
        System.out.print("\nDigite a placa do veículo a ser removido: ");
        String placa = scanner.nextLine();

        try {
            veiculoService.removerVeiculo(placa);
            System.out.println("Veículo removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarTodosVeiculos();

        if (veiculos.isEmpty()) {
            System.out.println("\nNenhum veículo cadastrado!");
            return;
        }

        System.out.println("\n=== Lista de Veículos ===");
        for (Veiculo veiculo : veiculos) {
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Cor: " + veiculo.getCor());
            System.out.println("Proprietário: " + veiculo.getProprietario().getNome());
            System.out.println("----------------------");
        }
    }

    private static void gerenciarReservas() {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n=== Gerenciamento de Reservas ===");
            System.out.println("1. Realizar Reserva");
            System.out.println("2. Buscar Reserva por ID");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Finalizar Reserva");
            System.out.println("5. Listar Todas as Reservas");
            System.out.println("6. Listar Reservas Ativas");
            System.out.println("7. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    realizarReserva();
                    break;
                case 2:
                    buscarReservaPorId();
                    break;
                case 3:
                    cancelarReserva();
                    break;
                case 4:
                    finalizarReserva();
                    break;
                case 5:
                    listarTodasReservas();
                    break;
                case 6:
                    listarReservasAtivas();
                    break;
                case 7:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void realizarReserva() {
        System.out.println("\n=== Realizar Reserva ===");

        List<Veiculo> veiculos = veiculoService.listarTodosVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado!");
            return;
        }

        System.out.println("\nVeículos disponíveis:");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println((i + 1) + ". " + veiculos.get(i).getModelo() + " - " + veiculos.get(i).getPlaca());
        }

        System.out.print("\nEscolha o veículo (número): ");
        int veiculoIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (veiculoIndex < 0 || veiculoIndex >= veiculos.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        Veiculo veiculo = veiculos.get(veiculoIndex);

        System.out.print("\nNúmero da vaga: ");
        int numeroVaga = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Setor da vaga: ");
        String setorVaga = scanner.nextLine();

        Vaga vaga = new Vaga(numeroVaga, setorVaga, true);

        Reserva reserva = new Reserva(0, vaga, veiculo, LocalDateTime.now());

        try {
            reservaService.realizarReserva(reserva);
            System.out.println("Reserva realizada com sucesso! ID: " + reserva.getId());
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void buscarReservaPorId() {
        System.out.print("\nDigite o ID da reserva: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = reservaService.buscarReservaPorId(id);
        if (reserva != null) {
            System.out.println("\nReserva encontrada:");
            System.out.println("ID: " + reserva.getId());
            System.out.println("Vaga: " + reserva.getVaga().getSetor() + " - " + reserva.getVaga().getNumero());
            System.out.println("Veículo: " + reserva.getVeiculo().getModelo() + " - " + reserva.getVeiculo().getPlaca());
            System.out.println("Proprietário: " + reserva.getVeiculo().getProprietario().getNome());
            System.out.println("Data/Hora Entrada: " + reserva.getDataHoraEntrada());
            if (reserva.getDataHoraSaida() != null) {
                System.out.println("Data/Hora Saída: " + reserva.getDataHoraSaida());
                System.out.println("Valor: R$ " + reserva.getValor());
            } else {
                System.out.println("Status: Ativa");
            }
        } else {
            System.out.println("Reserva não encontrada!");
        }
    }

    private static void cancelarReserva() {
        System.out.print("\nDigite o ID da reserva a ser cancelada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            reservaService.cancelarReserva(id);
            System.out.println("Reserva cancelada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void finalizarReserva() {
        System.out.print("\nDigite o ID da reserva a ser finalizada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            reservaService.finalizarReserva(id);
            System.out.println("Reserva finalizada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarTodasReservas() {
        List<Reserva> reservas = reservaService.listarTodasReservas();

        if (reservas.isEmpty()) {
            System.out.println("\nNenhuma reserva cadastrada!");
            return;
        }

        System.out.println("\n=== Lista de Todas as Reservas ===");
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getId());
            System.out.println("Vaga: " + reserva.getVaga().getSetor() + " - " + reserva.getVaga().getNumero());
            System.out.println("Veículo: " + reserva.getVeiculo().getModelo() + " - " + reserva.getVeiculo().getPlaca());
            System.out.println("Proprietário: " + reserva.getVeiculo().getProprietario().getNome());
            System.out.println("Data/Hora Entrada: " + reserva.getDataHoraEntrada());
            if (reserva.getDataHoraSaida() != null) {
                System.out.println("Data/Hora Saída: " + reserva.getDataHoraSaida());
                System.out.println("Valor: R$ " + reserva.getValor());
            } else {
                System.out.println("Status: Ativa");
            }
            System.out.println("----------------------");
        }
    }

    private static void listarReservasAtivas() {
        List<Reserva> reservas = reservaService.listarReservasAtivas();

        if (reservas.isEmpty()) {
            System.out.println("\nNenhuma reserva ativa no momento!");
            return;
        }

        System.out.println("\n=== Lista de Reservas Ativas ===");
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getId());
            System.out.println("Vaga: " + reserva.getVaga().getSetor() + " - " + reserva.getVaga().getNumero());
            System.out.println("Veículo: " + reserva.getVeiculo().getModelo() + " - " + reserva.getVeiculo().getPlaca());
            System.out.println("Proprietário: " + reserva.getVeiculo().getProprietario().getNome());
            System.out.println("Data/Hora Entrada: " + reserva.getDataHoraEntrada());
            System.out.println("----------------------");
        }
    }
}