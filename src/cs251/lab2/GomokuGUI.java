//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cs251.lab2;

import cs251.lab2.GomokuInterface.Square;
import cs251.lab2.GomokuInterface.TurnResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GomokuGUI {
    private static final int SQUARE_SIZE = 20;
    private final GomokuInterface model;
    private final JFrame boardFrame;
    private final JLabel turnLabel;

    private void doMouseClick(int var1, int var2) {
        int var3 = var2 / 20;
        int var4 = var1 / 20;
        boolean var5 = true;
        TurnResult var6 = this.model.handleClickAt(var3, var4);
        this.boardFrame.repaint();
        this.updateTurnLabel();
        switch(var6) {
            case DRAW:
                JOptionPane.showMessageDialog((Component)null, "Draw Game!", "Game Over", 1);
                break;
            case CROSS_WINS:
                JOptionPane.showMessageDialog((Component)null, "Cross Wins!", "Game Over", 1);
                break;
            case RING_WINS:
                JOptionPane.showMessageDialog((Component)null, "Ring Wins!", "Game Over", 1);
                break;
            default:
                var5 = false;
        }

        if (var5) {
            int var7 = JOptionPane.showConfirmDialog((Component)null, "Play again?", "Play again?", 0);
            if (var7 == 1) {
                System.exit(0);
            } else {
                this.model.initializeGame();
            }
        }

        this.boardFrame.repaint();
        this.updateTurnLabel();
    }

    private void updateTurnLabel() {
        this.turnLabel.setText("<html><h3>Current Player is " + this.model.getCurrentTurn() + "</h3>");
    }

    private GomokuGUI(GomokuInterface var1) {
        this.turnLabel = new JLabel();
        this.model = var1;
        this.model.initializeGame();
        this.boardFrame = new JFrame();
        this.boardFrame.setTitle("Gomoku");
        GomokuGUI.BoardPanel var2 = new GomokuGUI.BoardPanel();
        var2.setPreferredSize(new Dimension(this.model.getNumCols() * 20 + 1, this.model.getNumRows() * 20 + 1));
        var2.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent var1) {
                int var2 = var1.getX();
                int var3 = var1.getY();
                GomokuGUI.this.doMouseClick(var2, var3);
            }
        });
        JPanel var3 = new JPanel(new FlowLayout());
        JButton var4 = new JButton("New Game");
        var4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                GomokuGUI.this.model.initializeGame();
                GomokuGUI.this.boardFrame.repaint();
                GomokuGUI.this.updateTurnLabel();
            }
        });
        var3.add(var4);
        JButton var5 = new JButton("Quit");
        var5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                System.exit(0);
            }
        });
        var3.add(var5);
        this.boardFrame.add(var3, "North");
        JPanel var6 = new JPanel();
        var6.add(var2);
        this.boardFrame.add(var6, "Center");
        JPanel var7 = new JPanel();
        this.updateTurnLabel();
        var7.add(this.turnLabel);
        this.boardFrame.add(var7, "South");
        this.boardFrame.setResizable(false);
        this.boardFrame.pack();
        this.boardFrame.setDefaultCloseOperation(3);
        this.boardFrame.setLocationRelativeTo((Component)null);
        this.boardFrame.setVisible(true);
    }

    public static void showGUI(final GomokuInterface var0) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GomokuGUI(var0);
            }
        });
    }

    private class BoardPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        private BoardPanel() {
        }

        public void drawBoard(Graphics2D var1) {
            String var2 = GomokuGUI.this.model.getCurrentBoardAsString();
            if (var2 == null) {
                var2 = "";
            }

            String[] var3 = var2.split("\\n");
            int var4 = var3.length;
            int var5 = var3[0].length();
            byte var6 = 4;
            int var7 = 2 * var6;
            var1.setStroke(new BasicStroke((float)var6));

            for(int var8 = 0; var8 < var4; ++var8) {
                for(int var9 = 0; var9 < var5; ++var9) {
                    char var10 = var3[var8].charAt(var9);
                    if (var10 == Square.RING.toChar()) {
                        var1.setColor(Color.BLUE);
                        var1.drawOval(var9 * 20 + var6, var8 * 20 + var6, 20 - var7, 20 - var7);
                    } else if (var10 == Square.CROSS.toChar()) {
                        var1.setColor(Color.RED);
                        var1.drawLine(var9 * 20 + var6, var8 * 20 + var6, (var9 + 1) * 20 - var6, (var8 + 1) * 20 - var6);
                        var1.drawLine((var9 + 1) * 20 - var6, var8 * 20 + var6, var9 * 20 + var6, (var8 + 1) * 20 - var6);
                    } else if (var10 != Square.EMPTY.toChar()) {
                        System.err.println("Unexpected character " + var10 + " in board string at row " + var8 + ", col " + var9);
                    }
                }
            }

        }

        public void paintComponent(Graphics var1) {
            var1.setColor(Color.BLACK);
            int var2 = this.getWidth();
            int var3 = this.getHeight();

            int var4;
            int var5;
            for(var4 = 0; var4 <= GomokuGUI.this.model.getNumRows(); ++var4) {
                var5 = var4 * 20;
                var1.drawLine(0, var5, var2, var5);
            }

            for(var4 = 0; var4 <= GomokuGUI.this.model.getNumCols(); ++var4) {
                var5 = var4 * 20;
                var1.drawLine(var5, 0, var5, var3);
            }

            this.drawBoard((Graphics2D)var1);
        }
    }
}
