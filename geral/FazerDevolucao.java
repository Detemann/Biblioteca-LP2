package geral;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class FazerDevolucao {
	Auxiliares auxi = new Auxiliares();
	
	public void devolucao() {
		System.out.println("------ Devoluções ------\n");
		System.out.println("Digite a matricula do aluno, professor ou funcionário: ");
		int matricula = auxi.buscaMatricula(ProgramaMain.entrada.next(), 0);
		
		String[] statusEmprestimo = auxi.buscaEmprestimo(matricula, 1);
		if (statusEmprestimo[1].equals("0")) {
			Integer[] codigoItem = auxi.buscaItem(Integer.parseInt(statusEmprestimo[0]));
			String[] item = auxi.buscaArcevo(String.valueOf(codigoItem[0]), codigoItem[1]);
			auxi.setDisponibilidade(item, codigoItem[1]);
			
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\EMPRESTIMO.csv"));
				leitor.readLine();
				BufferedReader leitor2 = new BufferedReader(new FileReader("csv\\ITENS.csv"));
				String linhaEmprestimo;
				String linhaItem;
				while((linhaEmprestimo = leitor.readLine()) != null) {
					boolean passou = false;
					String[] emprestimoInfo = linhaEmprestimo.split(";");
					while ((linhaItem = leitor2.readLine()) != null) {
						if (linhaItem.contains(emprestimoInfo[0])) {
							leitor.close();
							leitor2.close();

							passou = true;
							break;
						}
					}
					if(passou==true) {
						break;
					}
				}
				
				String linhasEmprestimo;
				String novasLinhasEmprestimo = "";
				leitor = new BufferedReader(new FileReader("csv\\EMPRESTIMO.csv"));
				while ((linhasEmprestimo = leitor.readLine()) != null) {
					novasLinhasEmprestimo += linhasEmprestimo+ "\n";
				}
				novasLinhasEmprestimo = novasLinhasEmprestimo.replace(linhaEmprestimo, "");
				novasLinhasEmprestimo = novasLinhasEmprestimo.replaceAll("(?m)^[ \\t]*\\r?\\n", "");
				
				OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\EMPRESTIMO.csv", false), "UTF-8");
				escritor.write(novasLinhasEmprestimo);
				escritor.close();
			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				e.printStackTrace();
				ProgramaMain.menuPrincipal();
			}
			
			System.out.println("FIM\n\n");
		} else {
			auxi.buscarMulta(matricula);
		}
		
		
	}
}
