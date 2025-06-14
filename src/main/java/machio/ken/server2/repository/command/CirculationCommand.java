package machio.ken.server2.repository.command;

import machio.ken.server2.model.CirculationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * 貸出記録を登録するコマンド系リポジトリクラス。
 * DBへの書き込み操作を担当します。
 */
@Repository
public class CirculationCommand {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CirculationCommand(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 新しい貸出レコードをデータベースに登録します。
     *
     * @param memberId   会員ID（誰が借りたか）
     * @param collectionId 蔵書ID（どの本か）
     * @param sinceDate  貸出開始日
     * @param dueDate    返却予定日
     * @param status     貸出ステータス（例：IN_RENT）
     */
    public void insert(
            Integer memberId,
            Integer collectionId,
            LocalDate sinceDate,
            LocalDate dueDate,
            CirculationStatus status
    ) {
        String sql = """
            INSERT INTO circulation_record (collection_id, member_id, since_date, due_date, status)
            VALUES (?, ?, ?, ?, ?)
        """;

        jdbcTemplate.update(
                sql,
                collectionId,
                memberId,
                sinceDate,
                dueDate,
                status.name() // Enum → String に変換して保存
        );
    }
}

