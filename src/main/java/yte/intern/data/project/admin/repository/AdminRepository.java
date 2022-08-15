package yte.intern.data.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
