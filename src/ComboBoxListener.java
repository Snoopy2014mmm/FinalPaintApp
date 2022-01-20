import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class ComboBoxListener implements ItemListener {
    private MousePaintListener listener;

    public ComboBoxListener(MousePaintListener listener){
        this.listener = listener;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        ComboBoxItem items = (ComboBoxItem) e.getItem();
        this.listener.setLimit(items.getLimit());
    }
}
