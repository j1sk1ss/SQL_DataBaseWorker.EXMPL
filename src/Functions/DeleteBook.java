package Functions;

import DataWorker.Connector;
import Windows.DecreaseDataBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBook implements ActionListener {
    public DeleteBook(Connector connector, DecreaseDataBase decreaseDataBase) {
        this.connector = connector;
        this.decreaseDataBase = decreaseDataBase;
    }
    private Connector connector;
    private DecreaseDataBase decreaseDataBase;
    @Override
    public void actionPerformed(ActionEvent e) {
        connector.DeleteBook(Integer.parseInt(decreaseDataBase.user_input.getText()));
    }
}
