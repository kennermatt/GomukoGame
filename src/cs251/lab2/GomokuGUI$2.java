//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cs251.lab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GomokuGUI$2 implements ActionListener {
    GomokuGUI$2(GomokuGUI var1) {
        this.this$0 = var1;
    }

    public void actionPerformed(ActionEvent var1) {
        GomokuGUI.access$000(this.this$0).initializeGame();
        GomokuGUI.access$300(this.this$0).repaint();
        GomokuGUI.access$400(this.this$0);
    }
}
