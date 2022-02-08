//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cs251.lab2;

import cs251.lab2.GomokuInterface.Square;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class GomokuGUI$BoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private GomokuGUI$BoardPanel(GomokuGUI var1) {
        this.this$0 = var1;
    }

    public void drawBoard(Graphics2D var1) {
        String var2 = GomokuGUI.access$000(this.this$0).getCurrentBoardAsString();
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
        for(var4 = 0; var4 <= GomokuGUI.access$000(this.this$0).getNumRows(); ++var4) {
            var5 = var4 * 20;
            var1.drawLine(0, var5, var2, var5);
        }

        for(var4 = 0; var4 <= GomokuGUI.access$000(this.this$0).getNumCols(); ++var4) {
            var5 = var4 * 20;
            var1.drawLine(var5, 0, var5, var3);
        }

        this.drawBoard((Graphics2D)var1);
    }
}
