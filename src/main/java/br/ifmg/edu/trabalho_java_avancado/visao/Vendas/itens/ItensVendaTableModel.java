package br.ifmg.edu.trabalho_java_avancado.visao.Vendas.itens;

import br.ifmg.edu.trabalho_java_avancado.modelo.VendaProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class ItensVendaTableModel extends AbstractTableModel {

    private List<VendaProduto> dados;
    private String[] colunas = {"Produto", "Qtde", "Valor", "Total"};

    public ItensVendaTableModel(List<VendaProduto> dados) {
        this.dados = dados;
    }

    public ItensVendaTableModel(List<VendaProduto> dados, String[] colunas) {
        this.dados = dados;
        this.colunas = colunas;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dados.get(rowIndex).getProduto();
            case 1:
                return dados.get(rowIndex).getQtde();
            case 2:
                return dados.get(rowIndex).getValor();
            case 3:
                return dados.get(rowIndex).getTotal();
        }
        return null;
    }

    public void addRow(VendaProduto a) {
        dados.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha) {
        dados.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}
