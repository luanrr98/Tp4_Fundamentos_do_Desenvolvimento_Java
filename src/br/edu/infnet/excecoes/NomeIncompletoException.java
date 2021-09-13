package br.edu.infnet.excecoes;

public class NomeIncompletoException extends Exception {
	public NomeIncompletoException(String mensagem) { // Exceção para caso não seja digitado o nome completo
		super(mensagem);
	}

}
