package machio.ken.server2.service;

import machio.ken.server2.model.Member;
import machio.ken.server2.repository.query.MembersQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 利用者に関する情報の取得を担当するサービスクラスです。
 *
 * ※ 現段階では読み取り専用ですが、将来的に利用者情報の登録や更新機能を追加する予定であれば
 *    このクラスにビジネスロジックを追加していくことになります。
 */
@Service
@Transactional
public class MembersService {

    private final MembersQuery membersQuery;

    /**
     * コンストラクタインジェクション
     * @param membersQuery 利用者情報の読み取りリポジトリ
     */
    @Autowired
    public MembersService(MembersQuery membersQuery) {
        this.membersQuery = membersQuery;
    }

    /**
     * このアプリケーションに登録されている全ての利用者情報を取得します。
     *
     * @return Memberオブジェクトのリスト
     */
    public List<Member> listAll() {
        return membersQuery.listAll();
    }
}

