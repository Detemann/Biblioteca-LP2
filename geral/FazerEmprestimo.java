package geral;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FazerEmprestimo {
	PlanilhaDeEmprestimos emprestimo = new PlanilhaDeEmprestimos();
	PlanilhaItensEmprestimos item = new PlanilhaItensEmprestimos();
	Auxiliares auxi = new Auxiliares();
	
	public void emprestimo() {
		//Gera um código aleatório para o emprestimo
		System.out.println("Para cancelar o processo digite 0 em qualquer um dos campos de digitação.");
		Random codigo = new Random();
		emprestimo.setCodigo(codigo.nextInt(10000000, 99999999));
		item.setCodigoEmprestimo(emprestimo.getCodigo());
		
		//Busca e associa a matricula de professores ou alunos ao empréstimo; metodo auxi.buscaMatricula está na classe de Auxiliares.
		while(true) {
			System.out.println("Digite a matricula: ");
			String matriculaStr = ProgramaMain.entrada.next();
			Integer matricula = auxi.buscaMatricula(matriculaStr);
			if (matricula==0) {
				ProgramaMain.menuUsuarios();
				break;
			} else if (matricula == null) {
				System.out.println("Matricula não encontrada!");
			} else if (matriculaStr.length() == 8){
				System.out.println("Matricula encontrada!");
				emprestimo.setMatriculaCliente(matricula);
				break;
			} else {
				System.out.println("Matricula inválida!");
			}
		}

		while(true) {
			System.out.print("Digite sua matricula de funcionário: ");
			String matriculaStr = ProgramaMain.entrada.next();
			Integer matricula = auxi.buscaMatricula(matriculaStr);
			if (matricula==0) {
				ProgramaMain.menuUsuarios();
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
					
					if (dataEmprestimo.compareTo(dataDevolucao) == 1) {
						emprestimo.setDataDevolucao(dataDevolucao.toString());
						item.setDataDevolucao(dataDevolucao.toString());
						break;
					} else {
						System.out.println("Data inválida.");
					}
				} catch (ParseException e) {
					System.out.println("Ocorreu um erro.");
				}
			} else {
				System.out.println("Formato de data inválido, insira conforme esse padrão Dia/Mês/Ano !");
			}
		}
	}
}