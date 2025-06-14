package machio.ken.server2.repository.query;

import machio.ken.server2.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 利用者情報を取得するクエリ系リポジトリクラスです。
 *
 * Memberテーブルからデータを取得し、Memberオブジェクトにマッピングします。
 */
@Repository
public class MembersQuery {

    /** SpringのJDBC操作用テンプレート */
    private final JdbcTemplate jdbcTemplate;

    /** 結果セットを Member クラスに自動変換するRowMapper */
    private final RowMapper<Member> rowMapper = new DataClassRowMapper<>(Member.class);

    /**
     * コンストラクタによる依存注入
     */
    @Autowired
    protected MembersQuery(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 利用者をすべて取得する
     *
     * @return Memberのリスト
     */
    public List<Member> listAll() {
        return jdbcTemplate.query("SELECT * FROM member", rowMapper);
    }
}

