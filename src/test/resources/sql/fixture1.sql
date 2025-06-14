insert into published_title (isbn, title, author)
values
('9784296105441', 'Amazon Web Services 基礎からのネットワーク&サーバー構築 改訂3版', '清水美樹 著 玉川憲 監修 HLI技術者 今井雄太 監修'),
('9784873119762', 'Head Firstデザインパターン 第2版', 'Eric Freeman／著 Elisabeth Robson／著 佐藤直生／監修・翻訳 ほか');

insert into collection (status, serial_number, published_title_id)
values
('IN_SERVICE', 1, (select id from published_title where isbn = '9784296105441')),
('IN_SERVICE', 2, (select id from published_title where isbn = '9784296105441')),
('IN_SERVICE', 3, (select id from published_title where isbn = '9784296105441')),
('IN_SERVICE', 4, (select id from published_title where isbn = '9784296105441')),
('IN_SERVICE', 5, (select id from published_title where isbn = '9784296105441')),
('IN_SERVICE', 6, (select id from published_title where isbn = '9784296105441')),
('IN_SERVICE', 7, (select id from published_title where isbn = '9784296105441')),
('IN_SERVICE', 8, (select id from published_title where isbn = '9784296105441')),
('IN_SERVICE', 9, (select id from published_title where isbn = '9784873119762')),
('IN_SERVICE', 10, (select id from published_title where isbn = '9784873119762')),
('IN_SERVICE', 11, (select id from published_title where isbn = '9784873119762')),
('IN_SERVICE', 12, (select id from published_title where isbn = '9784873119762'));

insert into member (name, email)
values
('山田太郎', 'taro.yamada@example.com'),
('佐藤花子', 'hanako.sato@example.com'),
('鈴木一郎', 'ichiro.suzuki@example.com'),
('高橋次郎', 'jiro.takahashi@example.com'),
('田中三郎', 'saburo.tanaka@example.com');

insert into circulation_record (
    member_id,
    collection_id,
    since_date,
    due_date,
    actual_return_date,
    status
)
values
(
    (select id from member where name = '山田太郎'),
    (select id from collection where serial_number = 1),
    '2025-01-01',
    '2025-01-15',
    '2025-01-13',
    'RETURNED'
),
(
    (select id from member where name = '佐藤花子'),
    (select id from collection where serial_number = 1),
    '2025-01-14',
    '2025-01-28',
    null,
    'IN_RENT'
),
(
    (select id from member where name = '鈴木一郎'),
    (select id from collection where serial_number = 9),
    '2025-01-12',
    '2025-01-15',
    '2025-01-14',
    'RETURNED'
);
