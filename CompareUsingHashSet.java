package comparetxtlinesusinghashset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author gergohs
 * The code opens a file, read all the lines, filter all duplications, sort the filtered lines in alphabetically growing order and write it to the destination file
 */
public class CompareUsingHashSet {

    public static void main(String[] args) throws IOException {
        File sourceFile = new File("C:\\Users\\evohoge0\\Documents\\NetBeansProjects\\CompareTxtLinesUsingHashSet\\orig.txt");
        File destinationFile = new File("result.txt");
        FileWriter fWriter = new FileWriter(destinationFile);

        List<String> linesFromDoc;
        Set<String> set;
        List<String> sortedList;

        try {
            Scanner lineScanner = new Scanner(sourceFile);
            linesFromDoc = new ArrayList<>();

            while (lineScanner.hasNext()) {
                linesFromDoc.add(lineScanner.next());
            }

            set = new HashSet<>(linesFromDoc);
            sortedList = new ArrayList<>(set);
            Collections.sort(sortedList);

            int lineCounter = 0;
            for (String x : sortedList) {
                fWriter.append(sortedList.get(lineCounter));
                fWriter.append(System.lineSeparator());
                lineCounter++;
            }
        } catch (FileNotFoundException ex) {
            fWriter.append("Error, source file not found");
        }
        fWriter.flush();
        fWriter.close();
    }
}
