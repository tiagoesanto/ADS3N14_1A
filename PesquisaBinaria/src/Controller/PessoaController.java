package Controller;

import Model.Pessoa;

public class PessoaController {
	
	private Pessoa contato;
	
	public void criarContato(String nome, String telefone)
	{
		contato = new Pessoa();
		contato.setNome(nome);
		contato.setTelefone(telefone);
	}

}
