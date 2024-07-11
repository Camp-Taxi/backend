package com.richjun.campride.post.response;

import com.richjun.campride.comment.response.CommentResponse;
import com.richjun.campride.like.response.LikeResponse;
import com.richjun.campride.post.domain.Post;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostResponse {

    private Long id;
    private String name;
    private String title;
    private List<LikeResponse> likeResponses;
    private List<CommentResponse> commentResponses;
    private List<String> imageNames;
    private LocalDateTime createdAt;


    public static PostResponse of(Post post) {
        return new PostResponse(
                post.getId(),
                post.getNickname(),
                post.getTitle(),
                LikeResponse.from(post.getLikes()),
                CommentResponse.from(post.getComments()),
                post.getImages(),
                post.getCreatedAt()
        );
    }

}
