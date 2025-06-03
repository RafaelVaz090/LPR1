/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_5.dto;
import java.util.Date;
/**
 *
 * @author otavi
 */
public class ProdutoDTO {
    private int id_prod;
    private String nome_prod, desc_prod, cod_bar_prod;
    private double p_custo_prod, p_venda_prod, quantidade_prod;
    private Date data_cad_prod;
    private String categoria_prod, marca_prod;

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNome_prod() {
        return nome_prod;
    }

    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public String getDesc_prod() {
        return desc_prod;
    }

    public void setDesc_prod(String desc_prod) {
        this.desc_prod = desc_prod;
    }

    public String getCod_bar_prod() {
        return cod_bar_prod;
    }

    public void setCod_bar_prod(String cod_bar_prod) {
        this.cod_bar_prod = cod_bar_prod;
    }

    public double getP_custo_prod() {
        return p_custo_prod;
    }

    public void setP_custo_prod(double p_custo_prod) {
        this.p_custo_prod = p_custo_prod;
    }

    public double getP_venda_prod() {
        return p_venda_prod;
    }

    public void setP_venda_prod(double p_venda_prod) {
        this.p_venda_prod = p_venda_prod;
    }

    public double getQuantidade_prod() {
        return quantidade_prod;
    }

    public void setQuantidade_prod(double quantidade_prod) {
        this.quantidade_prod = quantidade_prod;
    }

    public Date getData_cad_prod() {
        return data_cad_prod;
    }

    public void setData_cad_prod(Date data_cad_prod) {
        this.data_cad_prod = data_cad_prod;
    }

    public String getCategoria_prod() {
        return categoria_prod;
    }

    public void setCategoria_prod(String categoria_prod) {
        this.categoria_prod = categoria_prod;
    }

    public String getMarca_prod() {
        return marca_prod;
    }

    public void setMarca_prod(String marca_prod) {
        this.marca_prod = marca_prod;
    }
    
}
