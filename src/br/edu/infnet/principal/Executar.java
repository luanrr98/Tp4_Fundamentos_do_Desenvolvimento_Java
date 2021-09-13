package br.edu.infnet.principal;

import java.util.Scanner;

import br.edu.infnet.auxiliar.Constantes;
import br.edu.infnet.excecoes.NomeIncompletoException;
import br.edu.infnet.excecoes.NumeroNoNomeException;
import br.edu.infnet.pessoas.Aluno;
import br.edu.infnet.pessoas.Pessoa;
import br.edu.infnet.pessoas.Professor;

public class Executar {
	
	static Scanner lerString = new Scanner(System.in);
	

	public static void telaInicial() {
		System.out.println("============================");
		System.out.println("Controle Acadêmico");
		System.out.println("============================");
		System.out.println();
		System.out.println("[1] Cadastrar Professor");
		System.out.println("[2] Cadastrar Aluno");
		System.out.println("[3] Consultar situação de um docente/discente.");
		System.out.println("[4] Sair");
		System.out.print("Digite a operação: ");
	}
	
	public static Professor cadastrarProfessor() throws NomeIncompletoException, NumberFormatException, NumeroNoNomeException {
		Professor prof = new Professor();
		System.out.println("Cadastro de Professor");
		System.out.print("Digite o nome: "); 
		prof.setNome(lerString.nextLine().trim()); // Pode causar a exceção NomeIncompletoException
		System.out.print("Digite a matéria: ");
		prof.setMateria(lerString.nextLine().trim());
		System.out.print("Digite a idade: ");
		prof.setIdade(Integer.valueOf(lerString.nextLine()));
		System.out.print("Digite o salário: ");
		prof.setSalario(Double.valueOf(lerString.nextLine()));
		System.out.println("Um número deve ser informado");

		return prof;
	}
	
	public static Aluno cadastrarAluno() throws NomeIncompletoException, NumberFormatException, NumeroNoNomeException  {
		Aluno aluno = new Aluno();
	
		System.out.println("Cadastro de Aluno");
		System.out.print("Digite o nome: ");
		aluno.setNome(lerString.nextLine().trim()); // Pode causar a exceção NomeIncompletoException
		System.out.print("Digite o turno: ");
		aluno.setTurno(lerString.nextLine().trim());
		System.out.print("Digite a idade: ");
		aluno.setIdade(Integer.valueOf(lerString.nextLine()));
		System.out.print("Digite a primeira nota: ");
		aluno.setNota1(Double.valueOf(lerString.nextLine()));
		System.out.print("Digite a segunda nota: ");
		aluno.setNota2(Double.valueOf(lerString.nextLine()));
		System.out.print("Digite a terceira nota: ");
		aluno.setNota3(Double.valueOf(lerString.nextLine()));

		return aluno;
	}
	


	public static void main(String[] args)  {
		Pessoa[] pessoas = new Pessoa[Constantes.posicoesVetor];
		String opcao = new String("null");
		int indice = 0;

		do {
			telaInicial();
			opcao = lerString.nextLine();
			System.out.println();
			
			switch (opcao) {
			
			case "1":
				if(indice<Constantes.posicoesVetor) { 
					try {
						pessoas[indice] = cadastrarProfessor();
						System.out.printf("Código do Professor cadastrado: [%d]\n",indice);
						indice++;
					} catch (NomeIncompletoException e) {
						System.out.println(e.getMessage());
					} catch (NumberFormatException e) {
						System.out.println("Precisa Ser um número!!");
					} catch (NumeroNoNomeException e) {
						System.out.println(e.getMessage());
					}
						
				}else {
					System.err.println("Limite de discentes/docentes cadastrados atingido!!");
				}
				
				System.out.println();
				break;
			
			case "2":
				if(indice<Constantes.posicoesVetor) { 
					try {
						pessoas[indice] = cadastrarAluno();
						System.out.printf("Código do Aluno cadastrado: [%d]\n",indice);
						indice++;
					} catch (NomeIncompletoException e) {
						System.out.println(e.getMessage());
					} catch (NumeroNoNomeException e) {
						System.out.println(e.getMessage());
					} 

				}else {
					System.err.println("Limite de discentes/docentes cadastrados atingido!!");
				}
				System.out.println();
				break;
				
			case "3":
				System.out.println("Consulta de Discentes/Docentes ");

				try {
					System.out.print("Digite o codigo: ");
					int codigo = Integer.valueOf(lerString.nextLine());
					pessoas[codigo].consultarSituacao();
				} catch(java.lang.ArrayIndexOutOfBoundsException | java.lang.NumberFormatException | java.lang.NullPointerException  e) {
					System.err.println("Codigo Inválido!!");
	 				System.out.println();

			
				}finally {
	 				System.out.println("Voltando ao menu principal...");
	 				System.out.println();

				}
				break;
				
			case "4":
				System.out.println();
				System.out.println("Saindo do Programa...");
				System.out.println();
				break;
				
			default:
				System.out.println();
				System.err.println("Opção Inválida!!");
				System.out.println();
				break;
			}
		}while(!"4".equals(opcao));
		
	}
}
