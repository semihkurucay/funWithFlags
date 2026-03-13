package com.semihkurucay.main;

import java.awt.Image;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmMain extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmMain.class.getName());

    private List<String> flagKeys = null;
    private List<String> usedFlagKeys = new ArrayList<>();
    private Map<String, String> flags = Flags.getFlags();
    private Random rnd = new Random();
    private String selectKey;
    private String[] buttonValue = {"", "", "", ""};
    boolean isActiveGame = true;
    private int score = 0, correctAnswerIndex, level = 0, point = 0;

    private void clearButtonArray() {
        buttonValue[0] = "";
        buttonValue[1] = "";
        buttonValue[2] = "";
        buttonValue[3] = "";
    }

    private String selectFlag() {
        do {
            selectKey = flagKeys.get(rnd.nextInt(flagKeys.size()));
        } while (usedFlagKeys.contains(selectKey));

        usedFlagKeys.add(selectKey);
        return selectKey;
    }

    private void setButtonValue() {
        int incorrectCount = 0;
        List<String> randomFlag = new ArrayList<>(flagKeys);
        randomFlag.remove(selectKey);
        
        Collections.shuffle(randomFlag);
        
        for (int i = 0; i < 4; i++) {
            if (buttonValue[i].equals("") || buttonValue[i].isEmpty()) {
                buttonValue[i] = randomFlag.get(incorrectCount++);
            }
        }
    }

    private String getFlagName(String key) {
        return flags.get(key);
    }

    private void setButtonName() {
        correctAnswerIndex = rnd.nextInt(4);
        buttonValue[correctAnswerIndex] = selectKey;
        setButtonValue();

        lblA.setText(getFlagName(buttonValue[0]));
        lblB.setText(getFlagName(buttonValue[1]));
        lblC.setText(getFlagName(buttonValue[2]));
        lblD.setText(getFlagName(buttonValue[3]));
    }

    private void nextRound() {
        if (usedFlagKeys.size() == flagKeys.size()) {
            lblImg.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/flags/sheldon.png")).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH)));

            isActiveGame = false;
            
            lblA.setEnabled(isActiveGame);
            lblB.setEnabled(isActiveGame);
            lblC.setEnabled(isActiveGame);
            lblD.setEnabled(isActiveGame);

            JOptionPane.showMessageDialog(rootPane, "Sistemdeki tüm bayrakları gördünüz. Tebrikler", "Oyunumuz Buraya Kadar", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        clearButtonArray();
        selectFlag();
        setButtonName();
        setLabel();

        lblImg.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/flags/" + selectKey + ".png")).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH)));
    }

    private void setLabel() {
        lblLevel.setText(++level + "/" + flags.size());
        lblScore.setText(score + "");
    }

    public FrmMain() {
        initComponents();
        this.setIconImage((new ImageIcon(getClass().getResource("/logo.png")).getImage()));
        JOptionPane.showMessageDialog(rootPane, "Bu Oscar Ödülü almaya hak kazanmış\nDr. Sheldon Lee Cooper ve Dr. Amy Farrah Fowler'ın\n sunduğu Fun With Flags programının bir oyunudur.\nBaşarılar dileriz", "İyi Oyunlar", JOptionPane.WARNING_MESSAGE);

        if(flags.size() < 4){
            JOptionPane.showMessageDialog(rootPane, "Sistemde 4'ten az bayrak bulunmakta, bu sebepten bayrak yükleyin.", "Yetersiz Bayrak Sayısı", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        point = 100 / flags.size();
        flagKeys = new ArrayList<>(flags.keySet());
        nextRound();
    }

    private void buttonProcess(int index){
        if (isActiveGame) {
            if (correctAnswerIndex == index) {
                score += point;
                JOptionPane.showMessageDialog(rootPane, "Tebrikler, bayrağı bildiniz.", "Doğru Bildin", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Maalesef bilemediniz. Cevap : " + getFlagName(selectKey), "Yanlış Bildin", JOptionPane.ERROR_MESSAGE);
            }

            nextRound();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblC = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblA = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblB = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblD = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fun With Flags");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 247));

        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg.setMaximumSize(new java.awt.Dimension(220, 220));
        lblImg.setMinimumSize(new java.awt.Dimension(220, 220));
        lblImg.setPreferredSize(new java.awt.Dimension(220, 220));

        jPanel2.setBackground(new java.awt.Color(29, 161, 75));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblC.setBackground(new java.awt.Color(29, 161, 75));
        lblC.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC.setText("jLabel4");
        lblC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblC, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(29, 161, 75));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblA.setBackground(new java.awt.Color(29, 161, 75));
        lblA.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblA.setText("jLabel1");
        lblA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblA, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(29, 161, 75));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblB.setBackground(new java.awt.Color(29, 161, 75));
        lblB.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB.setText("jLabel3");
        lblB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblB, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(29, 161, 75));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblD.setBackground(new java.awt.Color(29, 161, 75));
        lblD.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblD.setText("jLabel5");
        lblD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblD, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        lblLevel.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblLevel.setForeground(new java.awt.Color(110, 57, 149));
        lblLevel.setText("jLabel6");

        lblScore.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblScore.setForeground(new java.awt.Color(110, 57, 149));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScore.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
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

    private void lblAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAMouseClicked
        buttonProcess(0);
    }//GEN-LAST:event_lblAMouseClicked

    private void lblBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBMouseClicked
        buttonProcess(1);
    }//GEN-LAST:event_lblBMouseClicked

    private void lblCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCMouseClicked
        buttonProcess(2);
    }//GEN-LAST:event_lblCMouseClicked

    private void lblDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDMouseClicked
        buttonProcess(3);
    }//GEN-LAST:event_lblDMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmMain().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblScore;
    // End of variables declaration//GEN-END:variables
}
