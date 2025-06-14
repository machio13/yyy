package machio.ken.server2.model;

/**
 * 貸出ステータス
 */
public enum CirculationStatus {
    IN_RENT,     // 貸出中
    RETURNED,    // 返却済み
    EXTENDED     // 延長中
}
