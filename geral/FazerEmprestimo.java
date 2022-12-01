package geral;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class FazerEmprestimo {
	PlanilhaDeEmprestimos emprestimo = new PlanilhaDeEmprestimos();
	PlanilhaItensEmprestimos item = new PlanilhaItensEmprestimos();
	Auxiliares auxi = new Auxiliares();
	
	public void emprestimo() {
		//Gera um código aleatório para o emprestimo
		System.out.println("Para cancelar o processo digite 0 em qualquer um dos campos de digitação.");
		Random codigos = new Random();
		emprestimo.setCodigo(codigos.nextInt(10000000, 99999999));
		item.setCodigoItem(codigos.nextInt(10000000, 99999999));
		item.setCodigoEmprestimo(emprestimo.getCodigo());
		
		//Busca e associa a matricula de professores ou alunos ao empréstimo; metodo auxi.buscaMatricula está na classe de Auxiliares.
		while(true) {
			System.out.println("Digite a matricula: ");
			String matriculaStr = ProgramaMain.entrada.next();
			Integer matricula = auxi.buscaMatricula(matriculaStr, 0);
			if (auxi.buscarMulta(matricula)==false) {
				if (matricula==0) {
					ProgramaMain.menuPrincipal();
					break;
				} else if (matricula == -1) {
					System.out.println("Matricula não encontrada!");
				} else if (matriculaStr.length() == 8){
					System.out.println("Matricula encontrada!");
					emprestimo.setMatriculaCliente(matricula);
					break;
				} else {
					System.out.println("Matricula inválida!");
				}
			} else {
				System.out.println("Aluno posssi multa!");
				ProgramaMain.menuPrincipal();
				//Função de printar informações da multa do aluno
			}
		}

		while(true) {
			System.out.print("Digite sua matricula de funcionário: ");
			String matriculaStr = ProgramaMain.entrada.next();
			Integer matricula = auxi.buscaMatricula(matriculaStr, 3);
			if (matricula==0) {
				ProgramaMain.menuPrincipal();
				break;
			} else if (matricula == null) {
				System.out.println("Matricula não encontrada!");
			} else if (matriculaStr.length() == 8) {
				System.out.println("Matricula encontrada!");
				emprestimo.setMatriculaFuncionarios(matricula);
				break;
			} else {
				System.out.println("Matricula inválida!");
			}
		}
		//Pega a data atual do sistema e formata para dia/mês/ano, e seta nas informações do empréstimo.
		SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		emprestimo.setDataEmprestimo(dataFormat.format(data));
		
		while (true) {
			System.out.println("Informe a data de devolução do item:[dia/mês/ano] ");
			String dataStr = ProgramaMain.entrada.next();
			if (dataStr.contains("/")) {
				try {
					Date dataEmprestimo = dataFormat.parse(emprestimo.getDataEmprestimo());
					Date dataDevolucao = dataFormat.parse(dataStr);
					
					if (dataDevolucao.compareTo(dataEmprestimo) == 1) {
						emprestimo.setDataDevolucao(dataFormat.format(dataDevolucao));
						item.setDataDevolucao(dataFormat.format(dataDevolucao));
						break;
					} else {
						System.out.println("Data inválida.");
					}
				} catch (ParseException e) {
					System.out.println("Ocorreu um erro.");
					e.printStackTrace();
				}
			} else {
				System.out.println("Formato de data inválido, insira conforme esse padrão Dia/Mês/Ano !");
			}
		}
		// Busca o livro
		System.out.println("O item é um livro ou periódico?");
		boolean passou = false;
		while(true) {
			System.out.println("[1]Livro\n[2]Periódico");
			switch (ProgramaMain.entrada.nextInt()) {
			case 1:
				String codigoLivro="0";
				String[] livroInfo = new String[6];
				do {
					System.out.println("Escreva o código do livro: ");
					codigoLivro = ProgramaMain.entrada.next();
					if (codigoLivro.equals("0") || codigoLivro.length() < 8 || codigoLivro.length() > 8) {
						System.out.println("Código está errado.");
						codigoLivro = "0";
					} else {
						livroInfo = auxi.buscaArcevo(codigoLivro, 1);
						
						if (Objects.equals(livroInfo[0], "0")) {
							System.out.println("Código não encontrado.");
						} else {
							livroInfo = auxi.buscaArcevo(codigoLivro, 1);
							break;
						}
					}
					
				} while (true);
				
				item.setCodigoLivro(Integer.parseInt(livroInfo[0]));
				if (Objects.equals(livroInfo[7], "false")) {
					System.out.println("O livro solicitado existe, mas não está disponível.");
				} else {
					auxi.setDisponibilidade(livroInfo, 1);
					passou=true;
				}
				break;
			case 2:
				String codigoPeriodico="0";
				String[] periodicoInfo = new String[6];
				do {
					System.out.println("Escreva o código do livro: ");
					codigoLivro = ProgramaMain.entrada.next();
					if (codigoPeriodico.equals("0") && codigoPeriodico.length() < 8 && codigoPeriodico.length() > 8) {
						System.out.println("Periodico não encontrado ou código está errado.");
					} else {
						periodicoInfo = auxi.buscaArcevo(codigoPeriodico, 2);
						break;
					}
				} while (codigoPeriodico.equals("0"));
				
				 
				item.setCodigoPeriodico(Integer.parseInt(periodicoInfo[0]));
				if (Objects.equals(periodicoInfo[6], "false")) {
					System.out.println("O periódico solicitado existe, mas não está disponível.");
				} else {
					passou=true;
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			if (passou==true) {
				break;
			}
		}
		//Escreve no arquivo csv o emprestimo é o item emprestado
		try {
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\EMPRESTIMO.csv", true),"UTF-8");
			escritor.write(System.lineSeparator());
			escritor.write(emprestimo.toString());
			System.out.println("Emprestimo feito com sucesso!");
			escritor.close();
			
			escritor = new OutputStreamWriter(new FileOutputStream("csv\\ITENS.csv", true),"UTF-8");
			escritor.write(System.lineSeparator());
			escritor.write(item.toString());
			escritor.close();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}
}
