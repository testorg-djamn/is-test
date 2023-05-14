package net.is.lms.project.utilities;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Objects;

public class CellRenderer implements TableCellRenderer {
    private final TableCellRenderer originalRenderer;

    public CellRenderer(TableCellRenderer originalRenderer) {
        this.originalRenderer = originalRenderer;
    }


    // Update die jeweiligen Zellen, je nachdem, was drinsteht
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final Component c = originalRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        c.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        if (value instanceof String && ((String) value).contains("Available")) {
            c.setForeground(new Color(0, 153, 0));
            c.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13));
        } else if (value instanceof String && ((String) value).contains("Borrowed")) {
            c.setForeground(new Color(206, 17, 17));
            c.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13));
        } else {
            c.setForeground(Color.BLACK);
        }
        return c;
    }
}
