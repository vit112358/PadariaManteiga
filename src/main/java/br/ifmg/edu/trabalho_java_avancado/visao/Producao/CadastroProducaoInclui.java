package br.ifmg.edu.trabalho_java_avancado.visao.Producao;

import br.ifmg.edu.trabalho_java_avancado.modelo.ItemProducao;
import br.ifmg.edu.trabalho_java_avancado.modelo.Producao;
import br.ifmg.edu.trabalho_java_avancado.service.ProducaoService;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import br.ifmg.edu.trabalho_java_avancado.visao.Producao.itensProducao.ProducaoProdutoEdita;
import br.ifmg.edu.trabalho_java_avancado.visao.Producao.itensProducao.ProducaoProdutoInclui;
import br.ifmg.edu.trabalho_java_avancado.visao.Producao.itensProducao.itensProducaoTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
public class CadastroProducaoInclui extends javax.swing.JDialog {

    private ProducaoService pService;
    private List<ItemProducao> itens = new ArrayList<>();
    private itensProducaoTableModel iProducao;

    public CadastroProducaoInclui(JDialog parent, boolean modal, ProducaoService pService) {
        super(parent, modal);
        initComponents();

        this.pService = pService;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dtAtual = sdf.format(new Date());
        jFmtData.setText(dtAtual);
        jFmtData.setEditable(false);

        atualizaDados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jTBBotoes = new javax.swing.JToolBar();
        jBtnIncluir = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnRemover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jFmtData = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jBtnSalva = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Padaria");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Produção"));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableProdutos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTBBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));
        jTBBotoes.setRollover(true);

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.setFocusable(false);
        jBtnIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });
        jTBBotoes.add(jBtnIncluir);

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pencil-edit-button (1).png"))); // NOI18N
        jBtnEditar.setText("Editar");
        jBtnEditar.setFocusable(false);
        jBtnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });
        jTBBotoes.add(jBtnEditar);

        jBtnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remove (2).png"))); // NOI18N
        jBtnRemover.setText("Remover");
        jBtnRemover.setFocusable(false);
        jBtnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverActionPerformed(evt);
            }
        });
        jTBBotoes.add(jBtnRemover);

        jLabel1.setText("Data:");

        jFmtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yy"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTBBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jBtnSalva.setText("Salvar");
        jBtnSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvaActionPerformed(evt);
            }
        });

        jBtnFechar.setText("Fechar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(432, Short.MAX_VALUE)
                .addComponent(jBtnSalva)
                .addGap(30, 30, 30)
                .addComponent(jBtnFechar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSalva)
                    .addComponent(jBtnFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(636, 447));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jBtnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvaActionPerformed

        if (itens == null) {
            JOptionPane.showMessageDialog(this,
                    "Não existem Produtos nessa Produção!");
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this,
                "Confirma a Inclusão?",
                "Incluir registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp != JOptionPane.YES_OPTION) {
            return;
        }

        Producao p = new Producao();

        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = s.parse(jFmtData.getText());
        } catch (ParseException ex) {
            Logger.getLogger(CadastroProducaoInclui.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setDataProducao(d);
        p.setProdutos_feitos(itens);
        itens.forEach((iten) -> {
            iten.setProducao(p);
        });

        for (int i = 0; i < p.getProdutos_feitos().size(); i++) {
            p.getProdutos_feitos().get(i).getProd().setEstoque(
                    p.getProdutos_feitos().get(i).getProd().getEstoque()+p.getProdutos_feitos().get(i).getQtde());
        }
        
        try {
            pService.salvar(p);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_jBtnSalvaActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        ProducaoProdutoInclui dialog = new ProducaoProdutoInclui(this, true, itens);
        dialog.setVisible(true);
        atualizaDados();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverActionPerformed
        if (jTableProdutos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecione um registro");
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this,
                "Confirma a exclusão?",
                "Excluir registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp != JOptionPane.YES_OPTION) {
            return;
        }

        itens.remove(jTableProdutos.getSelectedRow());
        atualizaDados();
    }//GEN-LAST:event_jBtnRemoverActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        if (jTableProdutos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecione um registro");
            return;
        }

        ItemProducao p = itens.get(jTableProdutos.getSelectedRow());
        ProducaoProdutoEdita dialog = new ProducaoProdutoEdita(this, true, p);
        dialog.setVisible(true);
        atualizaDados();
    }//GEN-LAST:event_jBtnEditarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnRemover;
    private javax.swing.JButton jBtnSalva;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jTBBotoes;
    private javax.swing.JTable jTableProdutos;
    // End of variables declaration//GEN-END:variables

    private void atualizaDados() {
        iProducao = new itensProducaoTableModel(itens);
        jTableProdutos.setModel(iProducao);
    }
}
