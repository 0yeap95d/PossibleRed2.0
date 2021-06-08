package team.talktalk.possiblered.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.talktalk.possiblered.dto.post.PostResponseDto;
import team.talktalk.possiblered.dto.post.PostSaveRequestDto;
import team.talktalk.possiblered.dto.post.PostUpdateRequestDto;
import team.talktalk.possiblered.entity.post.Post;
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
    public PostResponseDto findById(Long postNo){
        Post post = postRepository.findById(postNo)
                .orElseThrow(() -> new IllegalAccessError("[postNo =" + postNo + "] 해당 포스트가 존재하지 않습니다."));
        return new PostResponseDto(post);
    }
    // 포스트 - 등록
    @Transactional
    public Long save(PostSaveRequestDto postSaveRequestDto){
        return postRepository.save(postSaveRequestDto.toEntity())
                .getPostNo();
    }
    // 포스트 - 수정
    @Transactional
    public Long update(Long postNo, PostUpdateRequestDto postUpdateRequestDto){
        Post post = postRepository.findById(postNo)
                .orElseThrow(() -> new IllegalAccessError("[postNo=" + postNo + "] 해당 포스트가 존재하지 않습니다."));
        post.update(postUpdateRequestDto.getPostDate(), postUpdateRequestDto.getPostPhoto(), postUpdateRequestDto.getPostContent());
        return postNo;
    }
    // 포스트 - 삭제
    @Transactional
    public void delete(Long postNo){
        Post post = postRepository.findById(postNo)
                .orElseThrow(() -> new IllegalAccessError("[postNo=" + postNo + "] 해당 포스트가 존재하지 않습니다."));
        postRepository.delete(post);
    }
}
