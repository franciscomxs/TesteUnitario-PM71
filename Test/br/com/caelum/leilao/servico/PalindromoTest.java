package br.com.caelum.leilao.servico;

import static org.junit.Assert.*;
import org.junit.Test;

public class PalindromoTest {
	
	@Test
	public void verificaSeEPalindromo(){
		assertTrue(Palindromo.ehPalindromo("aea"));
	}
}
