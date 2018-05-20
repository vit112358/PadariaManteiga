package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Fornecedor;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class FornecedorDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    /**
     * Esta função salva um Fornecedor no Banco de Dados
     * 
     * @param f Fornecedor a ser salvo
     */
    public void salvar(Fornecedor f){
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }
    
    /**
     * Esta função remove um Fornecedor no Banco de Dados
     * 
     * @param f Fornecedor a ser removido
     * 
     * @return true se for removido, caso contrário false
     */
    public boolean remover(Fornecedor f){
        Fornecedor aux = em.find(Fornecedor.class,f.getID());
        if (aux != null){
            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();
            return true;            
        }
        else
            return false;          
    }
    
    /**
     * Esta função busca um dado Fornecedor 
     * 
     * @param codigo código do Fornecedor
     * @return Fornecedor
     */
    public Fornecedor buscarPorCodigo(Integer codigo){
        return em.find(Fornecedor.class, codigo);
    }
    
    /**
     * Esta função busca todos os Fornecedores Cadastrados por Código
     * 
     * @return Lista de Fornecedores
     */
    public List<Fornecedor> buscarTodos(){
        String sql = "from " + "Fornecedor" + " v";
        List<Fornecedor> v = em.createQuery(sql).getResultList();
        return v;
    }
    
    /**
     * Esta função busca todos os Fornecedores Cadastrados por Razaão Social
     * 
     * @param nome Razao Social
     * @return Fornecedor
     */
    public Fornecedor getFornecedorPeloNome(String nome){
        
        String sql = "Select c from Fornecedor c "
                   + "where c.razaoSocial like ?1";
        
        
        return em.createQuery(sql, Fornecedor.class)
                .setParameter("1", nome)
                .getSingleResult();  
    }
}
