package com.example.commentcrud.repository;

import com.example.commentcrud.entity.Comment;
import com.example.commentcrud.entity.InComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InCommentRepository extends JpaRepository<InComment, Long> {

    InComment findByCommentId(Long commentId);
}
