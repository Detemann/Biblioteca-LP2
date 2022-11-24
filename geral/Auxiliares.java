package geral;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

// Essa classe contém metodos de busca e outras coisas
public class Auxiliares {

	public Integer buscaMatricula(String matricula, int tipo) {
		
		// 1 para Professores; 2 para Alunos; 3 para Funcionários
		if (matricula.equals("0") != true) {
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\PROFESSORES.csv")); // É um leitor de
																									// arquivo
				String linha;
				if (tipo == 0) {
					System.out.print(
							"A matricula é de um aluno, professor ou funcionário?\n[1]Professor\n[2]Aluno\n[3]Funcionário\nDigite a opção: ");
					tipo = ProgramaMain.entrada.nextInt();
				}
				switch (tipo) {
				case 1:
					while ((linha = leitor.readLine()) != null) {
						String[] usuario = linha.split(";");
						if (usuario[0].equals(matricula)) {
							leitor.close();
							return Integer.parseInt(usuario[0]);
						}
					}
					leitor.close();
					break;
				case 2:
					leitor.close();
					leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv"));
					while ((linha = leitor.readLine()) != null) {
						String[] usuario = linha.split(";");
						if (usuario[0].equals(matricula)) {
							leitor.close();
							return Integer.parseInt(usuario[0]);
						}
					}
					leitor.close();
					break;
				case 3:
					leitor.close();
					leitor = new BufferedReader(new FileReader("csv\\FUNCIONARIOS.csv"));
					while ((linha = leitor.readLine()) != null) {
						String[] usuario = linha.split(";");
						if (usuario[0].equals(matricula)) {
							leitor.close();
							return Integer.parseInt(usuario[0]);
						}
					}
					leitor.close();
					break;
				default:
					System.out.println("Opção invalida!\n");
					buscaMatricula(matricula, tipo);
					break;
				}
			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				e.printStackTrace();
				return null;
			}
		} else
			return 0;

		return null;
	}

	public String[] buscaArcevo(String codigoLivro, int tipo) {
		
		// 1 para livros; 2 para periódicos
		if (codigoLivro.equals("0") != true) {
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\LIVROS.csv"));
				String linha;
				if (tipo == 0) {
					System.out.print("O item é um livro ou um periódico?\n[1]Livros\n[2]Periódicos\nDigite a opção: ");
					tipo = ProgramaMain.entrada.nextInt();
				}
				switch (tipo) {
				case 1:
					while ((linha = leitor.readLine()) != null) {
						String[] livro = linha.split(";");
						if (livro[0].equals(codigoLivro)) {
							if (livro[7].equals("true")) {
								leitor.close();
								return livro;
							} else {
								leitor.close();
								livro[0]="-1";
								return livro;
							}
						}
					}
					leitor.close();
					break;
				case 2:
					leitor.close();
					leitor = new BufferedReader(new FileReader("csv\\PERIODICOS.csv"));
					while ((linha = leitor.readLine()) != null) {
						String[] periodico = linha.split(";");
						if (periodico[0].equals(codigoLivro)) {
							if (periodico[7].equals("true")) {
								leitor.close();
								return periodico;
							} else {
								leitor.close();
								periodico[0]="-1";
								return periodico;
							}
						}
					}
					leitor.close();
					break;
				default:
					System.out.println("Opção invalida!\n");
					buscaArcevo(codigoLivro, tipo);
					break;
				}
			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				e.printStackTrace();
				return null;
			}
		} else
			return null;
		
		return null;
	}
	
	public Integer[] buscaEmprestimo(int matricula) {
		
		if (matricula != 0) {
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\EMPRESTIMO.csv"));
																									
				String linha;
				while ((linha = leitor.readLine()) != null) {
					String[] emprestimo = linha.split(";");
					if (emprestimo[1].equals(String.valueOf(matricula))) {
						leitor.close();
						int[] resultado = new int[2];
						resultado[0] = Integer.parseInt(emprestimo[0]);
						
						SimpleDateFormat formatData = new SimpleDateFormat();
						Date dataHoje = new Date();
						Date dataDevolução = formatData.parse(emprestimo[4]);
						if (dataHoje.after(dataDevolução)) {
							resultado[1] = 1;
						} else {				//1 para tem multa; 0 para não tem multa
							resultado[1] = 0;
						}
					}
				}
				leitor.close();
			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				e.printStackTrace();
				return null;
			}
		} else
			return null;

		return null;
	}
	
public Integer buscaItem(int codigo, int tipo) {
		
		// 1 para livros; 2 para periódicos
		if (codigo != 0) {
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\EMPRESTIMO.csv"));
				String linha;
				switch (tipo) {
				case 1:
					while ((linha = leitor.readLine()) != null) {
						String[] item = linha.split(";");
						if (item[1].equals(String.valueOf(codigo))) {
							leitor.close();
							return Integer.parseInt(item[2]);
						}
					}
					leitor.close();
					break;
				case 2:
					while ((linha = leitor.readLine()) != null) {
						String[] item = linha.split(";");
						if (item[1].equals(String.valueOf(codigo))) {
							leitor.close();
							return Integer.parseInt(item[3]);
						}
					}
					leitor.close();
					break;
				default:
					System.out.println("Opção inválida!");
					buscaItem(codigo, tipo);
					break;
				}
			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				e.printStackTrace();
				return null;
			}
		} else
			return 0;

		return null;
	}
	
	public void setDisponibilidade(String[] item, int tipo) {
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("csv\\LIVROS.csv"));
			
			switch (tipo) {
			case 1:
				String linhaLivros;
				String novasLinhasLivros="";
				while ((linhaLivros = leitor.readLine()) != null) {
					novasLinhasLivros += linhaLivros+"\n";
				}
				
				String livroStr="";
				for (String string : item) {
					livroStr += ";"+string;
				}
				livroStr = livroStr.replaceFirst(";", "");
				novasLinhasLivros = novasLinhasLivros.replace(livroStr, (livroStr = livroStr.replace("true", "false")));
				leitor.close();
				
				OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\LIVROS.csv"),"UTF-8");
				escritor.write(novasLinhasLivros);
				escritor.close();
				break;
			case 2:
				String linhaPeriodicos;
				String novasLinhasPeriodicos="";
				while ((linhaPeriodicos = leitor.readLine()) != null) {
					novasLinhasPeriodicos += linhaPeriodicos+"\n";
				}
				String periodicoStr="";
				for (String string : item) {
					periodicoStr += ";"+string;
				}
				periodicoStr = periodicoStr.replaceFirst(";", "");
				novasLinhasPeriodicos = novasLinhasPeriodicos.replace(periodicoStr, livroStr = periodicoStr.replace("true", "false"));
				leitor.close();
				
				escritor = new OutputStreamWriter(new FileOutputStream("csv\\PERIODICOS.csv"),"UTF-8");
				escritor.write(novasLinhasPeriodicos);
				escritor.close();
				break;
			default:
				System.out.println("AAAAAAAAAAA");
				break;
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}

	public Boolean buscarMulta(int matricula) {
		try {
			@SuppressWarnings("resource")
			BufferedReader leitor = new BufferedReader(new FileReader("csv\\ALUNOS.csv"));
			String linha;
			while ((linha=leitor.readLine())!=null) {
				String[] aluno = linha.split(";");
				if (aluno[0].equals(String.valueOf(matricula))&&aluno[5].equals("20")) {
					leitor.close();
					return true;
				} else if (aluno[0].equals(String.valueOf(matricula))) {
					leitor.close();
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
		System.out.println("Aluno/Multa não encontrado.");
		return false;
	}
}
