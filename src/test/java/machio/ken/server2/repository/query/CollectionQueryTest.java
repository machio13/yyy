package machio.ken.server2.repository.query;

import machio.ken.server2.model.CirculationStatus;
import machio.ken.server2.model.CollectionStatus;
import machio.ken.server2.model.view.CollectionWithStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@JdbcTest
class CollectionQueryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private CollectionQuery sut;

    @BeforeEach
    void setup() {
        sut = new CollectionQuery(jdbcTemplate);
    }

    @Test
    @org.springframework.test.context.jdbc.Sql("/sql/fixture1.sql")
    void test() {
        List<CollectionWithStatus> ret = sut.listAll();

        assertThat(ret).hasSize(12);

        CollectionWithStatus first = ret.get(0);
        assertThat(first.getCollectionStatus()).isEqualTo(CollectionStatus.IN_SERVICE);
        assertThat(first.getSerialNumber()).isEqualTo(1);
        assertThat(first.getPublishedTitleIsbn()).isEqualTo("9784296105441");
        assertThat(first.getPublishedTitleName()).isEqualTo("Amazon Web Services 基礎からのネットワーク＆サーバー構築 改訂3版");
        assertThat(first.getPublishedTitleAuthor()).isEqualTo("斉藤 祐一郎／著 玉川 憲／HLI技術／著 今井 雄太／著");
        assertThat(first.getSinceDate()).isEqualTo(LocalDate.parse("2025-01-14"));
        assertThat(first.getDueDate()).isEqualTo(LocalDate.parse("2025-01-28"));
        assertThat(first.getActualReturnDate()).isNull();
        assertThat(first.getCirculationStatus()).isEqualTo(CirculationStatus.IN_RENT);
        assertThat(first.getBorrowerName()).isEqualTo("佐藤花子");

        CollectionWithStatus tenth = ret.get(8);
        assertThat(tenth.getCollectionStatus()).isEqualTo(CollectionStatus.IN_SERVICE);
        assertThat(tenth.getSerialNumber()).isEqualTo(9);
        assertThat(tenth.getPublishedTitleIsbn()).isEqualTo("9784873119762");
        assertThat(tenth.getPublishedTitleName()).isEqualTo("Head Firstデザインパターン 第2版");
        assertThat(tenth.getPublishedTitleAuthor()).isEqualTo("EricFreeman／著 ElisabethRobson／著 佐藤 由美／監修・翻訳 ほか");
        assertThat(tenth.getSinceDate()).isNull();
        assertThat(tenth.getDueDate()).isNull();
        assertThat(tenth.getActualReturnDate()).isNull();
        assertThat(tenth.getCirculationStatus()).isNull();
        assertThat(tenth.getBorrowerName()).isNull();

        // 1〜7件目までを一括検証
        assertAll(
                IntStream.rangeClosed(1, 7)
                        .mapToObj(i -> () -> assertThat(ret.get(i)).extracting(
                                        CollectionWithStatus::getCollectionStatus,
                                        CollectionWithStatus::getSerialNumber,
                                        CollectionWithStatus::getPublishedTitleIsbn,
                                        CollectionWithStatus::getPublishedTitleName,
                                        CollectionWithStatus::getPublishedTitleAuthor,
                                        CollectionWithStatus::getSinceDate,
                                        CollectionWithStatus::getDueDate,
                                        CollectionWithStatus::getActualReturnDate,
                                        CollectionWithStatus::getCirculationStatus,
                                        CollectionWithStatus::getBorrowerName
                                ).withFailMessage("Index %d fails", i)
                                .containsExactly(
                                        CollectionStatus.IN_SERVICE,
                                        i + 1,
                                        "9784296105441",
                                        "Amazon Web Services 基礎からのネットワーク＆サーバー構築 改訂3版",
                                        "斉藤 祐一郎／著 玉川 憲／HLI技術／著 今井 雄太／著",
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ))
        );

        // 9〜11件目までを一括検証
        assertAll(
                IntStream.rangeClosed(9, 11)
                        .mapToObj(i -> () -> assertThat(ret.get(i)).extracting(
                                        CollectionWithStatus::getCollectionStatus,
                                        CollectionWithStatus::getSerialNumber,
                                        CollectionWithStatus::getPublishedTitleIsbn,
                                        CollectionWithStatus::getPublishedTitleName,
                                        CollectionWithStatus::getPublishedTitleAuthor,
                                        CollectionWithStatus::getSinceDate,
                                        CollectionWithStatus::getDueDate,
                                        CollectionWithStatus::getActualReturnDate,
                                        CollectionWithStatus::getCirculationStatus,
                                        CollectionWithStatus::getBorrowerName
                                ).withFailMessage("Index %d fails", i)
                                .containsExactly(
                                        CollectionStatus.IN_SERVICE,
                                        i + 1,
                                        "9784873119762",
                                        "Head Firstデザインパターン 第2版",
                                        "EricFreeman／著 ElisabethRobson／著 佐藤 由美／監修・翻訳 ほか",
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ))
        );
    }
}
