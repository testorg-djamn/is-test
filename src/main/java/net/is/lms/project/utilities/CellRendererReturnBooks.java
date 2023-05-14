package net.is.lms.project.utilities;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

import static net.is.lms.project.frames.AdminView.checkDeadlineExceed;


public class CellRendererReturnBooks implements TableCellRenderer {
    private final TableCellRenderer originalRenderer;

    public CellRendererReturnBooks(TableCellRenderer originalRenderer) {
        this.originalRenderer = originalRenderer;
    }


    // Update die jeweiligen Zellen, je nachdem, was drinsteht
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final Component c = originalRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        if (value instanceof String) {
            String borrowDate = (String) table.getValueAt(row, 4);
            String dueDate = (String) table.getValueAt(row, 5);
            if (checkDeadlineExceed(borrowDate, dueDate)) {
                if (column == 5) {
                    c.setForeground(Color.RED);
                    c.setFont(new java.awt.Font("Segoe UI", Font.BOLD, c.getFont().getSize()));
                } else c.setForeground(Color.BLACK);
            } else {
                c.setForeground(Color.BLACK);
                c.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, c.getFont().getSize()));
            }
        }
        return c;
    }
}
