package br.ifmg.edu.trabalho_java_avancado.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Vitor
 */
@Entity
@DiscriminatorValue("Produto_Produzido")
public class ProdutoProduzido extends Produto{
    
    @OneToMany(mappedBy = "produto",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Itens> materiaisUsados = new LinkedList<Itens>();
    
    public ProdutoProduzido() {
    }

    public List<Itens> getMateriaisUsados() {
        return materiaisUsados;
    }

    public void setMateriaisUsados(List<Itens> materiaisUsados) {
        this.materiaisUsados = materiaisUsados;
    }

    @Override
    public String toString() {
        return super.getNome();
    }
}
