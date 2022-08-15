package yte.intern.data.project.akademisyen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;
import yte.intern.data.project.akademisyen.repository.AkademisyenRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AkademisyenService {
    private final AkademisyenRepository akademisyenRepository;

    public MessageResponse addAkademisyen(Akademisyen akademisyen) {
        akademisyenRepository.save(akademisyen);

        return new MessageResponse(ResponseType.SUCCESS, "Academician has been added successfully");
    }

    public List<Akademisyen> getAllAkademisyen() {
        return akademisyenRepository.findAll();
    }

    public Akademisyen getById(Long id) {
        return akademisyenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Academician not found"));
    }

    public MessageResponse deleteAkademisyenById(Long id) {
        akademisyenRepository.deleteById(id);
        return new MessageResponse(ResponseType.SUCCESS, "Academician has been deleted successfully");
    }

    public MessageResponse updateAkademisyen(Long id, Akademisyen updatedAkademisyen) {
        Akademisyen akademisyen = akademisyenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Academician not found"));

        akademisyen.update(updatedAkademisyen);

        akademisyenRepository.save(akademisyen);

        return new MessageResponse(ResponseType.SUCCESS, "Academician has been updated successfully");
    }
}
