package br.edu.infnet.pessoas;

import br.edu.infnet.excecoes.NomeIncompletoException;
import br.edu.infnet.excecoes.NumeroNoNomeException;

public abstract class Pessoa {
	protected String nome;
	protected String nomeDoMeio;
	protected String ultimoNome;
	protected int idade;
	
	public String getNome() {
		return nome;
	}
	
	public String getNomeDoMeio() {
		return nomeDoMeio;
	}

	public void setNoDoMeio(String nomeDoMeio) {
		this.nomeDoMeio = new String (nomeDoMeio);
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public abstract void setNome(String nome) throws NomeIncompletoException, NumeroNoNomeException;
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) throws NumberFormatException {
			this.idade = idade;

	}

	public abstract void consultarSituacao();
	
	
	
	

}
