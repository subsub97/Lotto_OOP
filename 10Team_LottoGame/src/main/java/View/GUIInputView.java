package View;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utils.Validator;

public class GUIInputView implements InputView {

    @Override
    public String inputPuchasePrice() {
        JTextField purchasePriceField = new JTextField(10);
        Object[] message = {
                "로또 구매금액을 입력해주세요.\n (1,000원 단위로 구매 가능)", purchasePriceField
        };

        JOptionPane.showMessageDialog(null, message, "Enter Purchase Price", JOptionPane.PLAIN_MESSAGE);
        String userInput = purchasePriceField.getText();
        Validator.validateNumericValue(userInput);
        Validator.validateUnderThousand(userInput);
        Validator.validateMulitpleOfThousand(userInput);
        return userInput;
    }

    @Override
    public String inputPrizeNumbers() {
        JTextField prizeNumbersField = new JTextField(10);
        Object[] message = {
                "로또 당첨번호 6개를 입력해주세요! \n ( ex : 1,2,3,4,5,6 )", prizeNumbersField
        };
        JOptionPane.showMessageDialog(null, message, "Enter Prize Numbers", JOptionPane.PLAIN_MESSAGE);
        return prizeNumbersField.getText();
    }

    @Override
    public String inputBonusNumber() {
        JTextField bonusNumberField = new JTextField(10);
        Object[] message = {
                "로또 보너스번호 1개를 입력해주세요! \n (주의 : 당첨번호와 중복된 숫자는 불가능합니다.)", bonusNumberField
        };
        JOptionPane.showMessageDialog(null, message, "Enter Bonus Number", JOptionPane.PLAIN_MESSAGE);
        return bonusNumberField.getText();
    }
}
