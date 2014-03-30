package View;
import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Controller.ListaTelefonicaController;
import Estruturas.ListaEmArray;
import Estruturas.Nodo;
import Model.Pessoa;

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
					+ "1 - Listar todos os contatos\n"
					+ "2 - Navegar a partir do primeiro contato\n"
					+ "3 - Procurar contato\n"
					+ "4 - Adicionar contatos\n"
					+ "5 - Sair");
								
			try
			{
				opcao = leitor.nextInt();
				
				switch (opcao)
				{
					case 1:	
						lista.imprimeLista();
						break;
					case 2:
						navegarContatos();
						break;
					case 3:
						procurarContato();
						break;
					case 4:
						adicionarDeletarContato();
						break;
					case 5:
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
	
	public void navegarContatos()
	{		
		Nodo<Pessoa> contato = lista.primeiroDaLista();
		
		contatoView.printContato(contato.getChave().getNome(), contato.getChave().getTelefone());
		
		boolean sair = false;
		
		while (sair == false)
		{
			out.println("\n1 - Anterior | 2 - Pr�ximo | 3 - Voltar ao Menu Inicial");
			
			try
			{
				opcao = leitor.nextInt();		
			
				switch (opcao)
				{
					case 1:	
						if (contato == lista.primeiroDaLista())
						{
							out.println("Voc� j� esta no in�cio da lista telef�nica. Tente selecionar o pr�ximo.");
						}
						else
						{
							contato = lista.anteriorDaLista(contato);
						}
						contatoView.printContato(contato.getChave().getNome(), contato.getChave().getTelefone());
						break;
					case 2:
						if (contato == lista.ultimoDaLista())
						{
							out.println("Voc� j� esta no fim da lista telef�nica. Tente selecionar o anterior.");
						}
						else
						{
							contato = lista.proximoDaLista(contato);
						}
						contatoView.printContato(contato.getChave().getNome(), contato.getChave().getTelefone());
						break;
					case 3:
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
		
		ListaEmArray listaEmArray = new ListaEmArray(lista.getLista());
		
		while (sair == false)
		{	
			try
			{
				out.println("Digite o nome do contato:");
				
				String nomeContatoBusca = leitor.next();
				
				Nodo<Pessoa> contatoEncontrado = listaEmArray.procuraContato(nomeContatoBusca);
				
				if (contatoEncontrado != null)				
					contatoView.printContato(contatoEncontrado.getChave().getNome(), contatoEncontrado.getChave().getTelefone());				
				else
					out.println("Contato n�o encontrado!");
					
				out.println("A pesquisa utilizou " + listaEmArray.getContadorUltimaPesquisa() + " compara��es nessa busca!");
				
				out.println("\n1 - Procurar outro contato | 2 - Voltar ao Menu Inicial");
			
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
	
	public void adicionarDeletarContato()
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
				
				lista.inserirNodo(novoNodo);
				
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
}