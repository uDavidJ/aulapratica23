import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra extends JFrame{
    JFreeChart grafico;

    public GraficoBarra(int flag) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gráfico Barra");
        setSize(950,700);
        setLocationRelativeTo(null);

        criarGrafico(flag);

        setVisible(true);
    }

    public void criarGrafico(int flag) {
        DefaultCategoryDataset barra = new DefaultCategoryDataset();

        long comeco;
        long fim;

        //Criacao de arvores ordenadas de diferentes tamanhos
        ArvoreBinaria arvore1 = new ArvoreBinaria();
        for(int i = 1; i <= 1000; i++) 
            arvore1.insere(new Item(i), new No());

        ArvoreBinaria arvore2 = new ArvoreBinaria();
        for(int i = 1; i <= 10000; i++) 
            arvore2.insere(new Item(i), new No());

        ArvoreBinaria arvore3 = new ArvoreBinaria();
        for(int i = 1; i <= 100000; i++) 
            arvore3.insere(new Item(i), new No());
        
        //Criação de várias árvores com elementos aleatórios e com elementos crescentes.

        ArvoreBinaria arvore_aleatoria1 = new ArvoreBinaria();
        for(int i = 0; i < 1000; i++)
            arvore_aleatoria1.insere(new Item((int)(Math.random() * 1000)), new No());
                
        ArvoreBinaria arvore_aleatoria2 = new ArvoreBinaria();
        for(int i = 0; i < 10000; i++)
            arvore_aleatoria2.insere(new Item((int)(Math.random() * 10000)), new No());

        ArvoreBinaria arvore_aleatoria3 = new ArvoreBinaria();
        for(int i = 0; i < 100000; i++)
            arvore_aleatoria3.insere(new Item((int)(Math.random() * 100000)), new No());

        ArvoreBinaria arvore_aleatoria4 = new ArvoreBinaria();
        for(int i = 0; i < 1000000; i++)
            arvore_aleatoria4.insere(new Item((int)(Math.random() * 1000000)), new No());

        ArvoreBinaria arvore_aleatoria5 = new ArvoreBinaria();
        for(int i = 0; i < 10000000; i++)
            arvore_aleatoria5.insere(new Item((int)(Math.random() * 10000000)), new No());


        //Flag 1 = n x Comparaçoes e arvore ordenada
        //Flag 2 = n x Comparações e arvore aleatoria
        //Flag 3 = n x Tempo Gasto e arvore ordenada
        //Flag 4 = n x Tempo Gasto e arvore aleatoria

        if(flag == 1){

            barra.setValue(arvore1.pesquisa(new Item(1001)), "Ordenado com 1000 elementos", "");
            barra.setValue(arvore2.pesquisa(new Item(10001)), "Ordenado com 10000 elementos", "");
            barra.setValue(arvore3.pesquisa(new Item(100001)), "Ordenado com 100000 elementos", "");
        
            grafico = ChartFactory.createBarChart("Gráfico da quantidade de comparações em função da quantidade de elementos ordenados", "Quantidade de elementos", "Comparações", barra, PlotOrientation.VERTICAL, true, true, false);

        }else if(flag == 2) {

            //Pesquisas de elementos inexistentes e insersão no gráfico

            barra.setValue(arvore_aleatoria1.pesquisa(new Item(1001)), "Aleatório 1000 elementos", "");
            barra.setValue(arvore_aleatoria2.pesquisa(new Item(10001)), "Aleatório 10000 elementos", "");
            barra.setValue(arvore_aleatoria3.pesquisa(new Item(100001)), "Aleatório 100000 elementos", "");
            barra.setValue(arvore_aleatoria4.pesquisa(new Item(1000001)), "Aleatório 1000000 elementos", "");
            barra.setValue(arvore_aleatoria5.pesquisa(new Item(10000001)), "Aleatório 10000000 elementos", "");

            grafico = ChartFactory.createBarChart("Gráfico da quantidade de comparações em função da quantidade de elementos aleatórios", "Quantidade de elementos", "Comparações", barra, PlotOrientation.VERTICAL, true, true, false);

        }else if(flag == 3) {

            //mede o tempo de pesquisa das árvores ordenadas com elementos inexistentes.

            comeco = System.currentTimeMillis();
            arvore1.pesquisa(new Item(1001));
            fim = (System.currentTimeMillis() - comeco);
            barra.setValue(fim, "Ordenado com 1000 elementos", "");

            comeco = System.currentTimeMillis();
            arvore2.pesquisa(new Item(10001));
            fim = (System.currentTimeMillis() - comeco);
            barra.setValue(fim, "Ordenado com 10000 elementos", "");

            comeco = System.currentTimeMillis();
            arvore3.pesquisa(new Item(100001));
            fim = (System.currentTimeMillis() - comeco);
            barra.setValue(fim, "Ordenado com 100000 elementos", "");

            grafico = ChartFactory.createBarChart("Gráfico da quantidade de tempo em função da quantidade de elementos ordenados", "Quantidade de elementos", "tempo de execução em milisegundos", barra, PlotOrientation.VERTICAL, true, true, false);

        }else if(flag == 4) {

            comeco = System.currentTimeMillis();
            arvore_aleatoria1.pesquisa(new Item(523));
            fim = (System.currentTimeMillis() - comeco);
            barra.setValue(fim, "Aleatória com 1000 elementos", "");

            comeco = System.currentTimeMillis();
            arvore_aleatoria2.pesquisa(new Item(5235));
            fim = (System.currentTimeMillis() - comeco);
            barra.setValue(fim, "Aleatória com 10000 elementos", "");

            comeco = System.currentTimeMillis();
            arvore_aleatoria3.pesquisa(new Item(52315));
            fim = (System.currentTimeMillis() - comeco);
            barra.setValue(fim, "Aleatória com 100000 elementos", "");

            comeco = System.currentTimeMillis();
            arvore_aleatoria4.pesquisa(new Item(523672));
            fim = (System.currentTimeMillis() - comeco);
            barra.setValue(fim, "Aleatória com 1000000 elementos", "");

            comeco = System.currentTimeMillis();
            arvore_aleatoria5.pesquisa(new Item(5315662));
            fim = (System.currentTimeMillis() - comeco);
            barra.setValue(fim, "Aleatória com 10000000 elementos", "");

            grafico = ChartFactory.createBarChart("Gráfico da quantidade de tempo em função da quantidade de elementos aleatórios", "Quantidade de elementos", "tempo de execução em milisegundos", barra, PlotOrientation.VERTICAL, true, true, false);

        }


         
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
}
