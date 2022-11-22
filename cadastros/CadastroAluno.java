package cadastros;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import geral.ProgramaMain;
import pessoasLivros.Aluno;

public class CadastroAluno {
	
	Aluno aluno = new Aluno();
	
	public void cadastroAluno() {
		
		System.out.printf("Informe a matrícula do aluno: ");
		aluno.setMatricula(Integer.parseInt(ProgramaMain.entrada.next()));
		
		System.out.printf("Informe o nome do aluno: ");
		aluno.setNome(ProgramaMain.entrada.next());
		
		System.out.printf("Informe o endereÃ§o do aluno: ");
		aluno.setEndereco(ProgramaMain.entrada.next());
		
		System.out.printf("Informe curso do aluno: ");
		aluno.setCurso(ProgramaMain.entrada.next());
		
		System.out.printf("Informe a data de ingresso do aluno: ");
		aluno.setData(ProgramaMain.entrada.next());

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