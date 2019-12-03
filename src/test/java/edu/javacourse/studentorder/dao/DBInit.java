package edu.javacourse.studentorder.dao;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBInit {

    public static void startUp() throws Exception {

        executeSqlFromFile("student_project.sql");
        executeSqlFromFile("student_data.sql");
    }

    public static void executeSqlFromFile(String filePath) throws Exception {
        URL url = DictionaryDaoImplTest.class.getClassLoader().getResource(filePath);

        List<String> strings = Files.readAllLines(Paths.get(url.toURI()));
        String sql = strings.stream().collect(Collectors.joining());

        try (Connection con = ConnectionBuilder.getConnection();
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(sql);
        }
    }
}
