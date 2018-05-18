package br.ifmg.edu.trabalho_java_avancado.visao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Vendedor;
import br.ifmg.edu.trabalho_java_avancado.service.VendaService;
import br.ifmg.edu.trabalho_java_avancado.service.VendedorService;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;

/**
 *
 * @author Vitor
 */
public class visao {
    
    public static void main(String[] args) throws NegocioException {
        VendedorService v = new VendedorService();
        
        Vendedor v1=v.buscarPorCodigo(2);
        System.out.println(v1.toString());
    }
    
}
