import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Utility class for consistent and attractive UI styling across the application
 */
public class UIStyle {
    
    // Color Palette - Modern Dark Theme
    public static final Color PRIMARY = new Color(64, 123, 255);      // Blue
    public static final Color PRIMARY_DARK = new Color(45, 90, 200);  // Darker Blue
    public static final Color SECONDARY = new Color(108, 92, 231);    // Purple
    public static final Color SUCCESS = new Color(46, 213, 115);      // Green
    public static final Color WARNING = new Color(255, 171, 0);       // Orange
    public static final Color DANGER = new Color(255, 71, 87);        // Red
    public static final Color DARK = new Color(30, 30, 46);           // Dark Background
    public static final Color DARK_SECONDARY = new Color(45, 45, 65); // Slightly lighter
    public static final Color LIGHT = new Color(248, 249, 250);       // Light text
    public static final Color GRAY = new Color(150, 150, 160);        // Gray text
    public static final Color ACCENT = new Color(255, 215, 0);        // Gold accent
    
    // Fonts
    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 24);
    public static final Font SUBTITLE_FONT = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 14);
    public static final Font LABEL_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font INPUT_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    
    /**
     * Style a JFrame with modern look
     */
    public static void styleFrame(JFrame frame, String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }
    
    /**
     * Create a styled main panel with gradient background
     */
    public static JPanel createGradientPanel() {
        JPanel panel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, DARK, 0, getHeight(), DARK_SECONDARY);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        return panel;
    }
    
    /**
     * Create a styled panel with solid color
     */
    public static JPanel createPanel(Color bgColor) {
        JPanel panel = new JPanel(null);
        panel.setBackground(bgColor);
        return panel;
    }
    
    /**
     * Style a button with modern rounded look
     */
    public static void styleButton(JButton button, Color bgColor, Color fgColor) {
        button.setFont(BUTTON_FONT);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color originalBg = bgColor;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(originalBg.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalBg);
            }
        });
    }
    
    /**
     * Create a styled primary button
     */
    public static JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        styleButton(button, PRIMARY, LIGHT);
        return button;
    }
    
    /**
     * Create a styled secondary button
     */
    public static JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        styleButton(button, SECONDARY, LIGHT);
        return button;
    }
    
    /**
     * Create a styled success button
     */
    public static JButton createSuccessButton(String text) {
        JButton button = new JButton(text);
        styleButton(button, SUCCESS, DARK);
        return button;
    }
    
    /**
     * Create a styled danger button
     */
    public static JButton createDangerButton(String text) {
        JButton button = new JButton(text);
        styleButton(button, DANGER, LIGHT);
        return button;
    }
    
    /**
     * Create a styled warning button
     */
    public static JButton createWarningButton(String text) {
        JButton button = new JButton(text);
        styleButton(button, WARNING, DARK);
        return button;
    }
    
    /**
     * Style a label
     */
    public static void styleLabel(JLabel label, Color fgColor, Font font) {
        label.setFont(font);
        label.setForeground(fgColor);
    }
    
    /**
     * Create a styled label
     */
    public static JLabel createLabel(String text, Color fgColor) {
        JLabel label = new JLabel(text);
        styleLabel(label, fgColor, LABEL_FONT);
        return label;
    }
    
    /**
     * Create a title label
     */
    public static JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        styleLabel(label, ACCENT, TITLE_FONT);
        return label;
    }
    
    /**
     * Create a subtitle label
     */
    public static JLabel createSubtitleLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        styleLabel(label, LIGHT, SUBTITLE_FONT);
        return label;
    }
    
    /**
     * Style a text field with modern look
     */
    public static void styleTextField(JTextField textField) {
        textField.setFont(INPUT_FONT);
        textField.setBackground(DARK_SECONDARY);
        textField.setForeground(LIGHT);
        textField.setCaretColor(LIGHT);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }
    
    /**
     * Create a styled text field
     */
    public static JTextField createTextField() {
        JTextField textField = new JTextField();
        styleTextField(textField);
        return textField;
    }
    
    /**
     * Style a password field with modern look
     */
    public static void stylePasswordField(JPasswordField passwordField) {
        passwordField.setFont(INPUT_FONT);
        passwordField.setBackground(DARK_SECONDARY);
        passwordField.setForeground(LIGHT);
        passwordField.setCaretColor(LIGHT);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SECONDARY, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }
    
    /**
     * Create a styled password field
     */
    public static JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        stylePasswordField(passwordField);
        return passwordField;
    }
    
    /**
     * Style a checkbox with modern look
     */
    public static void styleCheckBox(JCheckBox checkBox) {
        checkBox.setFont(LABEL_FONT);
        checkBox.setForeground(LIGHT);
        checkBox.setBackground(DARK);
        checkBox.setFocusPainted(false);
        checkBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    /**
     * Create a styled checkbox
     */
    public static JCheckBox createCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        styleCheckBox(checkBox);
        return checkBox;
    }
    
    /**
     * Style a combo box with modern look
     */
    public static void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setFont(INPUT_FONT);
        comboBox.setBackground(DARK_SECONDARY);
        comboBox.setForeground(LIGHT);
        comboBox.setBorder(BorderFactory.createLineBorder(PRIMARY, 1));
        ((JComponent) comboBox.getRenderer()).setOpaque(true);
    }
    
    /**
     * Create a header panel with title
     */
    public static JPanel createHeaderPanel(String title, int width) {
        JPanel headerPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, PRIMARY, width, 0, SECONDARY);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setForeground(LIGHT);
        titleLabel.setBounds(0, 15, width, 40);
        headerPanel.add(titleLabel);
        
        return headerPanel;
    }
    
    /**
     * Create a decorative icon label (emoji-based)
     */
    public static JLabel createIconLabel(String emoji, int size) {
        JLabel label = new JLabel(emoji, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, size));
        return label;
    }
    
    /**
     * Apply system look and feel
     */
    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Use default look and feel
        }
    }
    
    /**
     * Style JOptionPane dialogs
     */
    public static void showStyledMessage(Component parent, String message, String title, int type) {
        UIManager.put("OptionPane.background", DARK);
        UIManager.put("Panel.background", DARK);
        UIManager.put("OptionPane.messageForeground", LIGHT);
        UIManager.put("Button.background", PRIMARY);
        UIManager.put("Button.foreground", LIGHT);
        JOptionPane.showMessageDialog(parent, message, title, type);
    }
    
    /**
     * Create a card-style panel with border
     */
    public static JPanel createCardPanel(int x, int y, int width, int height) {
        JPanel card = new JPanel(null);
        card.setBackground(DARK_SECONDARY);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 80), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        card.setBounds(x, y, width, height);
        return card;
    }
}
