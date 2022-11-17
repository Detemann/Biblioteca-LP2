package trabFinal;

import java.io.FileWriter;
import java.util.Scanner;

public class CadastroAluno {
	
	Aluno aluno = new Aluno();
	
	public void cadastroAluno() {
		Scanner ler = new Scanner(System.in).useDelimiter("\n");
		String entrada, linha="";
		
		System.out.printf("Informe a matrículaa do aluno: ");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setMatricula(Integer.parseInt(entrada));
		
		System.out.printf("Informe o nome do aluno: ");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setNome(entrada);
		
		System.out.printf("Informe o endereço do aluno: ");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setEndereco(entrada);
		
		System.out.printf("Informe curso do aluno: ");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setCurso(entrada);
		
		System.out.printf("Informe a data de ingresso do aluno: ");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setData(entrada);

		entrada = "0";
		linha += entrada;
		aluno.setMulta(Double.parseDouble(entrada));

		arquivarAluno(linha);
	}
	
	public void arquivarAluno(String linha) {
		try {
			FileWriter escritor = new FileWriter("csv\\ALUNOS.csv", true);
			escritor.write(System.lineSeparator());
			escritor.write(linha);
			escritor.close();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}
}