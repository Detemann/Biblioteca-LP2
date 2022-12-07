package geral;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class FazerDevolucao {
	Auxiliares auxi = new Auxiliares();
	
	public void devolucao() {
		int matricula = -1;
		do {
			System.out.println("------ Devoluções ------\n");
			System.out.println("Digite a matrícula do aluno, professor ou funcionário: ");
			matricula = auxi.buscaMatricula(ProgramaMain.entrada.next(), 0);
			if (matricula == -1) {
				System.out.println("Matrícula não encontrada.\nTente novamente.");
			}
		} while (matricula == -1);
		
		String[] statusEmprestimo = auxi.buscaEmprestimo(matricula, 1);
		if (statusEmprestimo[1].equals("1")) {
			
			String [] infoAluno = new String[6];
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv"));
				String aluno;
				while((aluno = leitor.readLine()) != null) {
					if (aluno.contains(String.valueOf(matricula))) {
						infoAluno = aluno.split(";");
						leitor.close();
						break;
					}
				}
				
				leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv"));
				String linhaAluno;
				String novasLinhasAluno = "";
				while ((linhaAluno = leitor.readLine()) != null) {
					novasLinhasAluno += linhaAluno + "\n";
				}
				String alunoStr = "";
				for (String string : infoAluno) {
					alunoStr += ";" + string;
				}
				alunoStr = alunoStr.replaceFirst(";", "");
				if (alunoStr.contains("0.0")) {
					novasLinhasAluno = novasLinhasAluno.replace(alunoStr, alunoStr = alunoStr.replace("0.0", "20.0"));
				}
				leitor.close();
				
				OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\ALUNOS.csv", false), "UTF-8");
				escritor.write(novasLinhasAluno);
				escritor.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			auxi.buscarMulta(matricula);
			System.out.println("Aluno pagou a multa? [S/N]");
			String resultado = ProgramaMain.entrada.next();
			if (Objects.equals(resultado, "N")) {
				System.out.println("Aluno tem que pagar a multa para devolver o livro.");
				ProgramaMain.menuPrincipal();
			}
		}
			Integer[] codigoItem = auxi.buscaItem(Integer.parseInt(statusEmprestimo[0]));
			String[] item = auxi.buscaArcevo(String.valueOf(codigoItem[0]), codigoItem[1]);
			auxi.setDisponibilidade(item, codigoItem[1]);
			
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\EMPRESTIMO.csv"));
				leitor.readLine();
				BufferedReader leitor2 = new BufferedReader(new FileReader("csv\\ITENS.csv"));
				String linhaEmprestimo;
				String linhaItem = null;
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
				
				String [] infoAluno = new String[6];
				try {
					leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv"));
					String aluno;
					while((aluno = leitor.readLine()) != null) {
						if (aluno.contains(String.valueOf(matricula))) {
							infoAluno = aluno.split(";");
							leitor.close();
							break;
						}
					}
					
					leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv"));
					String linhaAluno;
					String novasLinhasAluno = "";
					while ((linhaAluno = leitor.readLine()) != null) {
						novasLinhasAluno += linhaAluno + "\n";
					}
					String alunoStr = "";
					for (String string : infoAluno) {
						alunoStr += ";" + string;
					}
					alunoStr = alunoStr.replaceFirst(";", "");
					if (alunoStr.contains("20.0")) {
						novasLinhasAluno = novasLinhasAluno.replace(alunoStr, alunoStr = alunoStr.replace("20.0", "0.0"));
					}
					leitor.close();
					
					OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\ALUNOS.csv", false), "UTF-8");
					escritor.write(novasLinhasAluno);
					escritor.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				String linhasEmprestimo;
				String novasLinhasEmprestimo = "";
				leitor = new BufferedReader(new FileReader("csv\\EMPRESTIMO.csv"));
				while ((linhasEmprestimo = leitor.readLine()) != null) {
					novasLinhasEmprestimo += linhasEmprestimo+ "\n";
				}
				leitor.close();
				novasLinhasEmprestimo = novasLinhasEmprestimo.replace(linhaEmprestimo, "");
				novasLinhasEmprestimo = novasLinhasEmprestimo.replaceAll("(?m)^[ \\t]*\\r?\\n", "");
				
				OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\EMPRESTIMO.csv", false), "UTF-8");
				escritor.write(novasLinhasEmprestimo);
				escritor.close();
				
				String linhasItens;
				String novasLinhasItens="";
				leitor = new BufferedReader(new FileReader("csv\\ITENS.csv"));
				while ((linhasItens = leitor.readLine()) != null) {
					novasLinhasItens += linhasItens+ "\n";
				}
				novasLinhasItens = novasLinhasItens.replace(linhaItem, "");
				novasLinhasItens = novasLinhasItens.replaceAll("(?m)^[ \\t]*\\r?\\n", "");
				
				
				escritor = new OutputStreamWriter(new FileOutputStream("csv\\ITENS.csv", false), "UTF-8");
				escritor.write(novasLinhasItens);
				escritor.close();
			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				e.printStackTrace();
				ProgramaMain.menuPrincipal();
			}
			
			System.out.println("FIM\n\n");
	}
}
