package net.is.lms.project.utilities;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ImageRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String photoName = value.toString();
        ImageIcon icon = new ImageIcon(new ImageIcon(photoName).getImage().getScaledInstance(40, 60, Image.SCALE_DEFAULT));
        return new JLabel(icon);
    }
}
