package learn.spring.manualdatasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class ManualDataSourceApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ManualDataSourceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    private void showData() {
        log.info("Start showing data--------------------------------------------------------------");
        jdbcTemplate.queryForList("select * from t_user;")
                .forEach(row -> log.info(row.toString()));
        log.info("End showing data++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private void showConnection() throws SQLException {
        log.info("--------------------------------------------------------------");
        log.info(dataSource.toString());
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Connection connection = dataSource.getConnection();
        log.info("--------------------------------------------------------------");
        log.info(connection.toString());
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        connection.close();
    }
}
