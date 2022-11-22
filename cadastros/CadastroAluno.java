package cadastros;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import geral.ProgramaMain;
import pessoasLivros.Aluno;

public class CadastroAluno {
	
	Aluno aluno = new Aluno();
	
	public void cadastroAluno() {
		
		ProgramaMain.entrada.nextLine(); //"limpa" a linha
		System.out.println("Informe a matrícula do aluno: ");
		aluno.setMatricula(Integer.parseInt(ProgramaMain.entrada.nextLine()));
		
		System.out.println("Informe o nome do aluno: ");
		aluno.setNome(ProgramaMain.entrada.nextLine());
		
		System.out.println("Informe o endereço do aluno: ");
		aluno.setEndereco(ProgramaMain.entrada.nextLine());
		
		System.out.println("Informe curso do aluno: ");
		aluno.setCurso(ProgramaMain.entrada.nextLine());
		
		System.out.println("Informe a data de ingresso do aluno: ");
		aluno.setData(ProgramaMain.entrada.nextLine());

		aluno.setMulta(0);

		arquivarAluno();
	}
	
	public void arquivarAluno() {
		try {
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\ALUNOS.csv", true), "UTF-8");
			escritor.write(System.lineSeparator());                                                                       
			escritor.write(aluno.toString());
			escritor.close();
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}
}