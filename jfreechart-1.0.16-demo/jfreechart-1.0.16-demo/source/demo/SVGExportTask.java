package demo;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.JFreeChart;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;
import org.jfree.ui.RectangleInsets;

public class SVGExportTask implements Runnable {

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
    public SVGExportTask(JFreeChart chart, int width, int height, File file) {
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
            SVGGraphics2D g2 = new SVGGraphics2D(this.width, this.height);
            this.chart.draw(g2, new Rectangle(this.width, this.height));
            SVGUtils.writeToHTML(this.file, "title", g2.getSVGElement());
        }
        catch (IOException e) {
           throw new RuntimeException(e);
        }
    }

}


