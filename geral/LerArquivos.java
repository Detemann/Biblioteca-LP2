package geral;

import java.io.BufferedReader;
import java.io.FileReader;

public class LerArquivos {
	public void imprimeTudo() {
		try {
			String[] caminhos = new String[7];
			caminhos[0] = "csv\\FUNCIONARIOS.csv";
			caminhos[1] = "csv\\PROFESSORES.csv";
			caminhos[2] = "csv\\ALUNOS.csv";
			caminhos[3] = "csv\\LIVROS.csv";
			caminhos[4] = "csv\\PERIODICOS.csv";
			caminhos[5] = "csv\\EMPRESTIMO.csv";
			caminhos[6] = "csv\\ITENS.csv";
			for (String string : caminhos) {
				BufferedReader file = new BufferedReader(new FileReader(string));
				String line;
				String input = "";
				while ((line = file.readLine()) != null) {
					input += line + '\n';
				}
				file.close();
				System.out.println(input + "\n"
						+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}
}
