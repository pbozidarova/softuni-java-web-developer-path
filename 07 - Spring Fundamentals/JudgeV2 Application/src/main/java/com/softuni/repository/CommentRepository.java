package com.softuni.repository;

import com.softuni.model.enitity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT avg(c.score) FROM Comment as c")
    Double findAvgScore();
}
