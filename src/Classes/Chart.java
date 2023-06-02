/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Rolando
 */
public class Chart extends ApplicationFrame {
    
    private DefaultCategoryDataset dataset;
    private PlantDirector director;
    private JFrame frame;
    
    public Chart(PlantDirector director) {
        
        
      super("Total Profit vs Time");
      this.frame = new JFrame();
      this.director = director;
      JFreeChart lineChart = ChartFactory.createLineChart(
         "Total Profit vs Time",
         "Time (Days)","Total Profit (Millions $)",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
      
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
      
      this.frame.add(chartPanel);

   }

   private DefaultCategoryDataset createDataset( ) {
        this.dataset = new DefaultCategoryDataset( );
        
        dataset.addValue(0, "Total Profit", Integer.toString(0));
        
//      dataset.addValue( 15 , "schools" , "1970" );
//      dataset.addValue( 30 , "schools" , "1980" );
//      dataset.addValue( 60 , "schools" ,  "1990" );
//      dataset.addValue( 120 , "schools" , "2000" );
//      dataset.addValue( 240 , "schools" , "2010" );
//      dataset.addValue( 300 , "schools" , "2014" );
//      
      return dataset;
   }
   
   public void updateDataset(int loot) {
       
       this.dataset.addValue(director.getUtility(), "Total Profit", Integer.toString(loot));
   }
   
   public void displayChart() {
       this.frame.pack();
       this.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       this.frame.setVisible(true);
   }
}

    

