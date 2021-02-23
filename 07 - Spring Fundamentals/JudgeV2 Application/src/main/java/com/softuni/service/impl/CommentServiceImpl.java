package com.softuni.service.impl;

import com.softuni.model.enitity.Comment;
import com.softuni.model.service.CommentServiceModel;
import com.softuni.repository.CommentRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.CommentService;
import com.softuni.service.HomeworkService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final HomeworkService homeworkService;
    private final CurrentUser currentUser;
    private final UserService userService;
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, HomeworkService homeworkService, UserService userService, CurrentUser currentUser) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.homeworkService = homeworkService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void add(CommentServiceModel serviceModel, Long homeworkId) {
        Comment comment = modelMapper.map(serviceModel, Comment.class);

        comment.setHomework(this.homeworkService.findByID(homeworkId));
        comment.setAuthor(userService.findById(currentUser.getId()));

        commentRepository.save(comment);
    }

    @Override
    public Double findAvgScore() {

        return this.commentRepository.findAvgScore();
    }

    @Override
    public Map<Integer, Integer> findScoreMap() {
        Map<Integer, Integer> scoreMap = initScoreMap();

        commentRepository
                .findAll()
                .forEach(comment -> {
                    Integer score = comment.getScore();
                    scoreMap.put(score, scoreMap.get(score) + 1);
                });

        return scoreMap;
    }

    private Map<Integer, Integer> initScoreMap() {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 2; i <= 6; i++) {
            map.put(i,0);
        }

        return map;
    }


}
