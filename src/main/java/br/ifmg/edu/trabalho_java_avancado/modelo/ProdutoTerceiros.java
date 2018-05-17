/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.modelo;

import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vitor
 */
@Entity
@DiscriminatorValue("Produtos_Terceiros")
public class ProdutoTerceiros extends Produto {

    //Verificar colocar Estoque
    @ManyToOne
    @JoinColumn(name = "Fornecedor_Id")
    private Fornecedor fornecedor_prod;

    public ProdutoTerceiros() {
    }

    public ProdutoTerceiros(Fornecedor fornecedor_prod) {
        super();
        this.fornecedor_prod = fornecedor_prod;
    }

    
    public Fornecedor getFornecedor() {
        return fornecedor_prod;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor_prod = fornecedor;
    }

    @Override
    public String toString() {
        return super.getNome();
    }

    
}
