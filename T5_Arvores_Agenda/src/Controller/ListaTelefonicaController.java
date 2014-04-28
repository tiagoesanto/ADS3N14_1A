package Controller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import View.*;
import Estruturas.*;
import Model.*;

public class ListaTelefonicaController {
	
	
	private Scanner scanner;
	public ArvoreBinaria arvore;
	private ContatoView view;

	public ListaTelefonicaController() throws FileNotFoundException
	{
		view = new ContatoView();
		scanner = new Scanner(new FileReader("PhonebookFiles.txt")).useDelimiter("\\|");
	}

	public void iniciaLista() 
	{
		Nodo<Pessoa> raiz = new Nodo<Pessoa>();
		Pessoa contato = new Pessoa();
		contato.setNome(scanner.next());
		contato.setTelefone(scanner.next());
		raiz.setChave(contato);
		arvore = new ArvoreBinaria<Pessoa>(raiz); 
		System.out.println("Inserido Raiz: " + contato.getNome());
		
		while (scanner.hasNext())
		{
			Nodo<Pessoa> novo = new Nodo<Pessoa>();
			contato = new Pessoa();
			contato.setNome(scanner.next());
			contato.setTelefone(scanner.next());
			novo.setChave(contato);
			System.out.print("Inserido: " + contato.getNome());
			arvore.inserirNodo(contato);			
		}
	}
	
}
