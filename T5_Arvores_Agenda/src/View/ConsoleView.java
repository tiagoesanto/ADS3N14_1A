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
			System.out.println("\nLISTA TELEFÔNICA\n"
					+ "Selecione uma opção:\n"					
					+ "1 - Adicionar contatos\n"
					+ "2 - Remover contato\n"
					+ "0 - Sair");
			
			try
			{
			opcao = leitor.nextInt();		
			
				switch (opcao)
				{
					case 1:
						adicionarContato();
						break;
					case 2:
						break;
					case 0:
						sair = true;
						break;
						
				}
			}
			catch (Exception e)
			{
				System.out.print("Opção inválida!!!");
			}
		}
	}
	
	public void procurarContato()
	{	
		boolean sair = false;
		
		while (sair == false)
		{	
			try
			{
				
			}
			catch(Exception e)
			{
				System.out.print("Opção inválida!!!");
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
				System.out.print("Opção inválida!!!");
			}
		}
	}
}