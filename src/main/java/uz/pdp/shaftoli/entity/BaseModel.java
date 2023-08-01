package uz.pdp.shaftoli.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    @CreationTimestamp
    protected  LocalDateTime createdDate;
    @UpdateTimestamp
    protected LocalDateTime updatedDate;

}