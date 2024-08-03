/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Stack;

public class Calculadora extends JFrame {

    private JTextField vista_calculadora;
    private JLabel label;
    private JButton key_1, key_2, key_3, key_plus, key_4, key_5, key_6, key_minus, key_7, key_8, key_9, key_times, key_0, key_point, key_equal, key_divided;

    public Calculadora() {
        initComponents();
        // Ajustar el tamaño de la ventana
        setSize(400, 500); // Puedes ajustar el tamaño aquí
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private void initComponents() {
        // Asigna los componentes a las variables
        vista_calculadora = new JTextField();
        label = new JLabel("Calculadora");
        key_1 = new JButton("1");
        key_2 = new JButton("2");
        key_3 = new JButton("3");
        key_plus = new JButton("+");
        key_4 = new JButton("4");
        key_5 = new JButton("5");
        key_6 = new JButton("6");
        key_minus = new JButton("-");
        key_7 = new JButton("7");
        key_8 = new JButton("8");
        key_9 = new JButton("9");
        key_times = new JButton("*");
        key_0 = new JButton("0");
        key_point = new JButton(".");
        key_equal = new JButton("=");
        key_divided = new JButton("/");

        // Establecer tamaño preferido de los botones
        java.awt.Dimension buttonSize = new java.awt.Dimension(70, 70); // Puedes ajustar el tamaño aquí
        key_1.setPreferredSize(buttonSize);
        key_2.setPreferredSize(buttonSize);
        key_3.setPreferredSize(buttonSize);
        key_plus.setPreferredSize(buttonSize);
        key_4.setPreferredSize(buttonSize);
        key_5.setPreferredSize(buttonSize);
        key_6.setPreferredSize(buttonSize);
        key_minus.setPreferredSize(buttonSize);
        key_7.setPreferredSize(buttonSize);
        key_8.setPreferredSize(buttonSize);
        key_9.setPreferredSize(buttonSize);
        key_times.setPreferredSize(buttonSize);
        key_0.setPreferredSize(buttonSize);
        key_point.setPreferredSize(buttonSize);
        key_equal.setPreferredSize(buttonSize);
        key_divided.setPreferredSize(buttonSize);

        // Configura el JFrame
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.BorderLayout());

        // Añade los componentes al JFrame
        add(label, java.awt.BorderLayout.NORTH);
        add(vista_calculadora, java.awt.BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(4, 4));

        panel.add(key_7);
        panel.add(key_8);
        panel.add(key_9);
        panel.add(key_divided);
        panel.add(key_4);
        panel.add(key_5);
        panel.add(key_6);
        panel.add(key_times);
        panel.add(key_1);
        panel.add(key_2);
        panel.add(key_3);
        panel.add(key_minus);
        panel.add(key_0);
        panel.add(key_point);
        panel.add(key_equal);
        panel.add(key_plus);

        add(panel, java.awt.BorderLayout.SOUTH);

        // Añadir barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem nuevo = new JMenuItem("Nuevo");
        JMenuItem historial = new JMenuItem("Historial");
        JMenuItem ayuda = new JMenuItem("Ayuda");

        nuevo.addActionListener(e -> nuevo());
        historial.addActionListener(e -> mostrarHistorial());
        ayuda.addActionListener(e -> mostrarAyuda());

        menu.add(nuevo);
        menu.add(historial);
        menu.add(ayuda);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Añade ActionListeners a los botones
        addActionListeners();

        // Añadir eventos de teclado
        vista_calculadora.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });

        pack();
    }

    private void addActionListeners() {
        // Añade el ActionListener para los botones
        key_1.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "1"));
        key_2.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "2"));
        key_3.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "3"));
        key_4.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "4"));
        key_5.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "5"));
        key_6.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "6"));
        key_7.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "7"));
        key_8.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "8"));
        key_9.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "9"));
        key_0.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "0"));
        key_plus.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "+"));
        key_minus.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "-"));
        key_times.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "*"));
        key_divided.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "/"));
        key_point.addActionListener(e -> vista_calculadora.setText(vista_calculadora.getText() + "."));
        key_equal.addActionListener(e -> calcularResultado());
    }

    private void handleKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_0 -> vista_calculadora.setText(vista_calculadora.getText() + "0");
            case KeyEvent.VK_1 -> vista_calculadora.setText(vista_calculadora.getText() + "1");
            case KeyEvent.VK_2 -> vista_calculadora.setText(vista_calculadora.getText() + "2");
            case KeyEvent.VK_3 -> vista_calculadora.setText(vista_calculadora.getText() + "3");
            case KeyEvent.VK_4 -> vista_calculadora.setText(vista_calculadora.getText() + "4");
            case KeyEvent.VK_5 -> vista_calculadora.setText(vista_calculadora.getText() + "5");
            case KeyEvent.VK_6 -> vista_calculadora.setText(vista_calculadora.getText() + "6");
            case KeyEvent.VK_7 -> vista_calculadora.setText(vista_calculadora.getText() + "7");
            case KeyEvent.VK_8 -> vista_calculadora.setText(vista_calculadora.getText() + "8");
            case KeyEvent.VK_9 -> vista_calculadora.setText(vista_calculadora.getText() + "9");
            case KeyEvent.VK_ADD -> vista_calculadora.setText(vista_calculadora.getText() + "+");
            case KeyEvent.VK_SUBTRACT -> vista_calculadora.setText(vista_calculadora.getText() + "-");
            case KeyEvent.VK_MULTIPLY -> vista_calculadora.setText(vista_calculadora.getText() + "*");
            case KeyEvent.VK_DIVIDE -> vista_calculadora.setText(vista_calculadora.getText() + "/");
            case KeyEvent.VK_DECIMAL -> vista_calculadora.setText(vista_calculadora.getText() + ".");
            case KeyEvent.VK_ENTER -> calcularResultado();
            case KeyEvent.VK_BACK_SPACE -> {
                String text = vista_calculadora.getText();
                if (!text.isEmpty()) {
                    vista_calculadora.setText(text.substring(0, text.length() - 1));
                }
            }
        }
    }

    private void calcularResultado() {
        try {
            String expression = vista_calculadora.getText();
            double result = evaluateExpression(expression);
            vista_calculadora.setText(String.valueOf(result));
            // Guardar el resultado en el archivo de historial
            guardarHistorial(expression + " = " + result);
        } catch (Exception e) {
            vista_calculadora.setText("Error");
        }
    }

    private double evaluateExpression(String expression) {
        // Implementación simple para evaluar la expresión
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                numberBuffer.append(c);
            } else {
                if (numberBuffer.length() > 0) {
                    numbers.push(Double.parseDouble(numberBuffer.toString()));
                    numberBuffer.setLength(0);
                }
                while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = operations.pop();
                    numbers.push(applyOperation(a, b, op));
                }
                operations.push(c);
            }
        }
        if (numberBuffer.length() > 0) {
            numbers.push(Double.parseDouble(numberBuffer.toString()));
        }
        while (!operations.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char op = operations.pop();
            numbers.push(applyOperation(a, b, op));
        }
        return numbers.pop();
    }

    private int precedence(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    private double applyOperation(double a, double b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                yield a / b;
            }
            default -> 0;
        };
    }

    private void nuevo() {
        vista_calculadora.setText("");
    }

    private void mostrarHistorial() {
        try {
            File file = new File("historial.txt");
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                JTextArea textArea = new JTextArea();
                textArea.read(reader, null);
                reader.close();

                JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Historial", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No hay historial disponible.", "Historial", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarAyuda() {
        String mensaje = "Calculadora simple.\n\n" +
                "Uso:\n" +
                "- Ingrese números y operadores usando los botones o el teclado.\n" +
                "- Presione '=' para calcular el resultado.\n" +
                "- Use la opción 'Nuevo' para limpiar la pantalla.\n" +
                "- Use la opción 'Historial' para ver operaciones anteriores.";
        JOptionPane.showMessageDialog(this, mensaje, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }

    private void guardarHistorial(String resultado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("historial.txt", true))) {
            writer.write(resultado);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculadora().setVisible(true));
    }
}

