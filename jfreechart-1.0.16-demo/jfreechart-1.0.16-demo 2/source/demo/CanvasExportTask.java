package demo;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.JFreeChart;
import org.jfree.graphics2d.canvas.CanvasGraphics2D;
import org.jfree.graphics2d.canvas.CanvasUtils;
import org.jfree.ui.RectangleInsets;

public class CanvasExportTask implements Runnable {

    JFreeChart chart;

    int width;

    int height;

    File file;

    /**
     * A task that exports a chart to a file in PDF format using iText.
     *
     * @param chart  the chart.
     * @param width  the width.
     * @param height  the height.
     * @param file  the file.
     */
    public CanvasExportTask(JFreeChart chart, int width, int height, File file) {
        this.chart = chart;
        this.file = file;
        this.width = width;
        this.height = height;
        chart.setBorderVisible(true);
        chart.setPadding(new RectangleInsets(2, 2, 2, 2));
    }

    /**
     * Performs the task.
     */
    public void run() {
        try {           
            CanvasGraphics2D g2 = new CanvasGraphics2D("canvas1");
            this.chart.draw(g2, new Rectangle(this.width, this.height));
            CanvasUtils.writeToHTML(this.file, "", g2.getCanvasID(), this.width, this.height, g2.getScript() + "\n");
        }
        catch (IOException e) {
           throw new RuntimeException(e);
        }
    }

}

