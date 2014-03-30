package Controller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import View.ContatoView;
import Estruturas.ListaOrdenada;
import Estruturas.Nodo;
import Model.Pessoa;

public class ListaTelefonicaController {
	
	
	private Scanner scanner;
	private ListaOrdenada<Pessoa> lista = new ListaOrdenada<Pessoa>();
	private ContatoView view = new ContatoView();

	public ListaTelefonicaController() throws FileNotFoundException
	{
		scanner = new Scanner(new FileReader("PhonebookFiles.txt")).useDelimiter("\\|");
	}

	public void iniciaLista() 
	{
		while (scanner.hasNext())
		{
			Nodo<Pessoa> novo = new Nodo<Pessoa>();
			Pessoa contato = new Pessoa();
			contato.setNome(scanner.next());
			contato.setTelefone(scanner.next());
			novo.setChave(contato);
			lista.inserir(novo);
		}
	}

	public void imprimeLista() 
	{
		Nodo<Pessoa> nodo = lista.getHead();
		while (nodo != null) 
		{
			view.printContato(nodo.getChave().getNome(),nodo.getChave().getTelefone());
			nodo = nodo.getProximo();
		}
	}
	
	public ListaOrdenada<Pessoa> getLista()
	{
		return this.lista;
	}
	
	public Nodo<Pessoa> primeiroDaLista()
	{
		return lista.getHead();
	}

	public Nodo<Pessoa> ultimoDaLista()
	{
		return lista.getTail();
	}
	
	public Nodo<Pessoa> proximoDaLista(Nodo<Pessoa> anterior)
	{
		return anterior.getProximo();
	}
	
	public Nodo<Pessoa> anteriorDaLista(Nodo<Pessoa> proximo)
	{
		return lista.getAnterior(proximo);
	}

	public Nodo<Pessoa> procuraNodo(Nodo<Pessoa> needle)
	{
		return lista.procuraNodo(needle);
	}
	
	public Nodo<Pessoa> buscaNodo(Pessoa pessoa)
	{
		Nodo<Pessoa> needle = new Nodo<Pessoa>();
		
		needle.setChave(pessoa);
		
		return lista.procuraNodo(needle);
	}
	
	public void inserirNodo(Nodo<Pessoa> novoNodo)
	{
		lista.inserir(novoNodo);
	}
	
}
