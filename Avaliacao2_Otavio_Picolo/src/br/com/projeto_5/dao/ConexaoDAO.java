/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_5.dao;
import java.sql.*;
/**
 *
 * @author paulo
 */
public class ConexaoDAO {
    public static Connection con = null;

    public static void ConectDB() {
        try {
            // Dados para conectar com o banco de dados Postgres
            String dsn = "Projeto_5"; // nome do banco de dados (igual ao criado no Postgres)
            String user = "postgres"; // nome do usuário utilizado para se conectar
            String senha = "@Harmonia05"; // senha do usuário acima informado  (Antes era postdba, porém como já tenho o pgadmin instalado, é outra senha)
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url = "jdbc:postgresql://localhost:5432/" + dsn;
            
            con = DriverManager.getConnection(url, user, senha);
            
            
            con.setAutoCommit(false);
            if (con == null) {
                System.out.println("erro ao abrir o banco");
            }
        } catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados! " + e.getMessage());
        }
    }
    public static void CloseDB(){
        try{
            con.close();
        }

        catch (Exception e){
            System.out.println("Problema ao fechar a base de dados! " + 
                    e.getMessage());
        }

    }
    
    public static Connection ConnectDBRels(){
        ConectDB();
        return con;
    }
}


