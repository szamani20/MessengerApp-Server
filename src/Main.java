import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main extends JFrame {
    static ServerSocket server;
    static Socket socket;
    static DataOutputStream dos;
    static DataInputStream dis;
    static JTextArea textArea;

    public Main() throws IOException {
        super("Server");
        server = new ServerSocket(1234);
        socket = server.accept();
        dos = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(new Dimension(300, 300));
        JTextField textField = new JTextField(10);
        textArea = new JTextArea();
        textArea.setEditable(false);

        add(textField, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setVisible(true);

        textField.addActionListener(e -> {
            try {
                dos.writeUTF(textField.getText());
            } catch (IOException e1) {
                System.out.println("Connection End, unable to send message");
                textArea.append("Connection end, unable to send message\n");
            } finally {
                textField.setText("");
            }
        });
    }


    public static void main(String[] args) throws IOException {
        try {
            new Main();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String messageIn;

        try {
            do {
                messageIn = dis.readUTF();
                if (!messageIn.equals(""))
                    textArea.append("Client: " + messageIn + "\n");
            } while (!messageIn.equals("End"));

            socket.close();
        } catch (Exception e) {

        }
    }
}
