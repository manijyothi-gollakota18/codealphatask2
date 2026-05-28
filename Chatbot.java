import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chatbot extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    BotLogic bot = new BotLogic();

    public Chatbot() {

        setTitle("AI ChatBot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        inputField = new JTextField(30);
        add(panel, BorderLayout.SOUTH);
        inputField.requestFocus();
        sendButton = new JButton("Send");

        sendButton.addActionListener(this);

        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        chatArea.append("Bot: Hello! I am your AI ChatBot.\n");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String userText = inputField.getText();

        if (!userText.isEmpty()) {

            chatArea.append("You: " + userText + "\n");

            String response = bot.getResponse(userText);

            chatArea.append("Bot: " + response + "\n\n");

            inputField.setText("");
        }
    }

    public static void main(String[] args) {

        new Chatbot();
    }
}
