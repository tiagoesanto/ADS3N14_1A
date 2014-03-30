package Estruturas;

import java.util.ArrayList;

import Model.Pessoa;

public class ListaEmArray {
	
	private ArrayList<Nodo<Pessoa>> lista = new ArrayList<Nodo<Pessoa>>();
	
	// Propriedade que mostra o contador de comparações efetuadas na ultima pesquisa
	private int contadorUltimaPesquisa;

	/**
	 * Método Construtor
	 * @param sorted A sorted list
	 */
	public ListaEmArray(ListaOrdenada<Pessoa> listaOrdenada)
	{
		Nodo<Pessoa> atual = listaOrdenada.getHead();

		// Create an ArrayList out of a sorted list
		while(atual != null)
		{
			lista.add(atual);
			atual = atual.getProximo();
		}
	}	

	/**
	 * Pesquisa no ArrayList utilizando o nome
	 * @param nome
	 * @return Nodo<Pessoa> pessoa encontrada, se estiver nulo, não encontrou nenhuma pessoa
	 */
	public Nodo<Pessoa> procuraContato(String nome)
	{
		contadorUltimaPesquisa = 0;
		
		int tamanhoDaLista = lista.size();
		Pessoa pessoaComparacao = new Pessoa();		
		
		int esquerda = 0;
		int direita = tamanhoDaLista - 1;
		int meio;
		
		pessoaComparacao.setNome(nome);
		
		while (esquerda <= direita)
		{
			contadorUltimaPesquisa ++;
			
			meio = (esquerda + direita)/2;
			
			if (!lista.get(meio).getChave().getNome().toUpperCase().startsWith(nome.toUpperCase()))
			{
				int comparar = lista.get(meio).getChave().compareTo(pessoaComparacao);
				
				if (comparar > 0)
				{
					direita = meio - 1;
				}
				else if (comparar < 0)
				{
					esquerda = meio + 1;
				}				
			}
			else
			{
				return lista.get(meio);				
			}
		}

		return null;
	}

	public ArrayList<Nodo<Pessoa>> getLista() 
	{
		return lista;
	}

	public int getContadorUltimaPesquisa() 
	{
		return contadorUltimaPesquisa;
	}
}
