package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Producao;
import br.ifmg.edu.trabalho_java_avancado.modelo.Produto;
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
public class ProducaoDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(Producao a){
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }
    
    public void remover(Producao a){
        Producao aux = em.find(Producao.class,a.getId());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public Producao buscarPorCodigo(Integer codigo){
        return em.find(Producao.class, codigo);
    }
    
    public List<Producao> buscarTodos(){
        return em.createQuery("from Producao a").getResultList();
    }
    
    public void UpdateEstoque(Produto p, Integer qtde){
        Produto aux = em.find(Produto.class,p.getId());
        
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        
        CriteriaUpdate<Produto> update = 
                builder.createCriteriaUpdate(Produto.class);
        
        Root e = update.from(Produto.class);
        
        update.set("Estoque", p.getEstoque()+qtde);
        update.where(builder.equal(e.get("Id"), aux.getId()));
        
        em.getTransaction().begin();
        em.createQuery(update).executeUpdate();
        em.getTransaction().commit();
    }
    
    public List<Integer> buscaNumItens(){
        /*
        select Sum(QTDE) from producao join 
        itemproducao on(Producao_Id = Cod_producao) group by(Cod_producao);
        */
        String sql = "Select sum(i.Qtde) from Producao p "
                + "join p.itens i "
                + "group by p";
        
        List<Integer> resultado = em.createQuery(sql).getResultList();
        
        return resultado;
    }
}
