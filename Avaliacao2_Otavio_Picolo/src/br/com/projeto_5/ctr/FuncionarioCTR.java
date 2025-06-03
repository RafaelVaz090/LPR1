/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_5.ctr;
import java.sql.ResultSet;
import br.com.projeto_5.dto.FuncionarioDTO;
import br.com.projeto_5.dao.FuncionarioDAO;
import br.com.projeto_5.dao.ConexaoDAO;

/**
 *
 * @author otavi
 */
public class FuncionarioCTR {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public FuncionarioCTR(){
        
    }
    
    public String inserirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            if(funcionarioDAO.inserirFuncionario(funcionarioDTO)){
                return "Funcionário Cadastrado com sucesso!!!";
            }
            else{
                return "Funcionário não cadastrado!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Funcionario NÃo Cadastrado";
        }
    }
    
    public String alterarFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            if(funcionarioDAO.alterarFuncionario(funcionarioDTO)){
                return "Funcionário alterado com sucesso!!!";
            }
            else{
                return "Funcionário não alterado!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Funcionário NÃO alterado";
        }
    }
    
    public String excluirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            if(funcionarioDAO.excluirFuncionario(funcionarioDTO)){
                return "Funcionario excluído com sucesso!!!";
            }
            else{
                return "Funcionario não excluído!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Funcionario NÃO excluído!!!";
        }
    }
    
    public ResultSet ConsultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao){
        ResultSet rs = null;
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);
        return rs;
    }
    
    public String logarFuncionario(FuncionarioDTO funcionarioDTO){
        return funcionarioDAO.logarFuncionario(funcionarioDTO);
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
