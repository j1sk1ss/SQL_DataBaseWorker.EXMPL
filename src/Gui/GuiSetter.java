package Gui;

import Functions.ShowData;
import Windows.DecreaseDataBase;
import Windows.IncreaseDataBase;
import Windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class GuiSetter {
    public GuiSetter(JFrame window) {
        window.setBounds(100, 100, 250, 250); //Размеры окна
        Window = window;
    }
    private final JFrame Window;
    public void SetDefaultWindow() throws SQLException {
        final int show_data   = 0;
        final int add_data    = 1;
        final int delete_data = 2;

        JButton[] user_button = {new JButton("Вывести базу"), new JButton("Добавить книгу"),
                new JButton("Удалить книгу")};

        user_button[show_data].addActionListener(new ShowData());
        user_button[add_data].addActionListener(new IncreaseDataBase());
        user_button[delete_data].addActionListener(new DecreaseDataBase());

        SetElement(user_button);
    }
    public void SetIncreaseWindow(IncreaseDataBase increaseDataBase) {
        JTextField[] user_input = {new JTextField("", 10), new JTextField("", 10)};
        SetElement(user_input);
        increaseDataBase.user_input = user_input;
    }
    private <T> void SetElement(T[] controller) {
        var interfaceGrid = new GridBagConstraints();  //Создаём линии, на основе которых располагются объекты
        interfaceGrid.insets = new Insets(5,5,5,5); //Расствляем координаты и добавляем элементы на места

        if (Window instanceof MainWindow mainWindow) {
            mainWindow.getContentPane().setLayout(new GridBagLayout()); //Создаём контейнер //Присваиваем ему лэйаут
            mainWindow.add((JButton)controller[0], interfaceGrid);
            interfaceGrid.gridy = 1;
            mainWindow.add((JButton)controller[1], interfaceGrid);
            interfaceGrid.gridy = 2;
            mainWindow.add((JButton)controller[2], interfaceGrid);
        }

        if (Window instanceof IncreaseDataBase increaseDataBase) {
            increaseDataBase.getContentPane().setLayout(new GridBagLayout()); //Создаём контейнер //Присваиваем ему лэйаут
            increaseDataBase.add((JTextField)controller[0], interfaceGrid);
            interfaceGrid.gridy = 1;
            increaseDataBase.add((JTextField)controller[1], interfaceGrid);
        }
    }
}
