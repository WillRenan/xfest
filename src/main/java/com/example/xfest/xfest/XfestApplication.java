package com.example.xfest.xfest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.example.xfest.xfest.entidades.PessoaFisica;
import com.example.xfest.xfest.entidades.PessoaJuridica;
import com.example.xfest.xfest.entidades.PessoaSexo;


//@EntityScan("com.exemple.xfest.xfest.entidades")
@EntityScan
@SpringBootApplication
public class XfestApplication implements CommandLineRunner {

	@PersistenceUnit
	private EntityManagerFactory factory;
	public static void main(String[] args) {
		SpringApplication.run(XfestApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception{
		
		PessoaFisica p = new PessoaFisica();
		PessoaJuridica p2 = new PessoaJuridica();

		p.setNome("jão");
		p.setSobrenome("Rodrigues");
		p.setSexo(PessoaSexo.MASCULINO);
		p.setCpf("12869648065");
		


		EntityManager manager = factory.createEntityManager();

		EntityTransaction t =  manager.getTransaction();

		t.begin();
		manager.persist(p); //persiste
		manager.persist(p2);
		//manager.persist(endereco);
		manager.flush();
		t.commit(); 



	}


	/* @Override
	public String toString() {
		return "XfestApplication []";
	} */


}
