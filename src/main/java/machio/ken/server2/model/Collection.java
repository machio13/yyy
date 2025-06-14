package machio.ken.server2.model;

import java.time.LocalDateTime;

/**
 * 蔵書クラス（Collection）
 *
 * 実際に図書館に存在する「本そのもの」を表すクラスです。
 * ISBNなどで定義された書籍の情報（PublishedTitle）とは別に、
 * 1冊1冊の個体（蔵書）を管理するために使用します。
 */
public class Collection {

    /** 蔵書ID（システム内のユニークな識別子） */
    private Integer id;

    /** 現在の状態（貸出可・貸出中など） */
    private CollectionStatus status;

    /** シリアル番号（1つの書籍に対して複数冊ある場合の識別子） */
    private Integer serialNumber;

    /** この蔵書が紐づく書籍タイトルのID（PublishedTitleテーブルの主キー） */
    private Integer publishedTitleId;

    /** 登録日時（この蔵書が図書館に追加された日時） */
    private LocalDateTime createdDatetime;

    // --- Getter / Setter ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CollectionStatus getStatus() {
        return status;
    }

    public void setStatus(CollectionStatus status) {
        this.status = status;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getPublishedTitleId() {
        return publishedTitleId;
    }

    public void setPublishedTitleId(Integer publishedTitleId) {
        this.publishedTitleId = publishedTitleId;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
}
