package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Produto;
import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutoTerceiros;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Vitor
 */
public class ProdutosTerceirosDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(ProdutoTerceiros p){
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
    
    public void remover(ProdutoTerceiros p){
        ProdutoTerceiros aux = em.find(ProdutoTerceiros.class,p.getId());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public void UpdateEstoque(Produto p, Integer qtde){
        Produto aux = em.find(Produto.class,p.getId());
        
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        
        CriteriaUpdate<Produto> update = 
                builder.createCriteriaUpdate(Produto.class);
        
        Root e = update.from(Produto.class);
        
        update.set("Estoque", p.getEstoque()-qtde);
        update.where(builder.equal(e.get("Id"), aux.getId()));
        
        em.getTransaction().begin();
        em.createQuery(update).executeUpdate();
        em.getTransaction().commit();
    }
    
    public ProdutoTerceiros buscarPorCodigo(Integer codigo){
        return em.find(ProdutoTerceiros.class, codigo);
    }
    
    public List<ProdutoTerceiros> buscarTodos(){
        return em.createQuery("from ProdutoTerceiros p").getResultList();
    }
}
