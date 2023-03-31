import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(new IdConta("577335547", "45938573125"), "Lucas", 20, "luquinhaslegal@gmail.com", "nro123", 2000.00 );
		System.out.println(c1);
		
		IdConta ic = new IdConta();
		ic.setCpf("69412257801");
		ic.setRg("152366548");
		
		Conta c2 = new Conta();
		c2.setEmail("mamaeluquinhas@gmail.com");
		c2.setId(ic);
		c2.setIdade(36);
		c2.setNome("Suelem");
		c2.setNroConta("nro456");
		c2.setSaldo(10000.00);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd
		em.persist(c1);
		em.persist(c2);
		
		em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();
	}

}
