package machio.ken.server2.model;

import java.time.LocalDateTime;

/**
 * 公刊書籍（PublishedTitle）
 *
 * 書籍の基本情報（ISBN、書名、著者など）を管理するクラス。
 * 蔵書（Collection）はこのタイトルに紐づきます。
 */
public class PublishedTitle {

    /** 書籍ID（システム内の一意な識別子） */
    private Integer id;

    /** ISBNコード（国際標準図書番号） */
    private String isbn;

    /** 書名（タイトル） */
    private String title;

    /** 著者名 */
    private String author;

    /** 登録日時（書籍情報がシステムに追加された日時） */
    private LocalDateTime createdDatetime;

    // --- Getter / Setter ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
}

