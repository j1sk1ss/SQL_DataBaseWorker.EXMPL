package Windows;
import Gui.GuiSetter;

import javax.swing.*;
import java.sql.SQLException;

public class MainWindow extends JFrame {
    public MainWindow() throws SQLException {
        super("Менеджер библиотеки");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new GuiSetter(this).SetDefaultWindow();
        this.setVisible(true); //Сделать его видимым
        this.setResizable(false);
    }
}
