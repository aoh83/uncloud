package monster.scalable.uncloud;

import org.springframework.boot.SpringApplication;

public class TestUncloudApplication {

	public static void main(String[] args) {
		SpringApplication.from(UncloudApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
