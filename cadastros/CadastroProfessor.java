package cadastros;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import geral.ProgramaMain;
import pessoasLivros.Professores;

public class CadastroProfessor {
	Professores professor = new Professores();
	
	public void cadastroProfessor() {
		
		System.out.printf("Informe a matrícula do professor: ");
		professor.setMatricula(Integer.parseInt(ProgramaMain.entrada.nextLine()));
		
		System.out.printf("Informe o nome do professor: ");
		professor.setNome(ProgramaMain.entrada.nextLine());
		
		System.out.printf("Informe o endereço do professor: ");
		professor.setEndereco(ProgramaMain.entrada.nextLine());
		
		System.out.printf("Informe o setor do professor: ");
		professor.setSetor(ProgramaMain.entrada.nextLine());
		
		System.out.printf("Informe a data de ingresso do professor: ");
		professor.setData(ProgramaMain.entrada.nextLine());

		arquivarProfessor();
	}
	
	public void arquivarProfessor() {
		try {
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\PROFESSORES.csv", true), "UTF-8");
			escritor.write(System.lineSeparator());
			escritor.write(professor.toString());
			System.out.println("Cadastro realizado com sucesso!");
			escritor.close();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}
}
