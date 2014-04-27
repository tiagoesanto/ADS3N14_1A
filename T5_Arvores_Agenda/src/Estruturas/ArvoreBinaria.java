package Estruturas;

public class ArvoreBinaria<T extends Comparable<T>> 
{
	private Nodo<T> raiz;

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
		
		Nodo<T> novo = new Nodo<T>();
		novo.setChave(chave);
		
		int compara��o = nodo.getChave().compareTo(chave);
		
		// Se a chave a ser inserida � MENOR que a chave do nodo verificar� se pode ser inserida na esquerda
		if (compara��o > 0)
        {
            if (nodo.getEsquerda() == null)
            {
            	nodo.setEsquerda(novo);
            	System.out.println(" (foi inserido � esquerda)");
            }
            else
                this.Inserir(nodo.getEsquerda(), chave);
        }
		// Se a chave a ser inserida � MAIOR que a chave do nodo verificar� se pode ser inserida na esquerda
        else if (compara��o < 0)
        {
            if (nodo.getDireita() == null)
            {
            	System.out.println(" (foi inserido � direita)");
            	nodo.setDireita(novo);
            }
            else
            	this.Inserir(nodo.getDireita(), chave);
        }
        else
        {
        	System.out.println("Nome j� existe");
        }
	}

}
