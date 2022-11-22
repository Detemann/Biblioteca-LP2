package geral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LerArquivos {
	public void imprimeTudo() {
		String linha;

		try {
			BufferedReader leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv"));
			ArrayList<String[]> Listas = new ArrayList<>();
			while ((linha = leitor.readLine()) != null) {
				String[] Lista = linha.split(";");				
			}
			leitor.close();
			System.out.println(Listas);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}

}
