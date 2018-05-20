package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Venda;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class VendaDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(Venda v){
        em.getTransaction().begin();
        em.merge(v);
        em.getTransaction().commit();
    }
    
    public void remover(Venda v){
        Venda aux = em.find(Venda.class,v.getID());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public Venda buscarPorCodigo(Integer codigo){
        return em.find(Venda.class, codigo);
    }
    
    public List<Venda> buscarTodos(){
        return em.createQuery("from Venda v").getResultList();
    }

    public void UpdateEstoque(Venda v){
        /*
        Update venda join vendaproduto on (Venda_Id = vendaproduto.codVenda) 
        join produto on (vendaproduto.codProduto = produto.Prod_id) 
        SET ESTOQUE = produto.ESTOQUE+vendaproduto.QTDE
        where venda.Venda_Id=1;
        */
        String sql = "Upda";
    }
}
