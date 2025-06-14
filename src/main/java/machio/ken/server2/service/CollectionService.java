package machio.ken.server2.service;

import machio.ken.server2.model.CirculationStatus;
import machio.ken.server2.model.view.CollectionWithStatus;
import machio.ken.server2.repository.command.CirculationCommand;
import machio.ken.server2.repository.query.CollectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * 蔵書の貸出操作や情報取得に関するアプリケーションロジックを担当するサービスクラス。
 */
@Service
@Transactional
public class CollectionService {

    private final CirculationCommand circulationCommand;
    private final CollectionQuery reader;

    /**
     * コンストラクタインジェクション
     * @param circulationCommand 書き込み系リポジトリ
     * @param reader 読み取り系リポジトリ
     */
    @Autowired
    public CollectionService(CirculationCommand circulationCommand, CollectionQuery reader) {
        this.circulationCommand = circulationCommand;
        this.reader = reader;
    }

    /**
     * 蔵書一覧（貸出状態付き）を取得します。
     * @return CollectionWithStatusのリスト
     */
    public List<CollectionWithStatus> listAll() {
        return reader.listAll();
    }

    /**
     * 指定した蔵書ID・会員ID・貸出日などに基づいて、貸出処理を試みます。
     * データベースに貸出情報を登録し、最新の蔵書情報を返します。
     *
     * @param collectionId 蔵書ID
     * @param memberId 会員ID
     * @param sinceDate 貸出開始日
     * @param dueDate 返却予定日
     * @return 貸出後の蔵書状態
     */
    public CollectionWithStatus tryToCheckout(Integer collectionId, Integer memberId,
                                              LocalDate sinceDate, LocalDate dueDate) {
        // データベースに貸出レコードを挿入
        circulationCommand.insert( memberId, collectionId, sinceDate, dueDate, CirculationStatus.IN_RENT);

        // 登録された貸出情報を含む蔵書状態を再取得して返す
        return reader.findById(collectionId);
    }
}

