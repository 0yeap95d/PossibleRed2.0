package team.talktalk.possiblered.controller.post;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.talktalk.possiblered.dto.post.PostResponseDto;
import team.talktalk.possiblered.dto.post.PostSaveRequestDto;
import team.talktalk.possiblered.dto.post.PostUpdateRequestDto;
import team.talktalk.possiblered.service.post.PostService;

import javax.persistence.PostUpdate;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;

    // 포스트 - 목록 조회
    @ApiOperation(value = "포스트 목록 조회 API", notes = "포스트 목록 리스트 반환")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PostResponseDto>> findAll(){
        List<PostResponseDto> postResponseDtoList = postService.findAll();
        return new ResponseEntity<List<PostResponseDto>>(postResponseDtoList, HttpStatus.OK);
    }
    // 포스트 - 상세 조회
    @ApiOperation(value = "포스트 상세 조회 API", notes = "포스트 상세 정보 반환")
    @GetMapping(value = "/{postNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PostResponseDto> findById(@PathVariable("postNo") Long postNo){
        PostResponseDto postResponseDto = postService.findById(postNo);
        return new ResponseEntity<PostResponseDto>(postResponseDto, HttpStatus.OK);
    }
    // 포스트 - 등록
    @ApiOperation(value = "포스트 등록 API", notes = "포스트 등록 후 해당 id값 반환")
    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> save(@RequestBody PostSaveRequestDto postSaveRequestDto){
        Long savedPostId = postService.save(postSaveRequestDto);
        return new ResponseEntity<Long>(savedPostId, HttpStatus.CREATED);
    }
    // 포스트 - 수정
    @ApiOperation(value = "포스트 수정 API", notes = "포스트 수정 후 해당 id값 반환")
    @PutMapping(value = "/{postNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> update(@PathVariable("postNo") Long postNo, @RequestBody PostUpdateRequestDto postUpdateRequestDto){
        Long updatedPostId = postService.update(postNo, postUpdateRequestDto);
        return new ResponseEntity<Long>(updatedPostId, HttpStatus.CREATED);
    }
    // 포스트 - 삭제
    @ApiOperation(value = "포스트 삭제 API", notes = "포스트 삭제 후 해당 id값 반환")
    @DeleteMapping(value = "/{postNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> delete(@PathVariable("postNo") Long postNo){
        postService.delete(postNo);
        return new ResponseEntity<Long>(postNo, HttpStatus.NO_CONTENT);
    }
}
