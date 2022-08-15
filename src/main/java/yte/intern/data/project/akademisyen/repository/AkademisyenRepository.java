package yte.intern.data.project.akademisyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.akademisyen.entity.Akademisyen;

public interface AkademisyenRepository extends JpaRepository<Akademisyen,Long> {
}
