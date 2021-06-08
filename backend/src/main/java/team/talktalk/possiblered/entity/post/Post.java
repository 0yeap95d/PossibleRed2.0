package team.talktalk.possiblered.entity.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;
    private Date postDate;
    private String postPhoto;
    private String postContent;

    @Builder
    public Post(Date postDate, String postPhoto, String postContent) {
        this.postDate = postDate;
        this.postPhoto = postPhoto;
        this.postContent = postContent;
    }

    public void update(Date postDate, String postPhoto, String postContent) {
        this.postDate = postDate;
        this.postPhoto = postPhoto;
        this.postContent = postContent;
    }
}
