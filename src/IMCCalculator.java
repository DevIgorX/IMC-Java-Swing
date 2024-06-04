import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame {

    private JTextField pesoField;
    private JTextField alturaField;
    private JLabel resultadoLabel;

    public IMCCalculator() {
        // Configurações da janela
        setTitle("Calculadora de IMC");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout da janela
        setLayout(null);

        // Componentes
        JLabel pesoLabel = new JLabel("Peso (kg):");
        pesoLabel.setBounds(10, 10, 80, 25);
        add(pesoLabel);

        pesoField = new JTextField();
        pesoField.setBounds(100, 10, 160, 25);
        add(pesoField);

        JLabel alturaLabel = new JLabel("Altura (m):");
        alturaLabel.setBounds(10, 40, 80, 25);
        add(alturaLabel);

        alturaField = new JTextField();
        alturaField.setBounds(100, 40, 160, 25);
        add(alturaField);

        JButton calcularButton = new JButton("Calcular IMC");
        calcularButton.setBounds(10, 70, 250, 25);
        add(calcularButton);

        resultadoLabel = new JLabel("Resultado: ");
        resultadoLabel.setBounds(10, 100, 250, 25);
        add(resultadoLabel);

        // Ação do botão
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoField.getText());
            double altura = Double.parseDouble(alturaField.getText());
            double imc = peso / (altura * altura);
            resultadoLabel.setText(String.format("Resultado: %.2f", imc));
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Entrada inválida. Por favor, insira números válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IMCCalculator().setVisible(true);
            }
        });
    }
}
