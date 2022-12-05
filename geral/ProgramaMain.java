package geral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import cadastros.CadastraFuncionarios;
import cadastros.CadastraLivro;
import cadastros.CadastraPeriodicos;
import cadastros.CadastroAluno;
import cadastros.CadastroProfessor;

public class ProgramaMain {
	public static final Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// LOGIN
		String matricula;
		String senha;
		String linha;
		boolean passou = false;
		try (BufferedReader leitor = new BufferedReader(new FileReader("csv\\FUNCIONARIOS.csv"))) {
			linha = leitor.readLine();
			while (true) {
				System.out.println("Digite o login do funcionario: ");
				matricula = entrada.next();
				System.out.println("Digite a senha: ");
				senha = entrada.next();
				while ((linha = leitor.readLine()) != null) {
					String[] funcionario = linha.split(";");
					if (funcionario[6].equals(matricula) && funcionario[5].equals(senha)) {
						leitor.close();
						menuPrincipal();
						passou = true;
						break;
					}
				}
				if (passou == true) {
					break;
				}
				System.out.println("login ou senha inválido");
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
			System.out.println("Informe o opcao desejada\n" + "[1] Fazer Emprestimo\n" + "[2] Devolução de Livros\n"
					+ "[3] Cadastrar novo Periodico \n" + "[4] Cadastrar novos Livros\n" + "[5] Cadastrar Funcionario\n"
					+ "[6] Cadastra Professor\n" + "[7] Cadastra Aluno \n" + "[8] Relatório Geral \n"
					+ "[9] sair do programa");
			op = entrada.nextInt();

			switch (op) {
			case 1:
				FazerEmprestimo novoEmp = new FazerEmprestimo(); // Coloquei aqui para testes
				novoEmp.emprestimo();
				break;
			case 2:
				FazerDevolucao buscaDevolucao = new FazerDevolucao();
				buscaDevolucao.devolucao();
				break;
			case 3:
				CadastraPeriodicos novoPeriodico = new CadastraPeriodicos();
				novoPeriodico.cadastroPeriodico();
				break;
			case 4:
				CadastraLivro novoLivro = new CadastraLivro();
				novoLivro.cadastroLivro();
				break;
			case 5:
				CadastraFuncionarios novoFunc = new CadastraFuncionarios();
				novoFunc.cadastroFuncionario();
				break;
			case 6:
				CadastroProfessor novoProf = new CadastroProfessor();
				novoProf.cadastroProfessor();
				break;
			case 7:
				CadastroAluno novoAluno = new CadastroAluno();
				novoAluno.cadastroAluno();
				break;
			case 8:
				LerArquivos arquivo = new LerArquivos();
				arquivo.imprimeTudo();
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
