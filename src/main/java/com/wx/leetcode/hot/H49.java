package com.wx.leetcode.hot;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;


import java.util.*;

public class H49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
//        OpenAiService service = new OpenAiService("OPENAPI_TOKEN");
//        CompletionRequest completionRequest = CompletionRequest.builder()
//                .model("text-davinci-003")
//                .prompt("Q: 今天重庆的天气咋样?\nA:")
//                .temperature(0D)
//                .maxTokens(1000)
//                .topP(1D)
//                .frequencyPenalty(0D)
//                .presencePenalty(0D)
//                .stop(Arrays.asList("\n"))
//                .build();
//        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
        sendMsg();
    }

    public static void sendMsg() {
        // 消息列表
        List<ChatMessage> list = new ArrayList<>();

        // 给chatGPT定义一个身份，是一个助手
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("system");
        chatMessage.setContent("You are a helpful assistant.");
        list.add(chatMessage);

        // 定义一个用户身份，content是用户写的内容
        ChatMessage userMessage = new ChatMessage();
        userMessage.setRole("user");
        userMessage.setContent("hello");
        list.add(userMessage);

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .messages(list)
                .model("gpt-3.5-turbo")
                .build();
        OpenAiService service = new OpenAiService("your token");

        // chatCompletion 对象就是chatGPT响应的数据了
        ChatCompletionResult chatCompletion = service.createChatCompletion(request);

        System.out.println(chatCompletion.toString());
    }
}
