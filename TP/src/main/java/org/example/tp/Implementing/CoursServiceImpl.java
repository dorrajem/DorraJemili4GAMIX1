package org.example.tp.Implementing;

import org.example.tp.Entities.Cours;
import org.example.tp.Repositories.CoursRepository;
import org.example.tp.Repositories.PisteRepository;
import org.example.tp.Services.ICoursService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursServiceImpl implements ICoursService {

    private static final Logger log = LoggerFactory.getLogger(CoursServiceImpl.class);

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    private final CoursRepository coursRepository;

    @Override
    public Cours addCours(Cours cours) {
        log.info("Received Cours: {}", cours);
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }

    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }
}
