package geral;

import java.io.BufferedReader;
import java.io.FileReader;

// Essa classe contém metodos de busca e outras coisas
public class Auxiliares {

	public Integer buscaMatricula(String matricula, int tipo) {

		if (matricula.equals("0") != true) {
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\PROFESSORES.csv")); // É um leitor de
																									// arquivo
				String linha;
				if (tipo == 0) {
					System.out.print(
							"A matricula é de um aluno, professor ou funcionário?\n[1]Professor\n[2]Aluno\n[3]Funcionário\nDigite a opção: ");
					tipo = ProgramaMain.entrada.nextInt();
				}
				switch (tipo) {
				case 1:
					while ((linha = leitor.readLine()) != null) {
						String[] usuario = linha.split(";");
						if (usuario[0].equals(matricula)) {
							leitor.close();
							return Integer.parseInt(usuario[0]);
						}
					}
					leitor.close();
					break;
				case 2:
					leitor.close();
					leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv"));
					while ((linha = leitor.readLine()) != null) {
						String[] usuario = linha.split(";");
						if (usuario[0].equals(matricula)) {
							leitor.close();
							return Integer.parseInt(usuario[0]);
						}
					}
					leitor.close();
					break;
				case 3:
					leitor.close();
					leitor = new BufferedReader(new FileReader("csv\\FUNCIONARIOS.csv"));
					while ((linha = leitor.readLine()) != null) {
						String[] usuario = linha.split(";");
						if (usuario[0].equals(matricula)) {
							leitor.close();
							return Integer.parseInt(usuario[0]);
						}
					}
					leitor.close();
					break;
				default:
					System.out.println("Opção invalida!\n");
					buscaMatricula(matricula, tipo);
					break;
				}
			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				return null;
			}
		} else
			return 0;

		return null;
	}

	public Integer buscaArcevo(String codigoLivro, int tipo) {

		if (codigoLivro.equals("0") != true) {
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\LIVROS.csv"));
				String linha;
				if (tipo == 0) {
					System.out.print("O item é um livro ou um periódico?\n[1]Livros\n[2]Periódicos\nDigite a opção: ");
					tipo = ProgramaMain.entrada.nextInt();
				}
				switch (tipo) {
				case 1:
					while ((linha = leitor.readLine()) != null) {
						String[] livro = linha.split(";");
						if (livro[0].equals(codigoLivro)) {
							leitor.close();
							return Integer.parseInt(livro[0]);
						}
					}
					leitor.close();
					break;
				case 2:
					leitor.close();
					leitor = new BufferedReader(new FileReader("csv\\PERIODICOS.csv"));
					while ((linha = leitor.readLine()) != null) {
						String[] periodico = linha.split(";");
						if (periodico[0].equals(codigoLivro)) {
							leitor.close();
							return Integer.parseInt(periodico[0]);
						}
					}
					leitor.close();
					break;
				default:
					System.out.println("Opção invalida!\n");
					buscaArcevo(codigoLivro, tipo);
					break;
				}
			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				e.printStackTrace();
				return null;
			}
		} else
			return 0;

		return null;
	}

	public Boolean buscarMulta(int matricula) {
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv"));
			String linha;
			while ((linha=leitor.readLine())!=null) {
				String[] aluno = linha.split(";");
				if (aluno[0].equals(String.valueOf(matricula))&&aluno[5].equals("20")) {
					leitor.close();
					return true;
				} else if (aluno[0].equals(String.valueOf(matricula))) {
					leitor.close();
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
		System.out.println("Aluno/Multa não encontrado.");
		return false;
	}
}
