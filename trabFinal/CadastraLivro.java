package trabFinal;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class CadastraLivro {
	Livros livro = new Livros();
	
	public void cadastroLivro() {

		System.out.printf("Informe o código do livro: ");
		livro.setCodigo(Integer.parseInt(ProgramaMain.entrada.nextLine()));

		System.out.printf("Informe o autor(es) do livro: ");
		livro.setAutores(ProgramaMain.entrada.nextLine());

		System.out.printf("Informe o título do livro: ");
		livro.setTitulo(ProgramaMain.entrada.nextLine());

		System.out.printf("Informe a editora do livro: ");
		livro.setEditora(ProgramaMain.entrada.nextLine());

		System.out.printf("Informe o ano de publicação: ");
		livro.setAnoDePubli(Integer.parseInt(ProgramaMain.entrada.nextLine()));
		
		Random issn = new Random();
		livro.setIssn(issn.nextInt(10000000, 99999999));

		livro.setTipo('l');

		arquivarlivro();
	}

	public void arquivarlivro() {
		try {
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\LIVROS.csv", true),
					"UTF-8"); // Faz o mesmo que o FileWriter
			escritor.write(System.lineSeparator()); // Só que consigo configurar os chars para UTF-8
			escritor.write(livro.toString());
			escritor.close();
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}
}
