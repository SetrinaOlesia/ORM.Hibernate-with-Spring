package com.sprint.hibernate.service.serviceImpl;


import com.sprint.hibernate.entity.Marathon;
import com.sprint.hibernate.repository.MarathonRepository;
import com.sprint.hibernate.service.MarathonService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

public class MarathonServiceImpl implements MarathonService {

    final private MarathonRepository marathonRepository;

    public MarathonServiceImpl(MarathonRepository marathonRepository) {
        this.marathonRepository = marathonRepository;
    }
    @Override
    public List<Marathon> getAll() {
        List<Marathon> marathons = marathonRepository.findAll();
        if (!marathons.isEmpty()) {
            return marathons;
        }
        return new ArrayList<>();
    }

    @Override
    public Marathon getMarathonById(Long marathonId) {
        Optional<Marathon> marathon = marathonRepository.findById(marathonId);
        if (marathon.isPresent()) {
            return marathon.get();
        } else {
            throw new EntityNotFoundException("No marathon with such id!");
        }
    }
    @Override
    public Marathon createOrUpdate(Marathon entity) {
        if (entity.getId() != null) {
            Optional<Marathon> marathon = marathonRepository.findById(entity.getId());
            if (marathon.isPresent()) {
                Marathon newMarathon = marathon.get();
                newMarathon.setTitle(entity.getTitle());
                newMarathon = marathonRepository.save(newMarathon);
                return newMarathon;
            }
        }
        entity = marathonRepository.save(entity);
        return entity;
    }

    @Override
    public void deleteMarathonById(Long marathonId) {
        Optional<Marathon> marathon = marathonRepository.findById(marathonId);
        if (marathon.isPresent()) {
            marathonRepository.deleteById(marathonId);
        } else throw new EntityNotFoundException("No marathon with such id!");
    }
}
