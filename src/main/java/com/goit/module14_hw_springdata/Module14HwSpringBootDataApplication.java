package com.goit.module14_hw_springdata;

import com.goit.module14_hw_springdata.configuration.ContextFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(exclude = FlywayAutoConfiguration.class)
public class Module14HwSpringBootDataApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(Module14HwSpringBootDataApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.contextFactory(new ContextFactory())
				.build()
				.run(args);
	}
}
