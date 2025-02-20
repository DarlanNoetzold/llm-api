package tech.noetzold.llm_api;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class OllamaChatController {

    private final ChatClient chatClient;

    public OllamaChatController(@Qualifier("ollamaChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ollama")
    public Flux<String> ollama() {
        return chatClient.prompt()
                .user("Can you give an example of a leet style coding problem and answer it in Java")
                .stream()
                .content();
    }
}
