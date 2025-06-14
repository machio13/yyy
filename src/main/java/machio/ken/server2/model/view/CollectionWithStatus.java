package machio.ken.server2.model.view;

import machio.ken.server2.model.CirculationStatus;
import machio.ken.server2.model.CollectionStatus;

import java.time.LocalDate;

/**
 * 蔵書と、その書籍の交換情報、貸出状態の記録などをひとつにまとめた情報表示クラスです。
 */
public class CollectionWithStatus {

    private Integer collectionId;
    private CollectionStatus collectionStatus;
    private Integer serialNumber;

    private String publishedTitleIsbn;
    private String publishedTitleName;
    private String publishedTitleAuthor;

    private Integer circulationRecordId;
    private LocalDate sinceDate;
    private LocalDate dueDate;
    private LocalDate actualReturnDate;
    private CirculationStatus circulationStatus;

    private Integer borrowerId;
    private String borrowerName;

    // Getters and Setters

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public CollectionStatus getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(CollectionStatus collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPublishedTitleIsbn() {
        return publishedTitleIsbn;
    }

    public void setPublishedTitleIsbn(String publishedTitleIsbn) {
        this.publishedTitleIsbn = publishedTitleIsbn;
    }

    public String getPublishedTitleName() {
        return publishedTitleName;
    }

    public void setPublishedTitleName(String publishedTitleName) {
        this.publishedTitleName = publishedTitleName;
    }

    public String getPublishedTitleAuthor() {
        return publishedTitleAuthor;
    }

    public void setPublishedTitleAuthor(String publishedTitleAuthor) {
        this.publishedTitleAuthor = publishedTitleAuthor;
    }

    public Integer getCirculationRecordId() {
        return circulationRecordId;
    }

    public void setCirculationRecordId(Integer circulationRecordId) {
        this.circulationRecordId = circulationRecordId;
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

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public CirculationStatus getCirculationStatus() {
        return circulationStatus;
    }

    public void setCirculationStatus(CirculationStatus circulationStatus) {
        this.circulationStatus = circulationStatus;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getSerialAndTitle() {
        return String.format("%s: %s", serialNumber, publishedTitleName);
    }

    @Override
    public String toString() {
        return "CollectionWithStatus{" +
                "collectionId=" + collectionId +
                ", collectionStatus=" + collectionStatus +
                ", serialNumber=" + serialNumber +
                ", publishedTitleIsbn='" + publishedTitleIsbn + '\'' +
                ", publishedTitleName='" + publishedTitleName + '\'' +
                ", publishedTitleAuthor='" + publishedTitleAuthor + '\'' +
                ", circulationRecordId=" + circulationRecordId +
                ", sinceDate=" + sinceDate +
                ", dueDate=" + dueDate +
                ", actualReturnDate=" + actualReturnDate +
                ", circulationStatus=" + circulationStatus +
                ", borrowerId=" + borrowerId +
                ", borrowerName='" + borrowerName + '\'' +
                '}';
    }
}

