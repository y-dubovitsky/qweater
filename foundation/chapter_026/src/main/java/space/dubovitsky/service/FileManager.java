package space.dubovitsky.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Component
public class FileManager {

    /**
     * Метод возвращает множество уникальных расширений файлов
     * @param folder
     * @return
     */
    public Set<String> getExtensionList(String folder) {
        File dir = new File(folder);
        Set<String> extList = new TreeSet<>();
        for (String fileName : dir.list()) {
            File file = new File(dir.getAbsolutePath() + "\\" + fileName);
            int i = fileName.lastIndexOf(".");
            if (file.isFile() && i != -1) {
                extList.add(fileName.substring(i + 1, fileName.length()).toLowerCase());
            }
        }
        return extList;
    }

    /**
     * Метод возвращает карту : формат файла - количество файлов данного формата
     * @param folder
     * @return
     */
    public Map<String, Integer> getExtensionCount(String folder) {
        File dir = new File(folder);

        Map<String, Integer> map = new HashMap<>();
        for (String extension : getExtensionList(folder)) {
            FilenameFilter filenameFilter = new CustomFileFilter(extension);
            map.put(extension, dir.list(filenameFilter).length);
        }
        return map;
    }

    private static class CustomFileFilter implements FilenameFilter {

        /**
         * Расширение файла
         */
        private String extension;

        public CustomFileFilter(String extension) {
            this.extension = extension;
        }

        /**
         * Tests if a specified file should be included in a file list.
         *
         * @param dir  the directory in which the file was found.
         * @param name the name of the file.
         * @return <code>true</code> if and only if the name should be
         * included in the file list; <code>false</code> otherwise.
         */
        @Override
        public boolean accept(File dir, String name) {
            return name.toUpperCase().endsWith("." + extension.toUpperCase());
        }
    }

}
