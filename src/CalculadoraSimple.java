import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CalculadoraSimple extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField cOp1;
    private JComboBox cOperacion;
    private JTextField cOp2;

    public CalculadoraSimple() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOk();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
                dispose();
            }
        });
        cOp1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
        cOp1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(Character.isLetter(e.getKeyChar())){
                    e.consume();
                    return;
                }
                super.keyTyped(e);
            }
        });
        cOp2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(Character.isLetter(e.getKeyChar())){
                    e.consume();
                    return;
                }

                super.keyTyped(e);
            }
        });
    }

    private void onOk() {
        double op1, op2,result=0;
        String oper;
        try {
            op1 = Double.parseDouble(cOp1.getText());
            op2 = Double.parseDouble(cOp2.getText());
            oper = (String) cOperacion.getSelectedItem();
            switch (oper) {
                case "+":
                    result = op1 + op2;
                    break;
                case "-":
                    result = op1 - op2;
                    break;
                case "*":
                    result = op1 * op2;
                    break;
                case "/":
                    result = op1 / op2;
                    break;

            }
            JOptionPane.showMessageDialog(
                    this,
                    ""+result,
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        CalculadoraSimple dialog = new CalculadoraSimple();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
