import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra extends JFrame{
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

        //Flag 1 = n x Comparaçoes e arvore ordenada
        //Flag 2 = n x Comparações e arvore aleatoria
        //Flag 3 = n x Tempo Gasto e arvore ordenada
        //Flag 4 = n x Tempo Gasto e arvore aleatoria

        if(flag == 1){

            //criacao de arvore ordenada de 10000 e 100000 elementos

            ArvoreBinaria arvore1 = new ArvoreBinaria();
            for(int i = 1; i <= 10000; i++) 
                arvore1.insere(new Item(i), new No());

            ArvoreBinaria arvore2 = new ArvoreBinaria();
            for(int i = 1; i <= 100000; i++) 
                arvore2.insere(new Item(i), new No());


            barra.setValue(arvore1.pesquisa(new Item(10001)), "Ordenado com 10000 posiçoes", "");

        }



        JFreeChart grafico = ChartFactory.createBarChart("A", "B", "C", barra, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
}
