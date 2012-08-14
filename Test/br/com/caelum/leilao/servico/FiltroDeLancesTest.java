package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
 
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;
 
public class FiltroDeLancesTest {

	@Test
	public void deveExcluirLancesEntre3000E5000() {
	    Usuario joao = new Usuario("João");
	 
	    FiltroDeLances filtro = new FiltroDeLances();
	    List<Lance> resultado = filtro.filtra(Arrays.asList(
	            new Lance(joao,4000), 
	            new Lance(joao, 3500)));
	     
	    assertEquals(0, resultado.size());
	}
	 
	@Test
	public void deveExcluirLancesMenoresQue500() {
	    Usuario joao = new Usuario("João");
	 
	    FiltroDeLances filtro = new FiltroDeLances();
	    List<Lance> resultado = filtro.filtra(Arrays.asList(
	            new Lance(joao,400), 
	            new Lance(joao, 300)));
	     
	    assertEquals(0, resultado.size());
	}
	 
	@Test
	public void deveAceitarLancesMaioresQue5000() {
	    Usuario joao = new Usuario("João");
	 
	    FiltroDeLances filtro = new FiltroDeLances();
	    List<Lance> resultado = filtro.filtra(Arrays.asList(
	            new Lance(joao,10000), 
	            new Lance(joao, 800)));
	     
	    assertEquals(1, resultado.size());
	    assertEquals(10000, resultado.get(0).getValor(), 0.00001);
	}

}