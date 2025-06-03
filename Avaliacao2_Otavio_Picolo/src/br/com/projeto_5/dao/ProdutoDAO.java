/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_5.dao;
import java.sql.*;
import br.com.projeto_5.dto.FornecedorDTO;
import br.com.projeto_5.dto.ProdutoDTO;
import java.text.SimpleDateFormat;

/**
 *
 * @author otavi
 */
public class ProdutoDAO {
    public ProdutoDAO() {
    }
    SimpleDateFormat data_format = new SimpleDateFormat("dd/mm/yyyy");

    private ResultSet rs = null;

    //manipular o banco de dados
    private Statement stmt = null;
    
    public boolean inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
    //chama o metodo que esta na classe conexaoDAO
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Insert into produto (nome_prod, desc_prod, cod_bar_prod, "
                    + "p_custo_prod, p_venda_prod, data_cad_prod, categoria_prod, "
                    + "marca_prod, quantidade_prod, id_for) values ( "
                    + "'" + produtoDTO.getNome_prod() + "', "
                    + "'" + produtoDTO.getDesc_prod() + "', "
                    + "'" + produtoDTO.getCod_bar_prod() + "', "
                    + produtoDTO.getP_custo_prod() + ", "
                    + produtoDTO.getP_venda_prod() + ", "
                    + "to_date('" + data_format.format(produtoDTO.getData_cad_prod()) + "', 'dd/mm/yyyy'), "
                    + "'" + produtoDTO.getCategoria_prod() + "', "
                    + "'" + produtoDTO.getMarca_prod() + "', "
                    + produtoDTO.getQuantidade_prod() + ", "
                    + fornecedorDTO.getId_for() + ")";

            //Executa o comando no banco de dados
            stmt.execute(comando.toUpperCase());

            //Da um commit (Registrar) no bando de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    } // Fecha o método inserirProduto

    
    public boolean alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
    //chama o metodo que esta na classe conexaoDAO
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Update produto set "
                    + "nome_prod = '" + produtoDTO.getNome_prod() + "', "
                    + "desc_prod = '" + produtoDTO.getDesc_prod() + "', "
                    + "cod_bar_prod = '" + produtoDTO.getCod_bar_prod() + "', "
                    + "p_custo_prod = " + produtoDTO.getP_custo_prod() + ", "
                    + "p_venda_prod = " + produtoDTO.getP_venda_prod() + ", "
                    + "data_cad_prod = to_date('" + data_format.format(produtoDTO.getData_cad_prod()) + "', 'dd/mm/yyyy'), "
                    + "categoria_prod = '" + produtoDTO.getCategoria_prod() + "', "
                    + "marca_prod = '" + produtoDTO.getMarca_prod() + "', "
                    + "quantidade_prod = " + produtoDTO.getQuantidade_prod() + ", "
                    + "id_for = " + fornecedorDTO.getId_for() + " "
                    + "where id_prod = " + produtoDTO.getId_prod();

            //Executa o comando no banco de dados
            stmt.execute(comando.toUpperCase());

            //Da um commit (Registrar) no bando de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    } // Fecha o método alterarProduto

    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "Select p.* from produto p where p.nome_prod ilike '" + produtoDTO.getNome_prod() + "%' order by p.nome_prod";
                    break;

                case 2:
                    comando = "Select p.*, f.nome_for, f.id_for from produto p, fornecedor f where p.id_for = f.id_for and p.id_prod = " + produtoDTO.getId_prod();
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public boolean excluirProduto(ProdutoDTO produtoDTO) {
        //chama o metodo que esta na classe conexaoDAO
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Delete from produto where id_prod = " + produtoDTO.getId_prod();

            //Executa o comando no banco de dados
            stmt.execute(comando);

            //Da um commit (Registrar) no bando de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }  // Fecha  o método excluirProduto
}

