package comparetxtlines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gergohs
 * The code opens a file, read all the lines, filter all duplications and write the filtered data to the given destination file
 */
public class CompareTxtLines {

    public static void main(String[] args) throws IOException {
        File sourceFile = new File("C:\\Users\\evohoge0\\Documents\\NetBeansProjects\\compareTxtLines\\orig.txt");
        File destinatioFile = new File("result.txt");

        FileWriter fWriter = new FileWriter(destinatioFile);
        String actualLine;
        String nextLine;

        try {
            Scanner lineScanner = new Scanner(sourceFile);
            actualLine = lineScanner.nextLine();

            do {
                nextLine = lineScanner.nextLine();
                if (lineScanner.hasNextLine() && !nextLine.equals(actualLine)) {
                    fWriter.write(actualLine);
                    fWriter.write(System.lineSeparator());
                } else if (!lineScanner.hasNextLine()) {
                    fWriter.write(nextLine);
                }
                actualLine = nextLine;
            } while (lineScanner.hasNextLine());
        } catch (FileNotFoundException ex) {
            fWriter.append("Error, source file not found");
        }
        fWriter.flush();
        fWriter.close();
    }
}
