package Estruturas;

public class ArvoreBinaria<T extends Comparable<T>> {
	protected Nodo<T> raiz;

	public ArvoreBinaria(Nodo<T> raiz) 
	{
		this.raiz = raiz;
	}
	
	public void Inserir(T chave)
	{
		this.Inserir(null, chave);
	}

	public void Inserir(Nodo<T> nodo, T chave) 
	{	
		if (nodo == null)
			nodo = this.raiz;
		else if (this.raiz == null) 
			this.raiz = nodo;
		else
		{
			Nodo<T> novo = new Nodo<T>();
			novo.setChave(chave);
			
			// Se a chave a ser inserida é MENOR que a chave do nodo verificará se pode ser inserida na esquerda
			if (chave.compareTo(nodo.getChave()) >= 0)
	        {
	            if (nodo.getEsquerda() == null)
	            	nodo.setEsquerda(novo);
	            else
	                this.Inserir(nodo.getEsquerda(), chave);
	        }
			// Se a chave a ser inserida é MAIOR que a chave do nodo verificará se pode ser inserida na esquerda
	        else
	        {
	            if (nodo.getDireita() == null)
	            	nodo.setDireita(novo);
	            else
	            	this.Inserir(nodo.getDireita(), chave);
	        }
		}
	}

}
