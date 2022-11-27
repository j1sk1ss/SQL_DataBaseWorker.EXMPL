package Functions;

import DataWorker.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShowData implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JScrollPane scrollPane = null; //Создаём лист, который можно скроллить
        try {
            scrollPane = new JScrollPane(new JTextArea(new Connector().GetBooksData()));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        scrollPane.setPreferredSize( new Dimension( 400, 300 ) );
        JOptionPane.showMessageDialog(null, scrollPane, "Данные о книгах:",
                JOptionPane.PLAIN_MESSAGE); //Закидываем его в новое окно, называем его, выбираем
    }
}
