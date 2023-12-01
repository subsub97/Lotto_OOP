import View.GUIInputView;
import View.InputView;
import controller.Controller;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import lotto.LottoMachine;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Lotto Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InputView inputView = new GUIInputView();
        LottoMachine lottoMachine = new LottoMachine();

        Controller controller = new Controller(lottoMachine, inputView);

        controller.run();

        frame.pack();
        frame.setVisible(true);
    }
}
