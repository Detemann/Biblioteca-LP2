package cadastros;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import geral.ProgramaMain;
import pessoasLivros.Funcionarios;

public class CadastraFuncionarios {
Funcionarios funcionario = new Funcionarios();
	
	public void cadastroFuncionario() {
		
		System.out.printf("Informe a matrÝcula do funcionario: ");
		funcionario.setMatricula(Integer.parseInt(ProgramaMain.entrada.next()));
		
		System.out.printf("Informe o nome do funcionario: ");
		funcionario.setNome(ProgramaMain.entrada.next());
		
		System.out.printf("Informe o enderešo do funcionario: ");
		funcionario.setEndereco(ProgramaMain.entrada.next());
		
		System.out.printf("Informe o setor do funcionario: ");
		funcionario.setSetor(ProgramaMain.entrada.next());
		
		System.out.printf("Informe a data de ingresso do funcionario: ");
		funcionario.setData(ProgramaMain.entrada.next());
		
		System.out.printf("Informe o login do funcionario: ");
		funcionario.setLogin(ProgramaMain.entrada.next());
		
		System.out.printf("Informe a senha do usuario:  ");
		funcionario.setSenha(ProgramaMain.entrada.next());

		arquivarfuncionario();
	}
	
	public void arquivarfuncionario() {
		try {
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\FUNCIONARIOS.csv", true), "UTF-8");
			escritor.write(System.lineSeparator());
			escritor.write(funcionario.toString());
			System.out.println("Cadastro realizado com sucesso!");
			escritor.close();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			e.printStackTrace();
		}
	}
}

