package Functions;

import DataWorker.Connector;
import Windows.IncreaseDataBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook implements ActionListener {
    public AddBook(Connector connector, IncreaseDataBase increaseDataBase) {
        this.connector        = connector;
        this.increaseDataBase = increaseDataBase;
    }
    private final Connector connector;
    private final IncreaseDataBase increaseDataBase;
    @Override
    public void actionPerformed(ActionEvent e) {
        connector.AddBook(increaseDataBase.user_input[0].getText(), increaseDataBase.user_input[1].getText());
    }
}
