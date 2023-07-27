package uz.pdp.shaftoli.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseModel {
    {
        this.id = UUID.randomUUID();
    }
    protected UUID id;
    protected Timestamp createdDate;
    protected Timestamp updatedDate;

}