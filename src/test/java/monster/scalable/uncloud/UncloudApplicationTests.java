package monster.scalable.uncloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class UncloudApplicationTests {

	@Test
	void contextLoads() {
	}

}
