/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_5.ctr;

import br.com.projeto_5.dao.ConexaoDAO;
import br.com.projeto_5.dao.ProdutoDAO;
import br.com.projeto_5.dto.ProdutoDTO;
import br.com.projeto_5.dto.FornecedorDTO;
import java.sql.ResultSet;
/**
 *
 * @author leonardo-teixeira
 */
public class ProdutoCTR {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
//    Método construtor da classe
    public ProdutoCTR() {
    }
    
    public String inserirProduto(  ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)){
                return "Produto Cadastro com Sucesso!!";
            }else{
                return "Produto NÃO cadastrado";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO cadastrado!!";
        }
    } //Fecha o metodo inserirProduto
    
    public ResultSet consultarFornecedor(ProdutoDTO produtoDTO, int opcao) {
        
        ResultSet rs = null;
        
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        
        return rs;
    } //fecha o meotodo consultarProduto
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }

    public String alterarProduto( ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)){
                return "Produo Alterado com Sucesso!!";
            }else{
                return "Produto NÃO Alterado";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO alterado!!";
        }
    }//Fecha o metodo alterarProduto
    
    public ResultSet consultarProduto(ProdutoDTO produtoDTO,  int opcao){
        ResultSet rs = null;
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        return rs;          
    }
    
    public String excluirProduto(ProdutoDTO produtoDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(produtoDAO.excluirProduto(produtoDTO)){
                return "Produto Excluído com Sucesso!!";
            }else{
                return "Produto NÃO Excluído";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO deletado!!";
        }
    } // fecha o metodo alterarProduto
}
