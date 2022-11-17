package trabFinal;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CadastroAluno {
	
	Aluno aluno = new Aluno();
	
	public void cadastroAluno() {
		
		System.out.printf("Informe a matrículaa do aluno: ");
		aluno.setMatricula(Integer.parseInt(ProgramaMain.entrada.nextLine()));
		
		System.out.printf("Informe o nome do aluno: ");
		aluno.setNome(ProgramaMain.entrada.nextLine());
		
		System.out.printf("Informe o endereço do aluno: ");
		aluno.setEndereco(ProgramaMain.entrada.nextLine());
		
		System.out.printf("Informe curso do aluno: ");
		aluno.setCurso(ProgramaMain.entrada.nextLine());
		
		System.out.printf("Informe a data de ingresso do aluno: ");
		aluno.setData(ProgramaMain.entrada.nextLine());

		aluno.setMulta(0);

		arquivarAluno();
	}
	
	public void arquivarAluno() {
		try {
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\ALUNOS.csv", true), "UTF-8"); //Faz o mesmo que o FileWriter
			escritor.write(System.lineSeparator());                                                                       //Só que consigo configurar os chars para UTF-8
			escritor.write(aluno.toString());
			escritor.close();
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}
}