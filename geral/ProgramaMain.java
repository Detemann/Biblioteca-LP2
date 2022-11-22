package geral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import cadastros.CadastraFuncionarios;
import cadastros.CadastraLivro;

public class ProgramaMain {
	public static final Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// LOGIN
		String matricula;
		String senha;
		String linha;
		try (BufferedReader leitor = new BufferedReader(new FileReader("csv\\FUNCIONARIOS.csv"))) {
			linha = leitor.readLine();
			while ((linha = leitor.readLine()) != null) {
				while (true) {
					String[] funcionario = linha.split(";");
					System.out.println("Digite a matricula do funcionario: ");
					matricula = entrada.next();
					System.out.println("Digite a senha: ");
					senha = entrada.next();
					if (funcionario[0].equals(matricula) && funcionario[5].equals(senha)) {
						leitor.close();
						menuPrincipal();
					} else {
						System.out.println("Matricula ou senha invalida!!");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}

	// MENU DE USUARIO
	public static void menuPrincipal() {
		System.out.println("\n=============== BIBLIOTECA DO(A) XXXXXXXXXX ===============");
		int op = 0;
		while (op != 9) {
			// PRECISA SER REALIZADO UMA AUTENTICACAO DE USUARIO ANTES DE EXIBIR A TELA DE
			// MENU
			System.out.println("Informe o opcao desejada\n" + "[1] Consultar livros emprestados\n"
					+ "[2] Devolução de Livros\n" + "[3] Cadastrar novos Livros\n" + "[4] Cadastrar novos Usuários\n"
					// Aluno
					// ou
					// Funcionário
					+ "[5] Relatório Geral\n" // Livros cadastrados; Empréstimos realizados; Funcionários
												// cadastrados; Alunos cadastrados; Imprimir multa individual;
					+ "[6] Funcao6");

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

				break;
			case 6:

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
