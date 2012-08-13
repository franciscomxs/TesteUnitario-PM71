package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatematicaMalucaTest {
	@Test
	public void deveAceitarValoresMaioresQueTrinta(){
		MatematicaMaluca m = new MatematicaMaluca();
		assertEquals(124, m.contaMaluca(31));
	}
	
	@Test
	public void deveAceitarValoresEntreTrintaEDez(){
		MatematicaMaluca m = new MatematicaMaluca();
		assertEquals(33, m.contaMaluca(11));
	}
	
	@Test
	public void deveAceitarValoresMenoresQueDez(){
		MatematicaMaluca m = new MatematicaMaluca();
		assertEquals(2, m.contaMaluca(1));
	}
	
	@Test
	public void deveAceitarValoresESeForTrinta(){
		MatematicaMaluca m = new MatematicaMaluca();
		assertEquals(90, m.contaMaluca(30));
	}
}
