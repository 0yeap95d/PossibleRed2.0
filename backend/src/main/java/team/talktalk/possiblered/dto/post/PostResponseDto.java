package team.talktalk.possiblered.dto.post;

import lombok.Getter;
import team.talktalk.possiblered.entity.post.Post;

import java.util.Date;

@Getter
public class PostResponseDto {

    private Long postNo;
    private Date postDate;
    private String postPhoto;
    private String postContent;

    public PostResponseDto(Post post) {
        this.postNo = post.getPostNo();
        this.postDate = post.getPostDate();
        this.postPhoto = post.getPostPhoto();
        this.postContent = post.getPostContent();
    }
}
