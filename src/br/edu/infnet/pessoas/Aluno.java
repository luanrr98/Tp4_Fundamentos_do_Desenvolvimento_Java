package br.edu.infnet.pessoas;

import br.edu.infnet.excecoes.NomeIncompletoException;
import br.edu.infnet.excecoes.NumeroNoNomeException;

public class Aluno extends Pessoa{
	private String turno;	
	private double nota1;
	private double nota2;
	private double nota3;
	private String aprovacao;
	private double media;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, int idade, String turno  ) throws NomeIncompletoException, NumeroNoNomeException {
		setNome(nome);
		this.idade = idade;
		this.turno = turno;
	}
	
	@Override
	public void setNome(String nome) throws NomeIncompletoException, NumeroNoNomeException { 
		//Caso acontece a exceção java.lang.StringIndexOutOfBoundsException apenas o primeiro nome foi digitado
		//Então é lançada a exceção NomeIncompletoException
		//Caso o nome contenha um número a exceção NumeroNoNomeException é lançada

		if(nome.matches(".*\\d.*") ==false){
			try { 
				int primeiroDelimitador =  nome.indexOf(" ");
				int ultimoDelimitador = nome.lastIndexOf(" ");
				this.nome = nome.substring(0, primeiroDelimitador);
				if(primeiroDelimitador != ultimoDelimitador) {
					nomeDoMeio = new String(nome.substring((primeiroDelimitador+1), ultimoDelimitador));
				}
				ultimoNome = nome.substring((ultimoDelimitador+1));
			}catch(java.lang.StringIndexOutOfBoundsException e) {
				throw new NomeIncompletoException("Nome Incompleto!!");
			}
		}else {
			throw new NumeroNoNomeException("Um número foi digitado no nome!!");
		}
		
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public double getNota1() {
		return nota1;
	}
	
	public void setNota1(double nota1) throws NumberFormatException {
			this.nota1 = nota1;
	}
	
	public double getNota2() {
		return nota2;
	}
	
	public void setNota2(double nota2) throws NumberFormatException {
			this.nota2 = nota2;
	
	}
	
	public double getNota3() {
		return nota3;
	}
	
	public void setNota3(double nota3) throws NumberFormatException {
			this.nota3 = nota3;
	}

	public String getAprovacao() {
		return aprovacao;
	}

	public double getMedia() {
		return media;
	}

	public void calcularMedia(Double nota1, Double nota2, Double nota3) {
		this.media = (nota1+nota2+nota3)/3;
	}
	
	public void calcularMedia(Double nota1, Double nota2) {
		this.media = (nota1+nota2)/2;
	}
	
	public void definirAprovacao(Double media) {
		if(media >= 7) {
			aprovacao = "Aprovado";
		}
		else if(media<= 4) {
			aprovacao = "Reprovado";
		}else {
			aprovacao =  "Recuperação";
		}
	}

	@Override
	public void consultarSituacao() {
		StringBuilder nomeCompleto =  new StringBuilder();
		if(nomeDoMeio != null) {
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

		calcularMedia(getNota1(),getNota2(),getNota3());
		definirAprovacao(this.media);
		System.out.printf("Nome do Aluno: %s\n"
				+ "Idade: %d\n"
				+"Turno: %s\n"
				+"Media: %.2f\n"
				+"Aprovação: %s\n",nomeCompleto,idade,turno,media,aprovacao);
		System.out.println();
	}
}
