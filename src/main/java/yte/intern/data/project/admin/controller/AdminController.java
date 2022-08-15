package yte.intern.data.project.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.data.project.admin.controller.request.AddAdminRequest;
import yte.intern.data.project.admin.controller.request.UpdateAdminRequest;
import yte.intern.data.project.admin.controller.responses.AdminQueryModel;
import yte.intern.data.project.admin.controller.request.AddAdminRequest;
import yte.intern.data.project.admin.controller.request.UpdateAdminRequest;
import yte.intern.data.project.admin.controller.responses.AdminQueryModel;
import yte.intern.data.project.admin.service.AdminService;
import yte.intern.data.project.common.response.MessageResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
@Validated
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public MessageResponse addAdmin(@Valid @RequestBody AddAdminRequest addAdminRequest) {
        return adminService.addAdmin(addAdminRequest.toDomainEntity());
    }

    @GetMapping
    public List<AdminQueryModel> getAllAdmins() {
        return adminService.getAllAdmins()
                .stream()
                .map(admin -> new AdminQueryModel(admin))
                .toList();
    }

    @GetMapping("/{id}")
    public AdminQueryModel getById(@NotNull @PathVariable Long id) {
        return new AdminQueryModel(adminService.getById(id));
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteAdminById(@PathVariable @NotNull Long id) {
        return adminService.deleteAdminById(id);
    }

    @PutMapping("/{id}")
    public MessageResponse updateAdmin(@Valid @RequestBody UpdateAdminRequest request, @PathVariable Long id) {
        return adminService.updateAdmin(id, request.toDomainEntity());
    }
}
