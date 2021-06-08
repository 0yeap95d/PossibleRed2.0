package team.talktalk.possiblered.repo.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.talktalk.possiblered.entity.post.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
