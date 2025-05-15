import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameGUI extends JFrame {
    private JLabel characterLabel;
    private JLabel backgroundLabel;
    private int characterX = 100, characterY = 200;
    private JLabel textLabel;
    private boolean movingLeft, movingRight, movingUp, movingDown;

    public GameGUI() {
        setTitle("Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Load background
        ImageIcon background = new ImageIcon("gambar/bg.jpg");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);

        // Load character
        ImageIcon character = new ImageIcon("gambar/char1.jpg");
        characterLabel = new JLabel(character);
        characterLabel.setBounds(characterX, characterY, 100, 100);
        backgroundLabel.add(characterLabel);

        // Text label
        textLabel = new JLabel("Game baru");
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        textLabel.setBounds(200, 100, 400, 50);
        textLabel.setForeground(Color.WHITE);
        backgroundLabel.add(textLabel);

        // Key listener untuk kontrol
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int step = 10;
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        movingLeft = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        movingRight = true;
                        break;
                    case KeyEvent.VK_UP:
                        movingUp = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        movingDown = true;
                        break;
                }
                updateCharacterPosition();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        movingLeft = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        movingRight = false;
                        break;
                    case KeyEvent.VK_UP:
                        movingUp = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        movingDown = false;
                        break;
                }
                updateCharacterPosition();
            }
        });

        setFocusable(true);
        requestFocusInWindow();
        setVisible(true);
    }
    private void updateCharacterPosition() {
        int step = 5;
        if (movingLeft) characterX -= step;
        if (movingRight) characterX += step;
        if (movingUp) characterY -= step;
        if (movingDown) characterY += step;

        characterLabel.setBounds(characterX, characterY, 100, 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameGUI());
    }
}