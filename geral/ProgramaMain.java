package geral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import cadastros.CadastraFuncionarios;
import cadastros.CadastraLivro;
import cadastros.CadastroAluno;
import cadastros.CadastroProfessor;

public class ProgramaMain {
	public static final Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// LOGIN
		String matricula;
		String senha;
		String linha;
		try (BufferedReader leitor = new BufferedReader(new FileReader("csv\\FUNCIONARIOS.csv"))) {
			linha = leitor.readLine();
			while (true) {
				System.out.println("Digite a matricula do funcionario: ");
				matricula = entrada.next();
				System.out.println("Digite a senha: ");
				senha = entrada.next();
				while ((linha = leitor.readLine()) != null) {
					String[] funcionario = linha.split(";");
					if (funcionario[0].equals(matricula) && funcionario[5].equals(senha)) {
						leitor.close();
						menuPrincipal();
					}
				}
				System.out.println("Matrícula ou senha inválido");
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}

	// MENU DE FUNCIONARIO
	public static void menuPrincipal() {
		System.out.println("\n=============== BIBLIOTECA DO(A) XXXXXXXXXX ===============");
		int op = 0;
		while (op != 9) {
			System.out.println("Informe o opcao desejada\n" 
					+ "[1] Consultar livros emprestados\n"
					+ "[2] Devolu��o de Livros\n"
					+ "[3] Cadastrar novos Livros\n" 
					+ "[4] Cadastrar Funcionario\n"					
					+ "[5] Cadastra Professor\n" 										
					+ "[6] Cadastra Aluno \n"							
					+ "[7] Relat�rio Geral");//cadastrados; Alunos cadastrados; Imprimir multa individual;Livros cadastrados; Empréstimos realizados; Funcionários
			op = entrada.nextInt();

			switch (op) {
			case 1:
				FazerEmprestimo novoEmp = new FazerEmprestimo(); // Coloquei aqui para testes
				novoEmp.emprestimo();
				break;
			case 2:

				break;
			case 3:
				CadastraLivro novoLivro = new CadastraLivro();
				novoLivro.cadastroLivro();
				break;
			case 4:
				CadastraFuncionarios novoFunc = new CadastraFuncionarios();
				novoFunc.cadastroFuncionario();
				break;
			case 5:
				CadastroProfessor novoProf = new CadastroProfessor();
				novoProf.cadastroProfessor();
				break;
			case 6:
				CadastroAluno novoAluno = new CadastroAluno();
				novoAluno.cadastroAluno();
				break;
			case 7:
				
				break;
			case 9:
				System.out.println("Fim de programa!");
				break;
			default:
				System.out.println("A opcao informada é inválida!");
				break;
			}

		}

	}

}
