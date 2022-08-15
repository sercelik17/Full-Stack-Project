package yte.intern.data.project.asistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.data.project.asistan.controller.request.AddAsistanRequest;
import yte.intern.data.project.asistan.controller.request.UpdateAsistanRequest;
import yte.intern.data.project.asistan.controller.responses.AsistanQueryModel;
import yte.intern.data.project.asistan.service.AsistanService;
import yte.intern.data.project.common.response.MessageResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/asistans")
@RequiredArgsConstructor
@Validated
public class AsistanController {
    private final AsistanService asistanService;

    @PostMapping
    public MessageResponse addAsistan(@Valid @RequestBody yte.intern.data.project.asistan.controller.request.AddAsistanRequest addAsistanRequest) {
        return asistanService.addAsistan(addAsistanRequest.toDomainEntity());
    }

    @GetMapping
    public List<AsistanQueryModel> getAllAsistans() {
        return asistanService.getAllAsistans()
                .stream()
                .map(asistan -> new yte.intern.data.project.asistan.controller.responses.AsistanQueryModel(asistan))
                .toList();
    }

    @GetMapping("/{id}")
    public AsistanQueryModel getById(@NotNull @PathVariable Long id) {
        return new AsistanQueryModel(asistanService.getById(id));
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteAsistanById(@PathVariable @NotNull Long id) {
        return asistanService.deleteAsistanById(id);
    }

    @PutMapping("/{id}")
    public MessageResponse updateAsistan(@Valid @RequestBody UpdateAsistanRequest request, @PathVariable Long id) {
        return asistanService.updateAsistan(id, request.toDomainEntity());
    }
}
