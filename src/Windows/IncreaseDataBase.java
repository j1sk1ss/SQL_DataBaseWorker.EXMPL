package Windows;

import DataWorker.Connector;
import Functions.AddBook;
import Gui.GuiSetter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class IncreaseDataBase extends JFrame implements ActionListener {
    public IncreaseDataBase() throws SQLException {
        super("Добавить книгу");
        new GuiSetter(this).SetIncreaseWindow(this);
        Connector = new Connector();
        var k = new GridBagConstraints();
        k.gridy = 10;
        this.add(button, k);
    }
    public JTextField[] user_input;
    private final Connector Connector;
    private final JButton button = new JButton("Добавить книгу");
    @Override
    public void actionPerformed(ActionEvent e) {
        OpenWindow();
    }
    private void OpenWindow() {
        this.setVisible(true); //Сделать его видимым
        this.setResizable(false);
        button.addActionListener(new AddBook(Connector, this));
    }
}
