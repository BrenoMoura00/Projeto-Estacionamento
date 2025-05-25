package br.com.estacionamento.view;

import java.util.Scanner;
import java.util.List;
import br.com.estacionamento.services.ClienteService;
import br.com.estacionamento.services.ConvenioService;
import br.com.estacionamento.services.VeiculoService;
import br.com.estacionamento.services.TicketService;
import br.com.estacionamento.entities.model.ClienteModel;
import br.com.estacionamento.entities.model.ConvenioModel;
import br.com.estacionamento.entities.model.VeiculoModel;
import br.com.estacionamento.entities.model.TicketModel;
import java.math.BigDecimal;

public class FuncionarioView {
    private Scanner scanner;
    private ClienteService clienteService;
    private ConvenioService convenioService;
    private VeiculoService veiculoService;
    private TicketService ticketService;

    public FuncionarioView(Scanner scanner) {
        this.scanner = scanner;
        this.clienteService = new ClienteService();
        this.convenioService = new ConvenioService();
        this.veiculoService = new VeiculoService();
        this.ticketService = new TicketService();
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== MENU FUNCIONÁRIO ===");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Convênios");
            System.out.println("3 - Gerenciar Veículos");
            System.out.println("4 - Gerenciar Tickets");
            System.out.println("5 - Gerar Pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuConvenios();
                    break;
                case 3:
                    menuVeiculos();
                    break;
                case 4:
                    menuTickets();
                    break;
                case 5:
                    gerarPagamento();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menuClientes() {
        while (true) {
            System.out.println("\n=== GERENCIAR CLIENTES ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    removerCliente();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menuConvenios() {
        while (true) {
            System.out.println("\n=== GERENCIAR CONVÊNIOS ===");
            System.out.println("1 - Cadastrar Convênio");
            System.out.println("2 - Listar Convênios");
            System.out.println("3 - Atualizar Convênio");
            System.out.println("4 - Remover Convênio");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarConvenio();
                    break;
                case 2:
                    listarConvenios();
                    break;
                case 3:
                    atualizarConvenio();
                    break;
                case 4:
                    removerConvenio();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menuVeiculos() {
        while (true) {
            System.out.println("\n=== GERENCIAR VEÍCULOS ===");
            System.out.println("1 - Cadastrar Veículo");
            System.out.println("2 - Listar Veículos");
            System.out.println("3 - Atualizar Veículo");
            System.out.println("4 - Remover Veículo");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    atualizarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menuTickets() {
        while (true) {
            System.out.println("\n=== GERENCIAR TICKETS ===");
            System.out.println("1 - Gerar Ticket");
            System.out.println("2 - Listar Tickets");
            System.out.println("3 - Atualizar Ticket");
            System.out.println("4 - Remover Ticket");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerarTicket();
                    break;
                case 2:
                    listarTickets();
                    break;
                case 3:
                    atualizarTicket();
                    break;
                case 4:
                    removerTicket();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarCliente() {
        ClienteModel cliente = new ClienteModel();
        
        System.out.print("Digite o nome do cliente: ");
        cliente.setNome(scanner.nextLine());
        
        System.out.print("Digite o CPF do cliente: ");
        cliente.setCpf(scanner.nextLine());
        
        System.out.print("Digite o telefone do cliente: ");
        cliente.setTelefone(scanner.nextLine());
        
        String resultado = clienteService.cadastrarCliente(cliente);
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

    private void atualizarCliente() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        
        ClienteModel cliente = clienteService.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        
        System.out.println("\n=== ATUALIZAR CLIENTE ===");
        System.out.print("Novo Nome [" + cliente.getNome() + "]: ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            cliente.setNome(nome);
        }
        
        System.out.print("Novo Telefone [" + cliente.getTelefone() + "]: ");
        String telefone = scanner.nextLine();
        if (!telefone.isEmpty()) {
            cliente.setTelefone(telefone);
        }
        
        String resultado = clienteService.atualizarCliente(cliente);
        System.out.println(resultado);
    }

    private void removerCliente() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        
        String resultado = clienteService.removerCliente(cpf);
        System.out.println(resultado);
    }

    private void cadastrarConvenio() {
        ConvenioModel convenio = new ConvenioModel();
        
        System.out.print("Digite o nome do convênio: ");
        convenio.setNome(scanner.nextLine());
        
        System.out.print("Digite o nome da empresa: ");
        convenio.setNomeEmpresa(scanner.nextLine());
        
        System.out.print("Digite o valor do convênio: ");
        convenio.setValor(new BigDecimal(scanner.nextLine()));
        
        System.out.print("Digite a quantidade de horas: ");
        convenio.setQntHoras(Integer.parseInt(scanner.nextLine()));
        
        System.out.print("Digite a quantidade de vagas: ");
        convenio.setQntVagas(Integer.parseInt(scanner.nextLine()));
        
        String resultado = convenioService.cadastrarConvenio(convenio);
        System.out.println(resultado);
    }

    private void listarConvenios() {
        List<ConvenioModel> convenios = convenioService.listarTodosConvenios();
        if (convenios == null || convenios.isEmpty()) {
            System.out.println("Nenhum convênio cadastrado.");
            return;
        }
        
        System.out.println("\n=== CONVÊNIOS CADASTRADOS ===");
        for (ConvenioModel convenio : convenios) {
            System.out.println("\nID: " + convenio.getId());
            System.out.println("Nome: " + convenio.getNome());
            System.out.println("Empresa: " + convenio.getNomeEmpresa());
            System.out.println("Valor: R$ " + convenio.getValor());
            System.out.println("Quantidade de Horas: " + convenio.getQntHoras());
            System.out.println("Quantidade de Vagas: " + convenio.getQntVagas());
        }
    }

    private void atualizarConvenio() {
        System.out.print("Digite o ID do convênio: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        
        ConvenioModel convenio = convenioService.buscarConvenioPorId(id);
        if (convenio == null) {
            System.out.println("Convênio não encontrado.");
            return;
        }
        
        System.out.println("\n=== ATUALIZAR CONVÊNIO ===");
        System.out.print("Novo Nome [" + convenio.getNome() + "]: ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            convenio.setNome(nome);
        }
        
        System.out.print("Nova Empresa [" + convenio.getNomeEmpresa() + "]: ");
        String empresa = scanner.nextLine();
        if (!empresa.isEmpty()) {
            convenio.setNomeEmpresa(empresa);
        }
        
        System.out.print("Novo Valor [" + convenio.getValor() + "]: ");
        String valor = scanner.nextLine();
        if (!valor.isEmpty()) {
            convenio.setValor(new BigDecimal(valor));
        }
        
        System.out.print("Nova Quantidade de Horas [" + convenio.getQntHoras() + "]: ");
        String horas = scanner.nextLine();
        if (!horas.isEmpty()) {
            convenio.setQntHoras(Integer.parseInt(horas));
        }
        
        System.out.print("Nova Quantidade de Vagas [" + convenio.getQntVagas() + "]: ");
        String vagas = scanner.nextLine();
        if (!vagas.isEmpty()) {
            convenio.setQntVagas(Integer.parseInt(vagas));
        }
        
        String resultado = convenioService.atualizarConvenio(convenio);
        System.out.println(resultado);
    }

    private void removerConvenio() {
        System.out.print("Digite o ID do convênio: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        
        String resultado = convenioService.removerConvenio(id);
        System.out.println(resultado);
    }

    private void cadastrarVeiculo() {
        VeiculoModel veiculo = new VeiculoModel();
        
        System.out.print("Digite a placa do veículo: ");
        veiculo.setPlaca(scanner.nextLine());
        
        System.out.print("Digite o modelo do veículo: ");
        veiculo.setModelo(scanner.nextLine());
        
        System.out.print("Digite a cor do veículo: ");
        veiculo.setCor(scanner.nextLine());
        
        System.out.print("Digite a marca do veículo: ");
        veiculo.setMarca(scanner.nextLine());
        
        System.out.print("Digite o ano do veículo: ");
        veiculo.setAno(Integer.parseInt(scanner.nextLine()));
        
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        ClienteModel cliente = clienteService.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        veiculo.setCliente(cliente);
        
        String resultado = veiculoService.cadastrarVeiculo(veiculo);
        System.out.println(resultado);
    }

    private void listarVeiculos() {
        List<VeiculoModel> veiculos = veiculoService.listarTodosVeiculos();
        if (veiculos == null || veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        
        System.out.println("\n=== VEÍCULOS CADASTRADOS ===");
        for (VeiculoModel veiculo : veiculos) {
            System.out.println("\nPlaca: " + veiculo.getPlaca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Cor: " + veiculo.getCor());
            System.out.println("Marca: " + veiculo.getMarca());
            System.out.println("Ano: " + veiculo.getAno());
            System.out.println("Cliente: " + veiculo.getCliente().getNome());
        }
    }

    private void atualizarVeiculo() {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        
        VeiculoModel veiculo = veiculoService.buscarVeiculoPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
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
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        
        String resultado = veiculoService.removerVeiculo(placa);
        System.out.println(resultado);
    }

    private void gerarTicket() {
        TicketModel ticket = new TicketModel();
        
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        VeiculoModel veiculo = veiculoService.buscarVeiculoPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }
        ticket.setVeiculo(veiculo);
        
        System.out.print("Digite o tempo de permanência (em horas): ");
        ticket.setTempoPermanencia(Integer.parseInt(scanner.nextLine()));
        
        String resultado = ticketService.cadastrarTicket(ticket);
        System.out.println(resultado);
    }

    private void listarTickets() {
        List<TicketModel> tickets = ticketService.listarTodosTickets();
        if (tickets == null || tickets.isEmpty()) {
            System.out.println("Nenhum ticket cadastrado.");
            return;
        }
        
        System.out.println("\n=== TICKETS CADASTRADOS ===");
        for (TicketModel ticket : tickets) {
            System.out.println("\nID: " + ticket.getId());
            System.out.println("Veículo: " + ticket.getVeiculo().getPlaca());
            System.out.println("Cliente: " + ticket.getVeiculo().getCliente().getNome());
            System.out.println("Tempo de Permanência: " + ticket.getTempoPermanencia() + " horas");
            System.out.println("Funcionário: " + ticket.getFuncionario().getNome());
        }
    }

    private void atualizarTicket() {
        System.out.print("Digite o ID do ticket: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        
        TicketModel ticket = ticketService.buscarTicketPorId(id);
        if (ticket == null) {
            System.out.println("Ticket não encontrado.");
            return;
        }
        
        System.out.println("\n=== ATUALIZAR TICKET ===");
        System.out.print("Novo Tempo de Permanência [" + ticket.getTempoPermanencia() + "]: ");
        String tempo = scanner.nextLine();
        if (!tempo.isEmpty()) {
            ticket.setTempoPermanencia(Integer.parseInt(tempo));
        }
        
        String resultado = ticketService.atualizarTicket(ticket);
        System.out.println(resultado);
    }

    private void removerTicket() {
        System.out.print("Digite o ID do ticket: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        
        String resultado = ticketService.removerTicket(id);
        System.out.println(resultado);
    }

    private void gerarPagamento() {
        System.out.print("Digite o ID do ticket: ");
        Long ticketId = scanner.nextLong();
        scanner.nextLine();
        
        TicketModel ticket = ticketService.buscarTicketPorId(ticketId);
        if (ticket == null) {
            System.out.println("Ticket não encontrado.");
            return;
        }
        
        System.out.println("Funcionalidade em desenvolvimento.");
    }
    
} 