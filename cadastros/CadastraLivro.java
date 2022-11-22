package cadastros;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

import geral.ProgramaMain;
import pessoasLivros.Livros;

public class CadastraLivro {
	Livros livro = new Livros();
	
	public void cadastroLivro() {
		
		ProgramaMain.entrada.nextLine(); //"limpa" a linha
		System.out.println("Informe o c�digo do livro: ");
		livro.setCodigo(Integer.parseInt(ProgramaMain.entrada.nextLine()));

		System.out.println("Informe o autor(es) do livro: ");
		livro.setAutores(ProgramaMain.entrada.nextLine());

		System.out.println("Informe o t�tulo do livro: ");
		livro.setTitulo(ProgramaMain.entrada.nextLine());

		System.out.println("Informe a editora do livro: ");
		livro.setEditora(ProgramaMain.entrada.nextLine());

		System.out.println("Informe o ano de publica��o: ");
		livro.setAnoDePubli(Integer.parseInt(ProgramaMain.entrada.nextLine()));
		
		Random issn = new Random();
		livro.setIssn(issn.nextInt(10000000, 99999999));

		livro.setTipo('l');

		arquivarlivro();
	}

	public void arquivarlivro() {
		try {
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\LIVROS.csv", true),"UTF-8"); 
			escritor.write(System.lineSeparator()); 
			escritor.write(livro.toString());
			escritor.close();
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}
}
