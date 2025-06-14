package machio.ken.server2.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class NewCirculationInput {

    @NotNull
    private Integer memberId;

    @NotNull
    private Integer collectionId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate sinceDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dueDate;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public LocalDate getSinceDate() {
        return sinceDate;
    }

    public void setSinceDate(LocalDate sinceDate) {
        this.sinceDate = sinceDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "NewCirculationInput{" +
                "memberId=" + memberId +
                ", collectionId=" + collectionId +
                ", sinceDate=" + sinceDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
