package trabFinal;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CadastroProfessor {
	Professores professor = new Professores();
	
	public void cadastroProfessor() {
		Scanner ler = new Scanner(System.in).useDelimiter("\n");
		
		System.out.printf("Informe a matrícula do professor: ");
		professor.setMatricula(Integer.parseInt(ler.nextLine()));
		
		System.out.printf("Informe o nome do professor: ");
		professor.setNome(ler.nextLine());
		
		System.out.printf("Informe o endereço do professor: ");
		professor.setEndereco(ler.nextLine());
		
		System.out.printf("Informeo setor do professor: ");
		professor.setSetor(ler.nextLine());
		
		System.out.printf("Informe a data de ingresso do professor: ");
		professor.setData(ler.nextLine());

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
		}
	}
}
