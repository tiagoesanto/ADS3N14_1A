package View;
import static java.lang.System.out;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Controller.ListaTelefonicaController;
import Estruturas.*;
import Model.*;

public class ConsoleView {
	
	public int opcao;	
	ListaTelefonicaController lista;
	ContatoView contatoView;
	Scanner leitor;
	
	public ConsoleView()
	{
		try
		{	
			lista = new ListaTelefonicaController();			
			lista.iniciaLista();
			
			leitor = new Scanner(System.in);
			contatoView = new ContatoView();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Falha na leitura do arquivo.");
			e.getStackTrace();
		}
	}
	
	public void menuPrincipal()
	{
		boolean sair = false;
		opcao = 0; 
		while (sair == false)
		{
			System.out.println("\nLISTA TELEF�NICA\n"
					+ "Selecione uma op��o:\n"					
					+ "1 - Adicionar contato\n"
					+ "2 - Buscar contato\n"
					+ "3 - Remover contato\n"					
					+ "0 - Sair");
			
			try
			{
			opcao = leitor.nextInt();		
			
				switch (opcao)
				{
					case 1:
						this.adicionarContato();
						break;
					case 2:
						this.procurarContato();
						break;
					case 3:
						this.excluirContato();
						break;
					case 0:
						sair = true;
						break;
						
				}
			}
			catch (Exception e)
			{
				System.out.print("Op��o inv�lida!!!");
			}
		}
	}
	
	public void adicionarContato()
	{
		boolean sair = false;
		
		while (sair == false)
		{	
			try
			{
				out.println("Digite o nome do contato a ser inserido:");				
				String nome = leitor.next();								
				out.println("Digite o telefone do contato a ser inserido:");
				String telefone = leitor.next();
				
				Pessoa contatoInserir = new Pessoa();
				contatoInserir.setNome(nome);
				contatoInserir.setTelefone(telefone);
				Nodo<Pessoa> novoNodo = new Nodo<Pessoa>();
				novoNodo.setChave(contatoInserir);
				
				lista.arvore.inserirNodo(novoNodo.getChave());
				
				out.println("\n1 - Inserir outro contato | 2 - Voltar ao Menu Inicial");
				
				opcao = leitor.nextInt();		
			
				switch (opcao)
				{
					case 1:	
						
						break;
					case 2:
						sair = true;
						break;
				}
			}
			catch(Exception e)
			{
				System.out.print("Op��o inv�lida!!!");
			}
		}
	}
	
	public void procurarContato()
	{	
		boolean sair = false;
		
		while (sair == false)
		{	
			System.out.println("Digite o nome do contato a ser procurado:");
			try
			{
				String nome = leitor.next();				
				Pessoa contato = new Pessoa();
				contato.setNome(nome);				
				
				Nodo<Pessoa> retorno = this.lista.buscarContato(contato);				
				
				if (retorno == null)
				{
					System.out.println("Contato n�o encontrado! \nBuscar outro contato?\n 1 - SIM; 2 - N�O");
					opcao = leitor.nextInt();
					
					switch(opcao)
					{
						case 1:
							break;
						case 2:
							sair = true;
							break;
					}
				}
				else
				{					
					System.out.println("Nome: "+ retorno.getChave().getNome());
					System.out.println("Telefone: "+ retorno.getChave().getTelefone() + "\n");
					System.out.println("Buscar outro contato?\n 1 - SIM; 2 - N�O");
					opcao = leitor.nextInt();
					
					switch(opcao)
					{
						case 1:
							break;
						case 2:
							sair = true;
							break;
					}
				}
			}
			catch(Exception e)
			{
				System.out.print("Op��o inv�lida!!!");
			}
		}
	}
	
	public void excluirContato()
	{
		boolean sair = false;
		
		while (sair == false)
		{	
			System.out.println("Digite o nome do contato a ser deletado:");
			try
			{
				String nome = leitor.next();				
				Pessoa contato = new Pessoa();
				contato.setNome(nome);				
				
				Nodo<Pessoa> retorno = this.lista.buscarContato(contato);				
				
				if (retorno == null)
				{
					System.out.println("Contato n�o encontrado! \nDeletar outro contato?\n 1 - SIM; 2 - N�O");
					opcao = leitor.nextInt();
					
					switch(opcao)
					{
						case 1:
							break;
						case 2:
							sair = true;
							break;
					}
				}
				else
				{
					System.out.println("Nome: "+ retorno.getChave().getNome());
					System.out.println("Telefone: "+ retorno.getChave().getTelefone() + "\n");
					System.out.println("Tem certeza que quer deletar esse contato?\n 1 - SIM; 2 - N�O");
					opcao = leitor.nextInt();
					
					switch(opcao)
					{
						case 1:
							lista.arvore.excluirNodo(retorno);
							sair = true;
							break;
						case 2:
							sair = true;
							break;
					}
				}
			}
			catch(Exception e)
			{
				System.out.print("Op��o inv�lida!!!");
			}
		}
	}
}