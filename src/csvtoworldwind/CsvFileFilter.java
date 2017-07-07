
package csvtoworldwind;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class CsvFileFilter extends FileFilter {               

    public boolean accept(File file) {
        return (file.isDirectory()
                || file.getName().toUpperCase().endsWith(".CSV"));
    }

    public String getDescription() {
        return "*.csv";
    }
}
