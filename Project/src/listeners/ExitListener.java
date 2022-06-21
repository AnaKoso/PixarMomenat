package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ExitListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		int confirm = JOptionPane.showOptionDialog(null,
                "Are You Sure to Close this Application?",
                "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
            System.out.println("exit listener");
            }

}
}