package com.dpt.backend.project.template.adapter.sql.user;

import com.dpt.backend.project.template.domain.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
    @Query(value = """ 
            SELECT *
            FROM users u
            WHERE to_tsvector('simple', 
                coalesce(u.username, '') || ' ' || 
                coalesce(u.full_name, '') || ' ' || 
                coalesce(u.email, '')
            ) @@ plainto_tsquery('simple', :query)
                AND u.deleted_at IS NULL AND u.deleted_by IS NULL
            """, countQuery = """
            SELECT COUNT(*)
            FROM users u
            WHERE to_tsvector('simple', 
                coalesce(u.username, '') || ' ' || 
                coalesce(u.full_name, '') || ' ' || 
                coalesce(u.email, '')
            ) @@ plainto_tsquery('simple', :query)
                AND u.deleted_at IS NULL AND u.deleted_by IS NULL
            """, nativeQuery = true)
    Page<User> findAllFullTextPaginated(@Param("query") String q, Pageable pageable);

    @Query(value = "SELECT * FROM users u where id = :userId and deleted_at is null and deleted_by is null", nativeQuery = true)
    Optional<User> findOneById(@Param("userId") Long userId);
}
