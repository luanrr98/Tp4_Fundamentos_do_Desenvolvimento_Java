package br.edu.infnet.pessoas;

import br.edu.infnet.excecoes.NomeIncompletoException;
import br.edu.infnet.excecoes.NumeroNoNomeException;

public class Professor extends Pessoa {
	private String materia;
	private double salario;
	

	public Professor() {
		
	}
	
	public Professor(String nome, int idade, String materia, double salario) throws NomeIncompletoException, NumeroNoNomeException {
		setNome(nome);
		this.idade = idade;
		this.materia = materia;
		this.salario = salario;
	}
	
	@Override
	public void setNome(String nome) throws NomeIncompletoException, NumeroNoNomeException { 
		//Caso o array nomeSeparado tenha apenas o indice 0 apenas o primeiro nome foi digitado
		//Então é lançada a exceção NomeIncompletoException
		//Caso o nome contenha um número a exceção NumeroNoNomeException é lançada
		if(nome.matches(".*\\d.*") ==false){
			String[] nomeSeparado = nome.split(" ");
			if(nomeSeparado.length == 1) {
				throw new NomeIncompletoException("Nome Incompleto!!");
			}
			this.nome = nomeSeparado[0];
			ultimoNome= new String(nomeSeparado[nomeSeparado.length -1]);
			nomeDoMeio ="";
			for(int i = 1; i < nomeSeparado.length-1; i++) {
				nomeDoMeio += nomeSeparado[i]+ " ";		
			}
			nomeDoMeio = nomeDoMeio.trim();
		}else {
			throw new NumeroNoNomeException("Um número foi digitado no nome!!");
		}
	}
	
	public String getMateria() {
		return materia;
	}
	
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) throws NumberFormatException {
			this.salario = salario;
	
	}
	
	@Override
	public void consultarSituacao() {
		
		StringBuilder nomeCompleto =  new StringBuilder();
		if(nomeDoMeio != "") {
			nomeCompleto.append(nome);
			nomeCompleto.append(" ");
			nomeCompleto.append(nomeDoMeio);
			nomeCompleto.append(" ");
			nomeCompleto.append(ultimoNome);
		}else {
			nomeCompleto.append(nome);
			nomeCompleto.append(" ");
			nomeCompleto.append(ultimoNome);
			
		}

		
		System.out.printf("Nome do professor: %s\n"
				+ "Idade: %d\n"
				+ "Materia: %s\n"
				+ "Salário: %.2f\n",nomeCompleto,idade,materia,salario);
		System.out.println();
	}
}
