package br.ifmg.edu.trabalho_java_avancado.visao.Producao.itensProducao;

import br.ifmg.edu.trabalho_java_avancado.modelo.ItemProducao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class itensProducaoTableModel extends AbstractTableModel {

    private List<ItemProducao> produtos;
    private String[] cols = {"Código", "Nome", "Quantidade"};

    public itensProducaoTableModel(List<ItemProducao> produtos) {
        this.produtos = produtos;
    }

    public itensProducaoTableModel(List<ItemProducao> produtos, String[] cols) {
        this.produtos = produtos;
        this.cols = cols;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (cols.length == 3) {
            switch (columnIndex) {
                case 0:
                    return produtos.get(rowIndex).getID();
                case 1:
                    return produtos.get(rowIndex).getProd().getNome();
                case 2:
                    return produtos.get(rowIndex).getQtde();
            }
        } else if (cols.length == 2) {
            switch (columnIndex) {
                case 0:
                    return produtos.get(rowIndex).getProd().getNome();
                case 1:
                    return produtos.get(rowIndex).getQtde();
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) {
            return;
        }

        if (cols.length == 3) {
            switch (columnIndex) {
                case 0:
                    produtos.get(rowIndex).setID((Integer) aValue);
                    break;
                case 1:
                    produtos.get(rowIndex).getProd().setNome((String) aValue);
                    break;
                case 2:
                    produtos.get(rowIndex).setQtde((Integer) aValue);
                    break;
            }
        } else if (cols.length == 2) {
            switch (columnIndex) {
                case 0:
                    produtos.get(rowIndex).getProd().setNome((String) aValue);
                    break;
                case 1:
                    produtos.get(rowIndex).setQtde((Integer) aValue);
                    break;
            }
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void addRow(ItemProducao a) {
        produtos.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha) {
        produtos.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
}
