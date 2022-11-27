package Windows;

import DataWorker.Connector;
import Functions.DeleteBook;
import Gui.GuiSetter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DecreaseDataBase extends JFrame implements ActionListener {
    public DecreaseDataBase() throws SQLException {
        super("Добавить книгу");
        Connector = new Connector();
    }
    private final Connector Connector;
    public JTextField user_input;
    @Override
    public void actionPerformed(ActionEvent e) {
        new GuiSetter(this);

        var button = new JButton("Удалить книгу");
        button.addActionListener(new DeleteBook(Connector, this));
        var k = new GridBagConstraints();
        k.insets = new Insets(5,5,5,5);
        this.getContentPane().setLayout(new GridBagLayout());
        k.gridy = 1;
        this.add(button, k);
        k.gridy = 0;
        user_input = new JTextField("", 10);
        this.add(user_input, k);
        this.setVisible(true);
        this.setResizable(false);
    }
}
