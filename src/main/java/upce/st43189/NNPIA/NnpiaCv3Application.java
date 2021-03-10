package upce.st43189.NNPIA;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		public String requestGreeting(@RequestParam(name= "date", required=false, defaultValue="01.01.2021" ) String customDate, Model model){
			counterService.add();
			model.addAttribute("date", StringUtils.toUpperCase(customDate, Locale.ENGLISH));
			model.addAttribute("counter", counterService.getCounter());
			return "greeting";
		}
		@GetMapping(value = "/welcome")
		public String requestWelcome(Model model){
			counterService.add();
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			String date = df.format(new Date());
			model.addAttribute("date", StringUtils.toUpperCase(date, Locale.ENGLISH));
			model.addAttribute("counter", counterService.getCounter());
			return "greeting";
		}
	}
	@Controller
	@RequestMapping("inside")
	public class GreetingController2 {

		private final CounterService counterService;

		public GreetingController2(@Qualifier("counterService2Imp") CounterService counterService) {
			this.counterService = counterService;
		}

		@GetMapping(value = "/welcome")
		public String requestWelcome(@RequestParam(name="name", defaultValue="World") String name, Model model){
			counterService.add();
			name = name.toLowerCase();
			name = name.substring(0,1).toUpperCase() + name.substring(1);
			int index = name.indexOf(" ") + 1;
			name = name.substring(0, index) + name.substring(index,index + 1).toUpperCase() + name.substring(index + 1);
			model.addAttribute("name", name);
			return "greeting2";
		}
	}
}
