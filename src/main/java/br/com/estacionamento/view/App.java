package br.com.estacionamento.view;

// import java.math.BigDecimal;
// import java.util.List;

// import br.com.estacionamento.entities.model.ClienteModel;
// import br.com.estacionamento.entities.model.ConvenioModel;
// import br.com.estacionamento.entities.model.VeiculoModel;
// import br.com.estacionamento.repositories.ClienteRepository;
// import br.com.estacionamento.repositories.ConvenioRepository;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.Persistence;
import br.com.estacionamento.services.*;
   
public class App {
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
        
        
        // EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("estacionamento");
        // EntityManager em =  entityManagerFactory.createEntityManager();
        // try{
        //     em.getTransaction().begin();
        //     em.getTransaction().commit();
        //     System.out.println("TESTE DE TRANSAÇÃO BEM SUCEDIDA");
        // }catch(Exception e){
        //     e.getMessage();
        // }

        // ConvenioRepository c = new ConvenioRepository();
        // ConvenioModel model = new ConvenioModel();
        // model.setAtivo(true);
        // model.setNome("top");
        // model.setNomeEmpresa("RECA");
        // model.setQntHoras(24);
        // model.setValor(new BigDecimal(1500.00));
        // model.setQntVagas(10);
        // // c.create(model);
        // for(ConvenioModel co : c.listarTodos()){
        //     System.out.println(co);
        // }

        // for(ClienteModel co : c.listarClientesPorNome("top")){
        //     System.out.println(co);
        // }


    }
}
