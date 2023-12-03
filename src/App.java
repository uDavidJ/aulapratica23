public class App {
    public static void main(String[] args) throws Exception {
        
        //Testes do método adiciona com criação e inserção de novos nós

        ArvoreBinaria arvore = new ArvoreBinaria();
        
        var item1 = new Item(10);
        var noRaiz = new No();
        
        noRaiz = arvore.insere(item1, noRaiz);

        var item2 = new Item(5);
        var no1 = new No();

        no1 = arvore.insere(item2, no1);
        
        var item3 = new Item(2);
        var no2 = new No();

        no2 = arvore.insere(item3, no2);

        var item4 = new Item(6);
        var no3 = new No();

        no2 = arvore.insere(item4, no3);     

        //teste do método pesquisa com um item existente na árvore
        arvore.pesquisa(item4);

        //teste do método pesquisa com um item inexistente na árvore
        arvore.pesquisa(new Item(7));


        System.out.println("------------------------------------------------------");


        //a) gerar árvores a partir de n elementos ORDENADOS, com n variando de 1.000 até 9.000, com intervalo de 1.000.
        
        //Criação da árvore com elementos numerados ordenadamente de 1 a 100000
        long comeco = System.currentTimeMillis();
        ArvoreBinaria arvore2 = new ArvoreBinaria();
        for(int i = 1; i <= 100000; i++) 
            arvore2.insere(new Item(i), new No());
        long fim = (System.currentTimeMillis() - comeco) ;
        System.out.println(fim + " Milisegundos na criação da árvore 2");
        
        //Criação da árvore com elementos numerados ordenadamente de 100000 a 1
        comeco = System.currentTimeMillis();
        ArvoreBinaria arvore3 = new ArvoreBinaria();
        for(int i = 100000; i >= 1; i--) 
            arvore3.insere(new Item(i), new No());
        fim = (System.currentTimeMillis() - comeco);
        System.out.println(fim + " Milisegundos na criação da árvore 3");

        //Criação da árvore com elementos ordenados de 1 a 100000 a partir da raiz 50000
        comeco = System.currentTimeMillis();
        ArvoreBinaria arvore4 = new ArvoreBinaria();
        for(int i = 50000; i >= 1; i--) 
            arvore4.insere(new Item(i), new No());

        for(int i = 50001; i <= 100000; i++) 
            arvore4.insere(new Item(i), new No());
        
        fim = (System.currentTimeMillis() - comeco);
        System.out.println(fim + " Milisegundos na criação da árvore 4");       

        System.out.println("------------------------------------------------------");

        //pesquisa inexistente nas árvores 2, 3 e 4



        comeco = System.currentTimeMillis();
        arvore2.pesquisa(new Item(100001));
        fim = (System.currentTimeMillis() - comeco);
        System.out.println(fim + " Milisegundos na execução da pesquisa da árvore 2");

        comeco = System.currentTimeMillis();
        arvore3.pesquisa(new Item(-1));
        fim = (System.currentTimeMillis() - comeco);
        System.out.println(fim + " Milisegundos na execução da pesquisa da árvore 3");

        comeco = System.currentTimeMillis();
        arvore4.pesquisa(new Item(100001));
        fim = (System.currentTimeMillis() - comeco);
        System.out.println(fim + " Milisegundos na execução da pesquisa da árvore 4");


        System.out.println("------------------------------------------------------");

        //b) gerar árvores a partir de n elementos ALEATÓRIOS, com n variando de 1.000 até 9.000, com intervalo de 1.000.

        //Neste teste serão geradas 3 ávores com 10000 números aleatórios de 0 a 9999 e em seguida será feita a pesquisa de um elemento inexistente.
        
        ArvoreBinaria arvore_aleatoria1 = new ArvoreBinaria();
        for(int i = 0; i < 10000000; i++)
            arvore_aleatoria1.insere(new Item((int)(Math.random() * 10000000)), new No());

        comeco = System.currentTimeMillis();
        arvore_aleatoria1.pesquisa(new Item(6542721));
        fim = (System.currentTimeMillis() - comeco);
        System.out.println(fim + " Milisegundos na execução da pesquisa da árvore 1 aleatória");


        ArvoreBinaria arvore_aleatoria2 = new ArvoreBinaria();
        for(int i = 0; i < 10000000; i++)
            arvore_aleatoria2.insere(new Item((int)(Math.random() * 10000000)), new No());

        comeco = System.currentTimeMillis();
        arvore_aleatoria2.pesquisa(new Item(41252));
        fim = (System.currentTimeMillis() - comeco);
        System.out.println(fim + " Milisegundos na execução da pesquisa da árvore 2 aleatória");

        ArvoreBinaria arvore_aleatoria3 = new ArvoreBinaria();
        for(int i = 0; i < 10000000; i++)
            arvore_aleatoria3.insere(new Item((int)(Math.random() * 10000000)), new No());

        comeco = System.currentTimeMillis();
        arvore_aleatoria3.pesquisa(new Item(7563212));
        fim = (System.currentTimeMillis() - comeco);
        System.out.println(fim + " Milisegundos na execução da pesquisa da árvore 3 aleatória");

        System.out.println("------------------------------------------------------");


    }
}
