package br.edu.infnet.excecoes;

public class NomeIncompletoException extends Exception {
	public NomeIncompletoException(String mensagem) { // Exce��o para caso n�o seja digitado o nome completo
		super(mensagem);
	}

}
