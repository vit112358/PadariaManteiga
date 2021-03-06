package br.ifmg.edu.trabalho_java_avancado.service;

import br.ifmg.edu.trabalho_java_avancado.dao.ProducaoDAO;
import br.ifmg.edu.trabalho_java_avancado.modelo.Producao;
import br.ifmg.edu.trabalho_java_avancado.modelo.Produto;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class ProducaoService {
    
    ProducaoDAO fabDAO = new ProducaoDAO();

    public void salvar(Producao v) throws NegocioException {
        if (v.getDataProducao() == null || v.getProdutos_feitos() == null) {
            throw new NegocioException("Verifique o Usuário! Ele pode não possuir "
                    + "Data ou Produtos.");
        }

        fabDAO.salvar(v);
    }

    public void remover(Producao f) {
        fabDAO.remover(f);
    }

    public Producao buscarPorCodigo(Integer codigo) {
        return fabDAO.buscarPorCodigo(codigo);
    }
    
    public void UpdateEstoqueProducao(Produto p, Integer qtd) throws NegocioException{
        if(qtd <= 0){
            throw new NegocioException("Quantidade Inválida! Para Registrar uma Produção, "
                    + "deve se cadastrar uma quantidade maior que zero.");
        }
        
        fabDAO.UpdateEstoque(p, qtd);
    }

    public List<Producao> buscarTodos() {
        return fabDAO.buscarTodos();
    }

    public List<Integer> buscarNum_itens() {
        return fabDAO.buscaNumItens();
    }
}
