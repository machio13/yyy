package machio.ken.server2.model;

/**
 * 蔵書ステータス（CollectionStatus）
 *
 * 蔵書（Collection）が現在どのような状態にあるかを示す列挙型です。
 * 図書館内での運用状態を表します。
 */
public enum CollectionStatus {

    /**
     * 目録作成前（登録はされているが貸出などの運用はまだされていない状態）
     */
    PRE_CATALOGING,

    /**
     * 運用中（通常貸出可能な状態）
     */
    IN_SERVICE,

    /**
     * 廃棄済み（利用できない／除籍された状態）
     */
    DISCONTINUED
}
