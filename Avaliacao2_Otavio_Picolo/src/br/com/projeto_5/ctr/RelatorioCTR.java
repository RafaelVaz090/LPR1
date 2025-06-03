/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_5.ctr;
import java.sql.*;
import br.com.projeto_5.dao.ConexaoDAO;
import java.io.InputStream;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author otavi
 */
public class RelatorioCTR {
    
    public RelatorioCTR(){
        
    }
    
    public JFrame abrirRelatorio(String relatorio, String titulo, Map parametros){
        try{
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("br/com/projeto_5/rels/"+relatorio);
            
            JasperPrint print = JasperFillManager.fillReport(inputStream, parametros,getConexao());
            
            CloseDB();
            
            JRViewer viewer = new JRViewer(print);
            
            JFrame frameRelatorio = new JFrame(titulo);
            
            frameRelatorio.add(viewer);
            
            frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            return frameRelatorio;
        }
        catch(Exception e){
            System.out.println("Entrou erro metodo abrirRelatorio");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Connection getConexao(){
        return ConexaoDAO.ConnectDBRels();
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
