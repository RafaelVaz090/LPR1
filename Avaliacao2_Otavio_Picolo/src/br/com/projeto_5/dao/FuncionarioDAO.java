/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_5.dao;
import java.sql.*;
import br.com.projeto_5.dto.FuncionarioDTO;

/**
 *
 * @author otavi
 */
public class FuncionarioDAO {
    
    /**
     * Método construtor da clase
     */
    public FuncionarioDAO(){    
    }
    
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    /**
     * Método utilizado para inserir um objeto funcionarioDTO no banco de dados
     * @param funcionarioDTO
     * @return 
     */
    public boolean inserirFuncionario(FuncionarioDTO funcionarioDTO) throws SQLException{
        try{
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();

            //Instancia o Statement que será responsável por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into funcionario (nome_fun, cpf_fun, "
                    + "login_fun, senha_fun, tipo_fun) values ( "
                    + "'" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "'" + funcionarioDTO.getCpf_fun().toUpperCase() + "', "
                    + "'" + funcionarioDTO.getLogin_fun().toUpperCase() + "', "
                    + "crypt ('" + funcionarioDTO.getSenha_fun() + "',gen_salt('bf', 8)) , "
                    + "'" + funcionarioDTO.getTipo_fun().toUpperCase() + "') ";

            //Executa o comando SQL no banco de dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o Statement
            stmt.close();
            return true;
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que está acontecendo
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }//Independente de dar erro ou não ele vai fechar o banco de dados
        finally{
            //Chama o metodo de classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método inserirFuncionario
    
    /**
     * Método utilizado para alterar um objeto funcionarioDTO no banco de dados
     * @param funcionarioDTO
     * @return 
     * @throws java.sql.SQLException 
     */
    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO) throws SQLException{
        try{
            //Chama o metodo que está na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que é responspável por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que será executado no banco de dados
            String comando = "";
            
            comando = "Update funcionario set "
                    + "nome_fun = '" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "cpf_fun = '" + funcionarioDTO.getCpf_fun() + "', "
                    + "login_fun = '" + funcionarioDTO.getLogin_fun() + "', ";
            
            if(funcionarioDTO.getSenha_fun() != null){
                comando += "senha_fun = crypt('" + funcionarioDTO.getSenha_fun() + "',gen_salt('bf', 8)), ";
            }
            
            comando += "tipo_fun = '" + funcionarioDTO.getTipo_fun().toUpperCase() + "' "
                    + "where id_fun = " + funcionarioDTO.getId_fun();
            
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
    
    public boolean excluirFuncionario(FuncionarioDTO funcionarioDTO) throws SQLException{
        try{
            ConexaoDAO.ConectDB();
                stmt = ConexaoDAO.con.createStatement();
                String comando = "Delete from funcionario where id_fun = "
                        + funcionarioDTO.getId_fun();

                stmt.execute(comando);
                ConexaoDAO.con.commit();
                stmt.close();
                return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            
            switch(opcao){
                case 1:
                    comando = "Select f.* " +
                              "from funcionario f " +
                              "where nome_fun ilike '" + funcionarioDTO.getNome_fun() + "%' " +
                              "order by f.nome_fun";
                break;
                case 2:
                    comando = "Select f.* " + 
                              "from funcionario f " + 
                              "where f.id_fun = " + funcionarioDTO.getId_fun();
                break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    
    public String logarFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Select f.tipo_fun " +
                             "from Funcionario f " +
                             "where f.login_fun = '" + funcionarioDTO.getLogin_fun() + "'" +
                             " and f.senha_fun = crypt ('" + funcionarioDTO.getSenha_fun() + "', senha_fun)";
            rs = null;
            rs = stmt.executeQuery(comando);
            if(rs.next()){
                return rs.getString("tipo_fun");
            }
            else{
                return "";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
}
