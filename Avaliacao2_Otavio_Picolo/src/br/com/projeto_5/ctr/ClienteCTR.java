/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_5.ctr;
import java.sql.ResultSet;
import br.com.projeto_5.dto.ClienteDTO;
import br.com.projeto_5.dao.ClienteDAO;
import br.com.projeto_5.dao.ConexaoDAO;
/**
 *
 * @author paulo
 */
public class ClienteCTR {
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public ClienteCTR(){
    }
    
    //Método para inserir cliente
    public String inserirCliente(ClienteDTO clienteDTO){
        try{
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(clienteDAO.inserirCliente(clienteDTO)){
                return "Cliente Cadastrado com Sucesso!!!";
            }else{
                return "Cliente NÃO Cadastrado!!!";
            }
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que ocorreu
    catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO Cadastrado";
        }  
    }//fecha inserirCliente
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        
        //o atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        
        return rs;
    }//Fecha ResultSet...
    
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }//Fecha método CloseDB
    
    public String alterarCliente(ClienteDTO clienteDTO){
        try{
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(clienteDAO.alterarCliente(clienteDTO)){
                return "Cliente alterado com Sucesso!!!";
            }else{
                return "Cliente NÃO alterado!!!";
            }
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que ocorreu
    catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO alterado";
        }  
    }
    
    public String excluirCliente(ClienteDTO clienteDTO){
        try{
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(clienteDAO.excluirCliente(clienteDTO)){
                return "Cliente excluído com Sucesso!!!";
            }else{
                return "Cliente NÃO excluído!!!";
            }
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que ocorreu
    catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO excluído";
        }  
    }
    
    
}//fecha classe 
