package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Adm;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class AdmDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    /**
     * Esta função salva um Administrador do Sistema no Banco de Dados
     * 
     * @param a Administrador a ser salvo
     */
    public void salvar(Adm a){
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }
    
    /**
     * Esta função remove um Administrador do Sistema no Banco de Dados
     * 
     * @param a Administrador a ser Removido
     */
    public void remover(Adm a){
        Adm aux = em.find(Adm.class,a.getID());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    /**
     * Esta função busca um dado Administrador
     * 
     * @param codigo código do Administrador
     * @return Administrador
     */
    public Adm buscarPorCodigo(Integer codigo){
        return em.find(Adm.class, codigo);
    }
    
    /**
     *  Esta função busca todos os Administradores Cadastrados
     * 
     * @return Lista de Administradores
     */
    public List<Adm> buscarTodos(){
        return em.createQuery("from Adm a").getResultList();
    }
    
    /**
     * Esta função valida o login de um Administrador
     * 
     * @param login Login do Administrador
     * @param senha Senha do Administrador
     * @return Administrador
     */
    public Adm isLoginValido(String login, String senha){
        
        String sql = "Select u from Adm u "
                   + "where u.login = ?1 and u.senha = ?2";
        
        Adm user = em.createQuery(sql, Adm.class)
                         .setParameter("1", login)
                         .setParameter("2", senha)
                         .getSingleResult();
        
        if (user != null)
           return user;       
        
        return null;
        
    }
    
}
