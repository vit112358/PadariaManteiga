package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Venda;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
        //return em.createQuery("from Venda v").getResultList();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Venda> criteriaQuery = builder.createQuery(Venda.class);
        criteriaQuery.from(Venda.class);
        
        List<Venda> vendas = em.createQuery(criteriaQuery).getResultList();
        return vendas;
    }
}
