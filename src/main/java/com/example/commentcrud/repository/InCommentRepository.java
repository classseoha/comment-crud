package com.example.commentcrud.repository;

import com.example.commentcrud.entity.InComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InCommentRepository extends JpaRepository<InComment, Long> {
}
