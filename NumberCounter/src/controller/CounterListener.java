package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.CounterView;

public class CounterListener implements ActionListener {
    private CounterView ctv;
    private int i = 3; // Lượt của Player 1
    private int j = 3; // Lượt của Player 2

    public CounterListener(CounterView ctv) {
        this.ctv = ctv;
    }

    // Dùng để "lắng nghe" các thao tác của người dùng
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println("You pressed button" + src);

        if (ctv.counterModel.getValue() > 0) {
            if (src.equals("Player1") && i > 0) {
                this.ctv.decrement();
                i--;
                j = 3;
            } else if (src.equals("Player2") && j > 0) {
                this.ctv.decrement();
                j--;
                i = 3;
            }
        }

        // Kiểm tra nếu giá trị của counterModel bằng 0 thì thông báo người chiến thắng
        if (ctv.counterModel.getValue() == 0) {
            if (src.equals("Player1") && i >= 0) {
                JOptionPane.showMessageDialog(ctv, "Player 1 wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            } else if (src.equals("Player2") && j >= 0) {
                JOptionPane.showMessageDialog(ctv, "Player 2 wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (src.equals("RESET")) {
            this.ctv.reset();
            i = 3; // Đặt lại lượt của Player 1
            j = 3; // Đặt lại lượt của Player 2
        }
    }
}
