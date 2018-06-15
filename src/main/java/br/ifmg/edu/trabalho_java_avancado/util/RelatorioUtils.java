package br.ifmg.edu.trabalho_java_avancado.util;

import br.ifmg.edu.trabalho_java_avancado.visao.Relatorios.RelatorioVenda;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Vitor
 */
public class RelatorioUtils {
    
    public void GeraRelatorio(String resource, String nome){
        Connection mySQLConnection = null;
        JasperPrint jp = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria-java", "root", "1234");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        InputStream relatorio = RelatorioVenda.class.getResourceAsStream(resource);
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("ParametersInativo", Boolean.TRUE);
        try {

            jp = JasperFillManager.fillReport(relatorio, parameters,mySQLConnection);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Escolha o Diretório");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);//disabilitando o modo "All-files"
        //instanciações do JFileChooser

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());

        } else {
            System.out.println("Sem Seleção");
        }
        
        String caminho = chooser.getSelectedFile().toString();
        System.out.println(caminho);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, caminho+File.separator+nome);
        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VisualizaRelatorio(String resource){
        Connection mySQLConnection = null;
        JasperPrint jp = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria-java", "root", "1234");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        InputStream relatorio = RelatorioVenda.class.getResourceAsStream(resource);
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("ParametersInativo", Boolean.TRUE);
        try {

            jp = JasperFillManager.fillReport(relatorio, parameters,mySQLConnection);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.show();
    }
    
    public void GeraRelatorioParametro(String resource, String nome, HashMap<String, Object> parametros){
        Connection mySQLConnection = null;
        JasperPrint jp = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria-java", "root", "1234");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        InputStream relatorio = RelatorioVenda.class.getResourceAsStream(resource);
        //Map<String, Object> parameters = new LinkedHashMap<>();
        //parameters.put("ParametersInativo", Boolean.TRUE);
        try {

            jp = JasperFillManager.fillReport(relatorio, parametros,mySQLConnection);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Escolha o Diretório");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);//disabilitando o modo "All-files"
        //instanciações do JFileChooser

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());

        } else {
            System.out.println("Sem Seleção");
        }
        
        String caminho = chooser.getSelectedFile().toString();
        System.out.println(caminho);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, caminho+File.separator+nome);
        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VisualizaRelatorioParametro(String resource, HashMap<String, Object> parametros){
        Connection mySQLConnection = null;
        JasperPrint jp = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria-java", "root", "1234");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        InputStream relatorio = RelatorioVenda.class.getResourceAsStream(resource);

        try {
            jp = JasperFillManager.fillReport(relatorio, parametros, mySQLConnection);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.show();
    }
    
}
