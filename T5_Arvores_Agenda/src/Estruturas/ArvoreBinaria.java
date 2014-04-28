package Estruturas;

public class ArvoreBinaria<T extends Comparable<T>> 
{
	private Nodo<T> raiz;

	public ArvoreBinaria(Nodo<T> raiz) 
	{
		this.raiz = raiz;
	}
	
	public void inserirNodo(T chave)
	{
		this.inserirNodo(null, chave);
	}

	public void inserirNodo(Nodo<T> nodo, T chave) 
	{	
		if (nodo == null)
			nodo = this.raiz;
		
		Nodo<T> novo = new Nodo<T>();
		novo.setChave(chave);
		
		int comparacao = nodo.getChave().compareTo(chave);
		
		// Se a chave a ser inserida é MENOR que a chave do nodo verificará se pode ser inserida na esquerda
		if (comparacao > 0)
        {
            if (nodo.getEsquerda() == null)
            {
            	novo.setRaiz(nodo);
            	nodo.setEsquerda(novo);
            	System.out.println(" (foi inserido à esquerda)");
            }
            else
                this.inserirNodo(nodo.getEsquerda(), chave);
        }
		// Se a chave a ser inserida é MAIOR que a chave do nodo verificará se pode ser inserida na esquerda
        else if (comparacao < 0)
        {
            if (nodo.getDireita() == null)
            {
            	novo.setRaiz(nodo);
            	nodo.setDireita(novo);
            	System.out.println(" (foi inserido à direita)");
            }
            else
            	this.inserirNodo(nodo.getDireita(), chave);
        }
        else
        {
        	System.out.println("Nome já existe");
        }
	}
	
	public void excluirNodo(Nodo<T> nodo)
	{
		Nodo<T> raiz = nodo.getRaiz();
		
		// Verifica se o nodo é uma folha
		if (nodo.getEsquerda() == null && nodo.getDireita() == null)
		{
			// Se o nodo não tiver raiz, significa que é a raiz da Arvore
			if (raiz == null)
			{
				this.raiz = null;
			}
			// Verifica em qual lado o nodo esta
			if (raiz.getEsquerda() != null && raiz.getEsquerda() == nodo)
			{
				raiz.setEsquerda(null);
			}
			else 
			{
				raiz.setDireita(null);
			}
		}
		// Se o nodo tiver um filho apenas
		else if (nodo.getEsquerda() == null ^ nodo.getDireita() == null)
		{
			if (nodo.getEsquerda() != null)
			{
				if (raiz == null)
				{
					this.raiz = nodo.getEsquerda();
				}
				if (raiz.getEsquerda() != null && raiz.getEsquerda() == nodo)
				{
					raiz.setEsquerda(nodo.getEsquerda());
				}
				else 
				{
					raiz.setDireita(nodo.getEsquerda());
				}
			}
			else
			{
				if (raiz == null)
				{
					this.raiz = nodo.getDireita();
				}
				if (raiz.getEsquerda() != null && raiz.getEsquerda() == nodo)
				{
					raiz.setEsquerda(nodo.getEsquerda());
				}
				else 
				{
					raiz.setDireita(nodo.getEsquerda());
				}
			}
		}
		// Se o nodo tiver dois filhos
		else
		{
			if (raiz == null)
			{
				System.out.println("Impossível Remover (Nodo Raiz)");
			}
			else
			{
				System.out.println("Impossível Remover (Item com dois filhos)");
			}
		}
			
	}

}
