package machio.ken.server2.repository.query;

import machio.ken.server2.model.view.CollectionWithStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 蔵書情報を取得するクエリ系リポジトリクラスです。
 *
 * {@link CollectionWithStatus} クラスの表示データをまとめて取得するための
 * JOIN付きSQLを定義し、貸出情報も含めた状態でデータ取得ができます。
 */
@Repository
public class CollectionQuery {

    /**
     * 蔵書情報＋貸出状態を取得するためのSQL。
     * 「現在貸出中（IN_RENT）の貸出レコード」のみをWITH句で抽出し、
     * LEFT JOINで蔵書に関連付けています。
     */
    private static final String BASE_SQL = """
        WITH rent_only_circulation_record AS (
            SELECT * FROM circulation_record cr
            WHERE cr.status = 'IN_RENT'
        )
        SELECT 
            c.id AS collection_id,
            c.status AS collection_status,
            c.serial_number,
            pt.isbn AS published_title_isbn,
            pt.title AS published_title_name,
            pt.author AS published_title_author,
            cr.id AS circulation_record_id,
            cr.since_date,
            cr.due_date,
            cr.actual_return_date,
            cr.status AS circulation_status,
            m.id AS borrower_id,
            m.name AS borrower_name
        FROM collection c
        JOIN public.published_title pt ON c.published_title_id = pt.id
        LEFT JOIN rent_only_circulation_record cr ON cr.collection_id = c.id
        LEFT JOIN member m ON m.id = cr.member_id
    """;

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<CollectionWithStatus> rowMapper =
            new DataClassRowMapper<>(CollectionWithStatus.class);

    @Autowired
    public CollectionQuery(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 蔵書一覧を取得（貸出情報を含む）
     * @return CollectionWithStatus のリスト
     */
    public List<CollectionWithStatus> listAll() {
        String sql = BASE_SQL + " ORDER BY c.serial_number ASC";
        return jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * 指定された蔵書IDに一致する1件の情報を取得
     * @param collectionId 蔵書ID
     * @return CollectionWithStatus オブジェクト
     */
    public CollectionWithStatus findById(Integer collectionId) {
        String sql = BASE_SQL + " WHERE c.id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, collectionId);
    }
}

