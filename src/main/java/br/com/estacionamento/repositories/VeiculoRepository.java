package br.com.estacionamento.repositories;

import java.util.List;

import br.com.estacionamento.entities.model.VeiculoModel;
import br.com.estacionamento.interfaces.repositories.IVeiculoRepository;

public class VeiculoRepository extends BaseDAO<VeiculoModel> implements IVeiculoRepository{
    public VeiculoRepository(){
        super(VeiculoModel.class);
    }

    @Override
    public void atualizar(VeiculoModel veiculo) {
        String jpql = """
        UPDATE VeiculoModel v SET 
            v.modelo = :modelo,
            v.cor = :cor,
            v.marca = :marca,
            v.ano = :ano,
            v.cliente = :cliente,
            v.placa = :placa
         WHERE 
         v.id = :id
        """;

        em.getTransaction().begin();
        em.createQuery(jpql)
          .setParameter("modelo", veiculo.getModelo())
          .setParameter("cor", veiculo.getCor())
          .setParameter("marca", veiculo.getMarca())
          .setParameter("ano", veiculo.getAno())
          .setParameter("cliente", veiculo.getCliente())
          .setParameter("placa", veiculo.getPlaca())
          .setParameter("id", veiculo.getId())
          .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public VeiculoModel buscarPorPlaca(String placa) {
        String jpql = "SELECT v FROM VeiculoModel v WHERE v.placa = :placa";
        List<VeiculoModel> resultado = em.createQuery(jpql, VeiculoModel.class)
                                      .setParameter("placa", placa)
                                      .getResultList();
        return resultado.isEmpty() ? null : resultado.get(0);
    }

    @Override
    public List<VeiculoModel> listarTodos() {
        String jpql = "SELECT v FROM VeiculoModel v";
        return em.createQuery(jpql, VeiculoModel.class).getResultList();
    }

    @Override
    public void remover(String placa) {
        VeiculoModel veiculo = buscarPorPlaca(placa);
        if (veiculo != null) {
            em.getTransaction().begin();
            em.remove(veiculo);
            em.getTransaction().commit();
        }
    }

    // @Override
    // public void salvar(VeiculoModel veiculo) {
    //     // TODO Auto-generated method stub
        
    // }

    
}
