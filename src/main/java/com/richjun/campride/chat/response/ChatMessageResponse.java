package com.richjun.campride.chat.response;

import com.richjun.campride.chat.domain.ChatMessage;
import com.richjun.campride.chat.domain.ChatMessageType;
import com.richjun.campride.chat.domain.ChatReaction;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatMessageResponse {
    private Long roomId;
    private String userId;
    private String text;
    private String imageUrl;
    private LocalDateTime timestamp;
    private boolean isSender;
    private ChatMessageType chatMessageType;
    private List<ChatReaction> reactions;
    private boolean isReply;
    private String replyingMessage;

    // 정적 팩토리 메서드 추가
    public static ChatMessageResponse from(ChatMessage chatMessage) {
        return new ChatMessageResponse(
                chatMessage.getRoomId(),
                chatMessage
                        .getUserId(),
                chatMessage.getText(),
                chatMessage.getImageUrl(),
                chatMessage.getTimestamp(),
                chatMessage.isSender(),
                chatMessage.getChatMessageType(),
                chatMessage.getReactions(),
                chatMessage.isReply(),
                chatMessage.getReplyingMessage()
        );
    }

    // 리스트 변환을 위한 정적 팩토리 메서드 추가
    public static List<ChatMessageResponse> from(List<ChatMessage> chatMessages) {
        return chatMessages.stream()
                .map(ChatMessageResponse::from).toList();

    }
}