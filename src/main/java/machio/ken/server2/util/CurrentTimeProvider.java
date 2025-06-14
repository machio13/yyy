package machio.ken.server2.util;

import org.springframework.stereotype.Component;
import java.time.LocalDate;

/**
 * アプリケーションの現在時刻を取得するユーティリティクラスです。
 *
 * <p>
 * アプリケーションロジック内で直接 `LocalDate.now()` を呼び出さないようにすることで、
 * テストコードの記述を簡単にし、保守性を高めるための設計です。
 * </p>
 */
@Component
public class CurrentTimeProvider {

    /**
     * 現在日付（LocalDate）を取得する。
     * このメソッドをモック化することで、日時に依存しないテストが可能になります。
     *
     * @return 今日の日付
     */
    public LocalDate today() {
        return LocalDate.now();
    }
}

