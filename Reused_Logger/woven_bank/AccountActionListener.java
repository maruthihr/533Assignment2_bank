package woven_bank;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import java.awt.event.ActionEvent;
import java.lang.Integer;
import javax.swing.JPanel;
import java.awt.Toolkit;

// Start of user code for imports
// End of user code

/**
 * AccountActionListener class definition.
 * Generated by the TouchCORE code generator.
 */
public class AccountActionListener implements ActionListener, DocumentListener {
    
    protected boolean isDeposit;
    protected JList<Account> accountList;
    protected JTextField amountTextField;
    protected JButton actionButton;
    protected JPanel myJPanel;
    
    public AccountActionListener(JButton button, JTextField amountField, JList<Account> accList, boolean deposit, JPanel panel) {
        this.accountList = accList;
        this.amountTextField = amountField;
        this.isDeposit = deposit;
        this.actionButton = button;
        this.myJPanel = panel;
    }

    JList<Account> getAccountList() {
        return this.accountList;
    }

    boolean setAccountList(JList<Account> newObject) {
        this.accountList = newObject;
        return true;
    }

    JTextField getAmountTextField() {
        return this.amountTextField;
    }

    boolean setAmountTextField(JTextField newObject) {
        this.amountTextField = newObject;
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        String text = amountTextField.getText();
        int amount = 0;
        try {
            amount = Integer.parseInt(text);
        } catch (NumberFormatException ne) {
            Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
            defaultToolkit.beep();
            amountTextField.requestFocusInWindow();
            amountTextField.setText("");
        }
        Account selectedAccount = accountList.getSelectedValue();
        if (isDeposit) {
            selectedAccount.deposit(amount);
        } else {
            selectedAccount.withdraw(amount);
        }
        amountTextField.requestFocusInWindow();
        amountTextField.setText("");
        myJPanel.repaint();
    }

    public void insertUpdate(DocumentEvent e) {
        actionButton.setEnabled(true);
    }

    public void removeUpdate(DocumentEvent e) {
        String text = amountTextField.getText();
        if (text.length() == 0) {
            actionButton.setEnabled(false);
        }
    }

    public void changedUpdate(DocumentEvent e) {
        String text = amountTextField.getText();
        if (text.length() == 0) {
            actionButton.setEnabled(false);
        } else {
            actionButton.setEnabled(true);
        }
    }

    JButton getActionButton() {
        return this.actionButton;
    }

    boolean setActionButton(JButton newObject) {
        this.actionButton = newObject;
        return true;
    }

    JPanel getMyJPanel() {
        return this.myJPanel;
    }

    boolean setMyJPanel(JPanel newObject) {
        this.myJPanel = newObject;
        return true;
    }
}
