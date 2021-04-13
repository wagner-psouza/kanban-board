package br.com.estudos.kanban.controller.bucket;

import br.com.estudos.kanban.request.bucket.CriarBucketRequest;
import br.com.estudos.kanban.response.bucket.CriarBucketResponse;
import br.com.estudos.kanban.services.bucket.NovoBucketService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping
public class NovoBucketController {

    private static final String PATH = "v1/board/{board_id}/bucket";

    private final NovoBucketService novoBucketService;

    public NovoBucketController(NovoBucketService novoBucketService) {
        this.novoBucketService = novoBucketService;
    }

    @ApiOperation(value = "Cria um novo bucket para o board")
    @PostMapping(PATH)
    public ResponseEntity<CriarBucketResponse> novo(
            @PathVariable("board_id") Long id,
            @RequestBody @Valid CriarBucketRequest request,
            UriComponentsBuilder uriBuilder) {

        CriarBucketResponse response = novoBucketService.execute(id, request);
        var url = PATH.concat("/{id}");
        var uri = uriBuilder.path(url).buildAndExpand(id, response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);

    }

}
