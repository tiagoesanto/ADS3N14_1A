package Estruturas;

import java.util.ArrayList;

import Model.Pessoa;

public class ListaEmArray {
	
	ArrayList<Nodo<Pessoa>> lista = new ArrayList<Nodo<Pessoa>>();
	
	// Propriedade que mostra o contador de comparações efetuadas na ultima pesquisa
	int contadorUltimaPesquisa;

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
	 * @param ch nome
	 * @return Nodo<Pessoa> pessoa encontrada, se estiver nulo, não encontrou nenhuma pessoa
	 */
	public Nodo<Pessoa> procuraContato(String nome)
	{
		contadorUltimaPesquisa = 0;		
		boolean finaliza = false;
		int tamanhoDaLista = lista.size();
		int posicaoAtual = (int)Math.floor(tamanhoDaLista/2);
		Nodo<Pessoa> ret = null;
		int metade = posicaoAtual;

		while (!finaliza)
		{
			contadorUltimaPesquisa ++;
			
			if (!lista.get(posicaoAtual).getChave().getNome().toUpperCase().startsWith(nome.toUpperCase()))
			{
				int comparar = lista.get(posicaoAtual).getChave().getNome().substring(0, 1).toUpperCase().compareTo(nome.toUpperCase());

				metade /= 2;
				if (comparar > 0 && metade >= 1)
				{
					posicaoAtual -= metade;
				}
				else if (comparar < 0 && metade >= 1)
				{
					posicaoAtual += metade;
				}
				else
				{
					finaliza = true;
				}
			}
			else
			{
				ret = lista.get(posicaoAtual);
				finaliza = true;
			}
		}

		return ret;
	}
	
	
}
