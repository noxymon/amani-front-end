package id.akademi.amanifo;

import java.time.Duration;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void learnSelisihHari(){
		LocalDate now = LocalDate.now();
		LocalDate startTime = LocalDate.of(2020, 8, 9);
		System.out.println(Duration.between(now.atStartOfDay(),startTime.atStartOfDay()).toDays());
	};

}
