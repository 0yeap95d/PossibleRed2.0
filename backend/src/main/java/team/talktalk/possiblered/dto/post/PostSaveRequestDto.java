package team.talktalk.possiblered.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.talktalk.possiblered.entity.post.Post;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {

    private Date postDate;
    private String postPhoto;
    private String postContent;

    @Builder
    public PostSaveRequestDto(Date postDate, String postPhoto, String postContent) {
        this.postDate = postDate;
        this.postPhoto = postPhoto;
        this.postContent = postContent;
    }

    public Post toEntity() {
        return Post.builder()
                .postDate(postDate)
                .postPhoto(postPhoto)
                .postContent(postContent)
                .build();
    }
}
