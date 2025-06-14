package machio.ken.server2.model;

import java.time.LocalDateTime;

/**
 * 利用者クラス（Member）
 *
 * 図書館を利用するユーザーの情報を表します。
 * 貸出・返却の履歴に関連づけられ、システム内で一意に識別されます。
 */
public class Member {

    /** 会員ID（ユニーク識別子） */
    private Integer id;

    /** 利用者の名前 */
    private String name;

    /** 利用者のメールアドレス */
    private String email;

    /** 登録日時（この利用者が登録された日時） */
    private LocalDateTime createdDatetime;

    // --- Getter / Setter ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
}
