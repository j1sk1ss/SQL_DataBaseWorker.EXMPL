package DataWorker;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres"; //Ссылка на базу данных
    private static final String DB_USERNAME = "postgres"; //Имя пользователя СУБД
    private static final String DB_PASSWORD = "1234"; //Пароль пользователя СУБД
    private final Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD); //Подключаемся к БД

    public Connector() throws SQLException {

    }
    public String GetBooksData() {
        var sqlCommand = "select * from books order by book_id"; //Команда для SQL
        ResultSet result;
        try {
            result = connection.createStatement().executeQuery(sqlCommand); //Получаем данные из бд в result
        } catch (Exception ex) {
            return "null";
        }

        var message = new StringBuilder(); //Создаём пустой стринг
        while (true) {
            try {
                if (!result.next()) break;
                message.append(result.getInt("book_id")).append(" | ").append(result.
                        getString("book_name")).append(" | ").append(result.
                        getString("book_author")).append("\n"); //Вставляем данные из result в строку
            } catch (Exception ex) {
                return "null";
            }
        }
        return message.toString();
    }
    public void AddBook(String bookName, String bookAuthor) {
        try {
            var insertCommand = "insert into books (book_name, book_author) values (?,?)"; //Команда для SQL вставить в
            var preparedStatement = connection.prepareStatement(insertCommand); //У нас есть заготовленный комманда
            preparedStatement.setString(1, bookName); //В команду мы добавляем book_name на первый ?
            preparedStatement.setString(2, bookAuthor); //И на второй ? - book_author
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        JOptionPane.showMessageDialog(null, "Книга успешно добавлена!",
                "Выполнено", JOptionPane.PLAIN_MESSAGE); //Показать в отдельном окне сообщение
    }

    public void DeleteBook(int bookId) {
        try {
            var deleteCommand = "delete from books where book_id = ?"; //Команда SQL: удалить книги с айди = ?
            var preparedStatement = connection.prepareStatement(deleteCommand);
            preparedStatement.setInt(1, bookId);
            //Засовываем туда банан, который спарсили со стринга, который получили с текстбокса input_id
            preparedStatement.executeUpdate(); //Выполнить команду
        } catch (Exception ex) {
            return;
        }
        JOptionPane.showMessageDialog(null, "Книга успешно удалена!",
                "Выполнено", JOptionPane.PLAIN_MESSAGE); //Сообщение об успехе
    }
}

