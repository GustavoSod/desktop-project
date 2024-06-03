package com.mycompany.projetofaculdade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UserModel;

public class OcorrenciasFrame extends javax.swing.JFrame {

    private final String url = "jdbc:mysql://localhost:3306/db_projeto";
    private final String usuarioBD = "root";
    private final String senhaBD = "12345678";
    
    private Connection conexao = null;
    private UserModel user;

    public OcorrenciasFrame(UserModel user) {
        initComponents();
        this.user = user;
        try {
            conexao = DriverManager.getConnection(url, usuarioBD, senhaBD);
            System.out.println("conectou ao banco de dados: ");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        jLabel8.setText("Bem vindo, " + user.getNome());
        OccurrencesSent();
        OccurrencesReceived();
    }
    
    private void OccurrencesReceived() {
        try {
            Connection conexao = DriverManager.getConnection(url, usuarioBD, senhaBD);
            String sql = "SELECT * FROM occurrences_received";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0); // Limpa os dados existentes na tabela
            
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String local = resultSet.getString("local");
                String tipoVeiculo = resultSet.getString("vehicle");
                String gravidade = resultSet.getString("severity");
                String horario = resultSet.getString("time");
                
                model.addRow(new Object[]{id, local, tipoVeiculo, gravidade, horario});
            }
            
            resultSet.close();
            statement.close();
            conexao.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void OccurrencesSent() {
        try {
            Connection conexao = DriverManager.getConnection(url, usuarioBD, senhaBD);
            String sql = "SELECT * FROM occurrences_sent";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
            model.setRowCount(0); // Limpa os dados existentes na tabela
            
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String local = resultSet.getString("local");
                String tipoVeiculo = resultSet.getString("vehicle");
                String gravidade = resultSet.getString("severity");
                String horario = resultSet.getString("time");
                
                model.addRow(new Object[]{id, local, tipoVeiculo, gravidade, horario});
            }
            
            resultSet.close();
            statement.close();
            conexao.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Ocorrências Recebidas:");
        jLabel3.setToolTipText("");

        jScrollPane3.setBackground(new java.awt.Color(51, 51, 51));

        jTable3.setBackground(new java.awt.Color(51, 51, 51));
        jTable3.setForeground(new java.awt.Color(204, 204, 204));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Rua tal", "Carro", "Grave", "15:30"},
                {"2", "Rua tal 2", "Carro", "Leve", "22:12"},
                {"3", "Rua tal 3", "Moto", "Médio", "00:43"},
                {"4", "Av tal 100", "Caminhão", "Médio", "9:45"},
                {"5", "Av tal 111", "Moto", "Leve", "1:32"},
                {"6", "Av tal 540", "Carro", "Leve", "9:45"},
                {"7", "Av tal 103", "Carro", "Leve", "00:43"},
                {"8", "Av tal 1", "Carro", "Grave", "22:12"},
                {"9", "Av tal 090", "Carro", "Grave", "9:45"},
                {"10", "Av tal 110", "Carro", "Leve", "00:43"},
                {"11", "Av tal 20", "Carro", "Grave", "1:32"},
                {"12", "Av tal 1500", "Carro", "Leve", "1:32"},
                {"13", "Av tal 1500", "Moto", "Leve", "00:43"},
                {"14", "Av tal 1500", "Moto", "Grave", "00:43"},
                {"15", "Av tal 1500", "Caminhão", "Grave", "00:43"},
                {"16", "Av tal 1500", "Moto", "Leve", "00:43"},
                {"17", "Av tal 1500", "Moto", "Grave", "00:43"}
            },
            new String [] {
                "Id", "Local", "Tipo de veículo", "Gravidade", "Horário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Ocorrências Enviadas");
        jLabel9.setToolTipText("");

        jTable4.setBackground(new java.awt.Color(51, 51, 51));
        jTable4.setForeground(new java.awt.Color(204, 204, 204));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Rua tal", "Carro", "Grave", "15:30"},
                {"2", "Rua tal 2", "Carro", "Leve", "22:12"},
                {"3", "Rua tal 3", "Moto", "Médio", "00:43"},
                {"4", "Av tal 100", "Caminhão", "Médio", "9:45"},
                {"5", "Av tal 111", "Moto", "Leve", "1:32"},
                {"6", "Av tal 540", "Carro", "Leve", "9:45"},
                {"7", "Av tal 103", "Carro", "Leve", "00:43"},
                {"8", "Av tal 1", "Carro", "Grave", "22:12"},
                {"9", "Av tal 090", "Carro", "Grave", "9:45"},
                {"10", "Av tal 110", "Carro", "Leve", "00:43"},
                {"11", "Av tal 20", "Carro", "Grave", "1:32"},
                {"12", "Av tal 1500", "Carro", "Leve", "1:32"},
                {"13", "Av tal 1500", "Moto", "Leve", "00:43"},
                {"14", "Av tal 1500", "Moto", "Grave", "00:43"},
                {"15", "Av tal 1500", "Caminhão", "Grave", "00:43"},
                {"16", "Av tal 1500", "Moto", "Leve", "00:43"},
                {"17", "Av tal 1500", "Moto", "Grave", "00:43"}
            },
            new String [] {
                "Id", "Local", "Tipo de veículo", "Gravidade", "Horário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("deletar por id:");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jButton2.setText("deletar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(105, 105, 105))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Enviar/Editar Ocorrência");
        jLabel1.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Local:");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Tipo de veículo:");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Gravidade:");
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Horário:");
        jLabel7.setToolTipText("");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setToolTipText("");

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("ID PARA EDITAR:");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String local = jTextField1.getText();
        String tipoVeiculo = jTextField3.getText();
        String gravidade = jTextField2.getText();
        String horario = jTextField4.getText();

        if (local.isEmpty() || tipoVeiculo.isEmpty() || gravidade.isEmpty() || horario.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
        }else{
        try {
            String sql = "INSERT INTO occurrences_sent (local, vehicle, severity, time) VALUES (?, ?, ?, ?)";

            java.sql.PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, local);
            pstmt.setString(2, tipoVeiculo);
            pstmt.setString(3, gravidade);
            pstmt.setString(4, horario);

            pstmt.executeUpdate();
            OccurrencesSent();
            OccurrencesReceived();
            System.out.println("Dados inseridos com sucesso!");
            JOptionPane.showMessageDialog(this, "Sua ocorrência foi adicionada com sucesso!", "Ocorrência Adicionada", JOptionPane.INFORMATION_MESSAGE);
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
         }catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
         }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String idText = jTextField5.getText().trim();    
        System.out.println("ID Text: " + idText);

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um ID válido.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idText);
            System.out.println("ID convertido: " + id);  // Adiciona uma mensagem de depuração
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID deve ser um número válido.");
            return;
        }

        String sql = "DELETE FROM occurrences_received WHERE ID = ?";

        try (java.sql.PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                OccurrencesReceived();
                jTextField5.setText("");
                JOptionPane.showMessageDialog(this, "Registro deletado com sucesso!", "Deleção Bem-sucedida", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum registro encontrado com o ID fornecido.", "Erro na Deleção", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar dados: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Erro ao deletar registro: " + e.getMessage(), "Erro na Deleção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String id = jTextField7.getText();
        String local = jTextField1.getText();
        String tipoVeiculo = jTextField3.getText();
        String gravidade = jTextField2.getText();
        String horario = jTextField4.getText();

        if (id.isEmpty() || local.isEmpty() || tipoVeiculo.isEmpty() || gravidade.isEmpty() || horario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String sql = "UPDATE occurrences_sent SET local = ?, vehicle = ?, severity = ?, time = ? WHERE id = ?";

                java.sql.PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setString(1, local);
                pstmt.setString(2, tipoVeiculo);
                pstmt.setString(3, gravidade);
                pstmt.setString(4, horario);
                pstmt.setString(5, id);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    OccurrencesSent();
                    OccurrencesReceived();
                    System.out.println("Dados atualizados com sucesso!");
                    JOptionPane.showMessageDialog(this, "Sua ocorrência foi atualizada com sucesso!", "Ocorrência Atualizada", JOptionPane.INFORMATION_MESSAGE);
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField7.setText("");
                } else {
                    System.out.println("Nenhuma ocorrência encontrada com o ID fornecido.");
                    JOptionPane.showMessageDialog(this, "Nenhuma ocorrência encontrada com o ID fornecido.", "ID Não Encontrado", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar dados: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}