package geral;

import java.io.BufferedReader;
import java.io.FileReader;

// Essa classe contém metodos de busca e outras coisas
public class Auxiliares {

	@SuppressWarnings("resource")
	public Integer buscaMatricula(String matricula) {

		if (matricula.equals("0") != true) {
			System.out.print("A matricula é de um aluno, professor ou funcionário?\n[1]Professor\n[2]Aluno\n[3]Funcionário\nDigite a opção: ");
					
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\PROFESSORES.csv")); // É um leitor de
																									// arquivo
				String linha;
				switch (ProgramaMain.entrada.nextInt()) {
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
					buscaMatricula(matricula);
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
}
