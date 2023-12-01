package View;

import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import lotto.Lotto;

public class GUIOutputView {

    public static void printWinResult(String message) {

        StringBuilder sb = new StringBuilder();
        sb.append("-----당첨통계-----\n" + message);

        JOptionPane.showMessageDialog(null, sb.toString());

    }

    public static void printReturnOfRate(double returnRate) {
        SwingUtilities.invokeLater(
                () -> JOptionPane.showMessageDialog(null, String.format("총 수익률은 %.1f%%입니다.", returnRate)));
    }
    
    public static void printLottos(List<Lotto> lottos) {

        StringBuilder sb = new StringBuilder();
        sb.append("↓↓로또 자동구매 내역입니다↓↓\n--------------------\n");

        for (Lotto lotto : lottos) {
            sb.append(lotto.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void printPrizeMoney(long prizeMoney) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String formattedPrizeMoney = numberFormat.format(prizeMoney);
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "총 당첨 금액 : " + formattedPrizeMoney + "원"));
    }
}
