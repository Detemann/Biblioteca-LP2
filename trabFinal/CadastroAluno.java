package trabFinal;

import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class CadastroAluno {
	
	Aluno aluno = new Aluno();
	
	public void cadastroAluno() {
		Scanner ler = new Scanner(System.in).useDelimiter("\n");
		String entrada, linha="";
		Random ran = new Random();
		
		System.out.printf("Informe a matrículaa do aluno:\n");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setMatricula(Integer.parseInt(entrada));
		
		System.out.printf("Informe o nome do aluno:\n");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setNome(entrada);
		
		System.out.printf("Informe o endereço do aluno:\n");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setEndereco(entrada);
		
		System.out.printf("Informe curso do aluno:\n");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setCurso(entrada);
		
		System.out.printf("\nInforme a data de ingresso do aluno: ");
		entrada = ler.nextLine();
		linha += entrada+";";
		aluno.setData(entrada);

		arquivarAluno(linha);
	}
	
	public void arquivarAluno(String linha) {
		try {
			RandomAccessFile arquivo = new RandomAccessFile("csv\\ALUNOS.csv", "rw");
			
			arquivo.seek(arquivo.length());
			arquivo.writeChars(linha);
			arquivo.close();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}
}