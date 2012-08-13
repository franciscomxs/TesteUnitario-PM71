package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3");
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(400, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(200, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance(){
		Usuario joao = new Usuario("João");
		Leilao leilao = new Leilao("Coleção de pokemons");
		leilao.propoe(new Lance(joao, 200.0));
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(200, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(200, leiloeiro.getMenorLance(), 0.00001);
		
	}
	
	@Test
	public void deveEntenderLancesDeFormaRandomica(){
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Usuario joaquin = new Usuario("Joaquin");
		Usuario gabriel = new Usuario("Gabriel");
		
		Leilao leilao = new Leilao("Playstation 3");
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400));
		leilao.propoe(new Lance(joaquin, 220));
		leilao.propoe(new Lance(gabriel, 120));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(120, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(400, leiloeiro.getMaiorLance(), 0.00001);
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Usuario joaquim = new Usuario("Joaquim");
		
		Leilao leilao = new Leilao("Playstation 3");
		leilao.propoe(new Lance(maria, 400.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(joaquim, 100.0));
		
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(400, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(100, leiloeiro.getMenorLance(), 0.00001);
	}
	
	public void deveDefinirOsTresMaioresLancesComListaCheia(){
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Usuario joaquim = new Usuario("Joaquim");
		Usuario pedro = new Usuario("Pedro");
		
		Leilao leilao = new Leilao("Playstation 3");
		leilao.propoe(new Lance(maria, 400.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(joaquim, 100.0));
		leilao.propoe(new Lance(pedro, 1100.0));
		
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(1100, maiores.get(0).getValor(), 0.00001);
		assertEquals(400, maiores.get(1).getValor(), 0.00001);
		assertEquals(300, maiores.get(2).getValor(), 0.00001);
	}
	
	
	public void deveDefinirOsMaioresLancesComListaIncompleta(){
		Usuario maria = new Usuario("Maria");
		Usuario pedro = new Usuario("Pedro");
		
		Leilao leilao = new Leilao("Playstation 3");
		leilao.propoe(new Lance(maria, 400.0));
		leilao.propoe(new Lance(pedro, 1100.0));
		
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(1100, maiores.get(0).getValor(), 0.00001);
		assertEquals(400, maiores.get(1).getValor(), 0.00001);
	}
	
	public void deveDefinirOsMaioresLancesComListaVazia(){
		
		Leilao leilao = new Leilao("Playstation 3");
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(0, maiores.size());
	}
}
