package geral;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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

		return -1;
	}

	public String[] buscaArcevo(String codigoItem, int tipo) {

		// 1 para livros; 2 para periódicos; 3 para indefinido, atenção tipo indefinido buscará em todo o arcevo.
		if (codigoItem.equals("0") != true) {
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
							if (livro[0].equals(codigoItem)) {
								leitor.close();
								return livro;
							}
						}
						leitor.close();
						break;
					case 2:
						leitor.close();
						leitor = new BufferedReader(new FileReader("csv\\PERIODICOS.csv"));
						while ((linha = leitor.readLine()) != null) {
							String[] periodico = linha.split(";");
							if (Objects.equals(periodico[0], codigoItem)) {
								leitor.close();
								return periodico;
							}
						}
						leitor.close();
						break;
					case 3:
						while ((linha = leitor.readLine()) != null) {
							String[] livro = linha.split(";");
							if (livro[0].equals(codigoItem)) {
								leitor.close();
								return livro;
							}
						}
						
						leitor.close();
						leitor = new BufferedReader(new FileReader("csv\\PERIODICOS.csv"));
						while ((linha = leitor.readLine()) != null) {
							String[] periodico = linha.split(";");
							if (periodico[0].equals(codigoItem)) {
								leitor.close();
								return periodico;
							}
						}
						break;
					default:
						System.out.println("Opção invalida!\n");
						buscaArcevo(codigoItem, tipo);
						break;
					}
			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				e.printStackTrace();
				return null;
			}
		} else
			return null;
		
		String[] resultado = {"0"};
		return resultado;
	}

	public String[] buscaEmprestimo(int matricula, int modo) {

		// O modo vai mudar a forma que o metodo retorna; se 1, o metodo retorna um string[] que será a matricula e se o prazo de entrega foi excedido.
		// Se 2, o metodo retorna todas as informações referente ao emprestimo.
		if (matricula != 0) {
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\EMPRESTIMO.csv"));

				switch (modo) {
				case 1:
					String linha;
					while ((linha = leitor.readLine()) != null) {
						String[] emprestimo = linha.split(";");
						if (emprestimo[1].equals(String.valueOf(matricula))) {
							leitor.close();

							SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
							Date dataHoje = new Date();
							Date dataDevolução = formatData.parse(emprestimo[4]);

							String[] resultado = new String[2];
							resultado[0] = emprestimo[0];
							if (dataHoje.after(dataDevolução)) {
								resultado[1] = "1";
								return resultado;
							} else { 		// 1 para tem multa; 0 para não tem multa
								resultado[1] = "0";
								return resultado;
							}
						}
					}
					break;
				case 2:
					while ((linha = leitor.readLine()) != null) {
						String[] emprestimo = linha.split(";");
						if (emprestimo[1].equals(String.valueOf(matricula))) {
							leitor.close();
							for (int i = 1; i < emprestimo.length; i++) {
								emprestimo[0] += "; "+emprestimo[i];
							}
							return emprestimo; //Todas as informações serão guardadas na posição 0 do vetor emprestimo.
						}
					}
					break;
				default:
					break;
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

	public Integer[] buscaItem(int codigo) {

		if (codigo != 0) {
			try {
				BufferedReader leitor = new BufferedReader(new FileReader("csv\\ITENS.csv"));
				String linha;
					while ((linha = leitor.readLine()) != null) {
						String[] item = linha.split(";");
						if (item[2].equals("0")) { //item[2] faz referancia ao tipo do item, ex.: se o codigo-livro for 0 então quer dizer que é um periodico.
							if (item[1].equals(String.valueOf(codigo))) {
								leitor.close();
								Integer[] resultado = {Integer.parseInt(item[3]), 2};
								return resultado;
							}
						} else if (item[3].equals("0")) {
							if (item[1].equals(String.valueOf(codigo))) {
								leitor.close();
								Integer[] resultado = {Integer.parseInt(item[2]), 1};
								return resultado;
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

	public void setDisponibilidade(String[] item, int tipo) {
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("csv\\LIVROS.csv"));
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\LIVROS.csv", true), "UTF-8");
			
			switch (tipo) {
			case 1:
				String linhaLivros;
				String novasLinhasLivros = "";
				while ((linhaLivros = leitor.readLine()) != null) {
					novasLinhasLivros += linhaLivros + "\n";
				}

				String livroStr = "";
				for (String string : item) {
					livroStr += ";" + string;
				}
				livroStr = livroStr.replaceFirst(";", "");
				if (livroStr.contains("true")) {
					novasLinhasLivros = novasLinhasLivros.replace(livroStr, (livroStr = livroStr.replace("true", "false")));
				} else {
					novasLinhasLivros = novasLinhasLivros.replace(livroStr, (livroStr = livroStr.replace("false", "true")));
				}
				leitor.close();
				
				escritor.close();
				escritor = new OutputStreamWriter(new FileOutputStream("csv\\LIVROS.csv", false), "UTF-8");
				escritor.write(novasLinhasLivros);
				escritor.close();
				break;
			case 2:
				leitor.close();
				leitor = new BufferedReader(new FileReader("csv\\PERIODICOS.csv"));
				String linhaPeriodicos;
				String novasLinhasPeriodicos = "";
				while ((linhaPeriodicos = leitor.readLine()) != null) {
					novasLinhasPeriodicos += linhaPeriodicos + "\n";
				}
				String periodicoStr = "";
				for (String string : item) {
					periodicoStr += ";" + string;
				}
				periodicoStr = periodicoStr.replaceFirst(";", "");
				if (periodicoStr.contains("true")) {
					novasLinhasPeriodicos = novasLinhasPeriodicos.replace(periodicoStr,livroStr = periodicoStr.replace("true", "false"));
				} else {
					novasLinhasPeriodicos = novasLinhasPeriodicos.replace(periodicoStr,livroStr = periodicoStr.replace("false", "true"));
				}
				leitor.close();
				
				escritor.close();
				escritor = new OutputStreamWriter(new FileOutputStream("csv\\PERIODICOS.csv", false), "UTF-8");
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
			while ((linha = leitor.readLine()) != null) {
				String[] aluno = linha.split(";");
				if (aluno[0].equals(String.valueOf(matricula)) && aluno[5].equals("20")) {
					leitor.close();
					String[] emprestimo = buscaEmprestimo(matricula, 2).clone();
					System.out.println("O usuario de matricula, " + matricula
							+ ", possuí multa no valor de R$20, referente ao emprestimo, " + emprestimo[0]+".");
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
		return false;
	}
}
