// DOMの読み込みが完了したらイベントを登録
document.addEventListener('DOMContentLoaded', () => {

    // 通知要素（クラス .notification に .delete を含む）を全て取得
    (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {

        // 通知全体の要素（親要素）を取得
        const $notification = $delete.parentNode;

        // 「×」ボタンがクリックされたら、通知を非表示にする（DOMから削除）
        $delete.addEventListener('click', () => {
            $notification.parentNode.removeChild($notification);
        });
    });

});
