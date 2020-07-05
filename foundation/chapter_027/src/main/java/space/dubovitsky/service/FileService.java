package space.dubovitsky.service;

import org.springframework.stereotype.Component;
import space.dubovitsky.annotation.NotReturnResult;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class FileService {

    /**
     * Абсолютный путь к вайлу
     * @param fileName
     */
    public void fileAbsolutePath(String fileName) {
        File file = new File(fileName);
        for (File f : file.listFiles()) {
            System.out.println(f.getAbsolutePath());
        }
    }

    /**
     * Информация о файле
     * @param fileName
     * @return
     * @throws Exception
     */
    public Map<String, String> fileInfo(String fileName) throws Exception {
        File file = new File(fileName);
        Map<String, String> map = new HashMap<>();
        map.put("file.getName()", file.getName());
        map.put("file.getAbsolutePath()", file.getAbsolutePath());
        map.put("file.getCanonicalPath()", file.getCanonicalPath());
        map.put("file.getParent()", file.getParent());
        map.put("file.getTotalSpace()", String.valueOf(file.getTotalSpace()));
        return map;
    }

    /**
     * Рекурсивно обходит все папки
     * @param dirName
     */
    @NotReturnResult //! Метод помечен собственной аннотацией
    public void getTree(String dirName) {
        File file = new File(dirName);
        if (file.isDirectory()) {
            for (File f :file.listFiles()) {
                if (f.isDirectory()) {
                    getTree(f.getAbsolutePath());
                } else {
                    System.out.println(f.getName());
                }
            }
        }
    }
}
