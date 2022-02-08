//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cs251.lab2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GomokuGUI$1 extends MouseAdapter {
    GomokuGUI$1(GomokuGUI var1) {
        this.this$0 = var1;
    }

    public void mouseReleased(MouseEvent var1) {
        int var2 = var1.getX();
        int var3 = var1.getY();
        GomokuGUI.access$200(this.this$0, var2, var3);
    }
}
