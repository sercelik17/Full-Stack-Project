package yte.intern.data.project.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.data.project.admin.entity.Admin;
import yte.intern.data.project.admin.entity.Admin;
import yte.intern.data.project.admin.repository.AdminRepository;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;
import yte.intern.data.project.student.entity.Student;
import yte.intern.data.project.student.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final yte.intern.data.project.admin.repository.AdminRepository adminRepository;

    public yte.intern.data.project.common.response.MessageResponse addAdmin(Admin admin) {
        adminRepository.save(admin);

        return new yte.intern.data.project.common.response.MessageResponse(yte.intern.data.project.common.response.ResponseType.SUCCESS, "Student has been added successfully");
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin.js not found"));
    }

    public MessageResponse deleteAdminById(Long id) {
        adminRepository.deleteById(id);

        return new MessageResponse(ResponseType.SUCCESS, "Admin.js has been deleted successfully");
    }

    public MessageResponse updateAdmin(Long id, Admin updatedAdmin) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin.js not found"));

        // admin.update(updatedAdmin);

        adminRepository.save(admin);

        return new MessageResponse(ResponseType.SUCCESS, "Admin.js has been updated successfully");
    }
}
