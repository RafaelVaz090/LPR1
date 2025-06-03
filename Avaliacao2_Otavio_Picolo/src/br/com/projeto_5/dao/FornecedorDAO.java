/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_5.dao;
import br.com.projeto_5.dto.FornecedorDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author otavi
 */
public class FornecedorDAO {
    
    SimpleDateFormat data_format = new SimpleDateFormat("dd/mm/yyyy");
    //Atibuto do tipo ResultSet utilizado para realizar consultas;
    private ResultSet rs = null;
    //manipular o banco de dados
    private Statement stmt = null;
    
    public boolean inserirFornecedor(FornecedorDTO fornecedorDTO){
        //chama o metodo que esta na classe conexaoDAO
        try{
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Insert into fornecedor (nome_for, cnpj_for, tel_for, email_for, logradouro_for, numero_for, "
                    + "bairro_for, cidade_for, estado_for, cep_for, tipo_produto_for, data_cad_for) values ( "
                    + "'" + fornecedorDTO.getNome_for() + "', "
                    + "'" + fornecedorDTO.getCnpj_for() + "', "
                    + "'" + fornecedorDTO.getTel_for() + "', "
                    + "'" + fornecedorDTO.getEmail_for() + "', "
                    + "'" + fornecedorDTO.getLogradouro_for() + "', "
                    + "'" + fornecedorDTO.getNumero_for() + "', "
                    + "'" + fornecedorDTO.getBairro_for() + "', "
                    + "'" + fornecedorDTO.getCidade_for() + "', "
                    + "'" + fornecedorDTO.getEstado_for() + "', "
                    + "'" + fornecedorDTO.getCep_for() + "', "
                    + "'" + fornecedorDTO.getTipo_produto_for() + "', "
                    + "to_date('" + data_format.format(fornecedorDTO.getData_cad_for()) + "','dd/mm/yyyy')) ";

            //Executa o comando no banco de dados
            stmt.execute(comando.toUpperCase());

            //Da um commit (Registrar) no bando de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao){

        try{
            //chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL
            String comando = "";
            switch(opcao){
                case 1:
                    comando = "Select f.id_for, f.nome_for "
                            + "from fornecedor f "
                            + "where f.nome_for like '"+fornecedorDTO.getNome_for()+"%' "
                            + "order by f.nome_for";
                break;
                case 2:
                    comando = "Select f.nome_for, f.cnpj_for, f.tel_for, f.email_for, f.logradouro_for, f.numero_for, "
                            + "f.bairro_for, f.cidade_for, f.estado_for, f.cep_for, f.tipo_produto_for, "
                            + "to_char(f.data_cad_for, 'dd/mm/yyyy') as data_cad_for "
                            + "from fornecedor f "
                            + "where f.id_for = "+fornecedorDTO.getId_for();
                break;
                }
            //execute o comando SQL no banco de dados;
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public boolean alterarFornecedor(FornecedorDTO fornecedorDTO){
        //chama o metodo que esta na classe conexaoDAO
        try{
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Update fornecedor set "
                    + "nome_for = '"+fornecedorDTO.getNome_for()+"', "
                    + "cnpj_for = '"+fornecedorDTO.getCnpj_for()+"', "
                    + "tel_for = '"+fornecedorDTO.getTel_for()+"', "
                    + "email_for = '"+fornecedorDTO.getEmail_for()+"', "
                    + "logradouro_for = '"+fornecedorDTO.getLogradouro_for()+"', "
                    + "numero_for = '"+fornecedorDTO.getNumero_for()+"', "
                    + "bairro_for = '"+fornecedorDTO.getBairro_for()+"', "
                    + "cidade_for = '"+fornecedorDTO.getCidade_for()+"', "
                    + "estado_for = '"+fornecedorDTO.getEstado_for()+"', "
                    + "cep_for = '"+fornecedorDTO.getCep_for()+"', "
                    + "tipo_produto_for = '"+fornecedorDTO.getTipo_produto_for()+"', "
                    + "data_cad_for = to_date('"+data_format.format(fornecedorDTO.getData_cad_for())+"','dd/mm/yyyy') "
                    + "where id_for = "+fornecedorDTO.getId_for();

            //Executa o comando no banco de dados
            stmt.execute(comando.toUpperCase());

            //Da um commit (Registrar) no bando de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }

     public boolean excluirFornecedor(FornecedorDTO fornecedorDTO){
        //chama o metodo que esta na classe conexaoDAO
        try{
        ConexaoDAO.ConectDB();
        
        stmt = ConexaoDAO.con.createStatement();
        
        String comando = "Delete from fornecedor where id_for = "+fornecedorDTO.getId_for();
        
        //Executa o comando no banco de dados
        stmt.execute(comando);
            
            //Da um commit (Registrar) no bando de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
}
