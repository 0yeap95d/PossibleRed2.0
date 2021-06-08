package team.talktalk.possiblered.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.talktalk.possiblered.dto.post.PostResponseDto;
import team.talktalk.possiblered.repo.post.PostRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    // 포스트 - 목록 조회
    @Transactional
    public List<PostResponseDto> findAll(){
        return postRepository.findAll()
                .stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }
    // 포스트 - 상세 조회
    @Transactional
    public PostResponseDto findByNo(Long postNo)
}
