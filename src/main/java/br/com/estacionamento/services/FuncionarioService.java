package br.com.estacionamento.services;

import br.com.estacionamento.interfaces.services.IFuncionarioService;
import br.com.estacionamento.repositories.FuncionarioRepository;
import br.com.estacionamento.entities.model.FuncionarioModel;
import java.time.LocalDate;
import java.util.List;

public class FuncionarioService implements IFuncionarioService {
    
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService() {
        this.funcionarioRepository = new FuncionarioRepository();
    }

    @Override
    public String cadastrarFuncionario(FuncionarioModel funcionario) {
        if (funcionario == null) {
            return "Funcionário não pode ser nulo";
        }

        if (funcionario.getCpf() == null || funcionario.getCpf().trim().isEmpty()) {
            return "CPF é obrigatório";
        }

        if (funcionario.getPis() == null || funcionario.getPis().trim().isEmpty()) {
            return "PIS é obrigatório";
        }

        if (funcionario.getCargo() == null || funcionario.getCargo().trim().isEmpty()) {
            return "Cargo é obrigatório";
        }

        if (funcionario.getSalario() == null) {
            return "Salário é obrigatório";
        }

        try {
            funcionario.setDataAdmissao(LocalDate.now());
            funcionarioRepository.create(funcionario);
            return "Funcionário cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar funcionário: " + e.getMessage();
        }
    }

    @Override
    public FuncionarioModel buscarFuncionarioPorCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return null;
        }
        return funcionarioRepository.findByCpf(cpf);
    }

    @Override
    public String atualizarFuncionario(FuncionarioModel funcionario) {
        if (funcionario == null) {
            return "Funcionário não pode ser nulo";
        }

        if (funcionario.getCpf() == null || funcionario.getCpf().trim().isEmpty()) {
            return "CPF é obrigatório";
        }

        FuncionarioModel funcionarioExistente = funcionarioRepository.findByCpf(funcionario.getCpf());
        if (funcionarioExistente == null) {
            return "Funcionário não encontrado para atualização";
        }

        try {
            // Mantém a data de admissão original
            funcionario.setDataAdmissao(funcionarioExistente.getDataAdmissao());
            funcionarioRepository.update(funcionario);
            return "Funcionário atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar funcionário: " + e.getMessage();
        }
    }

    @Override
    public String removerFuncionario(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return "CPF não pode ser nulo ou vazio";
        }

        FuncionarioModel funcionario = funcionarioRepository.findByCpf(cpf);
        if (funcionario == null) {
            return "Funcionário não encontrado com o CPF: " + cpf;
        }

        try {
            funcionarioRepository.delete(funcionario.getId().intValue());
            return "Funcionário removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover funcionário: " + e.getMessage();
        }
    }

    @Override
    public List<FuncionarioModel> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public List<FuncionarioModel> buscarPorCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            return null;
        }
        return funcionarioRepository.findByCargo(cargo);
    }

    public List<FuncionarioModel> buscarPorDataAdmissao(LocalDate dataAdmissao) {
        if (dataAdmissao == null) {
            return null;
        }
        return funcionarioRepository.findByDataAdmissao(dataAdmissao);
    }
}
