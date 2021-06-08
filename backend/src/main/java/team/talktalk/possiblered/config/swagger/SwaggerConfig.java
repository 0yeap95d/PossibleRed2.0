package team.talktalk.possiblered.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    /*
     *  Swagger API 문서 생성
     */

    //  http://localhost:8080/swagger-ui/
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())

                /*
                 *  API 설정 (select() - build()의 쌍으로 이루어짐)
                 */
                .select()
                //  API 요청 주소를 정의한 클래스가 있는 패키지 정의
                .apis(RequestHandlerSelectors.basePackage("team.talktalk.possiblered.controller"))
                //  API 요청 주소 중 Swagger에 나타낼 주소 정의
                .paths(PathSelectors.any()).build();
    }

    /*
     *  Swagger 정보
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Possible_Red 2.0") //    API 이름
                        .description("미션 완료형 소셜 네트워크 서비스 플랫폼") //   API 설명
                        .version("2.0.0") //    API 버전
                        .build();
    }
}
