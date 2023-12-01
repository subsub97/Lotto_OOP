import View.GUIInputView;
import View.InputView;
import controller.Controller;
import javax.swing.SwingUtilities;
import lotto.LottoMachine;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
            System.exit(0);
        });
    }

    private static void createAndShowGUI() {
        InputView inputView = new GUIInputView();
        LottoMachine lottoMachine = new LottoMachine();
        Controller controller = new Controller(lottoMachine, inputView);
        controller.run();
    }
}
