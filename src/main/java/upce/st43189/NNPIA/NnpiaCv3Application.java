package upce.st43189.NNPIA;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@SpringBootApplication
public class NnpiaCv3Application {
	public static void main(String[] args) {
		SpringApplication.run(NnpiaCv3Application.class, args);
	}

	@Controller
	@RequestMapping("user")
	public class GreetingController {

		private final CounterService counterService;

		public GreetingController(@Qualifier("counterService2Imp") CounterService counterService) {
			this.counterService = counterService;
		}

		@RequestMapping(value = "/greeting", method = {RequestMethod.GET})
		public String requestGreeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
			counterService.add();
			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
			model.addAttribute("counter", counterService.getCounter());
			return "greeting";
		}
		@GetMapping(value = "/welcome/{name}")
		public String requestWelcome(@PathVariable("name") String username, Model model){
			counterService.add();
			model.addAttribute("name", StringUtils.toUpperCase(username, Locale.ENGLISH));
			model.addAttribute("counter", counterService.getCounter());
			return "greeting";
		}
	}
}
