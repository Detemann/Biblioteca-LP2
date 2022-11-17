package trabFinal;

import java.io.FileWriter;
import java.util.Scanner;

public class CadastroAluno {
	
	Aluno aluno = new Aluno();
	
	public void cadastroAluno() {
		Scanner ler = new Scanner(System.in).useDelimiter("\n");
		
		System.out.printf("Informe a matrículaa do aluno: ");
		aluno.setMatricula(Integer.parseInt(ler.nextLine()));
		
		System.out.printf("Informe o nome do aluno: ");
		aluno.setNome(ler.nextLine());
		
		System.out.printf("Informe o endereço do aluno: ");
		aluno.setEndereco(ler.nextLine());
		
		System.out.printf("Informe curso do aluno: ");
		aluno.setCurso(ler.nextLine());
		
		System.out.printf("Informe a data de ingresso do aluno: ");
		aluno.setData(ler.nextLine());

		aluno.setMulta(0);

		arquivarAluno();
	}
	
	public void arquivarAluno() {
		try {
			FileWriter escritor = new FileWriter("csv\\ALUNOS.csv", true);
			escritor.write(System.lineSeparator());
			escritor.write(aluno.toString());
			escritor.close();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}
}