package br.com.ecommerce;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var user = "Gere 5 produtos";
        var system = "gere apenas o nome dos produtos e produtos ficticios";

        var chave = System.getenv("OPEN_API_KEY");

        var service = new OpenAiService(chave);

        var completionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-4")
                .messages(Arrays.asList(
                        new ChatMessage(ChatMessageRole.USER.value(),user),
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),system)
                ))
                .build();

        service.createChatCompletion(completionRequest)
                .getChoices()
                .forEach(c -> System.out.print(c.getMessage().getContent()));





    }
}