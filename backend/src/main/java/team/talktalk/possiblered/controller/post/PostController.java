package team.talktalk.possiblered.controller.post;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;

    // 포스트 - 목록 조회
    @ApiOperation(value = "포스트 목록 조회 API", notes = "포스트 목록 리스트 반환")
}
