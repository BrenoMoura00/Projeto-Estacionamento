package br.com.estacionamento.view;

import java.util.Scanner;
import java.util.List;
import br.com.estacionamento.services.EstacionamentoService;
import br.com.estacionamento.services.VagaService;
import br.com.estacionamento.entities.model.EstacionamentoModel;
import br.com.estacionamento.entities.model.Endereco;
import br.com.estacionamento.entities.model.ResponsavelModel;
import br.com.estacionamento.entities.model.VagaModel;

public class ResponsavelView {
    private Scanner scanner;
    private EstacionamentoService estacionamentoService;
    private VagaService vagaService;

    public ResponsavelView(Scanner scanner) {
        this.scanner = scanner;
        this.estacionamentoService = new EstacionamentoService();
        this.vagaService = new VagaService();
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== MENU RESPONSÁVEL ===");
            System.out.println("1 - Gerenciar Estacionamentos");
            System.out.println("2 - Gerenciar Vagas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    menuEstacionamentos();
                    break;
                case 2:
                    menuVagas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menuEstacionamentos() {
        while (true) {
            System.out.println("\n=== GERENCIAR ESTACIONAMENTOS ===");
            System.out.println("1 - Cadastrar Estacionamento");
            System.out.println("2 - Listar Estacionamentos");
            System.out.println("3 - Atualizar Estacionamento");
            System.out.println("4 - Remover Estacionamento");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarEstacionamento();
                    break;
                case 2:
                    listarEstacionamentos();
                    break;
                case 3:
                    atualizarEstacionamento();
                    break;
                case 4:
                    removerEstacionamento();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menuVagas() {
        while (true) {
            System.out.println("\n=== GERENCIAR VAGAS ===");
            System.out.println("1 - Cadastrar Vaga");
            System.out.println("2 - Listar Vagas");
            System.out.println("3 - Atualizar Vaga");
            System.out.println("4 - Remover Vaga");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarVaga();
                    break;
                case 2:
                    listarVagas();
                    break;
                case 3:
                    atualizarVaga();
                    break;
                case 4:
                    removerVaga();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Implementar métodos de CRUD de Estacionamento
    private void cadastrarEstacionamento() {
        EstacionamentoModel estacionamento = new EstacionamentoModel();
        
        System.out.print("Digite o CNPJ: ");
        estacionamento.setCnpj(scanner.nextLine());
        
        System.out.println("\n=== ENDEREÇO ===");
        Endereco endereco = new Endereco();
        System.out.print("Rua: ");
        endereco.setRua(scanner.nextLine());
        System.out.print("Bairro: ");
        endereco.setBairro(scanner.nextLine());
        System.out.print("Cidade: ");
        endereco.setCidade(scanner.nextLine());
        System.out.print("UF: ");
        endereco.setUf(scanner.nextLine());
        System.out.print("CEP: ");
        endereco.setCep(scanner.nextLine());
        System.out.print("Complemento: ");
        endereco.setComplemento(scanner.nextLine());
        
        estacionamento.setEndereco(endereco);
        
        System.out.println("\n=== RESPONSÁVEL ===");
        ResponsavelModel responsavel = new ResponsavelModel();
        System.out.print("Nome: ");
        responsavel.setNome(scanner.nextLine());
        System.out.print("CPF: ");
        responsavel.setCpf(scanner.nextLine());
        System.out.print("Telefone: ");
        responsavel.setTelefone(scanner.nextLine());
        
        estacionamento.setResponsavel(responsavel);
        
        String resultado = estacionamentoService.criarEstacionamentoSeCnpjNaoExistir(estacionamento);
        System.out.println(resultado);
    }

    private void listarEstacionamentos() {
        List<EstacionamentoModel> estacionamentos = estacionamentoService.listarTodosEstacionamentos();
        if (estacionamentos == null || estacionamentos.isEmpty()) {
            System.out.println("Nenhum estacionamento cadastrado.");
            return;
        }
        
        System.out.println("\n=== ESTACIONAMENTOS CADASTRADOS ===");
        for (EstacionamentoModel est : estacionamentos) {
            System.out.println("\nID: " + est.getId());
            System.out.println("CNPJ: " + est.getCnpj());
            System.out.println("Endereço: " + est.getEndereco().getRua() + ", " + 
                             est.getEndereco().getBairro() + ", " + 
                             est.getEndereco().getCidade() + " - " + 
                             est.getEndereco().getUf());
            System.out.println("Responsável: " + est.getResponsavel().getNome());
        }
    }

    private void atualizarEstacionamento() {
        System.out.print("Digite o ID do estacionamento: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Limpar buffer
        
        EstacionamentoModel estacionamento = estacionamentoService.buscarEstacionamentoPorId(id);
        if (estacionamento == null) {
            System.out.println("Estacionamento não encontrado.");
            return;
        }
        
        System.out.println("\n=== ATUALIZAR ESTACIONAMENTO ===");
        System.out.print("Novo CNPJ [" + estacionamento.getCnpj() + "]: ");
        String cnpj = scanner.nextLine();
        if (!cnpj.isEmpty()) {
            estacionamento.setCnpj(cnpj);
        }
        
        System.out.println("\n=== ATUALIZAR ENDEREÇO ===");
        Endereco endereco = estacionamento.getEndereco();
        System.out.print("Nova Rua [" + endereco.getRua() + "]: ");
        String rua = scanner.nextLine();
        if (!rua.isEmpty()) {
            endereco.setRua(rua);
        }
        
        System.out.print("Novo Bairro [" + endereco.getBairro() + "]: ");
        String bairro = scanner.nextLine();
        if (!bairro.isEmpty()) {
            endereco.setBairro(bairro);
        }
        
        System.out.print("Nova Cidade [" + endereco.getCidade() + "]: ");
        String cidade = scanner.nextLine();
        if (!cidade.isEmpty()) {
            endereco.setCidade(cidade);
        }
        
        System.out.print("Nova UF [" + endereco.getUf() + "]: ");
        String uf = scanner.nextLine();
        if (!uf.isEmpty()) {
            endereco.setUf(uf);
        }
        
        System.out.print("Novo CEP [" + endereco.getCep() + "]: ");
        String cep = scanner.nextLine();
        if (!cep.isEmpty()) {
            endereco.setCep(cep);
        }
        
        System.out.print("Novo Complemento [" + endereco.getComplemento() + "]: ");
        String complemento = scanner.nextLine();
        if (!complemento.isEmpty()) {
            endereco.setComplemento(complemento);
        }
        
        String resultado = estacionamentoService.atualizarEstacionamento(estacionamento);
        System.out.println(resultado);
    }

    private void removerEstacionamento() {
        System.out.print("Digite o ID do estacionamento: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Limpar buffer
        
        String resultado = estacionamentoService.removerEstacionamento(id);
        System.out.println(resultado);
    }

    // Implementar métodos de CRUD de Vaga
    private void cadastrarVaga() {
        VagaModel vaga = new VagaModel();
        
        System.out.print("Digite o número da vaga: ");
        vaga.setNumero(Integer.parseInt(scanner.nextLine()));
        
        System.out.print("Digite o setor: ");
        vaga.setSetor(scanner.nextLine());
        
        System.out.print("Digite o andar: ");
        vaga.setAndar(scanner.nextLine());
        
        System.out.print("Digite o ID do estacionamento: ");
        Long estacionamentoId = scanner.nextLong();
        scanner.nextLine(); 
        
        EstacionamentoModel estacionamento = estacionamentoService.buscarEstacionamentoPorId(estacionamentoId);
        if (estacionamento == null) {
            System.out.println("Estacionamento não encontrado.");
            return;
        }
        
        vaga.setEstacionamento(estacionamento);
        vaga.setDisponivel(true);
        
        String resultado = vagaService.cadastrarVaga(vaga);
        System.out.println(resultado);
    }

    private void listarVagas() {
        System.out.print("Digite o ID do estacionamento: ");
        Long estacionamentoId = scanner.nextLong();
        scanner.nextLine(); // Limpar buffer
        
        List<VagaModel> vagas = vagaService.buscarVagasPorEstacionamento(estacionamentoId.intValue());
        if (vagas == null || vagas.isEmpty()) {
            System.out.println("Nenhuma vaga encontrada para este estacionamento.");
            return;
        }
        
        System.out.println("\n=== VAGAS DO ESTACIONAMENTO ===");
        for (VagaModel vaga : vagas) {
            System.out.println("\nNúmero: " + vaga.getNumero());
            System.out.println("Setor: " + vaga.getSetor());
            System.out.println("Andar: " + vaga.getAndar());
            System.out.println("Disponível: " + (vaga.isDisponivel() ? "Sim" : "Não"));
        }
    }

    private void atualizarVaga() {
        System.out.print("Digite o número da vaga: ");
        Integer numero = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Digite o ID do estacionamento: ");
        Long estacionamentoId = scanner.nextLong();
        scanner.nextLine(); 
        
        VagaModel vaga = vagaService.buscarVagaPorNumero(numero.toString());
        if (vaga == null) {
            System.out.println("Vaga não encontrada.");
            return;
        }
        
        System.out.println("\n=== ATUALIZAR VAGA ===");
        System.out.print("Novo Setor [" + vaga.getSetor() + "]: ");
        String setor = scanner.nextLine();
        if (!setor.isEmpty()) {
            vaga.setSetor(setor);
        }
        
        System.out.print("Novo Andar [" + vaga.getAndar() + "]: ");
        String andar = scanner.nextLine();
        if (!andar.isEmpty()) {
            vaga.setAndar(andar);
        }
        
        String resultado = vagaService.atualizarVaga(vaga);
        System.out.println(resultado);
    }

    private void removerVaga() {
        System.out.print("Digite o número da vaga: ");
        String numero = scanner.nextLine();
        
        System.out.print("Digite o ID do estacionamento: ");
        Long estacionamentoId = scanner.nextLong();
        scanner.nextLine(); // Limpar buffer
        
        String resultado = vagaService.removerVaga(numero, estacionamentoId.intValue());
        System.out.println(resultado);
    }
} 