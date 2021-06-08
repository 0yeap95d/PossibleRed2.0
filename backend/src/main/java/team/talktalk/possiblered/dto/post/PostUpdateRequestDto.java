package team.talktalk.possiblered.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {

    private Date postDate;
    private String postPhoto;
    private String postContent;

    @Builder
    public PostUpdateRequestDto(Date postDate, String postPhoto, String postContent) {
        this.postDate = postDate;
        this.postPhoto = postPhoto;
        this.postContent = postContent;
    }
}
