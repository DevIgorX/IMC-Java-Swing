import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

public class IMCCalculator extends JFrame {

    private JTextField pesoField;
    private JTextField alturaField;
    private JLabel resultadoLabel;
    private JLabel faixaLabel;

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
        // Altera o cursor do mouse para a mãozinha de clique quando passa sobre o botão
        calcularButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(calcularButton);

        resultadoLabel = new JLabel("Resultado: ");
        resultadoLabel.setBounds(10, 100, 250, 25);
        add(resultadoLabel);

        faixaLabel = new JLabel("");
        faixaLabel.setBounds(10, 130, 300, 25);
        add(faixaLabel);

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

            // Verifica a faixa de IMC e define a mensagem correspondente
            if (imc < 18.5) {
                faixaLabel.setText("Abaixo do peso");
            } else if (imc >= 18.5 && imc < 25.0) {
                faixaLabel.setText("Peso normal");
            } else if (imc >= 25.0 && imc < 30.0) {
                faixaLabel.setText("Sobrepeso");
            } else if (imc >= 30.0 && imc < 35.0) {
                faixaLabel.setText("Obesidade grau I");
            } else if (imc >= 35.0 && imc < 40.0) {
                faixaLabel.setText("Obesidade grau II");
            } else {
                faixaLabel.setText("Obesidade grau III");
            }
        } catch (NumberFormatException ex) {
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

