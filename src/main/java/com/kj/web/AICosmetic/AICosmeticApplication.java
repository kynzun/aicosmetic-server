package com.kj.web.AICosmetic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class AICosmeticApplication {
	@GetMapping("/")
	public String hello() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(AICosmeticApplication.class, args);
		System.out.println(" _______  _______  _______           _______  _______    _______ _________ _______  _______ _________\n" +
				"(  ____ \\(  ____ \\(  ____ )|\\     /|(  ____ \\(  ____ )  (  ____ \\\\__   __/(  ___  )(  ____ )\\__   __/\n" +
				"| (    \\/| (    \\/| (    )|| )   ( || (    \\/| (    )|  | (    \\/   ) (   | (   ) || (    )|   ) (   \n" +
				"| (_____ | (__    | (____)|| |   | || (__    | (____)|  | (_____    | |   | (___) || (____)|   | |   \n" +
				"(_____  )|  __)   |     __)( (   ) )|  __)   |     __)  (_____  )   | |   |  ___  ||     __)   | |   \n" +
				"      ) || (      | (\\ (    \\ \\_/ / | (      | (\\ (           ) |   | |   | (   ) || (\\ (      | |   \n" +
				"/\\____) || (____/\\| ) \\ \\__  \\   /  | (____/\\| ) \\ \\__  /\\____) |   | |   | )   ( || ) \\ \\__   | |   \n" +
				"\\_______)(_______/|/   \\__/   \\_/   (_______/|/   \\__/  \\_______)   )_(   |/     \\||/   \\__/   )_(   \n" +
				"                                                                                                     ");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
}
