public class ArvoreBinaria {
    private No raiz;

    //Inicializa a árvore, setando a raiz como null (nao existe raiz até o momento)
    public ArvoreBinaria() {
        this.raiz = null;
    }

    //Método responsável por criar a raiz se ainda não houver e adicionar novos elementos na árvore.
    public No insere(Item reg, No p) {
        //Inicializa o no
        p.reg = reg;
        p.esq = null;
        p.dir = null;

        //Verifica se existe uma raiz na arvore. Se não existir, ele iniciará a raiz.
        if(this.raiz == null) {
            this.raiz = p;
            //System.out.println("Nó inserido com sucesso na raiz");

        }else {

            //Percorrerá toda a árvore até achar o elemento final. Ao achá-lo, o elemento será inserido
            //na esquerda ou na direita, dependendo se for menor ou maior. Após a inserção, é feito uma quebra no loop;

            No atual = this.raiz;

            while(true) {
                if(atual.reg.compara(reg) == 1) {
                    if(atual.esq != null) {
                        atual = atual.esq;
                    }else {
                        //System.out.println("Item " + reg.getChave() + " inserido a esquerda do " + atual.reg.getChave());
                        atual.esq = p;
                        break;
                    }
                }else {//se for maior ou igual
                    if(atual.dir != null) {
                        atual = atual.dir;
                    }else {
                        atual.dir = p;
                        //System.out.println("Item " + reg.getChave() + " inserido a direta do " + atual.reg.getChave());
                        break;
                    }
                }
            }
        }

        return p;
    }

    public int pesquisa(Item reg) {
        int quantidade_comparacoes = 0;

        if(this.raiz == null)
            System.out.println("Árvore está vazia");
        else {
            No atual = this.raiz;

            while(true) {
                quantidade_comparacoes++;

                if(atual.reg.getChave() == reg.getChave()) {
                    System.out.println("Número " + atual.reg.getChave() + " encontrado com " + quantidade_comparacoes + " comparações!!");
                    return quantidade_comparacoes;
                }else {

                    if(atual.reg.compara(reg) == 1) 
                        if(atual.esq != null) 
                            atual = atual.esq;
                        else {
                            System.out.println("Número " + reg.getChave() + " não existe na árvore após " + quantidade_comparacoes + " comparações!");
                            return quantidade_comparacoes;
                        }
                            
                    else //se for maior ou igual
                        if(atual.dir != null) 
                            atual = atual.dir; 
                        else {
                            System.out.println("Número " + reg.getChave() + " não existe na árvore após " + quantidade_comparacoes + " comparações!");
                            return quantidade_comparacoes;
                        }
                        
                }
            }
        }

        return quantidade_comparacoes;
    }
}



