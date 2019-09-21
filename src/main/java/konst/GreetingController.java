package konst;


import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import konst.Message;


@Controller
public class GreetingController {
    @Autowired
    private MessageRep userRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") 
    String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = userRepository.findAll();
        model.put("messages", messages);
    	return "main";
    }
    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
       Message message = new Message(text, tag);
userRepository.save(message);
Iterable<Message> messages = userRepository.findAll();
model.put("messages", messages);
return "main";
    }
@PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
Iterable<Message> messages;
if (filter != null && !filter.isEmpty()){
    messages = userRepository.findByTag(filter);
}else {
    messages = userRepository.findAll();
}
model.put("massages", messages);
        return "main";
}
}