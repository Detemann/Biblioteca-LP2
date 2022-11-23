package cadastros;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

import geral.ProgramaMain;
import pessoasLivros.Periodicos;

public class CadastraPeriodicos {
	Periodicos periodico = new Periodicos();
	
	public void cadastroPeriodico() {

		ProgramaMain.entrada.nextLine(); //"limpa" a linha
		System.out.println("Informe o código do periodico: ");
		periodico.setCodigo(Integer.parseInt(ProgramaMain.entrada.nextLine()));

		System.out.println("Informe o autor(es) do periodico: ");
		periodico.setAutores(ProgramaMain.entrada.nextLine());

		System.out.println("Informe o t�tulo do periodico: ");
		periodico.setTitulo(ProgramaMain.entrada.nextLine());

		System.out.println("Informe o fator de impacto do periodico: ");
		periodico.setFatorDeImpacto(Double.parseDouble(ProgramaMain.entrada.nextLine()));
		
		Random issn = new Random();
		periodico.setIssn(issn.nextInt(10000000, 99999999));

		periodico.setTipo('p');
	
		periodico.setDisponivel(true);
		
		arquivarperiodico();
	}

	public void arquivarperiodico() {
		try {
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\PERIODICOS.csv", true),
					"UTF-8"); // Faz o mesmo que o FileWriter
			escritor.write(System.lineSeparator()); // Só que consigo configurar os chars para UTF-8
			escritor.write(periodico.toString());
			escritor.close();
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}
}
