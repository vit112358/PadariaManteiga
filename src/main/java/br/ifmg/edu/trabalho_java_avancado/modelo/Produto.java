package br.ifmg.edu.trabalho_java_avancado.modelo;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO",
                     discriminatorType = DiscriminatorType.STRING)
public abstract class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Prod_id")
    private Integer Id;
    
    @NotNull
    private String Nome;
    
    private Float precoCusto;
    private Float precoVenda;
    
    private Integer Estoque;
    private Integer EstoqueMin;

    public Produto() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getEstoque() {
        return Estoque;
    }

    public void setEstoque(Integer Estoque) {
        this.Estoque = Estoque;
    }

    public Integer getEstoqueMin() {
        return EstoqueMin;
    }

    public void setEstoqueMin(Integer EstoqueMin) {
        this.EstoqueMin = EstoqueMin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "Id=" + Id + ", Nome=" + Nome + ", precoCusto=" + precoCusto + ", precoVenda=" + precoVenda + ", Estoque=" + Estoque + ", EstoqueMin=" + EstoqueMin + '}';
    }
    
}
