package geral;

import java.io.BufferedReader;
import java.io.FileReader;

// Essa classe contém metodos de busca e outras coisas
public class Auxiliares {

	@SuppressWarnings("resource")
	public int buscaMatricula(String matricula) {
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv")); //É um leitor de arquivo
			do {
				String linha = leitor.readLine();
				String[] usuario = linha.split(";");
				if (usuario[0].equals(matricula)) {
					leitor.close();
					return Integer.parseInt(usuario[0]);
				}
			} while (leitor.readLine() != null);
			
			leitor = new BufferedReader(new FileReader("csv\\PROFESSORES.csv"));
			do {
				String linha = leitor.readLine();
				String[] usuario = linha.split(";");
				if (usuario[0].equals(matricula)) {
					leitor.close();
					return Integer.parseInt(usuario[0]);
				}
			} while (leitor.readLine()!=null);
			leitor.close();
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			return 0;
		}
		return 0;
	}
}
